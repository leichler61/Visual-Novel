package edu.vassar.cmpu203.batonpass.model;

public class MainCharacter extends Character {

    public MainCharacter(int skill, int health, String name) {
        super(skill, health, name);
    }

    // MainCharacter attacks Character c by decreasing their health by however much skill MainCharacter has
    public void attack(Character c) {
        c.decreaseHealth(this.getSkill());
    }
}
