package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.vassar.cmpu203.batonpass.databinding.FragmentStoryBinding;

public class StoryFragment extends Fragment implements IStoryView {

    FragmentStoryBinding binding;

    Listener listener;

    public StoryFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentStoryBinding.inflate(inflater);
        hideChoices();
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the next button, display the next line of script with onNextDisplay()
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNextDisplay();
            }
        });

        // on selecting choice 1, call onChoice1()
        this.binding.buttonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { listener.onChoice1(); }
        });

        // on selecting choice 2, call onChoice2()
        this.binding.buttonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { listener.onChoice2(); }
        });
    }

    // display a line of text from the script
    public void displayLine(String text){
        this.binding.storyScript.setText(text);
    }

    // display choice 1
    public void displayChoice1(Integer choiceLabel){
        Drawable myDrawable = this.getContext().getDrawable(choiceLabel);
        this.binding.buttonChoice1.setImageDrawable(myDrawable);
    }

    // display choice 2
    public void displayChoice2(Integer choiceLabel){
        Drawable myDrawable = this.getContext().getDrawable(choiceLabel);
        this.binding.buttonChoice2.setImageDrawable(myDrawable);
    }

    // display character portrait
    public void displayPortrait(int portraitLabel) {
        Drawable myDrawable = this.getContext().getDrawable(portraitLabel);
        this.binding.portraitImage.setImageDrawable(myDrawable);
    }

    // display background image
    public void displayBackground(int backgroundLabel) {
        Drawable myDrawable = this.getContext().getDrawable(backgroundLabel);
        this.binding.backgroundImage.setImageDrawable(myDrawable);
    }

    // hide the choices when there is no choice in the dialogue
    public void hideChoices(){
        this.binding.buttonChoice1.setEnabled(false);
        this.binding.buttonChoice1.setVisibility(View.INVISIBLE);
        this.binding.buttonChoice2.setEnabled(false);
        this.binding.buttonChoice2.setVisibility(View.INVISIBLE);
        this.binding.nextButton.setEnabled(true);
        this.binding.nextButton.setVisibility(View.VISIBLE);
        this.binding.storyScript.setEnabled(true);
        this.binding.storyScript.setVisibility(View.VISIBLE);
    }

    // show the choices when there are choices in the dialogue
    public void showChoices() {
        this.binding.buttonChoice1.setEnabled(true);
        this.binding.buttonChoice1.setVisibility(View.VISIBLE);
        this.binding.buttonChoice2.setEnabled(true);
        this.binding.buttonChoice2.setVisibility(View.VISIBLE);
        this.binding.nextButton.setEnabled(false);
        this.binding.nextButton.setVisibility(View.INVISIBLE);
        this.binding.storyScript.setEnabled(false);
        this.binding.storyScript.setVisibility(View.INVISIBLE);
    }
}
