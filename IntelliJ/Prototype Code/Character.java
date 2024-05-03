public abstract class Character{
   private int skill;
   private int health;
   private String name;

   public Character(int skill, int health, String name) {
       this.skill = skill;
       this.health = health;
       this.name = name;
   }
    public void changeSkill(int s) {
        this.skill = this.skill + s;
        if (this.skill < 0)
            this.skill = 0;
    }
    public void changeHealth(int h) {
        this.health = this.health - h;
    }
    public int getSkill() {
        return this.skill;
    }
    public int getHealth() {
        return this.health;
    }
    public String getName() {
       return this.name;
    }
    public abstract void attack(Character c);
}