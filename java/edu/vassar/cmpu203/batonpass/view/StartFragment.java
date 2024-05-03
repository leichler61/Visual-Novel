package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.batonpass.databinding.FragmentStartBinding;

public class StartFragment extends Fragment implements IStartView{

    FragmentStartBinding binding;
    Listener listener;

    public StartFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentStartBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the start button, start the game with onStartGame()
        this.binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onStartGame();
            }

        });
    }
}
