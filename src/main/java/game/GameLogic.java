package game;


public class GameLogic {

    public boolean availabilityCheck(Coordinates move, Players players, Messages message) {
        if (players.getPlayerOne().getMoves().contains(move) || players.getPlayerTwo().getMoves().contains(move)) {
            message.fieldVerification(1);
            return true;
        } else {
            return false;
        }
    }

    public boolean rangeCheck(Coordinates move, int size, Messages message) {
        if ((move.getRow() > size || move.getRow() < 1) || (move.getColumn() > size || move.getColumn() < 1)) {
            message.fieldVerification(2);
            return true;
        } else {
            return false;
        }
    }

    public boolean resultCheck(Player player, int boardSize, int winSize, int round, Messages message) {
        if (player.win(winSize)) {
            message.resultVerification(1, player);
            player.updatePoints();
            return true;
        } else if (round == boardSize * boardSize) {
            message.resultVerification(2, player);
            return true;
        } else return false;
    }

}


