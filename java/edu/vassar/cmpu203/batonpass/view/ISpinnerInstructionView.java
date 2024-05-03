package edu.vassar.cmpu203.batonpass.view;

public interface ISpinnerInstructionView {

    interface Listener {

        void onDisplayIntroduction();

        void onSetEasy();

        void onSetMedium();

        void onSetHard();
    }

    void displayInstruction(String text);

    void hideButtons();

    void hideNextButton();

    void showButtons();
}
