package edu.vassar.cmpu203.batonpass.model;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.batonpass.R;

public class Story {

    private final List<String> scriptList = new ArrayList<>();
    private final List<Integer> portraitList = new ArrayList<>();
    private final List<Integer> backgroundList = new ArrayList<>();
    private final List<String> aScriptList = new ArrayList<>();
    private final List<String> bScriptList = new ArrayList<>();
    private final List<Integer> aPortraitList = new ArrayList<>();
    private final List<Integer> bPortraitList = new ArrayList<>();
    private final List<Integer> aBackgroundList = new ArrayList<>();
    private final List<Integer> bBackgroundList = new ArrayList<>();
    private final List<Integer> aButtonChoices = new ArrayList<>();
    private final List<Integer> bButtonChoices = new ArrayList<>();
    int line = 1;

    int count = 0;

    boolean endingChoice = false;

    private StoryState state;

    public int getLine() {
        return line;
    }

    public void setLine(int newLine) {
        line = newLine;
    }

    public void addLine() {
        line++;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }


    public boolean getEndingChoice() {
        return endingChoice;
    }

    public List<String> getScriptList() {
        return scriptList;
    }

    public List<Integer> getPortraitList() {
        return portraitList;
    }

    public List<Integer> getBackgroundList() {
        return backgroundList;
    }

    public List<String> getAScriptList() {
        return aScriptList;
    }

    public List<String> getBScriptList() {
        return bScriptList;
    }

    public List<Integer> getAPortraitList() {
        return aPortraitList;
    }

    public List<Integer> getBPortraitList() {
        return bPortraitList;
    }
    public List<Integer> getABackgroundList(){ return aBackgroundList;}
    public List<Integer> getBBackgroundList(){ return bBackgroundList;}
    public List<Integer> getAButtonChoices(){ return aButtonChoices;}
    public List<Integer> getBButtonChoices(){ return bButtonChoices; }


    public StoryState getState(){return state;}

    // fill the script for the introduction
    public void introduction() {
        this.state = StoryState.INTRO;

        // IMAGE: black backdrop, white text appears
        scriptList.add("Welcome to the World of Anaideia, adventurer!. Tap Next to continue.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.blank_portrait);

        scriptList.add("In this world with a grand sky beyond one's reach and great plains beyond one’s sight, you shall start your adventure...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.blank_portrait);

        scriptList.add("As a retired hero who has once saved the world.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.blank_portrait);

        scriptList.add("What type of adventure awaits you?");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.blank_portrait);

        // IMAGE: dark screen, text box appears
        // INDEX: 4
        scriptList.add("*knock* *knock*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: 5
        scriptList.add("You open your eyes in a dim room.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: 6
        scriptList.add("*knock* *knock*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // IMAGE: screen flips from dark screen to outside of house, text box resurfaces moments after. Vin character portrait appears. Expression: open mouth, speaking, neutral (or if we don’t have resource, just smiling)
        // INDEX: 7
        scriptList.add("Mysterious Person: 'Hello! Is anyone home! Hello! So sorry to disturb you...'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: 8
        scriptList.add("*creak*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: 9
        scriptList.add("You: *yawn*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_morning);

        scriptList.add("You: 'Who wakes up so early in the morning...'");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You look down at the glowy-eyed kid in front of your door.");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You: 'Who  are you, kid?'");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("Mysterious Person: 'I’m Vin!'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You: 'Vin?'");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("Vin: 'Yes! The new hero!'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You: 'What?'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You: 'A kid like you? Seriously?'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("(...did they replace me?)");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("You: 'Just go away. Don't bother me.'");
        portraitList.add(R.drawable.vin_hesitant_speaking);
        backgroundList.add(R.drawable.hut_morning);

        // INDEX: 20
        scriptList.add("You leave the kid outside and re-enter your house, but...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("...the kid doesn't leave. They wait...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_morning);
        scriptList.add("...and wait...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_morning);
        // IMAGE: black background
        scriptList.add("...and wait.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_morning);

        // IMAGE: change to night hut

        scriptList.add("When the kid starts setting up a tent outside, you figure you'd do something to get rid of them.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);

        scriptList.add("You: 'Fine. I have something for you to do. Something heroic.'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Oh! What is it? I won’t let you down!'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'I need you to clean something up for me.'");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'A monster? A dragon?'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'A mushroom.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'A mushroom?'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Yes. Its spores are poisonous. It’s a threat to the village.'");
        portraitList.add(R.drawable.mushroom_portrait);
        backgroundList.add(R.drawable.night_forest_orange);
        scriptList.add("Vin: 'Doesn’t poisonous mean that it’s only harmful if you eat it?'");
        portraitList.add(R.drawable.mushroom_portrait);
        backgroundList.add(R.drawable.night_forest_orange);
        scriptList.add("You: 'And do you trust these villagers not to eat it? Besides, it puts up a hell of a fight. I need it gone.'");
        portraitList.add(R.drawable.mushroom_portrait);
        backgroundList.add(R.drawable.night_forest_orange);
        scriptList.add("Vin: 'It’s a creature?'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Yes, yes, now, go on. If you want to be a hero, this is what you have to do.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Okay, stop asking so many questions and just act, right?'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'No! Are you kidding? Ask questions! You want to just go in blind? Kill something that doesn’t need to be killed? Get killed yourself?'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Oh, but you said—'");
        portraitList.add(R.drawable.vin_hesitant_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Sure, ask questions, but don’t doubt me. I know what I’m talking about.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'The thing is poisonous or venomous or whatever you have it.' ");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'It’s been killing deer in the woods for weeks and it’s lodged itself in my yard. Get rid of it before it graduates from eating deer to eating people.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Yes, captain! Will do!'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_night);

        // IMAGE: switch image to night forest

        // <MINIGAME INITIATED>
    }

    // fill the script for the gorge scene
    public void gorge(boolean outcome) {
        this.state = StoryState.GORGE;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        // IMAGE: display hut + mushroom portrait

        // if the player won the previous minigame, display this text
        if (!outcome){
            scriptList.add("You fail to get rid of Vin after the mushroom ordeal. They boast about their success for days.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
            scriptList.add("They come back the very next day to bother you again.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
        }
        // if the player lost the previous minigame, display this text
        else {
            scriptList.add("Vin fails to get rid of the mushroom monster. You have to step in.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
            scriptList.add("After that, Vin leaves, and is back the very next day to bother you again.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
            scriptList.add("They don't bother apologizing for their mistakes, just beg you for another chance.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
            scriptList.add("You fail to get rid of them.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
        }

        // INDEX: -19
        //IMAGE: display village1, blank portrait
        scriptList.add("They continue to follow you around, and finally the day comes when you have to re-enter society to buy basic supplies in the village");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_entrance);

        //IMAGE: villager1 enter
        // INDEX: -18
        scriptList.add("Villager: 'Hero, please, hero!'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_entrance);

        // IMAGE: Villager A head portrait barge into screen (left to right, while Vin’s portrait shifts right)

        scriptList.add("You: 'What happened?'");
        portraitList.add(R.drawable.villager_concerned);
        backgroundList.add(R.drawable.village_entrance);
        scriptList.add("Villager: 'My sister, she, she!'");
        portraitList.add(R.drawable.villager_explaining);
        backgroundList.add(R.drawable.village_entrance);
        scriptList.add("Vin: 'What did she do?'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_entrance);
        scriptList.add("Villager: *deep breaths*");
        portraitList.add(R.drawable.villager_concerned);
        backgroundList.add(R.drawable.village_entrance);
        scriptList.add("Villager: 'She went out to pick berries... but that was hours ago! Then when I went to find her, I heard her voice in the gorge beside the lake.'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.villagekid2);
        scriptList.add("Villager: 'She’s in there and can’t get out! Please save her, there are monsters there!'");
        portraitList.add(R.drawable.villager_explaining);
        backgroundList.add(R.drawable.village_entrance);
        scriptList.add("You: '...'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_entrance);

        // IMAGE: switch background to gorge1
        scriptList.add("The gorge...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // INDEX: -10
        scriptList.add("That's where the dragon slumbers...");
        portraitList.add(R.drawable.ghoul_dragon_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // IMAGE: switch portrait to ghoul dragon
        // INDEX: -9
        scriptList.add("...");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // IMAGE: switch to village background and vin_fake_smile
        scriptList.add("You: 'Okay kid, your turn to shine again.'");
        portraitList.add(R.drawable.villager_concerned);
        backgroundList.add(R.drawable.village_entrance);

        // IMAGE: switch portrait to Vin, smile
        scriptList.add("Vin: 'Let’s go!'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.village_entrance);

        // IMAGE: switch back to gorge
        // INDEX: -6
        scriptList.add("Monsters appear in the gorge beside the village. You hear the faint cry for help of a girl from within.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // IMAGE: no goblin portrait yet
        // INDEX: -5
        scriptList.add("Goblin: 'GRRRRHHHH!'");
        portraitList.add(R.drawable.goblin_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // IMAGE: goblin portrait appears
        // INDEX: -4
        scriptList.add("Goblin: 'GRA GRA GRA!'");
        portraitList.add(R.drawable.goblin_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // IMAGE: switch to Vin portrait
        scriptList.add("Vin: 'I’m going down now! Please watch my back!'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.gorge_entrance);
        scriptList.add("You: 'They’re going to get themself killed...'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.gorge_entrance);

        // <MINIGAME INITIATED>
    }

    // based on the outcome of the previous minigames, set the route that the story should take
    // fill the script with the first part of that route
    public void setRoute(int original, int current, boolean outcome) {
        this.state = StoryState.SETROUTE;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        // if the player won the previous minigame, display this text
        if(!outcome) {
            scriptList.add("Villager: 'Oh, Lisa! Don’t ever run off like that again!'");
            portraitList.add(R.drawable.villager_concerned);
            backgroundList.add(R.drawable.villagekid1);
        }
        // if the player lost the previous minigame, display this text
        else {
            scriptList.add("Villager: 'Lisa! No! I will come get you myself! Thanks for nothing, heroes.'");
            portraitList.add(R.drawable.villager_explaining);
            backgroundList.add(R.drawable.gorge_entrance);
        }

        // if the player won at least one of the two previous minigames, follow this route (route 2)
        if(current >= original + 5)
        {
            this.state = StoryState.ROUTE2;

            // INDEX: 1
            // IMAGE: black?

            scriptList.add("(Perhaps they really are worth training.)");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // INDEX: 2
            scriptList.add("(With some more work... they could get better at this. Maybe be a hero like I was.)");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // IMAGE: dark screen white text
            // INDEX: 3
            scriptList.add("You stare at Vin.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // IMAGE: black background
            // INDEX: 4
            // SOUND: Night cricket
            scriptList.add("A month of training passes...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            scriptList.add("The young hero progresses smoothly.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // INDEX: 6
            scriptList.add("And it seems the peace of the world will be protected for yet another era...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // IMAGE: switch to night hut
            // INDEX: 7
            scriptList.add("The night breeze whistles through the window.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.hut_night);

            // IMAGE: black background
            // INDEX: 8
            scriptList.add("Vin has dozed off in the living room.");
            portraitList.add(R.drawable.vin_sleeping);
            backgroundList.add(R.drawable.hut_night);
            scriptList.add("(This kid... at least go sleep in their bed...)");
            portraitList.add(R.drawable.vin_sleeping);
            backgroundList.add(R.drawable.hut_night);

            // INDEX: 10
            // SOUND: ruffle noise, door noise
            scriptList.add("You lay a blanket over them, and silently leave the house with your blade.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_orange);

            // SOUND: cricket sound, image of forest at night
            // SOUND: *light string music starts playing*
            // IMAGE: fade into black screen
            // INDEX: 11
            scriptList.add("Bathed in the glow of fireflies, under the shimmering midnight moon,");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // INDEX: 12
            // SOUND: grass crunch
            scriptList.add("You draw your blade and let the scabbard lie by a grove...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // SOUND: breeze sound, theme of the common people
            scriptList.add("amongst the gentle moss and blooms.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Spirits deep in the forest gaze.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("At your silver blade they swoon.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Slowly, you too enter a daze,");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Memories flow from times of youth.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Back when good friends weren’t few,");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Yet too rare was solitude.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // SOUND: *Sword singing sound*
            // SOUND: *tree falling sound x12*, from slow to fast
            // SOUND: *dinging bell chime*
            // INDEX: 20
            scriptList.add("...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // INDEX: 21
            scriptList.add("You have regained the lost technique of the heroes: Blade of Rea.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            scriptList.add("A horde of goblins rush out from the forest.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // INDEX: 23
            scriptList.add("Goblins: 'GR, GRRR, GRRRR!'");
            portraitList.add(R.drawable.goblin_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("You: 'Just what I wanted on a night off.'");
            portraitList.add(R.drawable.goblin_portrait);
            backgroundList.add(R.drawable.night_forest_blue);

            // <MINIGAME INITIATED>
        }
        // if the player lost both previous minigames, follow this route (route 1)
        else
        {
            this.state = StoryState.ROUTE1;

            scriptList.add("(Are they really worth training?)");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);
            scriptList.add("(They haven't been able to accomplish any of the tasks set to them thus far.)");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            scriptList.add("You stare at Vin.");
            portraitList.add(R.drawable.vin_smile);
            backgroundList.add(R.drawable.gorge_entrance);

            scriptList.add("You: 'You are not ready. I knew I shouldn’t have done this.'");
            portraitList.add(R.drawable.vin_sad);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("Vin: 'No! I can work harder, just give me a chance.'");
            portraitList.add(R.drawable.vin_emotionless_speaking);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("You: 'Listen, kid, just go home. Don’t go out there and get yourself killed, trust me.'");
            portraitList.add(R.drawable.vin_very_sad);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("Vin: 'I can do this! I will keep working and I won’t let you down.'");
            portraitList.add(R.drawable.vin_hesitant_speaking);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("Vin: 'Please.'");
            portraitList.add(R.drawable.vin_very_sad);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("You: 'Sorry, kid.'");
            portraitList.add(R.drawable.vin_neutral);
            backgroundList.add(R.drawable.gorge_entrance);
            scriptList.add("You leave Vin standing there.");
            portraitList.add(R.drawable.vin_neutral);
            backgroundList.add(R.drawable.gorge_entrance);

            scriptList.add("Time passes...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.black_screen);

            // INDEX: -16
            // SOUND: scream and fire
            scriptList.add("The village is burning. A dragon towers overhead. The people are afraid.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_dragon1);
            scriptList.add("You watch Vin.");
            portraitList.add(R.drawable.vin_sad);
            backgroundList.add(R.drawable.village_fire_dragon1);
            scriptList.add("Vin: 'Don’t worry! I will help you!'");
            portraitList.add(R.drawable.vin_hesitant_speaking);
            backgroundList.add(R.drawable.village_fire_dragon1);

            //SOUND: swinging sound
            // INDEX: -13
            scriptList.add("Vin tries to take a hit at the dragon and misses.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_dragon1);

            // SOUND: dragon sound effect
            // INDEX: -12
            scriptList.add("Dragon: 'GRRRRRR!'");
            portraitList.add(R.drawable.ghoul_dragon_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("Vin: 'Wait!'");
            portraitList.add(R.drawable.vin_hesitant_speaking);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("You: 'Kid, get out of there!'");
            portraitList.add(R.drawable.vin_sad);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("Vin: 'No! If you won’t help them, then I will!'");
            portraitList.add(R.drawable.vin_hesitant_speaking);
            backgroundList.add(R.drawable.village_fire_no_dragon);

            // INDEX: -8
            // SOUND: add sword swing effect?
            scriptList.add("Vin tries to swing their blade and misses again, landing roughly in the dirt perilously close to a sharp dragon claw.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);

            // SOUND: dragon sound effect
            // INDEX: -7
            scriptList.add("Dragon: 'GRRRRRR!'");
            portraitList.add(R.drawable.ghoul_dragon_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("You: 'You are going to get yourself killed! Run!'");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("Vin ignores you.");
            portraitList.add(R.drawable.vin_neutral);
            backgroundList.add(R.drawable.village_fire_no_dragon);
            scriptList.add("You:'Fine!'");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);

            scriptList.add("You join the battle.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_fire_no_dragon);

            // <MINIGAME INITIATED>
        }
    }

    // fill the script with the next part of route 1
    // post-fighting the dragon, fight Vin in the boss battle
    public void route1_2(boolean outcome) {
        this.state = StoryState.ROUTE1_2;
        // SOUND: just play battle song the entire time

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        // if the player won the previous minigame, display this text
        if (!outcome) {
            scriptList.add("The dragon falls.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_post_fight);
            scriptList.add("...");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_post_fight);
        }
        // if the player lost the previous minigame, display this text
        else {
            scriptList.add("You manage to drive the dragon away, but not without a significant amount of damage to the village.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_post_fight);
            scriptList.add("And you know it will be back, perhaps to finish the job.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_post_fight);
            scriptList.add("Who knows if you will be around to stop it then? Who knows if Vin will even still be alive after their failures of attempts at heroics?");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.village_post_fight);
        }
        scriptList.add("You, injured, look up at Vin, standing over you, holding a weapon. Their facade is gone.");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'What happened? Are you hurt?'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin:  'Not me. You.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'Why are you...?'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'Why do I hate you? Is that what you can’t even manage to ask?'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'Cut the act.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'Cut the act! Yes, it’s finally time for that, isn’t it. Time for you to learn the truth.'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'Just get to the point.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'Shut up and listen for once in your goddamn life.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'I just wanted some respect. Is that too much to ask? Some respect in this tiny, worthless, piece of garbage town.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'And if I could ‘help’ some people to get it, then they wouldn’t know any better, stupid and ignorant as they are. You were supposed to be my ticket to do that. To get that goddamn respect. But you couldn’t even do that.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'No. You had to make me do this. This is your fault. If you had just paid attention to me, taught me like I asked. If you had given me the time of day. Just a little bit more respect. Well. Here we are now. And it’s on you.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You:'You don’t know what you’re saying. You should never have done this.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'I never should have done this? You should have done the job you agreed to do. If you had done that, none of this would have happened. But I don’t have time to make you realize that. You’re just going to be stubborn until the day you die.'");
        portraitList.add(R.drawable.vin_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You get up and put your hand on your weapon.");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'You finally got a clue. Yes, I’m going to kill you. And then I can pick up the pieces of this mess that you caused. Finally, people will know who I am and what I can do.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'You don’t have to do this.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'Oh, but I do.'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.village_post_fight);

        // <BOSS BATTLE INITIATED>
    }

    // determine the ending based on the outcome of the boss battle
    // if player lost -> ending1a
    // if player won -> ending1b
    public int route1_end(boolean outcome) {
        if (outcome) {
            ending1a();
            return 1;
        }
        else {
            ending1b();
            return 2;
        }
    }

    // ending 1 of 5
    // the player loses the boss battle against Vin after fighting the dragon in route 1
    public void ending1a() {
        // <Player lost after Route 1>

        this.state = StoryState.ENDING1A;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();
        // INDEX: 0
        scriptList.add("The smoke of battle subsides.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'You’re pathetic, old geezer.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: '...'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'What are you going to do now? The world’s forgotten you, your abilities and skills are all rusted...'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'None of that really matters. You’ll know one day.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'Stop lecturing me!'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin steps on your shoulder and leans their weight down to put pressure on it.");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        // INDEX: 7
        scriptList.add("You: *grunts*");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'I still believe in the Vin I saw that day. You’re a good kid deep down.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'I’ll let you in on a little secret before you go.'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);
        // INDEX: 10
        scriptList.add("Vin leans in.");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);

        scriptList.add("Vin: 'You are and have always been nothing. You know nothing. So no, there is no good kid deep down. You're wrong. You were fooled, once again, and finally, you will die for it.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_post_fight);
        // INDEX: 12
        scriptList.add("Vin’s sword falls.");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.village_post_fight);

        // <END>
    }

    // ending 2 of 5
    // the player wins the boss battle against Vin after fighting the dragon in route 1
    public void ending1b() {
        // <Player won after Route 1>

        this.state = StoryState.ENDING1B;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();
        // INDEX: 0
        scriptList.add("The smoke of battle subsides.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'You underestimated me, kid.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: '...'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.village_post_fight);
        // INDEX: 3
        scriptList.add("You: 'Look, kid, I don’t know what happened. But there’s still another chance.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin: 'There are no more chances for me.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("You: 'Fine, then. If that's what you want. Get going and never come back.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.village_post_fight);
        scriptList.add("Vin slowly gets up and sheathes their sword. Under the midnight moonlight, they vanish into the distance, never to return.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.village_post_fight);

        // <END>
    }

    // fill the script with the next part of route 2
    // post-goblin fight, fight Vin in the boss battle
    public void route2_2(boolean outcome) {
        this.state = StoryState.ROUTE2_2;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        // if the player won the previous minigame, display this text
        if(!outcome) {
            // IMAGE: night forest view
            scriptList.add("Your new technique really pays off! The goblins scamper into the forest, afraid.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
        }
        // if the player lost the previous minigame, display this text
        else {
            scriptList.add("Perhaps your new skill is not as useful as you thought... the goblins steal an old dagger of yours and run into the forest with it.");
            portraitList.add(R.drawable.blank_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
            scriptList.add("Goblins: 'Grr, Grrr GRRRAAAA.'");
            portraitList.add(R.drawable.goblin_portrait);
            backgroundList.add(R.drawable.night_forest_blue);
        }

        scriptList.add("You: 'That was quite the fight.'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.night_forest_blue);
        scriptList.add("You massage your shoulder and pick up the scabbard.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.night_forest_blue);
        scriptList.add("You: 'Better get back soon before it gets too late...'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.night_forest_blue);
        scriptList.add("You return to the entrance of the forest.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.night_forest_orange);
        scriptList.add("The house is still dark, barely visible in the night.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);


        // INDEX: -21
        scriptList.add("...but something isn’t right.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You reach for the handle of the door.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You stop.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);

        // SOUND: remove sound here
        scriptList.add("The crickets are quiet.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("The night is silent.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);


        // SOUND: want door sound here too
        // IMAGE: change to black screen

        // INDEX: -16
        scriptList.add("You throw open the door.");

        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Vin isn’t in the living room.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: -14
        scriptList.add("You run through the house.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("You: 'Vin! Where are you?'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Empty. The entire house was empty.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // SOUND: want sound here too
        // INDEX: -11
        scriptList.add("*SWOOSH*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("A sudden silver slashed through the darkness.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // SOUND: want sound here
        // INDEX: -9
        scriptList.add("*PANG*");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("You: 'Who’s there!'");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.black_screen);

        // INDEX: -7
        scriptList.add("Vin’s face emerges from the darkness. A foreign stoicness in their gaze sends shivers down your spine.");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("You: 'What happened to you?'");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Vin: 'You seem confused...'");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Vin grins.");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Vin: 'I’ve been itching to have you out of my way for good.'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.black_screen);
        // INDEX: -2
        scriptList.add("You: '...'");
        portraitList.add(R.drawable.vin_evil_smile);
        backgroundList.add(R.drawable.black_screen);
        scriptList.add("Vin: 'To think the retired hero regained their techniques so soon. It seems I should’ve gotten rid of you earlier.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.black_screen);
        // INDEX: -0
        scriptList.add("You: '...I never should have trusted again.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.black_screen);

        // <BOSS BATTLE INITIATED>
    }

    // determine the ending based on the outcome of the boss battle
    // if player won -> ending2
    // if player lost -> ending3
    public int route2_end(boolean outcome) {
        if (outcome) {
            ending3();
            return 5;
        }
        else {
            ending2();
            return 0;
        }
    }

    // ending divergence after route 2 (new technique and goblin fight) and the player won the boss battle
    // good and bad endings possible
    public void ending2() {

        this.state = StoryState.ENDING2;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        // <Player won after Route 2. Splits off afterwards into ending2a and ending 2b.>
        // Ending 2a & 2b (Player convinces Vin to change & Player exiles Vin)
        // Dialogue options that contribute to each ending are marked in () after the dialogue option.
        // If there are 3 or more points for ending 2a, ending 2a. If there are 3 or more points for ending 2b, ending 2b.
        // If there are equal points for both endings, jump to ending 2a or 2b based on a random number generator with 50% of both.

        endingChoice = true;
        aScriptList.add("You: 'Enough!'");
        aPortraitList.add(R.drawable.blank_portrait);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'No! It will... it will never be enough!'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("You: 'You need to stop this. You’ve lost.'");
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'I haven’t lost until I’m dead.'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);

        bScriptList.add("You: 'Enough!'");
        bPortraitList.add(R.drawable.blank_portrait);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'No! It will... it will never be enough!'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("You: 'You need to stop this. You’ve lost.'");
        bPortraitList.add(R.drawable.vin_very_sad);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'I haven’t lost until I’m dead.'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);

        // dialogue choice
        // aChoicesList.add("You: 'Is that the way you want it to be?'"); // (Ending 2a)
        aButtonChoices.add(R.drawable.is_that_the_way_you_want_it_to_be);
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        // bChoicesList.add("You: 'I won’t fight you.'"); //  (Ending 2b)
        bButtonChoices.add(R.drawable.i_wont_fight_you);
        bPortraitList.add(R.drawable.vin_sad);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'There is no other way.'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("You: 'You could just live.'");
        aPortraitList.add(R.drawable.vin_neutral);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'As who? Truly? Who knows me?'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);

        bScriptList.add("");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'There is no other way.'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("You: 'You could just live.'");
        bPortraitList.add(R.drawable.vin_neutral);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'As who? Truly? Who knows me?'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);

        // dialogue choice
        // aChoicesList.add("You: 'I do.'"); // (Ending 2a)
        aButtonChoices.add(R.drawable.i_do);
        aPortraitList.add(R.drawable.vin_sad);
        aBackgroundList.add(R.drawable.hut_night);
        // bChoicesList.add("You: 'Your home does.'"); // (Ending 2b)
        bButtonChoices.add(R.drawable.your_home_does);
        bPortraitList.add(R.drawable.vin_sad);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: *resigned* 'Like that means anything.'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: *angry* 'Like that means anything.'");
        bPortraitList.add(R.drawable.vin_ominous);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("You: 'Maybe if you stopped trying to be a hero, things would go better for you. You could be normal. Happy.'");
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'With what? What is the point of this world without heroes?'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);

        bScriptList.add("You: 'Maybe if you stopped trying to be a hero, things would go better for you. You could be normal. Happy.'");
        bPortraitList.add(R.drawable.vin_very_sad);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'With what? What is the point of this world without heroes?'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);

        // dialogue choice
        // aChoicesList.add("You: 'What’s the point of anything? You cannot truly believe you are only searching for meaning.'"); // (Ending 2a)
        aButtonChoices.add(R.drawable.whats_the_point);
        aPortraitList.add(R.drawable.vin_sad);
        aBackgroundList.add(R.drawable.hut_night);
        // bChoicesList.add("You: 'You are no hero.'"); // (Ending 2b)
        bButtonChoices.add(R.drawable.you_are_no_hero);
        bPortraitList.add(R.drawable.vin_ominous);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("");
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'No, I...'");
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'I need to be something. This world needs something. Is that not enough?'");
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);

        bScriptList.add("");
        bPortraitList.add(R.drawable.vin_very_sad);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'No, I...'");
        bPortraitList.add(R.drawable.vin_very_sad);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'I need to be something. This world needs something. Is that not enough?'");
        bPortraitList.add(R.drawable.vin_very_sad);
        bBackgroundList.add(R.drawable.hut_night);

        // dialogue choice
        // aChoicesList.add("You: 'Perhaps. But that something is not a hero. Perhaps this world has outgrown heroes.'"); // (Ending 2a)
        aButtonChoices.add(R.drawable.perhaps);
        aPortraitList.add(R.drawable.vin_very_sad);
        aBackgroundList.add(R.drawable.hut_night);
        // bChoicesList.add("You: 'I cannot answer that.'"); // (Ending 2b)
        bButtonChoices.add(R.drawable.i_cannot_answer_that);
        bPortraitList.add(R.drawable.vin_neutral);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("Vin: 'Heroes like you?'");
        aPortraitList.add(R.drawable.vin_emotionless_speaking);
        aBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'I can! I am enough, the way you never were and never will be. You are not needed.'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("You: 'Yes. The world has moved on. It no longer needs me.'");
        aPortraitList.add(R.drawable.vin_neutral);
        aBackgroundList.add(R.drawable.hut_night);
        aScriptList.add("You: 'The young do not need me.'");
        aPortraitList.add(R.drawable.vin_neutral);
        aBackgroundList.add(R.drawable.hut_night);

        bScriptList.add("You: 'Yes. The world has moved on. It no longer needs me.'");
        bPortraitList.add(R.drawable.vin_neutral);
        bBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("You: 'The young do not need me.'");
        bPortraitList.add(R.drawable.vin_neutral);
        bBackgroundList.add(R.drawable.hut_night);

        aScriptList.add("Vin: 'I did. To teach me, I—. Yes. I did. Isn’t that proof?'");
        aPortraitList.add(R.drawable.vin_sad);
        aBackgroundList.add(R.drawable.hut_night);
        bScriptList.add("Vin: 'I needed you and you failed me. You failed all of us. Isn't that proof?'");
        bPortraitList.add(R.drawable.vin_emotionless_speaking);
        bBackgroundList.add(R.drawable.hut_night);
    }

    // ending 3 of 5
    // the player wins the boss battle against Vin after fighting the goblins in route 2. good ending.
    public void ending2a() {
        //  <Player won after ending2() in Route 2. Good ending.>

        this.state = StoryState.ENDING2A;

        endingChoice = false;
        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        scriptList.add("");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Proof of? Your own deception?'");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.hut_night);

        scriptList.add("Vin: 'I... I suppose.'");
        portraitList.add(R.drawable.vin_hesitant_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'You truly think the world has moved on? That... I can move on?'");
        portraitList.add(R.drawable.vin_hesitant_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Who am I to say? That’s for you to decide.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Stop trying to fill a role. No more gallant adventures for whatever you believe passes as respect. Be a person. Live.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'And what will you do?'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'The same.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Will I... can I stay?'");
        portraitList.add(R.drawable.vin_hesitant_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Up to you. I won’t stop you, though those whose lives you endangered might object.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Perhaps I will rebuild. Elsewhere.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'But first, here. Here I can rebuild. Do something... heroic.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Sure, kid.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: '...Thank you.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'You can repay me by never asking me to train you. Ever again.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Deal.'");
        portraitList.add(R.drawable.vin_wide_smile);
        backgroundList.add(R.drawable.hut_night);

        // <END>
    }

    // ending 4 of 5
    // the player wins the boss battle against Vin after fighting the goblins in route 2. bad ending.
    public void ending2b() {
        // <Player won after ending2() in Route 2. Bad ending.>

        this.state = StoryState.ENDING2B;

        endingChoice = false;
        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();

        scriptList.add("");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Proof of what? The fact that you were never a hero? That you will never be one?'");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.hut_night);

        scriptList.add("Vin: 'You will never learn. You will never change!'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'I could say the same.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Leave here. Never come back. If you do, I will know.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'And what will you do about it? How will you even hope to stop me?'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'I will, same as now.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Or, I will spread your story. Tell tales of your... heroics. I am sure the village is curious as to the cause of all their troubles.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'You will finally receive some... respect.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'They will never believe you.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'Would you like to test that theory? Or would you just like me to kill you?'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'You are not worth my time.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'I will go. Gain my respect, as you so aptly put it, elsewhere.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: 'And never return.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'I heard you the first time. I’m not the one of us who is losing their hearing.'");
        portraitList.add(R.drawable.vin_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'You are the one who is truly losing something here.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Goodbye.'");
        portraitList.add(R.drawable.vin_neutral);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin leaves.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);

        // <END>
    }

    // ending 5 of 5
    // the player loses the boss battle against Vin after fighting the goblins in route 2
    public void ending3() {
        // <Player loses to Vin after Route 2>

        this.state = StoryState.ENDING3;

        scriptList.clear();
        portraitList.clear();
        backgroundList.clear();
        // INDEX: 0
        scriptList.add("The smoke of battle subsides.");
        portraitList.add(R.drawable.blank_portrait);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin’s blade touches your neck.");
        portraitList.add(R.drawable.vin_ominous);
        backgroundList.add(R.drawable.hut_night);
        // INDEX: 2
        scriptList.add("Vin: 'Look at you, a sad old geezer, no chance of gaining back the glory that once was.'");
        portraitList.add(R.drawable.vin_emotionless_speaking);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("You: “...”");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin strikes. You close your eyes and brace for the blow, but their weapon hits the dirt beside you.");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);
        scriptList.add("Vin: 'Never come back here. I am their hero now.'");
        portraitList.add(R.drawable.vin_very_sad);
        backgroundList.add(R.drawable.hut_night);

        // <END>
    }
}

