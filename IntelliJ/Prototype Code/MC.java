public class MC extends Character{
    private int skill;
    private int health;
    private String name;

    public MC(int skill, int health, String name) {
        super(skill, health, name);
    }

    // We have purposefully chosen to create three different classes for the main character, Vin, and enemies.
    // This is so that we have the opportunity to change the attack method for any individual if we so choose later on.
    // Additionally, this is so that we can have each character have a unique reply() method to dialogue and dialogue choices.
    // These aspects are not critical to the minigame, but they will be necessary later in the game.

    public void attack(Character c) {
        c.changeHealth(this.getSkill());
    }
}
