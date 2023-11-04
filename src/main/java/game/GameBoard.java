package game;

import java.util.Scanner;

public class GameBoard {
    private Player playerOne;
    private Player playerTwo;
    private boolean restart = true;
    private String[][] board;
    private final Scanner scanner = new Scanner(System.in);
    private final GameLogic gameLogic = new GameLogic();
    private final Messages message = new Messages();

    public void play() {
        intro();
        message.tutorial();
        scanner.nextLine();
        message.go();
        while(restart) {
            board = gameLogic.generateBoard();
            gamePlay();
            restart = restartOption();
        }
    }

    public void intro() {
        String name;
        message.pickPlayerName(1, "'X'");
        name = scanner.nextLine();
        playerOne = new Player(name, "X");
        message.pickPlayerName(2, "'Y'");
        name= scanner.nextLine();

        while(name.equals(playerOne.getName())) {
            message.repeatPlayerName();
            name= scanner.nextLine();
        }

        playerTwo = new Player(name, "O");
    }


    public void gamePlay() {

        boolean end = false;

        while (!end) {
            message.displayBoard(board);
            end = pickYourMoveX();
            if (!end) {
                message.displayBoard(board);
                end = pickYourMoveO();
            }
        }
        message.displayBoard(board);
        message.endResult(playerOne, playerTwo);
        playerOne.clearMoves();
        playerTwo.clearMoves();
    }

    public boolean restartOption() {
        scanner.nextLine();
        message.restart(1);
        String input = scanner.nextLine();
        if (input.equals("yes") || input.equals("YES")) {
            message.restart(2);
            restart = true;
            Players players = gameLogic.switchPlayers(playerOne, playerTwo);
            playerOne = players.getPlayerOne();
            playerTwo = players.getPlayerTwo();
        } else {
        restart = false;
        }
        return restart;
    }

    public boolean pickYourMoveX() {
        pickYourMove(playerOne);
        return gameLogic.resultCheck(playerOne);
    }

    public boolean pickYourMoveO() {
        pickYourMove(playerTwo);
        return gameLogic.resultCheck(playerTwo);
    }

    private void pickYourMove(Player player) {
        boolean availability = true;
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
        player.addMove(coordinates);
        board[coordinates.getRow() - 1][coordinates.getColumn() - 1] = "  " + player.getMark() + "  ";
    }

}
