package game;

import java.util.Scanner;

public class GameSetup {


    public void run() {

        enum GameMode {
            MultiPlayer, SinglePlayer
        }

        Messages message = new Messages();
        Scanner scanner = new Scanner(System.in);
        String difficulty;
        message.difficulty();
        difficulty = scanner.nextLine();

        switch (difficulty) {
            case "1" -> {
                GameBoard board = new GameBoard(3, 3, message, scanner);
                board.play(GameMode.MultiPlayer.ordinal());
            }
            case "2" -> {
                GameBoard board = new GameBoard(3, 3, message, scanner);
                board.play(GameMode.SinglePlayer.ordinal());
            }
            case "3" -> {
                GameBoard board = new GameBoard(10, 5, message, scanner);
                board.play(GameMode.MultiPlayer.ordinal());
            }
            case "4" -> {


            }
            default -> System.out.println("Nothing here (for now?), bye!");
        }

        scanner.close();
    }
}
