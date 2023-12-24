package advent_2023.twentyfour;

import java.util.ArrayList;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                19, 13, 30 @ -2,  1, -2
                18, 19, 22 @ -1, -1, -2
                20, 25, 34 @ -2, -2, -4
                12, 31, 28 @ -1, -2, -1
                20, 19, 15 @  1, -5, -3""";

        var points = new ArrayList<Point>();
        var velocities = new ArrayList<Velocity>();

        input.lines().forEach(line -> {
            var parts = line.split(" @ ");
            var point = parts[0].split(", +");
            var velocity = parts[1].split(", +");

            points.add(new Point(Long.parseLong(point[0].trim()), Long.parseLong(point[1].trim()), Long.parseLong(point[2].trim())));
            velocities.add(new Velocity(Long.parseLong(velocity[0].trim()), Long.parseLong(velocity[1].trim()), Long.parseLong(velocity[2].trim())));
        });

        var partsOfEquation = new ArrayList<PartsOfEquation>();

        for (int i = 0; i < points.size(); i++) {
            var point = points.get(i);
            var velocity = velocities.get(i);

            var slope = velocity.y() / velocity.x();
            var addition = point.y() - slope * point.x();

            partsOfEquation.add(new PartsOfEquation(slope, addition));
        }


        System.out.println(points);
        System.out.println(velocities);
        System.out.println(partsOfEquation);

        var intersections = 0L;

        for(int i = 0; i < partsOfEquation.size(); i++) {
            var equation1 = partsOfEquation.get(i);

            for(int j = i + 1; j < partsOfEquation.size(); j++) {
                var equation2 = partsOfEquation.get(j);

                var x = (equation2.addition() - equation1.addition()) / (equation1.slope() - equation2.slope());
                var y = equation1.slope() * x + equation1.addition();
                var time1 = (x - points.get(i).x()) / velocities.get(i).x();
                var time2 = (x - points.get(j).x()) / velocities.get(j).x();

                System.out.println("Found intersection at " + x + ", " + y + " for " + i + " and " + j);
                System.out.println("time: " + time1);
                System.out.println("time: " + time2);
                System.out.println("point 1: " + points.get(i));
                System.out.println("point 2: " + points.get(j));


                if (time1 < 0) {
                    continue;
                }

                if (time2 < 0) {
                    continue;
                }

                if (x < 200000000000000L || x > 400000000000000L) {
                    continue;
                }

                if (y < 200000000000000L || y > 400000000000000L) {
                    continue;
                }


                intersections++;
            }
        }
        System.out.println(intersections);
    }

    record Point(double x, double y, double z) {

    }

    record Velocity(double x, double y, double z) {

    }

    record PartsOfEquation(double slope, double addition) {

    }
}
