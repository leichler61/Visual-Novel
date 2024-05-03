public class Vin extends Character {
    private int skill;
    private int health;
    private String name;
    public Vin(int skill, int health, String name) {
       super(skill, health, name);
    }
    public void attack(Character c) {
        if(Math.random() < 0.5)
            this.changeSkill(5);
        else
            this.changeSkill(-5);
        c.changeHealth(this.getSkill());
    }
    // The Vin class currently exists as its own class so we can later implement Vin's unique reply() method to dialogue.
}
