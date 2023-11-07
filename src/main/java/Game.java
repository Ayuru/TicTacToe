import game.GameBoard;
import game.Messages;
import game.extended.ExtendedGameBoard;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Messages message = new Messages();
        Scanner scanner = new Scanner(System.in);
        String difficulty;
        message.difficulty();
        difficulty = scanner.nextLine();
        switch (difficulty) {
            case "1" -> {
                GameBoard board = new GameBoard(3, 3);
                board.play(1);
            }
            case "2" -> {
                GameBoard board = new GameBoard(3, 3);
                board.play(2);
            }
            case "3" -> {
                GameBoard board = new GameBoard(10, 5);
                board.play(1);
            }
            case "4" -> {
                ExtendedGameBoard board = new ExtendedGameBoard(3, 3);
                board.play();

            }
            default -> System.out.println("Nothing here (for now?), bye!");
        }

    }
}
