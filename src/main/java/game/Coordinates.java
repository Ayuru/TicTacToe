package game;

import java.util.Objects;

public class Coordinates {
    private int row;
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void update(int a, int b) {
        row = a;
        column = b;
    }

    public Coordinates neighbourNorth() {
        return new Coordinates(row - 1, column);
    }

    public Coordinates neighbourSouth() {
        return new Coordinates(row + 1, column);
    }

    public Coordinates neighbourEast() {
        return new Coordinates(row, column + 1);
    }

    public Coordinates neighbourWest() {
        return new Coordinates(row, column - 1);
    }

    public Coordinates neighbourNE() {
        return new Coordinates(row - 1, column + 1);
    }

    public Coordinates neighbourNW() {
        return new Coordinates(row - 1, column - 1);
    }

    public Coordinates neighbourSE() {
        return new Coordinates(row + 1, column + 1);
    }

    public Coordinates neighbourSW() {
        return new Coordinates(row + 1, column - 1);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}




