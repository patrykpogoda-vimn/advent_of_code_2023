package advent_2023.second;

public class SecondTask {

    public static void main(String[] args) {

        var input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                    """;

        var games = input.split("\n");

        var sum = 0;

        for (var game : games) {
            var gameRounds = game.substring(game.indexOf(":") + 1).split(";");

            var maxRedCubes = 0;
            var maxGreenCubes = 0;
            var maxBlueCubes = 0;

            for (var gameRound : gameRounds) {
                var gameRoundCubes = gameRound.split(",");

                for (var gameRoundCube : gameRoundCubes) {
                    var cubeColor = gameRoundCube.trim().split(" ")[1];
                    var cubeCount = Integer.parseInt(gameRoundCube.trim().split(" ")[0]);

                    switch (cubeColor) {
                        case "red" -> {
                            if (cubeCount > maxRedCubes) {
                                maxRedCubes = cubeCount;
                            }
                        }
                        case "green" -> {
                            if (cubeCount > maxGreenCubes) {
                                maxGreenCubes = cubeCount;
                            }
                        }
                        case "blue" -> {
                            if (cubeCount > maxBlueCubes) {
                                maxBlueCubes = cubeCount;
                            }
                        }
                    }
                }
            }
            var power = maxRedCubes * maxGreenCubes * maxBlueCubes;
            System.out.println("Max red cubes: " + maxRedCubes);
            System.out.println("Max green cubes: " + maxGreenCubes);
            System.out.println("Max blue cubes: " + maxBlueCubes);
            System.out.println("Power: " + power);
            sum += power;
        }
        
        System.out.println(sum);
    }
}
