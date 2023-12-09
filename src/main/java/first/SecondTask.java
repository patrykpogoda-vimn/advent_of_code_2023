package first;

import java.util.Map;

public class SecondTask {
    public static void main(String[] args) {
        var input = """
                    two1nine
                    eightwothree
                    abcone2threexyz
                    xtwone3four
                    4nineeightseven2
                    zoneight234
                    7pqrstsixteen
                """;

        var map = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        );

        var lines = input.split("\n");
        var sum = 0;

        for (var line : lines) {
            var forwardPointer = 0;
            var backwardPointer = line.length() - 1;
            var foundForwardNumber = false;
            var foundBackwardNumber = false;

            var forwardNumber = "0";
            var backwardNumber = "0";

            while(!foundBackwardNumber && backwardPointer >= 0) {
                if (Character.isDigit(line.charAt(backwardPointer))
                ) {
                    foundBackwardNumber = true;
                    backwardNumber = String.valueOf(line.charAt(backwardPointer));
                    System.out.println("Find backward number: " + backwardNumber);
                } else {
                    var lineToCheck = line.substring(0, backwardPointer + 1);
                    var textValue = map.keySet().stream().filter(lineToCheck::endsWith)
                            .findAny()
                            .map(map::get)
                            .stream().findAny();

                    if (textValue.isPresent()) {
                        foundBackwardNumber = true;
                        backwardNumber = textValue.get();
                        System.out.println("Find backward number: " + backwardNumber);
                    } else {
                        backwardPointer--;
                    }
                }
            }

            while(!foundForwardNumber && forwardPointer < line.length()) {
                if (Character.isDigit(line.charAt(forwardPointer))) {
                    foundForwardNumber = true;
                    forwardNumber = String.valueOf(line.charAt(forwardPointer));
                    System.out.println("Find forward number: " + forwardNumber);
                } else {
                    var lineToCheck = line.substring(forwardPointer);
                    var textValue = map.keySet().stream().filter(lineToCheck::startsWith)
                            .findAny()
                            .map(map::get)
                            .stream().findAny();

                    if (textValue.isPresent()) {
                        foundForwardNumber = true;
                        forwardNumber = textValue.get();
                        System.out.println("Find forward number: " + forwardNumber);
                    } else {
                        forwardPointer++;
                    }
                }
            }

            sum += Integer.parseInt(forwardNumber + backwardNumber);
        }

        System.out.println(sum);
    }
}