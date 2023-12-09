package nineth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstTask {

    public static void main(String[] args) {

        try {

            var input = """
                    0 3 6 9 12 15
                    1 3 6 10 15 21
                    10 13 16 21 30 45""";

            var lines = Arrays.stream(input.split("\n"))
                    .map(line -> Arrays.stream(line.split(" "))
                            .map(Integer::parseInt)
                            .toList())
                    .toList();

            System.out.println(lines);

            var sum = 0;

            for (var line : lines) {
                System.out.println("interpolated");
                var interpolated = interpolate(line);
                System.out.println(interpolated);

                var extrapolated = extrapolate(interpolated);
                System.out.println("extrapolated");
                System.out.println(extrapolated);

                sum += extrapolated.get(0).get(extrapolated.get(0).size() - 1);
            }

            System.out.println("result = " + sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<List<Integer>> extrapolate(List<List<Integer>> interpolated) {
        var extrapolated = new ArrayList<List<Integer>>();

        for(var line : interpolated) {
            var extrapolatedLine = new ArrayList<>(line);
            extrapolated.add(extrapolatedLine);
        }

        extrapolated.get(extrapolated.size() - 1).add(0);

        for(int i = extrapolated.size() - 2; i >= 0; i--) {
            var current = extrapolated.get(i);
            var previous = extrapolated.get(i + 1);

            var last = current.get(current.size() - 1);
            var previousLast = previous.get(previous.size() - 1);

            current.add(last + previousLast);
        }

        return extrapolated;
    }

    private static List<List<Integer>> interpolate(List<Integer> line) {
        var current = line;
        var interpolated = new ArrayList<List<Integer>>();

        do {
            var next = new ArrayList<Integer>();

            for(int i = 0; i < current.size() - 1; i++) {
                var first = current.get(i);
                var second = current.get(i + 1);
                next.add(second - first);
            }
            interpolated.add(current);
            current = next;
        } while (current.stream().anyMatch(x -> x != 0));
        interpolated.add(current);

        return interpolated;
    }
}
