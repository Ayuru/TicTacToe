package game.extended;

public class Goblin implements Monster{

    String name = "GOBLIN";
    private int hp = 12;
    private int attack = 4;
    private int experiencePoints = 5;
    private Dice dice = new Dice();

    public int attack(){
        int damage = attack + dice.roll(2);
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
