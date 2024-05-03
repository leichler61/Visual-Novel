package edu.vassar.cmpu203.batonpass.view;

public interface ISpinnerIntroductionView {

    interface Listener {

        void onDisplayTutorial();

        void onSetEasy();

        void onSetMedium();

        void onSetHard();
    }
}
