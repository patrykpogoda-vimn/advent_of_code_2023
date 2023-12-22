package advent_2023.twentyone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstTaskIneff {

    record Point(int row, int col) {

    }

    record Travel(List<Point> points, int steps) {

    }

    public static void main(String[] args) {
        var input = """
                ...........
                .....###.#.
                .###.##..#.
                ..#.#...#..
                ....#.#....
                .##..S####.
                .##..#...#.
                .......##..
                .##.#.####.
                .##..##.##.
                ...........
                """;
        var steps = 6;

        var map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        var visited = new boolean[map.length][map[0].length];

        for(int i = 0; i < map.length; i++) {
            visited[i] = new boolean[map[0].length];
        }

        var start = findStart(map);
        var currentTravel = new Travel(new ArrayList<>(List.of()), steps);

        try {
            var travels = travel(start, map, currentTravel);

            for (var travel : travels) {
                var lastPoint = travel.points.get(travel.points.size() - 1);
                visited[lastPoint.row][lastPoint.col] = true;
            }

            int result = 0;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (visited[i][j]) {
                        result++;
                        System.out.print("O");
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }

            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Travel> travel(Point point, char[][] map, Travel currentTravel) {
        if(point.row < 0 || point.row >= map.length || point.col < 0 || point.col >= map[0].length) {
            return Collections.emptyList();
        }

        if(map[point.row][point.col] == '#') {
            return Collections.emptyList();
        }

        var newPoints = new ArrayList<>(currentTravel.points);
        newPoints.add(point);

        if(currentTravel.steps == 0) {
            return List.of(new Travel(newPoints, 0));
        }

        var result = new ArrayList<Travel>();

        var newTravel = new Travel(newPoints, currentTravel.steps - 1);

        result.addAll(travel(new Point(point.row + 1, point.col), map, newTravel));
        result.addAll(travel(new Point(point.row - 1, point.col), map, newTravel));
        result.addAll(travel(new Point(point.row, point.col + 1), map, newTravel));
        result.addAll(travel(new Point(point.row, point.col - 1), map, newTravel));

        return result;
    }

    private static Point findStart(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            var row = map[i];

            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'S') {
                    return new Point(i, j);
                }
            }
        }
        throw new RuntimeException("Start not found");
    }
}
