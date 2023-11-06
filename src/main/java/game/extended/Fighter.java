package game.extended;

public class Fighter implements PlayerClass {

    private int experiencePoints = 0;
    private int level = 1;
    private int baseHP = 15;
    private int currentHP = 15;
    private int attack = 8;

    private Dice dice = new Dice();

    public int attack() {
        int damage = attack + dice.roll(4);
        System.out.println("Hit: " + damage);
        return damage;
    }

    public void defend(int damage) {
        currentHP = currentHP - damage;
    }

    public void levelUp() {
        level = level + 1;
        baseHP = baseHP + 6 + dice.roll(3);
        currentHP = baseHP;
        attack = attack + 2 + dice.roll(2);
    }

    public void heal() {
        currentHP = baseHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

}
