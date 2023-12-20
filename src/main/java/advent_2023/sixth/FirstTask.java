package advent_2023.sixth;

import java.util.HashMap;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                Time:        50     74     86     85
                Distance:   242   1017   1691   1252""";

        var lines = input.split("\n");
        var times = lines[0].substring(lines[0].indexOf(":") + 1).trim().split(" +");
        var distances = lines[1].substring(lines[1].indexOf(":") + 1).trim().split(" +");

        var timesToDistances = new HashMap<Integer, Integer>();

        for(int i = 0; i < times.length; i++) {
            timesToDistances.put(Integer.parseInt(times[i].trim()), Integer.parseInt(distances[i].trim()));
        }

        System.out.println(timesToDistances);

        int result = 0;

        for(int i = 0; i < times.length; i++) {
            int distanceToBeat = timesToDistances.get(Integer.parseInt(times[i].trim()));
            int timesBeaten = 0;

            for(int j = 0; j < Integer.parseInt(times[i]); j++) {
                var timeToTravel = Integer.parseInt(times[i]) - j;
                var speed = j;
                var distanceCovered = timeToTravel * speed;

                if(distanceCovered > distanceToBeat) {
                    timesBeaten++;
                }
            }

            System.out.println(times[i] + " " + timesBeaten);
            if(result == 0) {
                result = timesBeaten;
            } else {
                result *= timesBeaten;
            }
        }

        System.out.println(result);
    }
}
