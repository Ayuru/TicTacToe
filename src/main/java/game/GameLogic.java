package game;

public class GameLogic {

    public boolean availabilityCheck(Coordinates move, Player playerOne, Player playerTwo) {
        if (playerOne.getMoves().contains(move) || playerTwo.getMoves().contains(move)) {
            System.out.println("This field is already taken. Pick another one!");
            return true;
        } else {
            return false;
        }
    }

    public boolean rangeCheck(Coordinates move, int size) {
        if ((move.getRow() > size || move.getRow() < 1) || (move.getColumn() > size || move.getColumn() < 1)) {
            System.out.println("This field is out of range. Pick another one!");
            return true;
        } else {
            return false;
        }
    }

    public boolean resultCheck(Player player) {
        if (player.win()) {
            System.out.println("Congratulations, " + player.getName() + ". You've won.");
            player.updatePoints();
            return true;
        } else if (player.getMoves().size() == 5) {
            System.out.println("The game have ended with a draw. Good luck next time.");
            return true;
        } else return false;
    }

    public Players switchPlayers(Player playerOne, Player playerTwo) {
        return new Players(playerTwo, playerOne);
    }


    public String[][] generateBoard() {

        String[][] marks = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = "     ";
            }
        }
        return marks;
    }

}


