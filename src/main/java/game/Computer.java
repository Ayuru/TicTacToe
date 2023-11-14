package game;

public class Computer {


    public int move(Player player, Player computer, int boardSize, int round) {

        Coordinates move = new Coordinates(boardSize /2, boardSize /2);
        if (round == 1) {
            computer.addMove(move);
        } else if (round == 2) {
            if (player.getMoves().contains(move)) {
                computer.addMove(move.neighbourNE());
            } else {
                computer.addMove(move);
            }
        } else if (round == 3) {
            move = player.getMoves().get(player.getMoves().size() - 1);

        } else if (round == 4) {

        }

        return 0;
    }
}
