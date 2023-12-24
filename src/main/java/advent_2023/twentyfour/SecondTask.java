package advent_2023.twentyfour;

import java.util.ArrayList;

public class SecondTask {

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

        for(int x = 0; x <= 25; x++) {
            for(int y = 0; y <= 25; y++) {
                for(int z = 0; z <= 25; z++) {

                    for(int velX = -10; velX <= 10; velX++) {
                        for(int velY = -10; velY <= 10; velY++) {
                            for(int velZ = -10; velZ <= 10; velZ++) {

                                System.out.println("Checking " + x + ", " + y + ", " + z + " with velocity " + velX + ", " + velY + ", " + velZ);

                                var point = new Point(x, y, z);
                                var velocity = new Velocity(velX, velY, velZ);

                                var foundIntersection = true;

                                for(int i = 0; i < points.size(); i++) {
                                    double epsilon = 0.000001d;

                                    var point1 = points.get(i);
                                    var velocity1 = velocities.get(i);

                                    var time = (point.x() - point1.x()) / (velocity1.x() - velocity.x());

                                    var x1 = point1.x() + velocity1.x() * time;
                                    var x2 = point.x() + velocity.x() * time;

                                    var y1 = point1.y() + velocity1.y() * time;
                                    var z1 = point1.z() + velocity1.z() * time;

                                    var y2 = point.y() + velocity.y() * time;
                                    var z2 = point.z() + velocity.z() * time;

                                    if(Math.abs(x1 - x2) > epsilon || Math.abs(y1 - y2) > epsilon || Math.abs(z1 - z2) > epsilon) {
                                        foundIntersection = false;
                                        break;
                                    }

                                    if (time < 0) {
                                        foundIntersection = false;
                                        break;
                                    }
                                }

                                if(foundIntersection) {
                                    System.out.println("Found intersection at " + x + ", " + y + ", " + z + " with velocity " + velX + ", " + velY + ", " + velZ);
                                    return;
                                }
                            }
                        }
                    }

                }
            }
        }

    }

    record Point(double x, double y, double z) {

    }

    record Velocity(double x, double y, double z) {

    }
}
