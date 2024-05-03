package edu.vassar.cmpu203.batonpass.model;

import edu.vassar.cmpu203.batonpass.R;

public enum StoryState {


    INTRO(R.drawable.mushroom_infestation),
    GORGE(R.drawable.gorge),
    ROUTE1(R.drawable.village_fire),
    ROUTE2(R.drawable.pixel_orange_night_forest),

    SETROUTE(R.drawable.forest_upscaled__1_),
    ROUTE1_2(R.drawable.village_fire),
    ENDING1A(R.drawable.forest_upscaled__1_),
    ENDING1B(R.drawable.forest_upscaled__1_),
    ROUTE2_2(R.drawable.unsettling_night),
    ENDING2(R.drawable.forest_upscaled__1_),
    ENDING2A(R.drawable.forest_upscaled__1_),
    ENDING2B(R.drawable.forest_upscaled__1_),
    ENDING3(R.drawable.forest_upscaled__1_);
    final int combatBackground;

 StoryState(int combatBackground) {this.combatBackground = combatBackground;}
    // the story class has multiple states that indicate where in the story the game is currently
public int getBackgroundId(){return this.combatBackground;}
}
