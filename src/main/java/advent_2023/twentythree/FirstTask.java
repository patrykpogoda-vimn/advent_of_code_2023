package advent_2023.twentythree;

import java.util.HashSet;

public class FirstTask {

    record Point(int row, int col) {}

    record Direction(int row, int col) {

    }

    enum Directions {
        UP(new Direction(-1, 0)),
        DOWN(new Direction(1, 0)),
        LEFT(new Direction(0, -1)),
        RIGHT(new Direction(0, 1));

        private final Direction direction;

        Directions(Direction direction) {
            this.direction = direction;
        }

        public Direction getDirection() {
            return direction;
        }
    }

    public static void main(String[] args) {
        var input = """
                #.#####################
                #.......#########...###
                #######.#########.#.###
                ###.....#.>.>.###.#.###
                ###v#####.#v#.###.#.###
                ###.>...#.#.#.....#...#
                ###v###.#.#.#########.#
                ###...#.#.#.......#...#
                #####.#.#.#######.#.###
                #.....#.#.#.......#...#
                #.#####.#.#.#########v#
                #.#...#...#...###...>.#
                #.#.#v#######v###.###v#
                #...#.>.#...>.>.#.###.#
                #####v#.#.###v#.#.###.#
                #.....#...#...#.#.#...#
                #.#########.###.#.#.###
                #...###...#...#...#.###
                ###.###.#.###v#####v###
                #...#...#.#.>.>.#.>.###
                #.###.###.#.###.#.#v###
                #.....###...###...#...#
                #####################.#""";

        var map = input.lines().map(String::toCharArray).toArray(char[][]::new);

        var visited = new HashSet<Point>();

        var start = new Point(0, 1);

        var pathLength = travel(map, start, Directions.DOWN.getDirection(), false, 0, visited);

        System.out.println(pathLength);
    }

    private static long travel(char[][] map, Point point, Direction direction, boolean wasOnHighSlope, long currentLength, HashSet<Point> vistited) {
        if(point.col < 0 || point.col >= map[0].length || point.row < 0 || point.row >= map.length) {
            return 0;
        }

        if(vistited.contains(point)) {
            return 0;
        }

        if(map[point.row][point.col] == '#') {
            return 0;
        }

        if(map[point.row][point.col] == 'v') {
            if(direction.equals(Directions.UP.getDirection())) {
                if(wasOnHighSlope) {
                    return 0;
                }
                wasOnHighSlope = true;
            } else {
                wasOnHighSlope = false;
            }
        }

        if(map[point.row][point.col] == '>') {
            if(direction.equals(Directions.LEFT.getDirection())) {
                if(wasOnHighSlope) {
                    return 0;
                }
                wasOnHighSlope = true;
            } else {
                wasOnHighSlope = false;
            }
        }

        if(map[point.row][point.col] == '<') {
            if(direction.equals(Directions.RIGHT.getDirection())) {
                if(wasOnHighSlope) {
                    return 0;
                }
                wasOnHighSlope = true;
            } else {
                wasOnHighSlope = false;
            }
        }

        if(map[point.row][point.col] == '^') {
            if(direction.equals(Directions.DOWN.getDirection())) {
                if(wasOnHighSlope) {
                    return 0;
                }
                wasOnHighSlope = true;
            } else {
                wasOnHighSlope = false;
            }
        }

        if(point.row == map.length - 1 && point.col == map[0].length - 2) {
            System.out.println("Found the end, length: " + currentLength);
            return currentLength;
        }

        currentLength++;
        vistited.add(point);

        var up = travel(map, new Point(point.row + Directions.UP.getDirection().row, point.col + Directions.UP.getDirection().col), Directions.UP.getDirection(), wasOnHighSlope, currentLength, new HashSet<>(vistited));
        var down = travel(map, new Point(point.row + Directions.DOWN.getDirection().row, point.col + Directions.DOWN.getDirection().col), Directions.DOWN.getDirection(), wasOnHighSlope, currentLength, new HashSet<>(vistited));
        var left = travel(map, new Point(point.row + Directions.LEFT.getDirection().row, point.col + Directions.LEFT.getDirection().col), Directions.LEFT.getDirection(), wasOnHighSlope, currentLength, new HashSet<>(vistited));
        var right = travel(map, new Point(point.row + Directions.RIGHT.getDirection().row, point.col + Directions.RIGHT.getDirection().col), Directions.RIGHT.getDirection(), wasOnHighSlope, currentLength, new HashSet<>(vistited));

        return Math.max(Math.max(up, down), Math.max(left, right));
    }
}
