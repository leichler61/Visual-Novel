package edu.vassar.cmpu203.batonpass.view;

public interface ISpinnerView {

    interface Listener {

        void onStoppingJackpot();

        void onStartingJackpot();
    }
    void displaySpinningSymbol(char CurrentSymbol);

    void hideStopButton();

    void showStopButton();

    void displayTargetSymbol(char TargetSymbol);

    void displaySnackBar(String message);
}
