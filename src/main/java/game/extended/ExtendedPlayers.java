package game.extended;

import game.Player;

public class ExtendedPlayers {

    private final ExtendedPlayer PlayerOne;
    private final ExtendedPlayer PlayerTwo;

    public ExtendedPlayers(ExtendedPlayer playerOne, ExtendedPlayer playerTwo) {
        PlayerOne = playerOne;
        PlayerTwo = playerTwo;
    }

    public ExtendedPlayer getPlayerOne() {
        return PlayerOne;
    }

    public ExtendedPlayer getPlayerTwo() {
        return PlayerTwo;
    }
}
