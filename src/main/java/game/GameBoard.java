package game;

import java.util.Scanner;

public class GameBoard {
    private Players players;
    private boolean restart = true;
    private String[][] board;
    private final int boardSize;
    private final int winSize;
    private final Messages message;
    private final GameLogic gameLogic = new GameLogic();

    private final Scanner scanner;

    private Coordinates coordinates = new Coordinates(0, 0);


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
        BoardGenerator generator = new BoardGenerator();

        while (restart) {
            board = generator.generateBoard(boardSize);
            gamePlay(mode);
            restart = restartOption();
        }
    }

    public void intro(int mode) {
        String name;
        message.pickPlayerName(1, "'X'");
        name = scanner.nextLine();
        Player playerOne = new Player(name, "X");
        Player playerTwo;
        if (mode == 0) {
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
        players = new Players(playerOne, playerTwo);
    }


    public void gamePlay(int mode) {

        boolean end = false;
        int round = 0;
        while (!end) {
            round++;
            message.displayBoard(board);
            end = resultVerificationX(round);
            if (!end) {
                round++;
                if (mode == 0) {
                    message.displayBoard(board);
                    end = resultVerificationO(round);
                } else {
                    end = resultVerificationComputer(round);
                }
            }
        }
        message.displayBoard(board);
        message.endResult(players);
        players.getPlayerOne().clearMoves();
        players.getPlayerTwo().clearMoves();
    }

    public boolean restartOption() {
        scanner.nextLine();
        message.restart(1);
        String input = scanner.nextLine();
        if (input.equals("yes") || input.equals("YES")) {
            message.restart(2);
            restart = true;
            players.switchPlayers();
        } else {
            restart = false;
        }
        return restart;
    }

    public boolean resultVerificationX(int round) {
        moveVerification(players.getPlayerOne());
        return gameLogic.resultCheck(players.getPlayerOne(), boardSize, winSize, round, message);
    }

    public boolean resultVerificationO(int round) {
        moveVerification(players.getPlayerTwo());
        return gameLogic.resultCheck(players.getPlayerTwo(), boardSize, winSize, round, message);
    }

    public boolean resultVerificationComputer(int round) {
        if (players.getPlayerOne().getName().equals("Computer")) {
            moveVerificationComputer(players.getPlayerOne(), round);
        } else {
            moveVerificationComputer(players.getPlayerTwo(), round);
        }
        return gameLogic.resultCheck(players.getPlayerTwo(), boardSize, winSize, round, message);
    }

    private void moveVerification(Player player) {
        boolean availability = true;
        boolean range = true;
        message.pickMove(player.getName());
        while (availability || range) {
            try {
                coordinates.update(scanner.nextInt(), scanner.nextInt());
                availability = gameLogic.availabilityCheck(coordinates, players);
                if(availability) message.fieldVerification(1);
                range = gameLogic.rangeCheck(coordinates, boardSize);
                if(range) message.fieldVerification(2);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Oh no! Something went wrong! Error: " + e + "\nLets try again!");
                message.pickMove(player.getName());
            }
        }
        player.addMove(coordinates);
        board[coordinates.getRow() - 1][coordinates.getColumn() - 1] = "  " + player.getMark() + "  ";
    }

    private void moveVerificationComputer(Player computer, int round) {
        Computer computerLogic = new Computer();
        System.out.println(players);
        System.out.println(boardSize);
        System.out.println(round);
        Coordinates computerMove = computerLogic.move(players, boardSize, round, gameLogic);
        computer.addMove(computerMove);
        board[computerMove.getRow() - 1][computerMove.getColumn() - 1] = "  " + computer.getMark() + "  ";
    }

}
