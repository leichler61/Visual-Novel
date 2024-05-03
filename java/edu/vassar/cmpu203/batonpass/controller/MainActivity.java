package edu.vassar.cmpu203.batonpass.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import edu.vassar.cmpu203.batonpass.R;
import edu.vassar.cmpu203.batonpass.model.Character;
import edu.vassar.cmpu203.batonpass.model.MainCharacter;
import edu.vassar.cmpu203.batonpass.model.Enemy;
import edu.vassar.cmpu203.batonpass.model.Jackpot;
import edu.vassar.cmpu203.batonpass.model.JackpotState;
import edu.vassar.cmpu203.batonpass.model.Story;
import edu.vassar.cmpu203.batonpass.model.StoryState;
import edu.vassar.cmpu203.batonpass.view.EndFragment;
import edu.vassar.cmpu203.batonpass.view.ICombatView;
import edu.vassar.cmpu203.batonpass.view.CombatFragment;
import edu.vassar.cmpu203.batonpass.view.IEndView;
import edu.vassar.cmpu203.batonpass.view.ISpinnerInstructionView;
import edu.vassar.cmpu203.batonpass.view.ISpinnerIntroductionView;
import edu.vassar.cmpu203.batonpass.view.IStartView;
import edu.vassar.cmpu203.batonpass.view.IStoryView;
import edu.vassar.cmpu203.batonpass.view.SpinnerInstructionFragment;
import edu.vassar.cmpu203.batonpass.view.ISpinnerView;
import edu.vassar.cmpu203.batonpass.view.SpinnerFragment;
import edu.vassar.cmpu203.batonpass.view.IMainView;
import edu.vassar.cmpu203.batonpass.view.MainView;
import edu.vassar.cmpu203.batonpass.view.SpinnerIntroductionFragment;
import edu.vassar.cmpu203.batonpass.view.StartFragment;
import edu.vassar.cmpu203.batonpass.view.StoryFragment;

public class MainActivity extends AppCompatActivity implements ISpinnerInstructionView.Listener, ISpinnerView.Listener, IEndView.Listener, IStoryView.Listener, ISpinnerIntroductionView.Listener, ICombatView.Listener, IStartView.Listener {
    private final Jackpot j = new Jackpot();

    private final Story s = new Story();

    private Context context;

    IMainView mainView;

    StartFragment startFragment = new StartFragment(this, this);

    CombatFragment combatFragment = new CombatFragment(this, this);

    SpinnerInstructionFragment spinnerInstructionFragment = new SpinnerInstructionFragment(this, this);

    SpinnerFragment spinnerFragment = new SpinnerFragment(this, this);

    StoryFragment storyFragment = new StoryFragment(this, this);

    SpinnerIntroductionFragment spinnerIntroductionFragment = new SpinnerIntroductionFragment(this, this);

    EndFragment endFragment = new EndFragment(this, this);

    int count = 0;

    int minigame_num = 0;

    int ending_num = 0;

    boolean outcome;

    boolean routeSet = false;

    int a_count = 0;

    int b_count = 0;

    String lastChoice = "A";

    long time = 900;

    int enem_skill = 15;


    Character MC = new MainCharacter(40, 100, "You");

    Character vin_protag = new MainCharacter(30, 100, "Vin");

    Character vin_enemy = new Enemy(30, 100, "Vin");

    Character mushroom = new Enemy(enem_skill, 100, "The mushroom monster");

    Character gorge_goblins = new Enemy(enem_skill + 5, 100, "The goblin");

    Character forest_goblins = new Enemy(enem_skill + 5, 100, "The goblin");

    Character dragon = new Enemy(enem_skill + 10, 100, "The dragon");

    MediaPlayer music;
    MediaPlayer sound;

    // on the creation of the app, show the start fragment with the start button to start the game
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        this.mainView = new MainView(this);
        this.mainView.displayFragment(startFragment, false, "start menu");
        setContentView(this.mainView.getRootView());

        music = MediaPlayer.create(context, R.raw.start_menu);
        music.setLooping(true);
        music.start();
    }

    // on pressing the start button on the start fragment, display the story fragment
    // fill the story text with the introduction
    public void onStartGame() {
        this.mainView.displayFragment(storyFragment, false, "story introduction");
        playMusic(true, R.raw.sacred_theme);
        s.introduction();
    }

    // on pressing the next button on the story fragment
    // if there are dialogue choices to be displayed, display the choices and the correct story text associated with the choices
    // else display the lines of the story text with the background and character images
    // then initiate a minigame, starting with the tutorial for the first minigame, and the introduction for the rest
    // or, if at the end of the game, display the end fragment
    public void onNextDisplay() {
        // if it is the part of the story that uses dialogue choices
        if (s.getEndingChoice()) {
            // if it is the part of the text that includes a choice, go to that choice
            if (s.getLine() == 4 || s.getLine() == 8 || s.getLine() == 12 || s.getLine() == 15) {
                onEndingChoices();
            } else {
                // if the previous choice was choice 1, display the correct response
                if (lastChoice.equals("A")) {
                    if (s.getLine() < s.getAScriptList().size()) {
                        storyFragment.displayLine(s.getAScriptList().get(s.getLine()));
                        if (s.getLine() < s.getAPortraitList().size())
                            storyFragment.displayPortrait(s.getAPortraitList().get(s.getLine()));
                        if (s.getLine() < s.getABackgroundList().size())
                            storyFragment.displayBackground((s.getABackgroundList().get(s.getLine())));
                    }
                    // if there is no more text to display, set the ending
                    else {
                        onEnd();
                    }
                }
                // if the previous choice was choice 2, display the correct response
                if (lastChoice.equals("B")) {
                    if (s.getLine() < s.getBScriptList().size()) {
                        storyFragment.displayLine(s.getBScriptList().get(s.getLine()));
                        if (s.getLine() < s.getBPortraitList().size())
                            storyFragment.displayPortrait(s.getBPortraitList().get(s.getLine()));
                        if (s.getLine() < s.getBBackgroundList().size())
                            storyFragment.displayBackground(s.getBBackgroundList().get(s.getLine()));
                    }
                    // if there is no more text to display, set the ending
                    else {
                        onEnd();
                    }
                }
            }
        }
        // if it is not a part that includes dialogue choices
        // all other occasions of dialogue
        else {
            // if there is text to display, display it
            if (s.getLine() < s.getScriptList().size()) {
                storyFragment.displayLine(s.getScriptList().get(s.getLine()));
                if (s.getLine() < s.getPortraitList().size())
                    storyFragment.displayPortrait(s.getPortraitList().get(s.getLine()));
                if (s.getLine() < s.getBackgroundList().size())
                    storyFragment.displayBackground(s.getBackgroundList().get(s.getLine()));

                // play sound effects for the introduction
                if (s.getState() == StoryState.INTRO) {
                    if (s.getLine() == 4) {
                        playMusic(true, R.raw.morning_bird);
                        sound = MediaPlayer.create(context, R.raw.door_knock);
                        sound.setLooping(false);
                        sound.start();
                    }
                    if (s.getLine() == 5) {
                        playSound(false, R.raw.wakeup);
                    }
                    if (s.getLine() == 6) {
                        playSound(false, R.raw.door_knock);
                    }
                    if (s.getLine() == 8) {
                        playSound(false, R.raw.door_open);
                    }
                    if (s.getLine() == 9) {
                        playSound(false, R.raw.yawning);
                    }
                    if (s.getLine() == 20) {
                        playSound(false, R.raw.door_close);
                    }
                    if (s.getLine() == 24) {
                        playMusic(true, R.raw.night_cricket);
                    }
                }
                // play sound effects for the gorge scene
                if (s.getState() == StoryState.GORGE) {
                    if (s.getLine() == (s.getScriptList().size() - 19)) {
                        playMusic(true, R.raw.theme_for_the_ordinary_people);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 11)) {
                        playMusic(true, R.raw.fast_battle);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 10)) {
                        playSound(false, R.raw.dragon_roar);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 5)) {
                        playSound(false, R.raw.goblin_sound);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 4)) {
                        playSound(false, R.raw.goblin_sound);
                    }
                }
                // play sound effects for route 2
                if (s.getState() == StoryState.ROUTE2) {

                    if (s.getLine() == 0) {
                        music.stop();
                    }
                    if (s.getLine() == 1) {
                        playMusic(true, R.raw.sacred_theme);
                    }
                    if (s.getLine() == 7) {
                        music.stop();
                        playSound(false, R.raw.forest_wind);
                    }
                    if (s.getLine() == 8) {
                        playSound(false, R.raw.light_snoring);
                    }
                    if (s.getLine() == 10) {
                        playSound(false, R.raw.door_close);
                    }
                    if (s.getLine() == 11) {
                        playSound(true, R.raw.night_cricket);
                    }
                    if (s.getLine() == 12) {
                        playMusic(true, R.raw.theme_for_the_ordinary_people);
                        playSound(false, R.raw.draw_sword);
                    }
                    if (s.getLine() == 13) {
                        playSound(false, R.raw.forest_wind);
                    }
                    if (s.getLine() == 20) {
                        playSound(false, R.raw.draw_sword);
                        playSound(false, R.raw.tree_fall);
                    }
                    if (s.getLine() == 21) {
                        playSound(false, R.raw.bell_chime);
                    }
                    if (s.getLine() == 22) {
                        playSound(false, R.raw.forest_wind);
                    }
                    if (s.getLine() == 23) {
                        playSound(false, R.raw.goblin_sound);
                    }
                }
                // play sound effects for route 1
                if (s.getState() == StoryState.ROUTE1) {
                    playMusic(true, R.raw.theme_for_the_ordinary_people);
                    if (s.getLine() == (s.getScriptList().size() - 16)) {
                        music.stop();
                        playSound(false, R.raw.crowd_scream);
                        playSound(true, R.raw.big_fire);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 13)) {
                        playSound(true, R.raw.big_fire);
                        playSound(false, R.raw.sword_slash);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 12)) {
                        playSound(false, R.raw.dragon_roar);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 8)) {
                        playSound(false, R.raw.sword_slash);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 7)) {
                        playSound(false, R.raw.dragon_roar);
                    }
                }
                if (s.getState() == StoryState.ROUTE2_2) {
                    if (s.getLine() == 0) {
                        music.stop();
                        playSound(true, R.raw.night_cricket);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 21)) {
                        sound.stop();
                    }
                    if (s.getLine() == (s.getScriptList().size() - 16)) {
                        playSound(false, R.raw.door_open);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 14)) {
                        playSound(false, R.raw.run_wood);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 11)) {
                        playSound(false, R.raw.sword_slash);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 9)) {
                        playSound(false, R.raw.door_close);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 7)) {
                        playSound(false, R.raw.grass_walking);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 6)) {
                        sound.stop();
                    }
                }
                if (s.getState() == StoryState.ENDING3) {
                    if (s.getLine() == 0) {
                        playSound(false, R.raw.big_fire);
                    }
                    if (s.getLine() == 1) {
                        playMusic(true, R.raw.sacred_theme);
                    }
                    if (s.getLine() == 5) {
                        playMusic(true, R.raw.sword_slash);
                    }
                }
                if (s.getState() == StoryState.ENDING1A) {
                    music.stop();
                    if (s.getLine() == (s.getScriptList().size() - 13)) {
                        playSound(false, R.raw.big_fire);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 12)) {
                        playMusic(true, R.raw.sacred_theme);
                    }
                    if (s.getLine() == (s.getScriptList().size() - 1)) {
                        playSound(true, R.raw.final_slash);
                    }
                }
                if (s.getState() == StoryState.ENDING1B) {
                    music.stop();
                    if (s.getLine() == 0) {
                        playSound(false, R.raw.big_fire);
                    }
                    if (s.getLine() == 1) {
                        playMusic(true, R.raw.sacred_theme);
                    }
                    if (s.getLine() == 3) {
                        playSound(true, R.raw.draw_sword);
                    }
                }
            }
            // if there have been 3 or fewer minigames, there are still minigames to initiate
            else if (minigame_num <= 3) {
                playMusic(true, R.raw.start_menu);

                s.setLine(-1);
                j.addInstructions();
                minigame_num++;
                // if it is the first minigame, show the tutorial first
                if (minigame_num <= 1) {
                    this.mainView.displayFragment(spinnerInstructionFragment, false, "spinner instruction");
                }
                // if it is not the first minigame, show the introduction to the minigame
                else {
                    this.mainView.displayFragment(spinnerIntroductionFragment, false, "spinner introduction");
                }
            }
            // if there is no more text to display and no more minigames to play, then it is the end
            // display the end fragment
            else {
                endFragment.ending(ending_num);
                this.mainView.displayFragment(endFragment, false, "ending");
            }
        }
            s.addLine();
    }

    // display the introduction to the minigame (for all minigames after the first one)
    // give the player the option to return to the tutorial and to choose the difficulty level of the minigame
    public void onDisplayIntroduction() {
        // if there is text to display, display it
        if (j.getPage() < j.getList().size()) {
            spinnerInstructionFragment.displayInstruction((String) j.getList().get(j.getPage()));
            // when the end of the text is reached, show the buttons to choose Easy, Medium, Hard, or Tutorial
            // hide the next button
            if (j.getPage() == j.getList().size() - 1) {
                spinnerInstructionFragment.showButtons();
                spinnerInstructionFragment.hideNextButton();
            }
        }
        j.addPage();
    }

    // display the jackpot spinner
    public void onDisplaySpinner() {
        music.stop();

        this.mainView.displayFragment(spinnerFragment, false, "spinner");
    }

    // start the jackpot spinner
    // depending on the difficulty selected for the minigame, the symbols spin at a certain speed
    // if they take too long, they automatically miss the target
    public void onStartingJackpot() {
        playMusic(true, R.raw.jackpot_sound);

        count = 0;

        // start the spinning
        j.startSpin();

        // display the target symbol
        spinnerFragment.displayTargetSymbol(j.getTargetSymbol());
        spinnerFragment.showStopButton();

        // spin the symbols at a certain speed depending on the difficulty (Easy, Medium, Hard)
        if (j.getState() == JackpotState.SPINNING) {
            CountDownTimer c = new CountDownTimer(3000000, time) {
                private IMainView mainView;
                int index = 0;

                @Override
                public void onTick(long l) {
                    char[] arr = j.getRandomSymbols();
                    if (j.getState() == JackpotState.SPINNING) {
                        j.setDisplayedSymbol(arr[index]);
                        char DisplayedSymbol = j.getDisplayedSymbol();
                        index++;
                        spinnerFragment.displaySpinningSymbol(DisplayedSymbol);
                        if (index > arr.length - 1)
                            index = 0;
                    } else {
                        cancel();
                    }
                }

                // if the player takes too long to stop the jackpot, they automatically miss the target symbol
                @Override
                public void onFinish() {
                    if (j.getState() == JackpotState.SPINNING) {
                        spinnerFragment.displaySnackBar("You took too long! Moving on.");
                        j.setState(JackpotState.MISS);
                        this.mainView.displayFragment(combatFragment, false, "combat");
                    }
                }
            };
            c.start();
        }
    }

    // stop the jackpot spinning
    // set the JackpotState to either HIT or MISS
    // set the correct characters for each minigame and have them attack each other and display the attack
    public void onStoppingJackpot() {

        // end the jackpot spinning
        j.endSpin();
        playMusic(true, R.raw.battle_song);

        // set the correct characters for the minigame based on its placement in the story
        Character c1 = setCharacter(true);
        Character c2 = setCharacter(false);

        // have the characters attack each other
        if (j.getState() == JackpotState.HIT || j.getState() == JackpotState.MISS) {
            j.updateStats(c1, c2);
            c1.attack(c2);
            if (c2.getHealth() > 0) {
                j.updateStats(c2, c1);
                c2.attack(c1);
            }
            // display a snackbar to tell the player whether they hit the target

            this.mainView.displayFragment(combatFragment, false, "combat");
            combatFragment.setHit(j.getDisplayedSymbol() == j.getTargetSymbol());
        }
    }

    public StoryState getStoryState(){return this.s.getState();}

    // display the attack from the minigame
    // set the correct characters for each minigame and display the changes to character stats
    // choose where to go next based on whether the minigame is continuing or has ended
    @Override
    public void onDisplayAttack() {

        // set the correct characters for this minigame based on its placement in the story
        Character player = setCharacter(true);
        Character enemy = setCharacter(false);

        // switch the attacking character and the character being attacked for each round
        Character char1 = player;
        Character char2 = enemy;
        if (count == 0) {
            char1 = enemy;
            char2 = player;
        }
        count++;

        // if the main character and their enemy are still alive, go back to the jackpot spinner
        if (count > 2 && char1.getHealth() > 0 && char2.getHealth() > 0) {
            this.mainView.displayFragment(spinnerFragment, false, "spinner");
        }
        // post-combat stats update hasn't displayed yet, so display the text for the attack
        else if (count <= 2)
            if (char1.getName().equals(player.getName()))
                combatFragment.attackDisplay(char1.getSkill(), char1, char2, true);
            else
                combatFragment.attackDisplay(char1.getSkill(), char1, char2, false);
            // if the main character or their enemy died, finish looping the game and continue the story
        else {
            boolean b = char1.getHealth() <= 0 || char2.getHealth() <= 0;
            if (b) {
                // set the outcome for the minigame: win or lose
                if (player.getHealth() <= 0)
                    outcome = false;
                else if (enemy.getHealth() <= 0)
                    outcome = true;

                // reset the health and skill after each minigame
                // the base skill level for each character increases after each win at a minigame
                player.setHealth(player.getOriginalHealth());
                enemy.setHealth(enemy.getOriginalHealth());
                if(outcome)
                    player.setBaselineSkill(5);
                else
                    enemy.setBaselineSkill(5);
                player.setSkill(player.getBaselineSkill());
                enemy.setSkill(enemy.getBaselineSkill());
                this.mainView.displayFragment(storyFragment, false, "spinner end");
                // if one minigame has been played, display the gorge scene
                if (minigame_num == 1)
                    s.gorge(outcome);
                // if two minigames have been played and the story route is not set, set the route
                if (minigame_num == 2 && !routeSet) {
                    s.setRoute(vin_protag.getOriginalSkill(), vin_protag.getBaselineSkill(), outcome);
                    routeSet = true;
                }
                // if the route is route 2, follow this path
                if (s.getState() == StoryState.ROUTE2 || s.getState() == StoryState.ROUTE2_2) {
                    // if three minigames have been played, display the next part of route 2
                    if (minigame_num == 3)
                        s.route2_2(outcome);
                        // if the fourth and final minigame has been played, determine the ending
                    else if (minigame_num == 4) {
                        ending_num = s.route2_end(outcome);
                    }
                }
                // if if the route is route 1, follow this path
                if (s.getState() == StoryState.ROUTE1 || s.getState() == StoryState.ROUTE1_2) {
                    // if three minigames have been played, display the next part of route 1
                    if (minigame_num == 3)
                        s.route1_2(outcome);
                        // if the fourth and final minigame has been played, determine the ending
                    else if (minigame_num == 4) {
                        ending_num = s.route1_end(outcome);
                    }
                }
            }
        }
    }

    // display the tutorial for the minigame
    public void onDisplayTutorial() {
        this.mainView.displayFragment(spinnerInstructionFragment, false, "spinner instruction");
    }

    // set the difficulty level of the minigame to be Easy
    // the time is slow and the enemy's skill is low
    public void onSetEasy() {
        music.stop();
        time = 900;
        enem_skill = 15;
        mushroom.setSkill(enem_skill);
        gorge_goblins.setSkill(enem_skill + 5);
        forest_goblins.setSkill(enem_skill + 5);
        dragon.setSkill(enem_skill + 10);
        onDisplaySpinner();
    }

    // set the difficulty level of the minigame to be Medium
    // the time is of medium speed and the enemy's skill is medium
    public void onSetMedium() {
        music.stop();
        time = 500;
        enem_skill = 20;
        mushroom.setSkill(enem_skill);
        gorge_goblins.setSkill(enem_skill + 5);
        forest_goblins.setSkill(enem_skill + 5);
        dragon.setSkill(enem_skill + 10);
        onDisplaySpinner();
    }

    // set the difficulty level of the minigame to be Hard
    // the time is fast and the enemy's skill is high
    public void onSetHard() {
        music.stop();
        time = 300;
        enem_skill = 30;
        mushroom.setSkill(enem_skill);
        gorge_goblins.setSkill(enem_skill + 5);
        forest_goblins.setSkill(enem_skill + 5);
        dragon.setSkill(enem_skill + 10);
        onDisplaySpinner();
    }

    // display the correct ending based on the choices of the player in the dialogue
    public void onEnd() {
        if(a_count > 0 || b_count > 0) {
            // if the player chose choice 1 either 3 or 4 times, go to ending 2a
            if(a_count > 2) {
                s.ending2a();
                ending_num = 3;
            }
            // if the player chose choice 2 either 3 or 4 times, go to ending 2b
            else if (b_count > 2) {
                s.ending2b();
                ending_num = 4;
            }
            // if the player chose choice 1 twice and choice 2 twice, randomly go to ending 2a or 2b with equal chance of either
            else {
                if(Math.random() < 0.5) {
                    s.ending2a();
                    ending_num = 3;
                }
                else {
                    s.ending2b();
                    ending_num = 4;
                }
            }
            s.setLine(1);
            storyFragment.displayLine(s.getScriptList().get(s.getLine()));
        }
    }

    // set the correct characters for each minigame according to the story
    public Character setCharacter(boolean c) {
        Character c1;
        Character c2;
        // first minigame is Vin (controlled by the player) vs the mushroom monster
        if (minigame_num == 1) {
            c1 = vin_protag;
            c2 = mushroom;
        }
        // second minigame is Vin (controlled by the player) vs the goblins in the gorge
        else if (minigame_num == 2) {
            c1 = vin_protag;
            c2 = gorge_goblins;
        }
        // third minigame is the retired hero (controlled by the player) vs either the goblins in the forest or the dragon
        else if(minigame_num == 3) {
            c1 = MC;
            if(s.getState() == StoryState.ROUTE2 || s.getState() == StoryState.ROUTE2_2)
                c2 = forest_goblins;
            else
                c2 = dragon;
        }
        // fourth minigame is the retired hero (controlled by the player) vs Vin (as a computer)
        else {
            c1 = MC;
            c2 = vin_enemy;
        }
        if (c)
            return c2;
        else
            return c1;
    }

    // display the dialogue choices for the choice-based endings
    public void onEndingChoices() {
        storyFragment.showChoices();
        storyFragment.displayChoice1(s.getAButtonChoices().get(s.getCount()));
        storyFragment.displayChoice2(s.getBButtonChoices().get(s.getCount()));
        s.addCount();
    }

    // on the selection of choice 1
    // count how many times choice 1 has been selected
    public void onChoice1() {
        a_count++;
        lastChoice = "A";
        storyFragment.hideChoices();
        onNextDisplay();
    }

    // on the selection of choice 2
    // count how many times choice 2 has been selected
    public void onChoice2() {
        b_count++;
        lastChoice = "B";
        storyFragment.hideChoices();
        onNextDisplay();
    }

    public void playMusic(boolean loop, int sound) {
        music.stop();
        music = MediaPlayer.create(context, sound);
        music.setLooping(loop);
        music.start();
    }

    public void playSound(boolean loop, int effect) {
        sound.stop();
        sound = MediaPlayer.create(context, effect);
        sound.setLooping(loop);
        sound.start();
    }
}