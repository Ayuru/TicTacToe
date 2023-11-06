package game.extended;

import game.GameLogic;

public class ExtendedGameLogic extends GameLogic {

    public Monster[][] generateExtendedBoard() {
        Dice dice = new Dice();
        int roll;

        Monster[][] marks = new Monster[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roll = dice.roll(6);
                if(roll % 2 == 0) {
                    marks[i][j] = new Goblin();
                } else if(roll == 1) {
                    marks[i][j] = new Troll();
                } else {
                    marks[i][j] = new Orc();
                }
            }
        }
        return marks;
    }
}
