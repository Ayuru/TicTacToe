package game;

import game.extended.ExtendedPlayer;
import game.extended.Monster;

public class Messages {
    public void difficulty() {
        System.out.println("""
                Pick a game mode:
                 1 - Classic 3x3 with other player
                 2 - Classic 3x3 with computer
                 3 - Classic 10x10 with other player
                 4 - Battle edition with other player""");
    }

    public void pickPlayerName(int number, String mark) {
        System.out.println("\nPlayer " + number + ", you'll use " + mark + ". What's your name?");
    }

    public void repeatPlayerName() {
        System.out.println("You have to choose different name. What's your name?");
    }

    public void pickMove(String name) {
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

    public void endResult(Players players) {
        System.out.println("\nEND RESULT:");
        System.out.println(players.getPlayerOne().getName() + " - " + players.getPlayerTwo().getName() + " " + players.getPlayerOne().getPoints() + ":" + players.getPlayerTwo().getPoints());
    }

    public void restart(int step) {
        if (step == 1) {
            System.out.println("\nDo you want to play again? Enter 'yes' if so.");
        } else {
            System.out.println("Restarting the game...");
        }
    }

    public void displayBoard(String[][] board) {
        System.out.println("\n");
        for (String[] strings : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" | " + strings[j]);
            }
            System.out.print(" |\n\n");
        }
    }

    public void displayExtendedBoard(Monster[][] board) {
        System.out.println("\n");
        for (Monster[] monsters : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" | " + monsters[j].getName());
            }
            System.out.print(" |\n\n");
        }
    }

    public void tutorial() {
        System.out.println("\nHow do game coordinates work?");
        System.out.println("Just enter two numbers (separated by SPACE) presenting row and column.\n");
        System.out.println("     1      2     3\n");
        System.out.println("1  | 1 1 |  1 2 | 1 3 |");
        System.out.println("2  | 2 1 |  2 2 | 2 3 |");
        System.out.println("3  | 3 1 |  3 2 | 3 3 |\n");
        System.out.println("After reading press 'ENTER'.");
    }

    public void monsterBattleCard(Monster monster) {
        System.out.println("\n#################");
        System.out.println(monster.getName());
        System.out.println(" HP: " + monster.getHp());
        System.out.println("#################\n");
    }

    public void playerBattleCard(ExtendedPlayer player) {
        System.out.println("#################");
        System.out.println(player.getPlayerClass().getClass());
        System.out.println(" Level: " + player.getPlayerClass().getLevel());
        System.out.println(" HP: " + player.getPlayerClass().getCurrentHP());
        System.out.println("#################\n");
    }

}
