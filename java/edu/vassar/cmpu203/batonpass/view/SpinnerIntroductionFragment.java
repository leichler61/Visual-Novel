package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.batonpass.databinding.FragmentSpinnerIntroScreenBinding;

public class SpinnerIntroductionFragment extends Fragment implements ISpinnerIntroductionView {

    FragmentSpinnerIntroScreenBinding binding;
    Listener listener;

    public SpinnerIntroductionFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSpinnerIntroScreenBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the tutorial button, show the tutorial again with onDisplayTutorial()
        this.binding.tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDisplayTutorial();
            }

        });

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
    }
}
