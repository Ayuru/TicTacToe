package game.extended;

public interface PlayerClass {
    int attack();

    void defend(int damage);

    void levelUp();

    int getCurrentHP();

    void heal();

}
