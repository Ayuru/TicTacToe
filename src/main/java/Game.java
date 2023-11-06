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
                GameBoard board = new GameBoard();
                board.play();
            }
            case "3" -> {
                ExtendedGameBoard board = new ExtendedGameBoard();
                board.play();
            }
            default -> System.out.println("Nothing here (for now?), bye!");
        }

    }
}
