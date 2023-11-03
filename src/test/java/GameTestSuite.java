import game.Player;
import game.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTestSuite {

    @Test
    void testCalculateVictoryThreeInRow() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(2,1));
        player.addMove(new Coordinates(2,3));

        //When
        player.addMove(new Coordinates(2,2));
        boolean victory = player.win();

        //Then
        assertTrue(victory);
    }


    @Test
    void testCalculateVictoryThreeInColumn() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(1,1));
        player.addMove(new Coordinates(3,1));

        //When
        player.addMove(new Coordinates(2,1));
        boolean victory = player.win();

        //Then
        assertTrue(victory);
    }

    @Test
    void testCalculateVictoryThreeInCross() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(1,1));
        player.addMove(new Coordinates(2,2));

        //When
        player.addMove(new Coordinates(3,3));
        boolean victory = player.win();

        //Then
        assertTrue(victory);
    }

    @Test
    void testCalculateNoVictoryTwoInRow() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(2,1));
        player.addMove(new Coordinates(3,2));

        //When
        player.addMove(new Coordinates(2,2));
        boolean victory = player.win();

        //Then
        assertFalse(victory);
    }

    @Test
    void testCalculateNoVictoryThreeInColumn() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(1,1));
        player.addMove(new Coordinates(2,1));

        //When
        player.addMove(new Coordinates(1,2));
        boolean victory = player.win();

        //Then
        assertFalse(victory);
    }

    @Test
    void testCalculateNoVictoryTwoInCross() {
        //Given
        Player player = new Player("Test", "X" );
        player.addMove(new Coordinates(1,3));
        player.addMove(new Coordinates(2,2));

        //When
        player.addMove(new Coordinates(3,3));
        boolean victory = player.win();

        //Then
        assertFalse(victory);
    }
}