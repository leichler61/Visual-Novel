package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.batonpass.databinding.FragmentCombatBinding;
import edu.vassar.cmpu203.batonpass.model.Character;

public class CombatFragment extends Fragment implements ICombatView {

    FragmentCombatBinding binding;
    Listener listener;

    boolean hit;

    public CombatFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentCombatBinding.inflate(inflater);
        return this.binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the next button, display the attack with onDisplayAttack()
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CombatFragment.this.listener.onDisplayAttack();
            }

        });

        displayCombatScene(this.listener.getStoryState().getBackgroundId());

        String message;

        // if the player hit the target, display this
        if (hit)
            message = "You hit the target! You gain 5 attack.";
        // if the player did not hit the target, display this
        else
            message = "You missed the target! You lose 5 attack.";

        this.binding.statUpdate.setText(message);
    }

    // display the results of one character attacking another 
    public void attackDisplay(int a, Character c1, Character c2, boolean count) {
        if (count && c1.getHealth() <= 0)
            this.binding.statUpdate.setText(c1.getName() + " has 0 health!");
        else {
            if (c1.getName().equals("You") && !c2.getName().equals("Vin"))
                this.binding.statUpdate.setText(c1.getName() + " now have a skill level of " + a + ".\n" +
                        c1.getName() + " attacked " + c2.getName().toLowerCase() + " with skill " + a + "!\n" +
                        c2.getName() + " now has " + c2.getHealth() + " health!");
            else if(c1.getName().equals("You"))
                this.binding.statUpdate.setText(c1.getName() + " now have a skill level of " + a + ".\n" +
                        c1.getName() + " attacked " + c2.getName() + " with skill " + a + "!\n" +
                        c2.getName() + " now has " + c2.getHealth() + " health!");
            else if (c2.getName().equals("You"))
                this.binding.statUpdate.setText(c1.getName() + " now has a skill level of " + a + ".\n" +
                        c1.getName() + " attacked " + c2.getName().toLowerCase() + " with skill " + a + "!\n" +
                        c2.getName() + " now have " + c2.getHealth() + " health!");
            else if (c1.getName().equals("Vin"))
                this.binding.statUpdate.setText(c1.getName() + " now has a skill level of " + a + ".\n" +
                        c1.getName() + " attacked " + c2.getName().toLowerCase() + " with skill " + a + "!\n" +
                        c2.getName() + " now has " + c2.getHealth() + " health!");
            else
                this.binding.statUpdate.setText(c1.getName() + " now has a skill level of " + a + ".\n" +
                        c1.getName() + " attacked " + c2.getName() + " with skill " + a + "!\n" +
                        c2.getName() + " now has " + c2.getHealth() + " health!");
        }
    }

    // displays the background of each combat scene
    public void displayCombatScene(int combatSceneLabel) {

        Context context = this.getContext();
        Drawable myDrawable = context.getDrawable(combatSceneLabel);
        this.binding.combatBackground.setImageDrawable(myDrawable);
    }

    public void setHit(boolean hit){
        this.hit = hit;
    }
}
