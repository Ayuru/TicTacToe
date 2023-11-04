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
}
