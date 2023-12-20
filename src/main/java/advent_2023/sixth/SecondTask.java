package advent_2023.sixth;

import java.util.HashMap;

public class SecondTask {

    public static void main(String[] args) {

        var input = """
                Time:        50748685
                Distance:   242101716911252""";

        var lines = input.split("\n");
        var times = lines[0].substring(lines[0].indexOf(":") + 1).trim().split(" +");
        var distances = lines[1].substring(lines[1].indexOf(":") + 1).trim().split(" +");

        var timesToDistances = new HashMap<Long, Long>();

        for(int i = 0; i < times.length; i++) {
            timesToDistances.put(Long.parseLong(times[i].trim()), Long.parseLong(distances[i].trim()));
        }

        System.out.println(timesToDistances);

        int result = 0;

        for (String time : times) {
            long distanceToBeat = timesToDistances.get(Long.parseLong(time.trim()));
            int timesBeaten = 0;

            for (int j = 0; j < Long.parseLong(time); j++) {
                var timeToTravel = Long.parseLong(time) - j;
                var distanceCovered = timeToTravel * j;

                if (distanceCovered > distanceToBeat) {
                    timesBeaten++;
                }
            }

            System.out.println(time + " " + timesBeaten);
            if (result == 0) {
                result = timesBeaten;
            } else {
                result *= timesBeaten;
            }
        }

        System.out.println(result);
    }
}
