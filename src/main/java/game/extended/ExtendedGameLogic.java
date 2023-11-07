package game.extended;

import game.GameLogic;
import game.Players;

public class ExtendedGameLogic extends GameLogic {

    public Monster[][] generateExtendedBoard(int size) {
        Dice dice = new Dice();
        int roll;

        Monster[][] marks = new Monster[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                roll = dice.roll(6);
                if (roll % 2 == 0) {
                    marks[i][j] = new Goblin();
                } else if (roll == 1) {
                    marks[i][j] = new Troll();
                } else {
                    marks[i][j] = new Orc();
                }
            }
        }
        return marks;
    }

    public ExtendedPlayers switchPlayers(ExtendedPlayer playerOne, ExtendedPlayer playerTwo) {
        return new ExtendedPlayers(playerTwo, playerOne);
    }
}
