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

    private final ExtendedGameLogic gameLogic = new ExtendedGameLogic();

    private final Messages message = new Messages();


    public void play() {
        extendedIntro();
        message.tutorial();
        scanner.nextLine();
        message.go();
        while(restart) {
            board = gameLogic.generateExtendedBoard();
            gamePlay();

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

        while (!end) {
            message.displayExtendedBoard(board);
            end = pickYourMoveX();
            if (!end) {
                message.displayExtendedBoard(board);
                end = pickYourMoveO();
            }
        }
        message.displayExtendedBoard(board);
        message.endResult(playerOne, playerTwo);
        playerOne.clearMoves();
        playerTwo.clearMoves();
    }

    public boolean pickYourMoveX() {
        pickYourMove(playerOne);
        return gameLogic.resultCheck(playerOne);
    }

    public boolean pickYourMoveO() {
        pickYourMove(playerTwo);
        return gameLogic.resultCheck(playerTwo);
    }

    private void pickYourMove(ExtendedPlayer player) {
        boolean availability = true;
        Battle battle = new Battle();
        boolean range = true;
        Coordinates coordinates = new Coordinates(0, 0);
        message.pickMove(player.getName());
        while (availability || range) {
            try {
                coordinates.convert(scanner.nextInt());
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

}

