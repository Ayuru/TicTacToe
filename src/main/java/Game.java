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
        if (difficulty.equals("1")) {
            GameBoard board = new GameBoard();
            board.play();
        } else {
            System.out.println("Nothing new here, bye!");
            ExtendedGameBoard board = new ExtendedGameBoard();
            board.play();
        }

    }
}
