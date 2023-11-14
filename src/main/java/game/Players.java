package game;

public class Players {

    private Player playerOne;
    private Player playerTwo;

    public Players(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void switchPlayers() {
        Player substitute;
        substitute = playerOne;
        playerOne = playerTwo;
        playerTwo = substitute;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
