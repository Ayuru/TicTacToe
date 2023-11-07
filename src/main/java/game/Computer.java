package game;

public class Computer {
    int move;

    public int move(Player player, Player computer) {

        if (player.getMoves().size() + computer.getMoves().size() < 2) {
            move = 11;
        } else if (player.getMoves().size() + computer.getMoves().size() < 4) {
            move = 13;
        }

        return move;
    }
}
