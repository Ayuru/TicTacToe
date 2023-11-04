package game;

public class Messages {
    public void difficulty() {
        System.out.println("Pick a difficulty level: 1 - Classic, 2 - Extended");
    }

    public void pickPlayerName(int number, String mark) {
        System.out.println("\nPlayer " + number + ", you'll use " + mark + ". What's your name?");
    }

    public void repeatPlayerName() {
        System.out.println("You have to choose different name. What's your name?");
    }

    public void pickMove (String name) {
        System.out.println(name + ", pick your move ");
    }

    public void go() {
        System.out.println("\nLet's go!");
    }

    public void endResult(Player playerOne, Player playerTwo) {
        System.out.println("\nEND RESULT:");
        System.out.println(playerOne.getName() +  " - " + playerTwo.getName() + " " + playerOne.getPoints() + ":" + playerTwo.getPoints());
    }

    public void restart(int step) {
        if(step == 1) {
            System.out.println("\nDo you want to play again? Enter 'yes' if so.");
        }
        else {
            System.out.println("Restarting the game...");
        }
    }

    public void displayBoard(String[][] board) {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.print( " |\n\n");
        }
    }

    public void tutorial() {
        System.out.println("How do game coordinates work?");
        System.out.println("Just enter double digit number presenting row and column.\n");
        System.out.println("     1     2    3\n");
        System.out.println("1  | 11 |  12 | 13 |");
        System.out.println("2  | 21 |  22 | 23 |");
        System.out.println("3  | 31 |  32 | 33 |\n");
        System.out.println("After reading press 'ENTER'.");
    }
}
