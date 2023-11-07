package game;


public class GameLogic {

    Messages message = new Messages();

    public boolean availabilityCheck(Coordinates move, Player playerOne, Player playerTwo) {
        if (playerOne.getMoves().contains(move) || playerTwo.getMoves().contains(move)) {
            message.fieldVerification(1);
            return true;
        } else {
            return false;
        }
    }

    public boolean rangeCheck(Coordinates move, int size) {
        if ((move.getRow() > size || move.getRow() < 1) || (move.getColumn() > size || move.getColumn() < 1)) {
            message.fieldVerification(2);
            return true;
        } else {
            return false;
        }
    }

    public boolean resultCheck(Player player, int size, int round) {
        if (player.win()) {
            message.resultVerification(1, player);
            player.updatePoints();
            return true;
        } else if (round == size * size) {
            message.resultVerification(2, player);
            return true;
        } else return false;
    }

    public Players switchPlayers(Player playerOne, Player playerTwo) {
        return new Players(playerTwo, playerOne);
    }


    public String[][] generateBoard(int size) {

        String[][] marks = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                marks[i][j] = "     ";
            }
        }
        return marks;
    }

}


