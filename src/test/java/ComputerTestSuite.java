import game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTestSuite {

    private static final String COMPUTER_NAME = "Computer";

    @Nested
    @DisplayName("Testing Computer AI")

    class TestComputer {

        @Test
        void testComputerMoveStart() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 1, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(2, 2), computerMove);
        }

        @Test
        void testComputersMoveSecondMiddleNotAvailable() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerOne().addMove(new Coordinates(2, 2));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 2, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(1, 1), computerMove);
        }

        @Test
        void testComputersMoveSecondMiddleAvailable() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerOne().addMove(new Coordinates(1, 1));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 2, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(2, 2), computerMove);
        }

        @Test
        void testComputersMoveTryToWinRow() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerTwo().addMove(new Coordinates(1, 1));
            players.getPlayerOne().addMove(new Coordinates(2, 1));
            players.getPlayerTwo().addMove(new Coordinates(1, 2));
            players.getPlayerOne().addMove(new Coordinates(3, 1));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(1, 3), computerMove);
        }

        @Test
        void testComputersMoveTryNotToLoseRow() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerOne().addMove(new Coordinates(1, 1));
            players.getPlayerTwo().addMove(new Coordinates(2, 2));
            players.getPlayerOne().addMove(new Coordinates(1, 2));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(1, 3), computerMove);
        }

        @Test
        void testComputersMoveTryToWinColumn() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerTwo().addMove(new Coordinates(1, 1));
            players.getPlayerOne().addMove(new Coordinates(1, 2));
            players.getPlayerTwo().addMove(new Coordinates(3, 1));
            players.getPlayerOne().addMove(new Coordinates(3, 3));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(2, 1), computerMove);
        }

        @Test
        void testComputersMoveTryNotToLoseColumn() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerOne().addMove(new Coordinates(1, 1));
            players.getPlayerTwo().addMove(new Coordinates(2, 2));
            players.getPlayerOne().addMove(new Coordinates(3, 1));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(2, 1), computerMove);
        }

        @Test
        void testComputersMoveTryToWinCross() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerTwo().addMove(new Coordinates(2, 2));
            players.getPlayerOne().addMove(new Coordinates(1, 3));
            players.getPlayerTwo().addMove(new Coordinates(1, 1));
            players.getPlayerOne().addMove(new Coordinates(1, 2));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(3, 3), computerMove);
        }

        @Test
        void testComputersMoveTryNotToLoseCross() {
            //Given
            Player player1 = new Player("Test", "X");
            Player player2 = new Player("Computer", "O");

            Players players = new Players(player1, player2);
            players.getPlayerOne().addMove(new Coordinates(2, 2));
            players.getPlayerTwo().addMove(new Coordinates(1, 1));
            players.getPlayerOne().addMove(new Coordinates(1, 3));
            Computer computer = new Computer();
            GameLogic gameLogic = new GameLogic();

            //When
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic, COMPUTER_NAME);


            //Then
            assertEquals(new Coordinates(3, 1), computerMove);
        }
    }

}
