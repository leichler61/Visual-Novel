package edu.vassar.cmpu203.batonpass.view;

import edu.vassar.cmpu203.batonpass.model.Character;
import edu.vassar.cmpu203.batonpass.model.StoryState;

public interface ICombatView {

    interface Listener {

        void onDisplayAttack();

        StoryState getStoryState();
    }

    void attackDisplay(int a, Character c1, Character c2, boolean count);

    void displayCombatScene(int combatSceneLabel);

    void setHit(boolean hit);
}
