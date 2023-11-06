package game;

public class Messages {
    public void difficulty() {
        System.out.println("Pick a game mode:\n 1 - Classic with other player\n 2 - Classic with computer\n 3 - Battle edition with other player");
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

    public void fieldVerification(int number) {
        if (number == 1) {
            System.out.println("This field is already taken. Pick another one!");
        } else {
            System.out.println("This field is out of range. Pick another one!");
        }
    }

    public void go() {
        System.out.println("\nLet's go!");
    }

    public void resultVerification(int number, Player player) {
        if (number == 1) {
            System.out.println("Congratulations, " + player.getName() + ". You've won.");
        } else {
            System.out.println("The game have ended with a draw. Good luck next time.");
        }
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
        System.out.println("\nHow do game coordinates work?");
        System.out.println("Just enter double digit number presenting row and column.\n");
        System.out.println("     1     2    3\n");
        System.out.println("1  | 11 |  12 | 13 |");
        System.out.println("2  | 21 |  22 | 23 |");
        System.out.println("3  | 31 |  32 | 33 |\n");
        System.out.println("After reading press 'ENTER'.");
    }
}
