package game.extended;

public class Troll implements Monster{

    String name = "TROLL";
    private int hp = 60;
    private int attack = 12;
    private int experiencePoints = 25;
    private Dice dice = new Dice();

    public int attack(){
        int damage = attack + dice.roll(4);
        System.out.println("Hit: " +  damage);
        return damage;
    }

    public void defend(int damage) {
        hp = hp - damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }
}
