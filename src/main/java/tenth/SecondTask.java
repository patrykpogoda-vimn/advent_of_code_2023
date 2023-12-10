package tenth;

import java.util.*;

public class SecondTask {


    private final static char START = 'S';
    private final static char NO_PIPE = '.';
    private final static char HORIZONTAL_PIPE = '-';
    private final static char VERTICAL_PIPE = '|';
    private final static char DOWN_RIGHT_PIPE = 'J';
    private final static char DOWN_LEFT_PIPE = 'L';
    private final static char UP_RIGHT_PIPE = '7';
    private final static char UP_LEFT_PIPE = 'F';

    record Point(int x, int y) {
    }

    public static void main(String[] args) {

        var input = """
                FF7FSF7F7F7F7F7F---7
                L|LJ||||||||||||F--J
                FL-7LJLJ||||||LJL-77
                F--JF--7||LJLJ7F7FJ-
                L---JF-JLJ.||-FJLJJ7
                |F|F-JF---7F7-L7L|7|
                |FFJF7L7F-JF7|JL---7
                7-L-JL7||F7|L7F-7F7|
                L.L7LFJ|||||FJL7||LJ
                L7JLJL-JLJLJL--JLJ.L""";


        var lines = input.split("\n");
        var map = new Character[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                map[i][j] = lines[i].charAt(j);
            }
        }

        System.out.println(Arrays.deepToString(map));

        try {
            var start = findStart(map);
            var startSymbol = findStartSymbol(map, start);
            var insidePilesCount = findInsidePilesCount(map, start, startSymbol);

            System.out.println("start = " + start);
            System.out.println("startSymbol = " + startSymbol);
            System.out.println("insidePilesCount = " + insidePilesCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Integer findInsidePilesCount(Character[][] map, Point start, StartPreviousAndNext startSymbol) {
        var currentPoint = start;
        Point previousPoint = null;
        var currentSymbol = startSymbol.startSymbol();
        var horizontalDirection = 1;
        var verticalDirection = 1;

        Set<Point> pointsOnLoop = new HashSet<>();

        //clockwise
        do {
            System.out.println("currentPoint = " + currentPoint);
            System.out.println("currentSymbol = " + currentSymbol);

            pointsOnLoop.add(currentPoint);
            var tempCurrent = currentPoint;

            if(currentSymbol == HORIZONTAL_PIPE) {
                currentPoint = new Point(currentPoint.x, currentPoint.y + horizontalDirection);
            } else if(currentSymbol == VERTICAL_PIPE) {
                currentPoint = new Point(currentPoint.x + verticalDirection, currentPoint.y);
            }

            else if(currentSymbol == UP_RIGHT_PIPE) {
                if(previousPoint == null || previousPoint.equals(new Point(currentPoint.x, currentPoint.y - 1))) {
                    verticalDirection = 1;
                    currentPoint = new Point(currentPoint.x + 1, currentPoint.y);
                } else {
                    horizontalDirection = -1;
                    currentPoint = new Point(currentPoint.x, currentPoint.y - 1);
                }
            }
            else if(currentSymbol == DOWN_RIGHT_PIPE) {
                if(previousPoint == null || previousPoint.equals(new Point(currentPoint.x - 1, currentPoint.y))) {
                    horizontalDirection = -1;
                    currentPoint = new Point(currentPoint.x, currentPoint.y - 1);
                } else {
                    verticalDirection = -1;
                    currentPoint = new Point(currentPoint.x - 1, currentPoint.y);
                }

            }
            else if(currentSymbol == DOWN_LEFT_PIPE) {
                if(previousPoint == null || previousPoint.equals(new Point(currentPoint.x, currentPoint.y + 1))) {
                    verticalDirection = -1;
                    currentPoint = new Point(currentPoint.x - 1, currentPoint.y);
                } else {
                    horizontalDirection = 1;
                    currentPoint = new Point(currentPoint.x, currentPoint.y + 1);
                }
            }  else if(currentSymbol == UP_LEFT_PIPE) {
                if(previousPoint == null || previousPoint.equals(new Point(currentPoint.x + 1, currentPoint.y))) {
                    horizontalDirection = 1;
                    currentPoint = new Point(currentPoint.x, currentPoint.y + 1);
                } else {
                    verticalDirection = 1;
                    currentPoint = new Point(currentPoint.x + 1, currentPoint.y);
                }

            } else {
                throw new RuntimeException("Unknown symbol");
            }

            previousPoint = tempCurrent;
            currentSymbol = map[currentPoint.x][currentPoint.y];

        } while (!currentPoint.equals(start));
        System.out.println("pointsOnLoop = " + pointsOnLoop);

        int result  = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                var pointToCheck = new Point(i, j);

                if(pointsOnLoop.contains(pointToCheck)) {
                    continue;
                }

                int counter = 0;
                for(int jj = j; jj >= 0; jj--) {

                    if(!pointsOnLoop.contains(new Point(i, jj))) {
                        continue;
                    }

                    if(map[i][jj] == VERTICAL_PIPE) {
                        counter++;
                    }
                    else if(map[i][jj] == DOWN_LEFT_PIPE) {
                        counter++;
                    }
                    else if(map[i][jj] == DOWN_RIGHT_PIPE) {
                        counter++;
                    }
                }

                if(counter%2 == 1) {
                    System.out.println("Inside point = " + pointToCheck);
                    result++;
                }
            }
        }

        return result;
    }

    record StartPreviousAndNext(Character startSymbol, Character previousSymbol, Character nextSymbol
    ) {
    }

    private static StartPreviousAndNext findStartSymbol(Character[][] map, Point start) {
        int row = start.x;
        int col = start.y;

        if (col + 1 < map[0].length && (
                map[row][col + 1] == HORIZONTAL_PIPE ||
                        map[row][col + 1] == DOWN_RIGHT_PIPE ||
                        map[row][col + 1] == UP_RIGHT_PIPE)
                ) {

            if(col - 1 >= 0 && (map[row][col - 1] == HORIZONTAL_PIPE
                    || map[row][col - 1] == DOWN_LEFT_PIPE
                    || map[row][col - 1] == UP_LEFT_PIPE)) {
                return new StartPreviousAndNext(
                        HORIZONTAL_PIPE,
                        map[row][col - 1],
                        map[row][col + 1]
                );
            }

            if(row + 1 < map.length && (map[row + 1][col] == VERTICAL_PIPE
                    || map[row + 1][col] == DOWN_LEFT_PIPE
                    || map[row + 1][col] == DOWN_RIGHT_PIPE)) {
                return new StartPreviousAndNext(
                        UP_LEFT_PIPE,
                        map[row + 1][col],
                        map[row][col + 1]
                );
            }

            if(row - 1 >= 0 && (map[row -1 ][col] == VERTICAL_PIPE
                    || map[row - 1][col] == UP_LEFT_PIPE
                    || map[row - 1][col] == UP_RIGHT_PIPE)) {
                return new StartPreviousAndNext(DOWN_LEFT_PIPE,
                        map[row - 1][col],
                        map[row][col + 1]
                );
            }
        }


        if (col - 1 >= 0 && (
                map[row][col - 1] == HORIZONTAL_PIPE ||
                        map[row ][col - 1] == DOWN_LEFT_PIPE ||
                        map[row][col - 1] == UP_LEFT_PIPE)
                ) {

            if(row + 1 < map.length && (map[row + 1][col] == VERTICAL_PIPE
                    || map[row + 1][col] == DOWN_LEFT_PIPE
                    || map[row + 1][col] == DOWN_RIGHT_PIPE)) {
                return new StartPreviousAndNext(UP_RIGHT_PIPE,
                        map[row + 1][col],
                        map[row][col - 1]
                );
            }

            if(row - 1 >= 0 && (map[row - 1][col] == VERTICAL_PIPE
                    || map[row - 1][col] == UP_LEFT_PIPE
                    || map[row - 1][col] == UP_RIGHT_PIPE)) {
                return new StartPreviousAndNext(DOWN_RIGHT_PIPE,
                        map[row - 1][col],
                        map[row][col - 1]
                );
            }
        }

        if (row + 1 < map.length && (
                map[row + 1][col] == VERTICAL_PIPE ||
                        map[row + 1][col] == DOWN_LEFT_PIPE ||
                        map[row + 1][col] == DOWN_RIGHT_PIPE)
                ) {

            if(row - 1 >= 0 && (map[row - 1][col] == VERTICAL_PIPE
                    || map[row - 1][col] == UP_LEFT_PIPE
                    || map[row - 1][col] == UP_RIGHT_PIPE)) {
                return new StartPreviousAndNext(VERTICAL_PIPE,
                        map[row - 1][col],
                        map[row + 1][col]
                );
            }
        }

        throw new RuntimeException("Start symbol not found");
    }

    private static Point findStart(Character[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == START) {
                    return new Point(i, j);
                }
            }
        }
        throw new RuntimeException("Start not found");
    }
}
