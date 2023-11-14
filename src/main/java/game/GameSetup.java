package game;

import game.extended.ExtendedGameBoard;

import java.util.Scanner;

public class GameSetup {

    public enum GameMode {
        Classic3x3Multiplayer, Classic5x5Multiplayer, Classic3x3Singleplayer, Extended
    }

    public void run() {
        Messages message = new Messages();
        Scanner scanner = new Scanner(System.in);
        String difficulty;
        message.difficulty();
        difficulty = scanner.nextLine();
        switch (difficulty) {
            case "1" -> {
                GameBoard board = new GameBoard(3, 3, message, scanner);
                board.play(1);
            }
            case "2" -> {
                GameBoard board = new GameBoard(3, 3, message, scanner);
                board.play(2);
            }
            case "3" -> {
                GameBoard board = new GameBoard(10, 5, message, scanner);
                board.play(1);
            }
            case "4" -> {
                ExtendedGameBoard board = new ExtendedGameBoard(3, 3, message);
                board.play();

            }
            default -> System.out.println("Nothing here (for now?), bye!");
        }

        scanner.close();
    }
}
