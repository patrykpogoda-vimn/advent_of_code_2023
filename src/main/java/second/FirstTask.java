package second;

public class FirstTask {

    public static void main(String[] args) {
        var redCubes = 12;
        var greenCubes = 13;
        var blueCubes = 14;

        var input = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;

        var games = input.split("\n");

        var sumIds = 0;

        for(var game: games) {
            var gameId = Integer.parseInt(game.substring(0, game.indexOf(":")).substring(5));
            var gameRounds = game.substring(game.indexOf(":") + 1).split(";");

            var success = true;

            for(var gameRound: gameRounds) {
                var gameRoundCubes = gameRound.split(",");

                var roundRedCubes = 0;
                var roundGreenCubes = 0;
                var roundBlueCubes = 0;

                for(var gameRoundCube: gameRoundCubes) {
                    var cubeColor = gameRoundCube.trim().split(" ")[1];
                    var cubeCount = Integer.parseInt(gameRoundCube.trim().split(" ")[0]);

                    switch (cubeColor) {
                        case "red" -> roundRedCubes += cubeCount;
                        case "green" -> roundGreenCubes += cubeCount;
                        case "blue" -> roundBlueCubes += cubeCount;
                    }
                }

                if(roundRedCubes > redCubes || roundGreenCubes > greenCubes || roundBlueCubes > blueCubes) {
                    success = false;
                    break;
                }
            }

            if(success) {
                sumIds += gameId;
            }
        }

        System.out.println(sumIds);
    }
}
