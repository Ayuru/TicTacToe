package game;

public class Players {

    private final Player PlayerOne;
    private final Player PlayerTwo;

    public Players(Player playerOne, Player playerTwo) {
        PlayerOne = playerOne;
        PlayerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return PlayerOne;
    }

    public Player getPlayerTwo() {
        return PlayerTwo;
    }
}
