package edu.vassar.cmpu203.batonpass.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.batonpass.databinding.FragmentEndBinding;

public class EndFragment extends Fragment implements IEndView {

    FragmentEndBinding binding;

    Listener listener;

    int endingNum;

    String endingMessage;

    public EndFragment(Context context, Listener listener) {

        this.listener = listener;
    }

    // on the creation of the end fragment, display the ending number and ending message
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentEndBinding.inflate(inflater);
        String message = "Ending " + endingNum + " of 5";
        this.binding.ending.setText(message);
        this.binding.endingMessage.setText(endingMessage);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // set the ending number and ending message
    public void ending(int ending_num) {
        endingNum = ending_num;
        if(endingNum == 1)
            endingMessage = "You are killed by your protege. You do not know what has come of them or of the little village you settled down in after your adventuring days were done. Perhaps if you had succeeded in training them, things could have gone better...";
        if(endingNum == 2)
            endingMessage = "Vin is never seen in the village again. From time to time, you wonder what has become of them, but your hopes are not high. You think it is likely they did not learn and have been killed or captured after trying to play a fake hero somewhere. You are glad you did not teach them better fighting skills, but you regret that you could not impart something even more valuable on your former protege: some sense.";
        if(endingNum == 3)
            endingMessage = "It is revealed that Vin was manufacturing problems to try to seem even more heroic. The village does not take kindly to this. However, Vin helps you and the rest of the village rebuild. Even after taking accountability for their actions and helping around the village, many of the villagers do not trust or forgive Vin. Eventually, Vin wishes you farewell and thanks you for your help. They depart, hopefully to enact some real heroics elsewhere. You have a feeling you will see them again someday. ";
        if(endingNum == 4)
            endingMessage = "Vin is never seen in the village again. Sometimes you regret the way things ended. You did care about them, even though they betrayed you. Perhaps if that final battle had gone differently, Vin could have gotten better. Perhaps they could have even learned to be a real hero. But now they become just another item on your long list of regrets";
        if(endingNum == 5)
            endingMessage = "You run from the village you called home. Years later, you consider approaching the village again, but the things you hear of Vin are not good. You do not return to your previous home. After all, you have called many places home throughout your adventures, what's one more loss? You regret that you could not do more for Vin or for the people of the village that are now left in their hands ";
    }
}

