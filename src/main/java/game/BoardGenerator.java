package game;

public class BoardGenerator {

    public String[][] generateBoard(int size) {

        String[][] marks = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                marks[i][j] = "     ";
            }
        }
        return marks;
    }
}
