
package advent_2023.fourth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SecondTask {

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
        var cardIds = new HashMap<Integer, Integer>();

        for (var card : cards) {
            var cardId = Integer.parseInt(
                    card.substring(5, card.indexOf(":")).trim()
            );

            if(!cardIds.containsKey(cardId)) {
                cardIds.put(cardId, 1);
            } else {
                cardIds.put(cardId, cardIds.get(cardId) + 1);
            }

            var count = cardIds.get(cardId);
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
                        points++;
                    }
                }

                for (int j = cardId; j < points + cardId; j++) {
                    if (cardIds.containsKey(j + 1)) {
                        cardIds.put(j + 1, cardIds.get(j + 1) + count);
                    } else {
                        cardIds.put(j + 1, count);
                    }
            }
        }

        System.out.println("Points sum: " + cardIds.values().stream().mapToInt(Integer::intValue).sum());
    }
}
