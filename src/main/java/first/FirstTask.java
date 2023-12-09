package first;

public class FirstTask {
    public static void main(String[] args) {
        var input = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;

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
                if (Character.isDigit(line.charAt(backwardPointer))) {
                    foundBackwardNumber = true;
                    backwardNumber = String.valueOf(line.charAt(backwardPointer));
                    System.out.println("Find backward number: " + backwardNumber);
                } else {
                    backwardPointer--;
                }
            }

            while(!foundForwardNumber && forwardPointer < line.length()) {
                if (Character.isDigit(line.charAt(forwardPointer))) {
                    foundForwardNumber = true;
                    forwardNumber = String.valueOf(line.charAt(forwardPointer));
                    System.out.println("Find forward number: " + forwardNumber);
                } else {
                    forwardPointer++;
                }
            }

            sum += Integer.parseInt(forwardNumber + backwardNumber);
        }

        System.out.println(sum);
    }
}