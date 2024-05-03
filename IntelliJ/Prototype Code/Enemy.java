public class Enemy extends Character{
    private int skill;
    private int health;
    private String name;

    public Enemy(int skill, int health, String name) {
        super(skill, health, name);
    }

    public void attack(Character c) {
        if(Math.random() < 0.5)
            this.changeSkill(5);
        else
            this.changeSkill(-5);
        c.changeHealth(this.getSkill());
    }

    // The Enemy class exists if we want to create enemies that have unique characteristics or methods to the main characters.
    // Additionally, the enemies do not need the same reply() method to dialogue that the two main characters will have.

}
