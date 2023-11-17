import game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTestSuite {
    int winSize3 = 3;
    int winSize5 = 5;


    @Nested
    @DisplayName("Testing Game Logic")

    class TestGameLogic {
        @Test
        void testCalculateVictoryThreeInRow() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(2, 1));
            player.addMove(new Coordinates(2, 3));

            //When
            player.addMove(new Coordinates(2, 2));
            boolean victory = player.win(winSize3);

            //Then
            assertTrue(victory);
        }

        @Test
        void testCalculateVictoryFiveInRow() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(7, 1));
            player.addMove(new Coordinates(7, 3));
            player.addMove(new Coordinates(7, 4));
            player.addMove(new Coordinates(7, 5));

            //When
            player.addMove(new Coordinates(7, 2));
            boolean victory = player.win(winSize5);

            //Then
            assertTrue(victory);
        }


        @Test
        void testCalculateVictoryThreeInColumn() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 1));
            player.addMove(new Coordinates(3, 1));

            //When
            player.addMove(new Coordinates(2, 1));
            boolean victory = player.win(winSize3);

            //Then
            assertTrue(victory);
        }

        @Test
        void testCalculateVictoryFiveInColumn() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 10));
            player.addMove(new Coordinates(2, 10));
            player.addMove(new Coordinates(3, 10));
            player.addMove(new Coordinates(5, 8));
            player.addMove(new Coordinates(5, 10));

            //When
            player.addMove(new Coordinates(4, 10));
            boolean victory = player.win(winSize5);

            //Then
            assertTrue(victory);
        }

        @Test
        void testCalculateVictoryThreeInCross() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 1));
            player.addMove(new Coordinates(2, 2));

            //When
            player.addMove(new Coordinates(3, 3));
            boolean victory = player.win(winSize3);

            //Then
            assertTrue(victory);
        }

        @Test
        void testCalculateVictoryFiveInCross() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 1));
            player.addMove(new Coordinates(2, 2));
            player.addMove(new Coordinates(4, 4));
            player.addMove(new Coordinates(5, 5));

            //When
            player.addMove(new Coordinates(3, 3));
            boolean victory = player.win(winSize5);

            //Then
            assertTrue(victory);
        }

        @Test
        void testCalculateNoVictoryTwoInRow() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(2, 1));
            player.addMove(new Coordinates(3, 2));

            //When
            player.addMove(new Coordinates(2, 2));
            boolean victory = player.win(winSize3);

            //Then
            assertFalse(victory);
        }

        @Test
        void testCalculateNoVictoryThreeInColumn() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 1));
            player.addMove(new Coordinates(2, 1));

            //When
            player.addMove(new Coordinates(1, 2));
            boolean victory = player.win(winSize3);

            //Then
            assertFalse(victory);
        }

        @Test
        void testCalculateNoVictoryTwoInCross() {
            //Given
            Player player = new Player("Test", "X");
            player.addMove(new Coordinates(1, 3));
            player.addMove(new Coordinates(2, 2));

            //When
            player.addMove(new Coordinates(3, 3));
            boolean victory = player.win(winSize3);

            //Then
            assertFalse(victory);
        }

    }

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
            Coordinates computerMove = computer.move(players, 3, 1, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 2, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 2, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 5, gameLogic);


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
            Coordinates computerMove = computer.move(players, 3, 4, gameLogic);


            //Then
            assertEquals(new Coordinates(3, 1), computerMove);
        }
    }


}