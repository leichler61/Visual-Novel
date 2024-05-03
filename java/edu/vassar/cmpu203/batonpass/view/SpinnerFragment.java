package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.batonpass.databinding.FragmentSpinnerBinding;

public class SpinnerFragment extends Fragment implements ISpinnerView {

    FragmentSpinnerBinding binding;
    Listener listener;

    public SpinnerFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSpinnerBinding.inflate(inflater);
        hideStopButton();
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // on clicking the start button, start the spinning of the jackpot
        this.binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onStartingJackpot();
            }

        });

        // on clicking the stop button, stop the spinning of the jackpot
        this.binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onStoppingJackpot();
            }

        });
    }

    // display the spinning jackpot symbol as it spins
    public void displaySpinningSymbol(char CurrentSymbol){
        this.binding.jackpotSpin.setText(String.valueOf(CurrentSymbol));
    }

    // hide the stop button until the jackpot is spinning
    // if the jackpot is not spinning, it cannot be stopped
    public void hideStopButton(){
        this.binding.stopButton.setEnabled(false);
        this.binding.stopButton.setVisibility(View.INVISIBLE);
    }

    // once the jackpot is spinning, hide the start button, because it cannot be started again
    // show the stop button when the jackpot is spinning so the spinning can be stopped
    public void showStopButton(){
        this.binding.startButton.setEnabled(false);
        this.binding.startButton.setVisibility(View.INVISIBLE);

        this.binding.stopButton.setEnabled(true);
        this.binding.stopButton.setVisibility(View.VISIBLE);
    }

    // display the target symbol the player aims to hit
    public void displayTargetSymbol(char TargetSymbol){
        this.binding.targetSymbol.setText(String.valueOf(TargetSymbol));
    }

    // display a short snackbar message
    public void displaySnackBar(String message){
        Snackbar snackbar = Snackbar.make(this.binding.getRoot(), message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
