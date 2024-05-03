package edu.vassar.cmpu203.batonpass.model;

public abstract class Character {
    private int skill;
    private final int originalSkill;
    private int baselineSkill;
    private int health;
    private final int originalHealth;
    private int baselineHealth;
    private final String name;

    public Character(int skill, int health, String name) {
        this.skill = skill;
        originalSkill = skill;
        baselineSkill = originalSkill;
        this.health = health;
        originalHealth = health;
        baselineHealth = originalHealth;
        this.name = name;
    }

    // change the character's skill
    // if the skill is negative, set it to zero, as a character cannot have negative skill
    public void changeSkill(int s) {
        this.skill = this.skill + s;
        if (this.skill < 0)
            this.skill = 0;
    }

    // decrease the character's health after an attack
    // if the health is negative, set it to zero, as a character cannot have negative health
    public void decreaseHealth(int h) {
        this.health = this.health - h;
        if (this.health < 0)
            this.health = 0;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getSkill() {
        return this.skill;
    }

    public void setSkill(int s) {
        this.skill = s;
    }

    public int getOriginalHealth() {
        return this.originalHealth;
    }

    public int getOriginalSkill() {
       return this.originalSkill;
    }

    public int getBaselineSkill() {
        return this.baselineSkill;
    }
    public void setBaselineSkill(int s) {
       this.baselineSkill= this.baselineSkill+ s;
    }
    public String getName() {
        return this.name;
    }

    // abstract method declared by the superclass and implemented by the subclasses
    public abstract void attack(Character c);
}