package eleventh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SecondTask {

    public static void main(String[] args) {
        try {
            var input = """
                    .............................................................................................#..............................................
                    ...#....................#............................#......................#........................#...........#................#.........
                    ................#.....................................................#..............#.....................#................................
                    ................................................................#.......................................................#...................
                    .......#........................#.........................#..............................#.....#............................................
                    ............#............................#..................................................................................................
                    ......................#........................#......................................................#.....................................
                    ....................................#.....................................#.................#..........................................#....
                    ................................................................................................................#..............#............
                    ...................#.................................................#............................#.........................................
                    ............................................#.........#...............................#.................#...................................
                    .....#.....................#..................................................#.............................................................
                    ........................................................................#.................#.................................................
                    ...............................................................#.....................................................#............#.........
                    ..............#.......................#...........................................#.........................................................
                    .......................#.......................#...........................................................#................................
                    .........#........................................................#.........................................................................
                    .........................................................................#................................................................#.
                    ............................#..........................#........................#.....#...............................#.....................
                    .....................................#..................................................................#....................#..............
                    #...........................................................................................................................................
                    ..........#......................#...........#............#............#....................................................................
                    ....................#.........................................................#.................................#...........................
                    .................................................#.............#.....................#..........#......................#..........#.........
                    ....................................#.......................................................................................................
                    ..........................................#..............................................................................................#..
                    ......................#.....................................................................................#.....#.........#...............
                    ...........#................#.............................#.............#.....................#.............................................
                    #.................#...............................................#...........#.............................................................
                    .......................................#.................................................#..................................................
                    .....#.......................................#.......................................................#..............................#......#
                    ..............#.................#.................#..................#..............#..............................#........................
                    ...........................................................................#................................................................
                    .........................#............................#....................................................#................#...............
                    .#..............................................................................#...........................................................
                    .......................................#................................#......................#............................................
                    ................#...........#...................#.......................................................................................#...
                    ..............................................................#..........................................................#..................
                    .......#......................................................................#.........#.............#.....................................
                    .......................................................#....................................................................................
                    ......................#................................................#....................................#.............................#.
                    #.........................................#......................................................................#..........................
                    ..................................#................#............................................#.......#...................................
                    .....#.....................#.............................#.............................#....................................................
                    ................#...............................................#...........................................................................
                    ...............................#................................................#....................#..........................#...........
                    ......................................................#....................#................#................#..............................
                    ..#..........................................#......................................................................#.......................
                    .............#..............................................................................................................................
                    .......................................................................................................................................#....
                    .......................#..............#...........................#............................#...............#............................
                    .........#..................#...............................................#...........#...................................................
                    ......................................................................#........................................................#............
                    ..............................................................#....................#...............#......#........#........................
                    ..............#...................#.............#.....................................................................................#.....
                    ............................................................................................................................................
                    .....................#.....#............#...........#......................................#................................................
                    ..........#...................................................................................................................#...........#.
                    ...#......................................................................#.....................#................#..........................
                    .............................................#...........................................................................#..................
                    ......................................................#...........#................#................#.................................#.....
                    .................................#.....................................#..................#...............#......................#..........
                    ............................................................................................................................................
                    .......#..............................................................................................................#.....................
                    .....................#..............#......#.................................................#..............................................
                    ..............................#..................................#..............#............................#..............................
                    ..........#...............................................#............................#..........................................#.........
                    #.................................................#...................#...........................#.........................................
                    .......................................#....................................................................................................
                    .......#...........................................................................#........................................................
                    ................#............................................#............................................#.........#....................#..
                    .......................#........#.........#...............................................................................#.................
                    ............................................................................................................................................
                    ..#................#........................................................................................................................
                    ..........#...........................................#......................................#..............................................
                    ............................................................................................................................................
                    .....#.....................................#...................#....................................................................#.......
                    .........................#...........#............#.................................................................#....................#..
                    ........................................................#...............#...................................................................
                    ............#.................#.................................................#......#..............#.....................................
                    .............................................................................................#................#................#............
                    ........................................#.......................#..........................................................................#
                    ..#.................#..........................#......................#.............#..............#...................#.............#......
                    ............................#............................#................................#......................#..........................
                    .............#.................................................................................#............................................
                    .................................#.........................................#................................................................
                    .........................#.........................#.................................................#........................#.............
                    .......#......................................................#.............................................................................
                    ............................................................................................................................................
                    ............................................................................................................................................
                    .......................#.........................................................................................#..........................
                    ...#...........................#..................................................................#......#................#.................
                    ...............................................#................#...........................................................................
                    ....................#.................................#.................#.......#..........#........................................#.......
                    ...........#.................................................................................................#.............................#
                    .#..................................................................................................#.......................................
                    .....................................#.................................................................................#....................
                    ...............#.........#...........................................................#......................................................
                    ................................#........................#........#.........................................................................
                    ......#..........................................#.............................................................................#............
                    ...............................................................................................#.......#....................................
                    ...............................................................................................................#............................
                    ..............................#...........#............................#.................................................#............#.....
                    ...................#...........................#............................................................................................
                    ...............................................................#.....................#.....#................................................
                    ........#.................#.......................................................................................#...........#.............
                    ...............#............................#.........#.......................#...........................#.................................
                    .#...................................#...................................#................................................................#.
                    .........................................................................................#...........................................#......
                    ........................#...................................................................................................................
                    ....................................................................................................................#.......................
                    ........................................#.....#.........#.........#.........................................................................
                    .......................................................................................#............#.......................................
                    .#..............................#.............................................................#........................#.....#.....#........
                    ............#...............................................................#.................................#.........................#...
                    ..............................................................#.........................................#...................................
                    ........................#..............................#...............#........#.........#.................................................
                    ...................#........................#.......................................................................#.......................
                    .......................................#...................................................................#................................
                    ..............#..................#..............#...................................................................................#.......
                    ........#......................................................#..............#.................#.........................................#.
                    ....................................................................#.......................................................#...............
                    .............................#..........................................................................#...................................
                    .................#..................................................................#.......................................................
                    ............................................#..........................#............................................#..............#........
                    ......#..............#..........................................#...........#..............................#................................
                    ............#.....................#.................................................................#.......................................
                    ...........................#.............#...............#..................................................................#...............
                    #....................................................................................................................................#......
                    .............................................................#.....................#........................................................
                    .......#..........................................#.................#....................................#........#.......................#.
                    ..........................................................................................#.................................................
                    ..........................#..............................................#......................#...........................................
                    ...............................#.....................#..........................#.............................#.............................
                    ....#......#................................................#..........................#.......................................#............
                    ..................#.............................#...........................................................................................
                    ...........................................#..................................................#.............................................
                    .......................#...........................................#...................................................#...................#
                    .......#......#.............#.........................#..................#..............................#...........................#.......
                    ..#..............................................................................................................#..........................""";

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
                if (isRowEmpty) {
                    emptyRows.add(i);
                }
            }

            for (int j = 0; j < lines[0].length(); j++) {
                var isColEmpty = true;

                for (String line : lines) {
                    var symbol = line.charAt(j);

                    if (symbol != '.') {
                        isColEmpty = false;
                        break;
                    }
                }

                if (isColEmpty) {
                    emptyCols.add(j);
                }
            }

            System.out.println(emptyRows);
            System.out.println(emptyCols);

            var map = new Character[lines.length][lines[0].length()];


            for (int i = 0; i < map.length; i++) {
                var line = lines[i];
                for (int j = 0; j < map[0].length; j++) {
                    var symbol = line.charAt(j);
                    map[i][j] = symbol;
                }
            }

            int number = 0;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == '#') {
                        number++;
                        map[i][j] = (char) ('0' + number);
                    }
                }
            }

            System.out.println(Arrays.deepToString(map));

            try {
                long sum = 0;
                for (int i = 1; i <= number; i++) {
                    for (int j = i + 1; j <= number; j++) {
                        var first = find(map, (char) ('0' + i));
                        var second = find(map, (char) ('0' + j));
                        long distance = Math.abs(first.x - second.x) + Math.abs(first.y - second.y);

                        var rowsToInclude = emptyRows.stream()
                                .filter(row -> row > Math.min(first.x, second.x))
                                .filter(row -> row < Math.max(first.x, second.x))
                                .collect(Collectors.toSet());

                        var colsToInclude = emptyCols.stream()
                                .filter(col -> col > Math.min(first.y, second.y))
                                .filter(col -> col < Math.max(first.y, second.y))
                                .collect(Collectors.toSet());

                        System.out.println("first " + i + " = " + first);
                        System.out.println("second " + j + " = " + second);
                        System.out.println("rowsToInclude = " + rowsToInclude);
                        System.out.println("colsToInclude = " + colsToInclude);
                        System.out.println("distance before include = " + distance);
                        distance += (long)rowsToInclude.size() * 999999 + (long)colsToInclude.size() * 999999;
                        System.out.println("distance after include = " + distance);

                        sum += distance;
                    }
                }
                System.out.println(sum);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Coordinates find(Character[][] map, char c) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == c) {
                    return new Coordinates(i, j);
                }
            }
        }

        throw new RuntimeException("Not found " + c + " in map");
    }

    record Coordinates(int x, int y) {

    }
}