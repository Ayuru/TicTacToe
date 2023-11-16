package game;


public class GameLogic {

    public boolean availabilityCheck(Coordinates move, Players players) {
        return players.getPlayerOne().getMoves().contains(move) || players.getPlayerTwo().getMoves().contains(move);
    }

    public boolean rangeCheck(Coordinates move, int size) {
        return (move.getRow() > size || move.getRow() < 1) || (move.getColumn() > size || move.getColumn() < 1);
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


