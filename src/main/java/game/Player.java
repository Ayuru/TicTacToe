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

    public boolean win() {
        if (moves.size() > 2) {
            Coordinates move = moves.get(moves.size() - 1);
            return rowCheck(move) || columnCheck(move) || crossCheck(move);
        } else {
            return false;
        }
    }

    public boolean rowCheck(Coordinates move) {
        return moves.contains(move.neighbourEast()) && moves.contains(move.neighbourWest())
                || moves.contains(move.neighbourEast()) && moves.contains(move.neighbourEast().neighbourEast())
                || moves.contains(move.neighbourWest()) && moves.contains(move.neighbourWest().neighbourWest());
    }

    public boolean columnCheck(Coordinates move) {
        return moves.contains(move.neighbourNorth()) && moves.contains(move.neighbourSouth())
                || moves.contains(move.neighbourNorth()) && moves.contains(move.neighbourNorth().neighbourNorth())
                || moves.contains(move.neighbourSouth()) && moves.contains(move.neighbourSouth().neighbourSouth());
    }

    public boolean crossCheck(Coordinates move) {
        return moves.contains(move.neighbourNW()) && moves.contains(move.neighbourSE())
                || moves.contains(move.neighbourNW()) && moves.contains(move.neighbourNW().neighbourNW())
                || moves.contains(move.neighbourSE()) && moves.contains(move.neighbourSE().neighbourSE())
                || moves.contains(move.neighbourNE()) && moves.contains(move.neighbourSW())
                || moves.contains(move.neighbourNE()) && moves.contains(move.neighbourNE().neighbourNE())
                || moves.contains(move.neighbourSW()) && moves.contains(move.neighbourSW().neighbourSW());
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
