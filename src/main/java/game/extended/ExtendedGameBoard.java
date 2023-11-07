package game.extended;
import game.Coordinates;
import game.Messages;


import java.util.Scanner;

public class ExtendedGameBoard {


    private boolean restart = true;
    private ExtendedPlayer playerOne;
    private ExtendedPlayer playerTwo;

    private final Scanner scanner = new Scanner(System.in);

    private Monster[][] board;
    private int size;

    private final ExtendedGameLogic gameLogic = new ExtendedGameLogic();

    private final Messages message = new Messages();

    public ExtendedGameBoard(int size) {
        this.size = size;
    }

    public void play() {
        extendedIntro();
        message.tutorial();
        scanner.nextLine();
        message.go();
        while(restart) {
            board = gameLogic.generateExtendedBoard(size);
            gamePlay();
            restart = restartOption();
        }
    }

    public void extendedIntro() {
        String name;
        message.pickPlayerName(1, "'X'");
        name = scanner.nextLine();
        playerOne = new ExtendedPlayer(name, "X");
        System.out.println(playerOne.getName() + ", pick your class (1 - mage, 2 - fighter). ");
        String code = scanner.nextLine();
        playerOne.addClass(code);

        message.pickPlayerName(2, "'Y'");
        name= scanner.nextLine();

        while(name.equals(playerOne.getName())) {
            message.repeatPlayerName();
            name= scanner.nextLine();
        }

        playerTwo = new ExtendedPlayer(name, "O");
        System.out.println(playerTwo.getName() + ", pick your class (1 - mage, 2 - fighter). ");
        code = scanner.nextLine();
        playerTwo.addClass(code);
    }

    public void gamePlay() {

        boolean end = false;
        int round = 0;

        while (!end) {
            round++;
            message.displayExtendedBoard(board);
            end = pickYourMoveX(round);
            if (!end) {
                round++;
                message.displayExtendedBoard(board);
                end = pickYourMoveO(round);
            }
        }
        message.displayExtendedBoard(board);
        message.endResult(playerOne, playerTwo);
        playerOne.clearMoves();
        playerTwo.clearMoves();
    }

    public boolean pickYourMoveX(int round) {
        pickYourMove(playerOne);
        return gameLogic.resultCheck(playerOne, size, round);
    }

    public boolean pickYourMoveO(int round) {
        pickYourMove(playerTwo);
        return gameLogic.resultCheck(playerTwo, size, round);
    }

    private void pickYourMove(ExtendedPlayer player) {
        boolean availability = true;
        Battle battle = new Battle();
        boolean range = true;
        Coordinates coordinates = new Coordinates(0, 0);
        message.pickMove(player.getName());
        while (availability || range) {
            try {
                coordinates.update(scanner.nextInt(), scanner.nextInt());
                availability = gameLogic.availabilityCheck(coordinates, playerOne, playerTwo);
                int size = 3;
                range = gameLogic.rangeCheck(coordinates, size);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Oh no! Something went wrong! Error: " + e + "\nLets try again!");
                message.pickMove(player.getName());
            }
        }
        if (battle.run(board[coordinates.getRow() - 1][coordinates.getColumn() - 1], player)) {
            player.addMove(coordinates);
            board[coordinates.getRow() - 1][coordinates.getColumn() - 1].setName("  " + player.getMark() + "  ");
        }
    }

    public boolean restartOption() {
        scanner.nextLine();
        message.restart(1);
        String input = scanner.nextLine();
        if (input.equals("yes") || input.equals("YES")) {
            message.restart(2);
            restart = true;
            ExtendedPlayers players = gameLogic.switchPlayers(playerOne, playerTwo);
            playerOne = players.getPlayerOne();
            playerTwo = players.getPlayerTwo();
        } else {
            restart = false;
        }
        return restart;
    }

}

