package game;

public class Computer {


    public Coordinates move(Players players, int boardSize, int round, GameLogic gameLogic) {

        Coordinates move = new Coordinates(boardSize / 2 + 1, boardSize / 2 + 1);

        if (round == 1) {
            return move;
        } else if (round == 2) {
            if (players.getPlayerOne().getMoves().contains(move)) {
                return move.neighbourNW();
            } else {
                return move;
            }
        } else if (threePossibility(players, players.getPlayerTwo(), gameLogic, boardSize) != null) {
            return threePossibility(players, players.getPlayerTwo(), gameLogic, boardSize);
        } else if (threePossibility(players, players.getPlayerOne(), gameLogic, boardSize) != null) {
            return threePossibility(players, players.getPlayerOne(), gameLogic, boardSize);
        } else {
            return fillAny(players, gameLogic, boardSize);
        }
    }


    public Coordinates fillAny(Players players, GameLogic gameLogic, int boardSize) {
        Coordinates move = new Coordinates(0,0);
        for (int i = 1; i <= boardSize; i++) {
            for (int j = 1; j <= boardSize; j++) {
                move.update(i, j);
                if(!gameLogic.availabilityCheck(move, players)) {
                    break;
                }
            }
        }
        return move;
    }
    public Coordinates threePossibility(Players players, Player player, GameLogic gameLogic, int boardSize) {
        Coordinates playerMove = player.getMoves().get(player.getMoves().size() - 1);
        if (betweenPossibility(players, player, gameLogic, playerMove) != null) {
            return betweenPossibility(players, player, gameLogic, playerMove);
        } else if (nextToPossibility(players, player, gameLogic, playerMove, boardSize) != null) {
            return nextToPossibility(players, player, gameLogic, playerMove, boardSize);
        } else {
            return null;
        }
    }


    public Coordinates betweenPossibility(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        if (betweenEast(players, player, gameLogic, move)) {
            return move.neighbourEast();
        } else if (betweenWest(players, player, gameLogic, move)) {
            return move.neighbourWest();
        } else if (betweenNorth(players, player, gameLogic, move)) {
            return move.neighbourNorth();
        } else if (betweenSouth(players, player, gameLogic, move)) {
            return move.neighbourSouth();
        } else if (betweenSW(players, player, gameLogic, move)) {
            return move.neighbourSW();
        } else if (betweenSE(players, player, gameLogic, move)) {
            return move.neighbourSE();
        } else if (betweenNW(players, player, gameLogic, move)) {
            return move.neighbourNW();
        } else if (betweenNE(players, player, gameLogic, move)) {
            return move.neighbourNE();
        } else {
            return null;
        }
    }

    public Coordinates nextToPossibility(Players players, Player player, GameLogic gameLogic, Coordinates move, int boardSize) {
        if (nextToRow(players, player, gameLogic, move, boardSize) != null) {
            return nextToRow(players, player, gameLogic, move, boardSize);
        } else if (nextToColumn(players, player, gameLogic, move, boardSize) != null) {
            return nextToColumn(players, player, gameLogic, move, boardSize);
        } else if (nextToCrossRight(players, player, gameLogic, move, boardSize) != null) {
            return nextToCrossRight(players, player, gameLogic, move, boardSize);
        } else if (nextToCrossLeft(players, player, gameLogic, move, boardSize) != null) {
            return nextToCrossLeft(players, player, gameLogic, move, boardSize);
        } else {
            return null;
        }
    }


    public boolean betweenEast(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourEast().neighbourEast())
                && !gameLogic.availabilityCheck(move.neighbourEast(), players);
    }

    public boolean betweenWest(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourWest().neighbourWest())
                && !gameLogic.availabilityCheck(move.neighbourWest(), players);
    }

    public boolean betweenNorth(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourNorth().neighbourNorth())
                && !gameLogic.availabilityCheck(move.neighbourNorth(), players);
    }

    public boolean betweenSouth(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourSouth().neighbourSouth())
                && !gameLogic.availabilityCheck(move.neighbourSouth(), players);
    }

    public boolean betweenNW(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourNW().neighbourNW())
                && !gameLogic.availabilityCheck(move.neighbourNW(), players);
    }

    public boolean betweenNE(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourNE().neighbourNE())
                && !gameLogic.availabilityCheck(move.neighbourNE(), players);
    }

    public boolean betweenSW(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourSW().neighbourSW())
                && !gameLogic.availabilityCheck(move.neighbourSW(), players);
    }

    public boolean betweenSE(Players players, Player player, GameLogic gameLogic, Coordinates move) {
        return player.getMoves().contains(move.neighbourNW().neighbourNW())
                && !gameLogic.availabilityCheck(move.neighbourNW(), players);
    }

    public Coordinates nextToRow(Players players, Player player, GameLogic gameLogic, Coordinates move, int boardSize) {
        if (player.getMoves().contains(move.neighbourWest())
                && isEmpty(players, gameLogic, move.neighbourWest().neighbourWest(), boardSize)) {
            return move.neighbourWest().neighbourWest();
        } else if (player.getMoves().contains(move.neighbourWest())
                && isEmpty(players, gameLogic, move.neighbourEast(), boardSize)) {
            return move.neighbourEast();
        } else if (player.getMoves().contains(move.neighbourEast())
                && isEmpty(players, gameLogic, move.neighbourEast().neighbourEast(), boardSize)) {
            return move.neighbourEast().neighbourEast();
        } else if (player.getMoves().contains(move.neighbourEast())
                && isEmpty(players, gameLogic, move.neighbourWest(), boardSize)) {
            return move.neighbourWest();
        } else {
            return null;
        }
    }

    public Coordinates nextToColumn(Players players, Player player, GameLogic gameLogic, Coordinates move, int boardSize) {
        if (player.getMoves().contains(move.neighbourNorth())
                && isEmpty(players, gameLogic, move.neighbourNorth().neighbourNorth(), boardSize)) {
            return move.neighbourNorth().neighbourNorth();
        } else if (player.getMoves().contains(move.neighbourNorth())
                && isEmpty(players, gameLogic, move.neighbourSouth(), boardSize)) {
            return move.neighbourSouth();
        } else if (player.getMoves().contains(move.neighbourSouth())
                && isEmpty(players, gameLogic, move.neighbourSouth().neighbourSouth(), boardSize)) {
            return move.neighbourSouth().neighbourSouth();
        } else if (player.getMoves().contains(move.neighbourSouth())
                && isEmpty(players, gameLogic, move.neighbourNorth(), boardSize)) {
            return move.neighbourNorth();
        } else {
            return null;
        }
    }

    public Coordinates nextToCrossRight(Players players, Player player, GameLogic gameLogic, Coordinates move, int boardSize) {
        if (player.getMoves().contains(move.neighbourNW())
                && isEmpty(players, gameLogic, move.neighbourNW().neighbourNW(), boardSize)) {
            return move.neighbourNW().neighbourNW();
        } else if (player.getMoves().contains(move.neighbourNW())
                && isEmpty(players, gameLogic, move.neighbourSE(), boardSize)) {
            return move.neighbourSE();
        } else if (player.getMoves().contains(move.neighbourSE())
                && isEmpty(players, gameLogic, move.neighbourSE().neighbourSE(), boardSize)) {
            return move.neighbourSE().neighbourSE();
        } else if (player.getMoves().contains(move.neighbourSE())
                && isEmpty(players, gameLogic, move.neighbourNW(), boardSize)) {
            return move.neighbourNW();
        } else {
            return null;
        }
    }

    public Coordinates nextToCrossLeft(Players players, Player player, GameLogic gameLogic, Coordinates move, int boardSize) {
        if (player.getMoves().contains(move.neighbourNE())
                && isEmpty(players, gameLogic, move.neighbourNE().neighbourNE(), boardSize)) {
            return move.neighbourNE().neighbourNE();
        } else if (player.getMoves().contains(move.neighbourNE())
                && isEmpty(players, gameLogic, move.neighbourSW(), boardSize)) {
            return move.neighbourSW();
        } else if (player.getMoves().contains(move.neighbourSW())
                && isEmpty(players, gameLogic, move.neighbourSW().neighbourSW(), boardSize)) {
            return move.neighbourSW().neighbourSW();
        } else if (player.getMoves().contains(move.neighbourSW())
                && isEmpty(players, gameLogic, move.neighbourNE(), boardSize)) {
            return move.neighbourNE();
        } else {
            return null;
        }
    }

    public boolean isEmpty(Players players, GameLogic gameLogic, Coordinates move, int boardSize) {
        return !gameLogic.availabilityCheck(move, players) && !gameLogic.rangeCheck(move, boardSize);
    }

}
