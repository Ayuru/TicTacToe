package game.extended;

import java.util.Random;

public class Dice {
    Random generator = new Random();

    public int roll(int size) {
        return generator.nextInt(size) + 1;
    }

}
