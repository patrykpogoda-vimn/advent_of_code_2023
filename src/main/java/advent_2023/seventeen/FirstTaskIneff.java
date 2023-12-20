package advent_2023.seventeen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FirstTaskIneff {

    record Direction(int row, int col) {
    }

    record Position(int row, int col) {
    }

    record PositionAndDirection(Position position, Direction direction) {
    }

    private static HashMap<PositionAndDirection, Long> pathResults = new HashMap<>();

    public static void main(String[] args) {

        var input = """
                2413432311323
                3215453535623
                3255245654254
                3446585845452
                4546657867536
                1438598798454
                4457876987766
                3637877979653
                4654967986887
                4564679986453
                1224686865563
                2546548887735
                4322674655533""";

        var map = input.lines()
                .map(line -> line.chars().map(c -> c - '0').boxed().toList())
                .toList();

        System.out.println(map);

        var directionBottom = new Direction(1, 0);
        var directionRight = new Direction(0, 1);

        var positionsBottom = new HashSet<Position>();
        positionsBottom.add(new Position(0, 0));
        var positionsRight = new HashSet<Position>();
        positionsRight.add(new Position(0, 0));

        try {
        long resultHeat = Math.min(
                travel(map, directionRight, 0, 1, 1, positionsRight),
                travel(map, directionBottom, 1, 0, 1, positionsBottom)
        );

        System.out.println(resultHeat);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static long travel(List<List<Integer>> map,
                              Direction direction,
                              int currentRow,
                              int currentCol,
                              int currentMoves,
                              HashSet<Position> visited) {

        if (currentRow < 0 || currentRow >= map.size() || currentCol < 0 || currentCol >= map.get(currentRow).size()) {
            throw new RuntimeException("Should not be here");
        }

        var position = new Position(currentRow, currentCol);
        var positionAndDirection = new PositionAndDirection(position, direction);

        if (pathResults.containsKey(positionAndDirection)) {
            return pathResults.get(positionAndDirection);
        }

        if (currentRow == map.size() - 1 && currentCol == map.get(currentRow).size() - 1) {
            return map.get(currentRow).get(currentCol);
        }

        long currentHeat = map.get(currentRow).get(currentCol);
        visited.add(position);

        long nextHeat = Integer.MAX_VALUE;

        if(currentMoves < 3) {
            var nextRow = currentRow + direction.row;
            var nextCol = currentCol + direction.col;

            if(nextRow >= 0 && nextRow < map.size()
                    && nextCol >= 0 && nextCol < map.get(nextRow).size()
                    && !visited.contains(new Position(nextRow, nextCol))) {
                nextHeat = Math.min(nextHeat, travel(map, direction, nextRow, nextCol, currentMoves + 1, new HashSet<>(visited)));
            }
        }

        Direction rightDirection;
        Direction leftDirection;

        if(direction.row == 0){
            rightDirection = new Direction(direction.col, 0);
        } else {
            rightDirection = new Direction(0, direction.row);
        }

        if(direction.row == 0){
            leftDirection = new Direction(-direction.col, 0);
        } else {
            leftDirection = new Direction(0, -direction.row);
        }

        var nextRowRight = currentRow + rightDirection.row;
        var nextColRight = currentCol + rightDirection.col;

        if(nextRowRight >= 0 && nextRowRight < map.size()
                && nextColRight >= 0 && nextColRight < map.get(nextRowRight).size()
                && !visited.contains(new Position(nextRowRight, nextColRight))
        ) {
            nextHeat = Math.min(nextHeat, travel(map, rightDirection,
                    nextRowRight,
                    nextColRight,
                0, new HashSet<>(visited)));
        }

        var nextRowLeft = currentRow + leftDirection.row;
        var nextColLeft = currentCol + leftDirection.col;

        if(nextRowLeft >= 0 && nextRowLeft < map.size()
                && nextColLeft >= 0 && nextColLeft < map.get(nextRowLeft).size()
                && !visited.contains(new Position(nextRowLeft, nextColLeft))) {
            nextHeat = Math.min(nextHeat, travel(map, leftDirection,
                    nextRowLeft,
                    nextColLeft,
                    0, new HashSet<>(visited)));
        }

        var pathResult = currentHeat + nextHeat;
        if(pathResult < Integer.MAX_VALUE) {
            pathResults.put(positionAndDirection, pathResult);
        }

        return currentHeat + nextHeat;
    }
}
