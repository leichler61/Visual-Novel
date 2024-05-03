package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import edu.vassar.cmpu203.batonpass.databinding.FragmentSpinnerInstructionBinding;

public class SpinnerInstructionFragment extends Fragment implements ISpinnerInstructionView {

    FragmentSpinnerInstructionBinding binding;

    Listener listener;

    public SpinnerInstructionFragment(Context context, Listener listener){

        this.listener=listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSpinnerInstructionBinding.inflate(inflater);
        hideButtons();
        return this.binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the Easy button, set the minigame difficulty to Easy
        this.binding.easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSetEasy();
            }
        });

        // on clicking the Medium button, set the minigame difficulty to Medium
        this.binding.mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSetMedium();
            }
        });

        // on clicking the Hard button, set the minigame difficulty to Hard
        this.binding.hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSetHard();
            }
        });

        // on clicking the next button, display the introduction to the minigame
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDisplayIntroduction();
            }
        });
    }

    // display a line of text for the instructions for the minigame
    public void displayInstruction(String text){
       this.binding.spinnerInstructions.setText(text);
    }

    // hide the difficulty buttons for before they should be clicked
    // the difficulty buttons should only appear after the instructions have been given
    public void hideButtons(){
        this.binding.easyButton.setEnabled(false);
        this.binding.easyButton.setVisibility(View.INVISIBLE);

        this.binding.mediumButton.setEnabled(false);
        this.binding.mediumButton.setVisibility(View.INVISIBLE);

        this.binding.hardButton.setEnabled(false);
        this.binding.hardButton.setVisibility(View.INVISIBLE);
    }

    // hide the next button for when the difficulty buttons appear
    public void hideNextButton() {
        this.binding.nextButton.setEnabled(false);
        this.binding.nextButton.setVisibility(View.INVISIBLE);
    }

    // show the difficulty buttons
    public void showButtons() {
        this.binding.easyButton.setEnabled(true);
        this.binding.easyButton.setVisibility(View.VISIBLE);

        this.binding.mediumButton.setEnabled(true);
        this.binding.mediumButton.setVisibility(View.VISIBLE);

        this.binding.hardButton.setEnabled(true);
        this.binding.hardButton.setVisibility(View.VISIBLE);
    }
}
