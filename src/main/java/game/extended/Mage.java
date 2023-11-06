package game.extended;

public class Mage implements PlayerClass {

    private int experiencePoints = 0;
    private int level = 1;
    private int baseHP = 7;
    private int currentHP = 7;
    private int attack = 12;
    private Dice dice = new Dice();

    public int attack(){
        int damage = attack + dice.roll(6);
        System.out.println("Hit: " +  damage);
        return damage;
    }

    public void defend(int damage) {
        currentHP = currentHP - damage;
    }

    public void levelUp() {
        level = level + 1;
        baseHP = baseHP + 4 + dice.roll(2);
        currentHP = baseHP;
        attack = attack + 4 + dice.roll(3);
    }

    public void heal() {
        currentHP = baseHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }
}
