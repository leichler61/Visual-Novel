package edu.vassar.cmpu203.batonpass.view;

public interface IStoryView {

    interface Listener {

        void onNextDisplay();

        void onChoice1();

        void onChoice2();
    }

    void displayLine(String text);

    void displayChoice1(Integer choiceLabel);

    void displayChoice2(Integer choiceLabel);

    void displayPortrait(int portraitLabel);

    void displayBackground(int backgroundLabel);

    void hideChoices();

    void showChoices();
}
