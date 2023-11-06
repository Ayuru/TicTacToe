package game.extended;

public class Orc implements Monster{

    String name = " ORC ";
    private int hp = 40;
    private int attack = 8;
    private int experiencePoints = 15;
    private Dice dice = new Dice();

    public int attack(){
        int damage = attack + dice.roll(3);
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
