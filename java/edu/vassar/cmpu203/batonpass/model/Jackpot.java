package edu.vassar.cmpu203.batonpass.model;

import java.util.ArrayList;
import java.util.List;

public class Jackpot {
    private final char[] randomSymbols = new char[10];
    private char targetSymbol;
    private char displayedSymbol;
    private JackpotState state;

    int page = 1;

    List<String> list = new ArrayList<>();

    // fill the instructions for the minigame
    public void addInstructions() {
        list.add("");
        list.add("Welcome to a minigame!");
        list.add("To attack your opponent, you will need to play the jackpot...");
        list.add("...and hit the target!");
        list.add("Stop the spinning jackpot at the right time to land on the intended target. This will increase your attack for this fight. If you miss, your attack will decrease for this fight.");
        list.add("If you win the minigame, you will gain additional attack to start the next fight. If you lose, your opponent in the next fight will gain additional attack.");
        list.add("Press Easy, Medium, or Hard to choose your difficulty level and continue to the minigame.");
    }

    public char[] getRandomSymbols() {
        return randomSymbols;
    }

    public char getTargetSymbol() {
        return targetSymbol;
    }

    public char getDisplayedSymbol() {
        return displayedSymbol;
    }

    public void setDisplayedSymbol(char c){
        this.displayedSymbol = c;
    }

    public JackpotState getState(){
        return state;
    }

    public void setState(JackpotState state_new) {
        this.state = state_new;
    }

    public int getPage() {return page;}

    public void addPage() {
        page++;
    }

    public List getList() {return list;}

    // start the jackpot spinning
    public void startSpin() {
        int[] AsciiTable = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 1117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127};

        // list of 10 random symbols
        for (int i = 0; i < 10; i++) {
            randomSymbols[i] = ((char) AsciiTable[(int) (Math.random() * AsciiTable.length)]);
        }

        // target symbol that player must hit for the jackpot, selected from the 10 randomSymbols
        targetSymbol = randomSymbols[(int) (Math.random() * randomSymbols.length)];

        this.state = JackpotState.SPINNING;
    }

    // end the jackpot spinning
    public void endSpin() {
        // if the target symbol is the same as the symbol displayed when the spinning stopped, it is HIT
        if (targetSymbol == displayedSymbol)
            this.state = JackpotState.HIT;
        // else, it is MISS
        else
            this.state = JackpotState.MISS;
    }

    // change the player's skill based on whether they hit or missed the jackpot, whether they are playing as the retired hero or Vin
    public void updateStats(Character c1, Character c2) {
        if (this.state == JackpotState.HIT && c1.getName().equals("You")) {
            c1.changeSkill(5);
        }
        else if (c1.getName().equals("You")) {
            c1.changeSkill(-5);
        }
        if(this.state == JackpotState.HIT && c1.getName().equals("Vin") && !c2.getName().equals("You")) {
            c1.changeSkill(5);
        }
        else if (c1.getName().equals("Vin") && !c2.getName().equals("You")) {
            c1.changeSkill(-5);
        }
    }
}