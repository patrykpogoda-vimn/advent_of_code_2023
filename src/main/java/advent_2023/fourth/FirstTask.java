package advent_2023.fourth;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
                """;

        var cards = input.split("\n");
        var sum = 0;

        for (var card : cards) {
            var numbers = card.substring(card.indexOf(":") + 1);
            var winningNumbers = Arrays.stream(numbers.split("\\|")[0]
                    .trim()
                    .split(" "))
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());


            var playerNumbers = Arrays.stream(numbers.split("\\|")[1]
                    .trim()
                    .split(" "))
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            var points = 0;

            for (var playerNumber : playerNumbers) {
                if (winningNumbers.contains(playerNumber)) {
                    if(points == 0) {
                        points = 1;
                    } else {
                        points *= 2;
                    }
                }
            }

            sum += points;
        }

        System.out.println("Points sum: " + sum);
    }
}
