package edu.vassar.cmpu203.batonpass.model;

public class Enemy extends Character {

    public Enemy(int skill, int health, String name) {
        super(skill, health, name);
    }

    // randomly decide if the Enemy gains or loses skill, 50% chance of either
    // Enemy attacks Character c by decreasing their health by however much skill Enemy has
    public void attack(Character c) {
        if(Math.random() < 0.5)
            this.changeSkill(5);
        else
            this.changeSkill(-5);
        c.decreaseHealth(this.getSkill());
    }
}
