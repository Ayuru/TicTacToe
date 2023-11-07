package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final String mark;

    private int points = 0;

    private List<Coordinates> moves = new ArrayList<>();

    public Player(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public void addMove(Coordinates move) {
        moves.add(move);
    }

    public boolean win(int size) {
        if (moves.size() > 2) {
            Coordinates move = moves.get(moves.size() - 1);
            return rowCheck(move, size) || columnCheck(move, size) || crossRightCheck(move, size) || crossLeftCheck(move, size);
        } else {
            return false;
        }
    }

    public boolean rowCheck(Coordinates move, int size) {
        Coordinates enteredMove = move;
        while (moves.contains(move.neighbourWest())) {
            move = move.neighbourWest();
            size--;
        }
        move = enteredMove;
        while (moves.contains(move.neighbourEast())) {
            move = move.neighbourEast();
            size--;
        }
        return size == 1;
    }

    public boolean columnCheck(Coordinates move, int size) {
        Coordinates enteredMove = move;
        while (moves.contains(move.neighbourNorth())) {
            move = move.neighbourNorth();
            size--;
        }
        move = enteredMove;
        while (moves.contains(move.neighbourSouth())) {
            move = move.neighbourSouth();
            size--;
        }
        return size == 1;
    }

    public boolean crossRightCheck(Coordinates move, int size) {
        Coordinates enteredMove = move;
        while (moves.contains(move.neighbourNW())) {
            move = move.neighbourNW();
            size--;
        }
        move = enteredMove;
        while (moves.contains(move.neighbourSE())) {
            move = move.neighbourSE();
            size--;
        }
        return size == 1;
    }

    public boolean crossLeftCheck(Coordinates move, int size) {
        Coordinates enteredMove = move;
        while (moves.contains(move.neighbourNE())) {
            move = move.neighbourNE();
            size--;
        }
        move = enteredMove;
        while (moves.contains(move.neighbourSW())) {
            move = move.neighbourSW();
            size--;
        }
        return size == 1;
    }

    public void updatePoints() {
        points++;
    }

    public void clearMoves() {
        moves.clear();
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public List<Coordinates> getMoves() {
        return moves;
    }

    public int getPoints() {
        return points;
    }
}
