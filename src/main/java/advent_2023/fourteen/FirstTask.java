package advent_2023.fourteen;

import java.util.Arrays;
import java.util.List;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                O....#....
                O.OO#....#
                .....##...
                OO.#O....O
                .O.....O#.
                O.#..O.#.#
                ..O..#O..O
                .......O..
                #....###..
                #OO..#....""";

        var map = Arrays.stream(input.split("\n"))
                .map(String::toCharArray)
                .toArray(char[][]::new);

        tiltNorth(map);
        System.out.println(Arrays.deepToString(map));

        var load = 0;

        var currentLoadRow = map.length;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'O') {
                    load += currentLoadRow - i;
                }
            }
        }


        System.out.println(load);
    }

    private static void tiltNorth(char[][] map) {
        for(int i = map.length - 1; i >= 0; i--) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'O') {
                   int lastIndexOfDot = map.length;

                    for(int k = i - 1; k >= 0; k--) {
                        if(map[k][j] == '#') {
                            break;
                        } else

                        if(map[k][j] == '.') {
                            lastIndexOfDot = k;
                        }
                    }
                    if(lastIndexOfDot == map.length) {
                        continue;
                    }

                    var temp = map[lastIndexOfDot][j];
                    map[lastIndexOfDot][j] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }
    }
}
