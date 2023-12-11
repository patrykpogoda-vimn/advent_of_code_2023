package eleventh;

import java.util.Arrays;
import java.util.HashSet;

public class FirstTask {

    public static void main(String[] args) {

        var input = """
                ...#......
                .......#..
                #.........
                ..........
                ......#...
                .#........
                .........#
                ..........
                .......#..
                #...#.....""";

        var lines = input.split("\n");

        var emptyRows = new HashSet<Integer>();
        var emptyCols = new HashSet<Integer>();

        for (int i = 0; i < lines.length; i++) {
            var isRowEmpty = true;
            var line = lines[i];

            for (int j = 0; j < line.length(); j++) {
                var symbol = line.charAt(j);
                if (symbol != '.') {
                    isRowEmpty = false;
                    break;
                }
            }
            if(isRowEmpty) {
                emptyRows.add(i);
            }
        }

        for(int j = 0; j < lines[0].length(); j++) {
            var isColEmpty = true;

            for (String line : lines) {
                var symbol = line.charAt(j);

                if (symbol != '.') {
                    isColEmpty = false;
                    break;
                }
            }

            if(isColEmpty) {
                emptyCols.add(j);
            }
        }

        System.out.println(emptyRows);
        System.out.println(emptyCols);

        var map = new Character[lines.length + emptyRows.size()][lines[0].length() + emptyCols.size()];

        int includedEmptyRows = 0;

        for (int i = 0; i + includedEmptyRows < map.length; i++) {
            int includedEmptyCols = 0;

            var line = lines[i];

            for (int j = 0; j + includedEmptyCols < map[0].length; j++) {
                var symbol = line.charAt(j);
                map[i + includedEmptyRows][j + includedEmptyCols] = symbol;

                if(emptyCols.contains(j)) {
                    includedEmptyCols++;
                }
            }

            if(emptyRows.contains(i)) {
                includedEmptyRows++;
            }
        }

        int number = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == null) {
                    map[i][j] = '.';
                }

                if(map[i][j] == '#') {
                    number++;
                    map[i][j] = (char)('0' + number);
                }
            }
        }
        System.out.println(Arrays.deepToString(map));

        try {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                for (int j = i + 1; j <= number; j++) {
                    var first = find(map, (char) ('0' + i));
                    var second = find(map, (char) ('0' + j));
                    var distance = Math.abs(first.x - second.x) + Math.abs(first.y - second.y);

                    System.out.println("first " + i + " = " + first);
                    System.out.println("second " + j + " = " + second);
                    System.out.println("distance = " + distance);

                    sum += distance;
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    record Coordinates(int x, int y) {

    }

    private static Coordinates find(Character[][] map, char c) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == c) {
                    return new Coordinates(i, j);
                }
            }
        }

        throw new RuntimeException("Not found " + c + " in map");
    }
}
