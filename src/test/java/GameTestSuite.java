import game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTestSuite {
    private static final int WIN_SIZE_3 = 3;
    private static final int WIN_SIZE_5 = 5;



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
            boolean victory = player.win(WIN_SIZE_3);

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
            boolean victory = player.win(WIN_SIZE_5);

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
            boolean victory = player.win(WIN_SIZE_3);

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
            boolean victory = player.win(WIN_SIZE_5);

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
            boolean victory = player.win(WIN_SIZE_3);

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
            boolean victory = player.win(WIN_SIZE_5);

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
            boolean victory = player.win(WIN_SIZE_3);

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
            boolean victory = player.win(WIN_SIZE_3);

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
            boolean victory = player.win(WIN_SIZE_3);

            //Then
            assertFalse(victory);
        }

    }

}