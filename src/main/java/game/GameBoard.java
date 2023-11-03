package game;

import java.util.Scanner;

public class GameBoard {
    private Player playerOne;
    private Player playerTwo;
    private boolean restart = true;
    private String[][] board;
    private final Scanner scanner = new Scanner(System.in);

    private GameLogic gameLogic = new GameLogic();



    public void play() {
        intro();
        while(restart) {
            board = gameLogic.generateBoard();
            gamePlay();
            restart = restartOption();
        }
    }

    public void intro() {
        String name;
        System.out.println("\nPlayer 1, you'll use 'X'. What's your name?");
        name = scanner.nextLine();
        playerOne = new Player(name, "X");
        System.out.println("\nPlayer 2,  you'll use 'O'. What's your name?");
        name= scanner.nextLine();

        while(name.equals(playerOne.getName())) {
            System.out.println("You have to choose different name. What's your name?");
            name= scanner.nextLine();
        }

        playerTwo = new Player(name, "O");
        System.out.println("\nLet's go!");
    }


    public void gamePlay() {

        boolean end = false;

        while (!end){
            displayBoard();
            end  = pickYourMoveX();
            if (!end){
            displayBoard();
            end = pickYourMoveO();}
        }
        System.out.println("\nEND RESULT:");
        System.out.println(playerOne.getName() +  " - " + playerTwo.getName() + " " + playerOne.getPoints() + ":" + playerTwo.getPoints());
        playerOne.clearMoves();
        playerTwo.clearMoves();
    }

    public boolean restartOption() {
        scanner.nextLine();
        System.out.println("\nDo you want to play again? Enter 'yes' if so.");
        String input = scanner.nextLine();
        if (input.equals("yes") || input.equals("YES")) {
            System.out.println("Restarting the game...");
            restart = true;
            Players players = gameLogic.switchPlayers(playerOne, playerTwo);
            playerOne = players.getPlayerOne();
            playerTwo = players.getPlayerTwo();
        } else {
        restart = false;
        }
        return restart;
    }

    public void displayBoard() {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.print( " |\n\n");
        }
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
        System.out.println(player.getName() + ", pick your move ");
        while (availability || range) {
            try {
            coordinates.convert(scanner.nextInt());
                availability = gameLogic.availabilityCheck(coordinates, playerOne, playerTwo);
                int size = 3;
                range = gameLogic.rangeCheck(coordinates, size);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Oh no! Something went wrong! Error: " + e + "\nLets try again!");
                System.out.println(player.getName() + ", pick your move ");
            }
        }
        player.addMove(coordinates);
        board[coordinates.getRow() - 1][coordinates.getColumn() - 1] = "  " + player.getMark() + "  ";
    }

}
