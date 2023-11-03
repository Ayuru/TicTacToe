import game.GameBoard;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String difficulty;
        System.out.println("Pick a difficulty level: 1 - Classic, 2 - Extended");
        difficulty = scanner.nextLine();
        if (difficulty.equals("1")) {
            GameBoard board = new GameBoard();
            board.play();
        } else {
            System.out.println("Nothing new here, bye!");
        }

    }
}
