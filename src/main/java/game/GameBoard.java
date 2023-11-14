package game;

import java.util.Scanner;

public class GameBoard {
    private Player playerOne;
    private Player playerTwo;
    private boolean restart = true;
    private String[][] board;
    private final int boardSize;
    private final int winSize;
    private final Messages message;
    private final GameLogic gameLogic = new GameLogic();

    private final Scanner scanner;


    public GameBoard(int boardSize, int winSize, Messages message, Scanner scanner) {
        this.boardSize = boardSize;
        this.winSize = winSize;
        this.message = message;
        this.scanner = scanner;
    }

    public void play(int mode) {
        intro(mode);
        message.tutorial();
        scanner.nextLine();
        message.go();
        while (restart) {
            board = gameLogic.generateBoard(boardSize);
            gamePlay();
            restart = restartOption();
        }
    }

    public void intro(int mode) {
        String name;
        message.pickPlayerName(1, "'X'");
        name = scanner.nextLine();
        playerOne = new Player(name, "X");
        if (mode == 1) {
            message.pickPlayerName(2, "'Y'");
            name = scanner.nextLine();

            while (name.equals(playerOne.getName())) {
                message.repeatPlayerName();
                name = scanner.nextLine();
            }

            playerTwo = new Player(name, "O");
        } else {
            playerTwo = new Player("Computer", "O");
        }
    }


    public void gamePlay() {

        boolean end = false;
        int round = 0;
        while (!end) {
            round++;
            message.displayBoard(board);
            end = pickYourMoveX(round);
            if (!end) {
                round++;
                message.displayBoard(board);
                end = pickYourMoveO(round);
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

    public boolean pickYourMoveX(int round) {
        pickYourMove(playerOne);
        return gameLogic.resultCheck(playerOne, boardSize, winSize, round, message);
    }

    public boolean pickYourMoveO(int round) {
        pickYourMove(playerTwo);
        return gameLogic.resultCheck(playerTwo, boardSize, winSize, round, message);
    }

    private void pickYourMove(Player player) {
        boolean availability = true;
        boolean range = true;
        Coordinates coordinates = new Coordinates(0, 0);
        message.pickMove(player.getName());
        while (availability || range) {
            try {
                coordinates.update(scanner.nextInt(), scanner.nextInt());
                availability = gameLogic.availabilityCheck(coordinates, playerOne, playerTwo, message);
                range = gameLogic.rangeCheck(coordinates, boardSize, message);
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
