package advent_2023.twentythree;

import java.util.*;
import java.util.stream.Collectors;

public class SecondGraphTask {

    record Point(int row, int col) {}

    static class Node {
        final Point point;
        final Map<Node, Long> connectedNodes;

        Node(Point point, List<Node> connectedNodes) {
            this.point = point;
            this.connectedNodes = connectedNodes.stream().collect(Collectors.toMap(it -> it, it -> 1L));
        }

        public Point point() {
            return point;
        }

        public List<Node> connectedNodes() {
            return connectedNodes.keySet().stream().toList();
        }

        public Map<Node, Long> connectedNodesWithWeight() {
            return connectedNodes;
        }

        @Override
        public String toString() {
            return "current point = " + point + ", connected nodes = " + connectedNodes.entrySet().stream().map(it -> it.getKey().point+ " " + it.getValue()).collect(Collectors.toSet()) + "\n";
        }
    }

    public static void main(String[] args) {
        var input = """
                #.###########################################################################################################################################
                #.#...#...#.........###.........###...#...###...#...#...#.....#...#...#...#...#...#...#...#...#...#...#...#.....###.....#...#...###.....#...#
                #.#.#.#.#.#.#######.###.#######.###.#.#.#.###.#.#.#.#.#.#.###.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.###.###.###.#.#.#.#.###.###.#.#.#
                #.#.#...#.#.......#.#...#.......#...#.#.#.#...#.#.#.#.#...#...#.#...#.#.#.#.#...#.#.#.#.#.#.#.#.#.#.#.#.#.#...#...#...#.#.#.#.#.###.#...#.#.#
                #.#.#####.#######.#.#.###.#######.###.#.#.#.###.#.#.#.#####.###.#####.#.#.#.#####.#.#.#.#.#.#.#.#.#.#.#.#.###.###.###.#.#.#.#.#.###.#.###.#.#
                #.#.#.....#...#...#.#...#...>.>.#...#.#.#.#...#.#.#.#.#.....#...#.....#.#.#.#.....#.#.#.#.#.#.#.#.#.#.#.#.#...#...#...#.#.#.#.#.#...#...#.#.#
                #.#.#.#####.#.#.###.###.#####v#.###.#.#.#.###.#.#.#.#.#.#####.###.#####.#.#.#.#####.#.#.#.#.#.#.#.#.#.#.#.#.###.###.###.#.#.#.#.#.#####.#.#.#
                #.#.#...#...#.#...#...#.#.....#.....#.#.#.#...#.#.#.#.#.>.>.#...#.#...#.#.#.#.#...#.#...#.#.#.#.#...#...#.#...#.#...###...#.#.#.#.###...#.#.#
                #.#.###.#.###v###.###.#.#.###########.#.#.#.###.#.#.#.###v#.###.#.#.#.#.#.#.#.#.#.#.#####.#.#.#.#########.###.#.#.#########.#.#.#.###.###.#.#
                #...###.#.###.>.#...#...#...#.......#...#.#...#.#.#.#.#...#...#.#...#.#.#.#.#.#.#.#.....#.#.#.#.......#...#...#.#.......#...#.#.#...#.....#.#
                #######.#.###v#.###.#######.#.#####.#####.###.#.#.#.#.#.#####.#.#####.#.#.#.#.#.#.#####.#.#.#.#######.#.###.###.#######.#.###.#.###.#######.#
                #.......#.#...#...#.....###...#.....###...#...#.#.#.#.#.....#...#.....#.#.#.#.#.#.###...#.#.#...#.>.>.#.#...#...#.......#.....#.#...#...#...#
                #.#######.#.#####.#####.#######.#######.###.###.#.#.#.#####.#####.#####.#.#.#.#.#.###.###.#.###.#.#v###.#.###.###.#############.#.###.#.#.###
                #.#...#...#.....#.#.....#...###.....#...#...###.#.#...#.....#...#...#...#.#.#.#.#.>.>.###.#...#...#...#.#...#...#.....###...#...#.#...#...###
                #.#.#.#.#######.#.#.#####.#.#######.#.###.#####.#.#####.#####.#.###.#.###.#.#.#.###v#####.###.#######.#.###.###.#####.###.#.#.###.#.#########
                #.#.#...#.......#...#...#.#.........#...#.....#.#.#.....#.....#...#...###.#.#.#.#...#...#.#...#.......#...#...#...#...#...#...#...#.........#
                #.#.#####.###########.#.#.#############.#####.#.#.#.#####.#######.#######.#.#.#.#.###.#.#.#.###.#########.###.###.#.###.#######.###########.#
                #.#.#.....#...#...#...#.#.............#...#...#...#.......#...###.#.....#...#...#.....#.#.#.#...#...#####.....###.#...#...#.....#...#.......#
                #.#.#.#####.#.#.#.#.###.#############.###.#.###############.#.###.#.###.###############.#.#.#.###.#.#############.###.###.#.#####.#.#.#######
                #.#.#.......#...#...#...#.............###...#...#...........#.....#.#...#...#.........#.#...#...#.#...#...#...###.....###...#...#.#.#.#...###
                #.#.#################.###.###################.#.#.#################.#.###.#.#.#######.#.#######.#.###.#.#.#.#.###############.#.#.#.#.#.#.###
                #.#.#.......###...#...###...............#...#.#.#...................#...#.#.#.......#.#.......#...###...#...#.......#...#...#.#.#.#.#...#.###
                #.#.#.#####.###.#.#.###################.#.#.#.#.#######################.#.#.#######.#.#######.#####################.#.#.#.#.#.#.#.#.#####.###
                #...#.....#.....#...#...###...........#.#.#...#.#.......#...............#.#.........#.....#...#.....#.............#.#.#...#...#...#.....#...#
                #########.###########.#.###.#########.#.#.#####.#.#####.#.###############.###############.#.###.###.#.###########.#.#.#################.###.#
                #.........#.....#...#.#.#...#.......#...#...#...#.#.....#...............#.......#...#...#...###...#.#...........#.#.#...#.....#...#...#...#.#
                #.#########.###.#.#.#.#.#.###.#####.#######.#.###.#.###################.#######.#.#.#.#.#########.#.###########.#.#.###.#.###.#.#.#.#.###.#.#
                #...........###...#...#.#.#...#...#...#...#.#...#.#...#...###...###.....#.......#.#...#.#...#.....#.#...........#...###...###...#.#.#.###...#
                #######################.#.#.###.#.###.#.#.#.###.#.###.#.#.###.#.###.#####.#######.#####.#.#.#.#####.#.###########################.#.#.#######
                #...................#...#...#...#.#...#.#.#.#...#...#.#.#.#...#.#...#...#.......#.#.....#.#.#.....#.#.#.....#.......#.......#...#...#.......#
                #.#################.#.#######.###.#.###.#.#.#.#####.#.#.#.#.###.#.###.#.#######.#.#.#####.#.#####.#.#.#.###.#.#####.#.#####.#.#.###########.#
                #...#.............#.#.....###...#...###.#.#.#.#...#.#.#.#.#...#.#...#.#.###...#.#.#.#...#.#.#...#.#.#.#.#...#.#.....#...#...#.#.#...........#
                ###.#.###########.#.#####.#####.#######.#.#.#.#.#.#.#.#.#.###.#.###v#.#.###.#.#v#.#.#.#.#.#.#.#.#.#.#.#.#.###.#.#######.#.###.#.#.###########
                ###...#...........#.......#...#...###...#.#.#.#.#.#.#.#.#.#...#...>.>.#.#...#.>.>.#.#.#...#.#.#...#.#.#.#.....#.#...#...#...#.#.#...........#
                #######.###################.#.###.###.###.#.#.#.#.#.#.#.#.#.#######v###.#.#####v###.#.#####.#.#####.#.#.#######.#.#.#.#####.#.#.###########.#
                ###.....#...........#.....#.#.#...#...###.#.#.#.#.#.#.#.#...#...#...###.#.#.....###...#.....#...#...#...#.......#.#.#.#.....#.#.#...#...#...#
                ###.#####.#########.#.###.#.#.#.###.#####.#.#.#.#.#.#.#.#####.#.#.#####.#.#.###########.#######.#.#######v#######.#.#.#.#####.#.#.#.#v#.#.###
                #...#...#.#.........#...#...#.#.###...#...#.#...#.#.#.#.#.....#...#...#.#.#...#...#...#.....#...#.#...#.>.>.....#.#.#.#...#...#...#.>.#...###
                #.###.#.#.#.###########.#####.#.#####.#.###.#####.#.#.#.#.#########.#.#.#.###.#.#.#.#.#####.#.###.#.#.#.#v#####.#.#.#.###.#.#########v#######
                #.....#...#.#...#...###...#...#.#.....#...#.....#...#...#...........#.#.#.###.#.#...#.#...#.#.###.#.#.#.#.....#.#.#.#.###...#.....#...#...###
                ###########.#.#.#.#.#####.#.###v#.#######.#####.#####################.#.#.###.#.#####.#.#.#.#.###.#.#.#.#####.#.#.#.#.#######.###.#.###.#.###
                #.........#...#.#.#...#...#.#.>.>.#######.......#.....................#.#...#.#.#.....#.#.#...###.#.#...#.....#...#.#.#.......###.#.....#...#
                #.#######.#####v#.###.#.###.#.#v#################.#####################.###.#.#.#.#####.#.#######.#.#####.#########.#.#.#########.#########.#
                #.....#...#...#.>.###...###...#.......#...#...###.....#...............#.....#...#.......#.......#...#.....#...#...#...#.........#.#.........#
                #####.#.###.#.#v#####################.#.#.#.#.#######.#.#############.#########################.#####.#####.#.#.#.#############.#.#.#########
                #...#.#.....#.#.....#...###...#.......#.#.#.#...#.....#.#.....#.......#...#...#...###...#...#...#.....#.....#...#.....#.........#.#.........#
                #.#.#.#######.#####.#.#.###.#.#.#######.#.#.###.#.#####.#.###.#.#######.#.#.#.#.#.###.#.#.#.#.###.#####.#############.#.#########.#########.#
                #.#.#.......#.#...#...#...#.#.#.........#.#.#...#.......#...#...###...#.#...#.#.#.....#...#.#...#.....#.#.......#...#.#.#...#####...#...#...#
                #.#.#######.#.#.#.#######.#.#.###########.#.#.#############.#######.#.#.#####.#.###########.###.#####.#.#.#####.#.#.#.#.#.#.#######.#.#.#.###
                #.#.........#...#.#.......#.#.............#.#.###...#...###.........#.#...#...#...........#.....#####...#.....#...#...#...#...#...#...#.#...#
                #.###############.#.#######.###############.#.###.#.#.#.#############.###.#.#############.###################.###############.#.#.#####.###.#
                #.........#.....#.#.....#...#.....#...#####.#...#.#.#.#.#.......#...#...#.#.#...#...#...#.......#.....#.......#...#...#...#...#.#...###...#.#
                #########.#.###.#.#####.#.###.###.#.#.#####.###.#.#.#.#.#.#####.#.#.###.#.#.#.#.#.#.#.#.#######.#.###.#.#######.#.#.#.#.#.#.###.###.#####.#.#
                #...#####...#...#.#.....#...#.###...#.......#...#.#.#.#.#.....#...#.....#.#.#.#...#.#.#.....#...#...#.#.......#.#.#.#.#.#.#.....#...#...#...#
                #.#.#########.###.#.#######.#.###############.###.#.#.#.#####.###########.#.#.#####.#.#####.#.#####.#.#######.#.#.#.#.#.#.#######.###.#.#####
                #.#...........###...###...#...#####...#.......#...#.#.#.#.....#.....#...#.#.#...#...#.....#...#...#.#.###.....#.#.#.#.#.#.#.....#.....#.....#
                #.#####################.#.#########.#.#.#######.###.#.#.#.#####.###.#.#.#.#.###.#.#######v#####.#.#.#.###v#####.#.#.#.#.#.#.###.###########.#
                #...#.......#...###...#.#.....#.....#...###...#.#...#.#.#.....#...#.#.#.#.#.#...#.......>.>...#.#.#.#.#.>.>.#...#.#.#...#.#.###.......#.....#
                ###.#.#####.#.#.###.#.#.#####.#.###########.#.#.#.###.#.#####v###.#.#.#.#.#.#.###########v###.#.#.#.#.#.#v#.#.###.#.#####.#.#########.#.#####
                ###...###...#.#.###.#.#.#.....#.........#...#.#.#...#.#...#.>.>...#...#.#.#.#.#.........#...#...#.#.#.#.#.#...###...#.....#.......#...#.....#
                #########v###.#.###.#.#.#.#############.#.###.#.###.#.###.#.#v#########.#.#.#.#.#######.###.#####.#.#.#.#.###########.###########.#.#######.#
                #.......#.>.#.#...#.#.#.#...#...#.......#...#.#...#.#.###...#.#.......#.#.#.#.#.......#.#...#...#.#.#...#...#####.....#...#...#...#.......#.#
                #.#####.#v#.#.###.#.#.#.###.#.#.#.#########.#.###.#.#.#######.#.#####.#.#.#.#.#######.#.#.###.#.#.#.#######.#####.#####.#.#v#.#.#########.#.#
                #.....#.#.#...###...#.#.#...#.#.#...###...#.#.#...#.#.###.....#.#...#.#.#.#.#.#.......#...#...#...#.....###.....#.......#.>.#...###.....#.#.#
                #####.#.#.###########.#.#.###.#.###v###.#.#.#.#.###.#.###.#####.#.#.#.#.#.#.#.#.###########.###########.#######.###########v#######.###.#.#.#
                #.....#...#...###...#.#.#.#...#.#.>.>.#.#.#.#.#...#.#.#...#.....#.#...#...#...#...........#.#...#...#...#.......#...........#.......#...#.#.#
                #.#########.#.###.#.#.#.#.#.###.#.#v#.#.#.#.#.###.#.#.#.###.#####.#######################.#.#.#.#.#.#.###.#######.###########.#######.###.#.#
                #.........#.#...#.#.#...#.#.###...#.#...#.#.#...#.#...#.....#...#...#####...#####...#...#.#.#.#...#...###...#...#.....#.......#...#...###...#
                #########.#.###.#.#.#####.#.#######.#####.#.###.#.###########.#.###.#####.#.#####.#.#.#.#.#.#.#############.#.#.#####.#.#######.#.#.#########
                #.........#...#...#.....#.#.#...#...#...#.#...#...#...#...#...#...#.....#.#...#...#.#.#...#...###...#######...#.....#...#.......#...#...#...#
                #.###########.#########.#.#.#.#.#.###.#.#.###.#####.#.#.#.#.#####.#####.#.###.#.###.#.###########.#.###############.#####.###########.#.#.#.#
                #...#.....#...#.........#...#.#.#...#.#.#.....#...#.#.#.#.#.....#.#.....#...#...###...###...###...#...#.....#.......###...#.....#...#.#.#.#.#
                ###.#.###.#.###.#############.#.###.#.#.#######.#.#.#.#.#.#####.#.#.#######.#############.#.###.#####.#.###.#.#########.###.###.#.#.#.#.#.#.#
                #...#.###...#...#...#...#.....#.....#.#.......#.#...#...#...#...#.#...#...#.......#...#...#.....#.....#...#.#.........#.....#...#.#...#...#.#
                #.###.#######.###.#.#.#.#.###########.#######.#.###########.#.###.###.#.#.#######.#.#.#.#########.#######.#.#########.#######.###.#########.#
                #...#...#.....#...#...#.#.#...#.......#.......#.......#...#...###.....#.#.......#...#.#.#...#...#...#...#.#.#.......#.###...#.....#.........#
                ###.###.#.#####.#######.#.#.#.#.#######.#############.#.#.#############.#######.#####.#.#.#.#.#.###.#.#.#.#.#.#####.#.###.#.#######.#########
                #...#...#...#...#.......#...#...#.......#...###...###...#.....#.......#.......#.......#...#...#...#.#.#.#.#.#.....#...#...#.......#.........#
                #.###.#####.#.###.###############.#######.#.###.#.###########.#.#####.#######.###################.#.#.#.#.#.#####v#####.#########.#########.#
                #.#...#.....#.###.......#...#...#.....#...#.#...#...#.....#...#.#.....#.......###.....###...#...#.#.#.#.#.#.#...>.>.###...#.....#.....#...#.#
                #.#.###.#####.#########.#.#.#.#.#####.#.###.#.#####.#.###.#.###.#.#####.#########.###.###.#.#.#.#.#.#.#.#.#.#.###v#.#####.#.###.#####.#.#.#.#
                #...###.......#####...#.#.#.#.#.#.....#...#.#.#.....#...#.#...#.#...#...#...#...#...#...#.#...#...#.#.#.#.#...#...#...###...###...###.#.#...#
                ###################.#.#.#.#.#.#.#.#######.#.#.#.#######.#.###v#.###.#.###.#.#.#.###.###.#.#########.#.#.#.#####.#####.###########v###.#.#####
                #...#...#...#...#...#...#.#.#.#.#.....#...#...#.#...#...#...>.>.#...#.....#...#.#...#...#.........#...#.#.#.....#...#...#.....#.>.###...#...#
                #.#.#.#.#.#.#.#.#.#######.#.#.#.#####.#.#######.#.#.#.#######v###.#############.#.###.###########.#####.#.#.#####.#.###.#.###.#.#v#######.#.#
                #.#...#...#...#.#...#...#.#.#.#.###...#.....#...#.#.#.###.....#...#...#.........#.#...#...#...###.....#.#.#...###.#.###.#.###...#.###.....#.#
                #.#############.###.#.#.#.#.#.#.###v#######.#.###.#.#.###.#####.###.#.#.#########.#.###.#.#.#.#######.#.#.###.###.#.###.#.#######.###.#####.#
                #.............#...#.#.#.#.#.#.#.#.>.>...#...#...#.#.#...#.....#.###.#.#.....#...#.#...#.#.#.#.#...#...#...###...#.#.#...#.......#...#...#...#
                #############.###.#v#.#.#.#.#.#.#.#v###.#.#####.#.#.###.#####.#.###.#.#####v#.#.#.###.#.#.#.#.#.#.#.###########.#.#.#.#########.###.###.#.###
                #.......#...#...#.#.>.#.#.#.#.#...#...#...#...#...#.#...#...#.#...#.#.....>.>.#.#.#...#.#.#.#...#.#.....#.......#.#.#.....#...#.###.....#...#
                #.#####.#.#.###.#.#v###.#.#.#.#######.#####.#.#####.#.###.#.#.###.#.#######v###.#.#.###.#.#.#####.#####.#.#######.#.#####.#.#.#.###########.#
                #.....#.#.#.....#...###...#.#.....###...#...#.....#.#.#...#.#.#...#.....#...###...#...#.#.#.#.....#.....#.........#.....#...#...#...........#
                #####.#.#.#################.#####.#####.#.#######.#.#.#.###.#.#.#######.#.###########.#.#.#.#.#####.###################.#########.###########
                #.....#.#...........#...###.......#...#...#.......#...#...#.#.#.........#.#...###...#...#...#.....#.###.........#.....#.#.........#...#.....#
                #.#####.###########.#.#.###########.#.#####.#############.#.#.###########.#.#.###.#.#############.#.###.#######.#.###.#.#.#########.#.#.###.#
                #.#...#...........#...#.....#...#...#.......###...#...#...#...#...#...#...#.#...#.#.#.........#...#...#.......#.#...#...#.....#.....#...#...#
                #.#.#.###########.#########.#.#.#.#############.#.#.#.#.#######.#.#.#.#.###.###.#.#.#.#######.#.#####.#######.#.###.#########.#.#########.###
                #.#.#...........#...........#.#.#...#.......###.#...#.#...#...#.#...#.#.....###...#...#.......#...#...#.......#.....###...###...#...#.....###
                #.#.###########.#############.#.###.#.#####.###.#####.###.#.#.#.#####.#################.#########.#.###.###############.#.#######.#.#.#######
                #...#.........#...#...#...###.#...#...#...#...#.#.....###...#...#.....#...#.....#.......###...###...###...........#...#.#.#...#...#.#.#.....#
                #####v#######.###.#.#.#.#.###.###.#####.#.###.#.#.###############.#####.#.#.###.#.#########.#.###################.#.#.#.#.#.#.#.###.#.#.###.#
                #...#.>.....#.....#.#.#.#.#...#...###...#.....#.#.#...#...#...###.#...#.#.#...#.#.....###...#.#...#...#...#.......#.#.#.#.#.#.#.#...#...#...#
                #.#.#v#####.#######.#.#.#.#.###.#####.#########.#.#.#.#.#.#.#.###v#.#.#.#.###.#.#####v###.###.#.#.#.#.#.#.#.#######.#.#.#.#.#.#.#.#######v###
                #.#...###...#...###.#.#.#.#...#.#...#.......###.#.#.#.#.#.#.#.#.>.>.#.#.#...#.#.....>.>.#...#.#.#.#.#.#.#.#.....#...#.#.#.#.#.#.#.#.....>.###
                #.#######.###.#.###.#.#.#.###.#.#.#.#######v###.#.#.#.#.#.#.#.#.#v###.#.###.#.#######v#.###.#.#.#.#.#.#.#.#####.#.###.#.#.#.#.#.#.#.#####v###
                #.#.....#.#...#.#...#.#.#.#...#...#.#.....>.>.#.#.#.#...#...#...#.#...#...#...#...#...#...#.#.#.#.#.#.#.#.###...#...#.#.#.#.#...#.#.#.....###
                #.#.###.#.#.###.#.###.#.#.#.#######.#.#####v#.#.#.#.#############.#.#####.#####.#.#.#####.#.#.#.#.#.#.#.#.###v#####.#.#.#.#.#####.#.#.#######
                #.#.#...#...#...#...#...#.#.#.......#...#...#...#...###...#...#...#.....#.#.....#...###...#.#.#.#.#.#.#.#...>.>.#...#.#.#.#.....#...#.......#
                #.#.#.#######.#####.#####.#.#.#########.#.#############.#.#.#.#.#######.#.#.###########.###.#.#.#.#.#.#.#####v#.#.###.#.#.#####.###########.#
                #.#.#.......#.#...#...###...#...........#.........###...#...#...#...###.#.#...........#...#.#.#.#.#.#.#.#.....#.#...#.#.#.#.....###...#.....#
                #.#.#######.#.#.#.###.###########################.###.###########.#.###.#.###########.###.#.#.#.#.#.#.#.#.#####.###.#.#.#.#.#######.#.#.#####
                #.#.#.......#...#.#...#.........#...#...#.........#...#...#.....#.#.#...#.#...........###...#.#.#.#.#...#.....#.#...#...#...###...#.#.#.....#
                #.#.#.###########.#.###.#######.#.#.#.#.#.#########.###.#.#.###.#.#.#.###.#.#################.#.#.#.#########.#.#.#############.#.#.#.#####.#
                #...#...........#.#.###.......#.#.#...#.#.......###.#...#.#.###...#.#.....#.................#.#.#.#.#.........#.#.......#.......#...#.#...#.#
                ###############.#.#.#########.#.#.#####.#######.###.#.###.#.#######.#######################.#.#.#.#.#.#########.#######.#.###########.#.#.#.#
                ###.............#...#...#...#.#.#.....#.#...#...#...#.#...#.#.....#...#.....................#...#...#.........#.........#.......#...#...#.#.#
                ###.#################.#.#.#.#.#.#####.#.#.#.#.###.###.#.###.#.###.###.#.#####################################.#################.#.#.#####.#.#
                #...#...............#.#...#.#.#.....#.#.#.#...###.....#.....#...#.....#.............###...#...........#.......#...#...#...#...#...#...###...#
                #.###.#############.#.#####.#.#####.#.#.#.#####################.###################.###.#.#.#########.#.#######.#.#.#.#.#.#.#.#######.#######
                #...#.#...#.........#.#...#...#...#.#.#.#.........#.......#...#...#...#.....#.....#.....#.#.........#.#.....###.#...#...#.#.#.......#...#...#
                ###.#.#.#.#.#########.#.#.#####.#.#.#.#.#########.#.#####.#.#.###.#.#.#.###.#.###.#######.#########.#.#####.###.#########.#.#######.###.#.#.#
                ###...#.#.#.........#...#.....#.#.#...#...........#.....#.#.#.#...#.#.#.#...#...#.........#...#...#.#...###...#.........#...#.......#...#.#.#
                #######.#.#########.#########.#.#.#####################.#.#.#.#.###.#.#.#.#####v###########.#.#.#.#.###.#####.#########.#####.#######.###.#.#
                #.......#...........#.......#.#.#.....#.....###...#...#.#...#.#.###.#.#.#...#.>.>.....#...#.#.#.#.#...#.......#...#...#.#.....#...#...###.#.#
                #.###################.#####.#.#.#####.#.###.###.#.#.#.#.#####.#.###.#.#.###.#.#######.#.#.#.#.#.#.###.#########.#.#.#.#.#.#####.#.#v#####.#.#
                #.#.................#.....#.#...#.....#...#...#.#.#.#.#.....#...#...#.#...#.#.#.......#.#.#.#.#.#...#.......#...#...#.#.#.#...#.#.>.#...#.#.#
                #.#.###############.#####.#.#####v#######.###.#.#.#.#.#####.#####.###.###.#.#.#.#######.#.#.#.#.###.#######.#.#######.#.#.#.#.#.###v#.#.#.#.#
                #.#.#...............#...#.#.###.>.>.#...#...#.#.#.#.#.#...#...#...###...#.#.#.#...#...#.#.#.#.#...#.#...###.#.......#.#.#.#.#.#.#...#.#...#.#
                #.#.#.###############.#.#.#.###.###.#.#.###.#.#.#.#.#.#.#.###v#.#######.#.#.#.###.#.#.#.#.#.#.###.#.#.#.###v#######.#.#.#.#.#.#.#.###.#####.#
                #...#.......###...###.#.#.#.#...###.#.#...#.#.#.#.#.#.#.#.#.>.>.#...###...#...#...#.#.#.#.#.#.#...#.#.#.#.>.>.#.....#.#.#.#.#.#.#.....#.....#
                ###########.###.#.###.#.#.#.#.#####.#.###.#.#.#.#.#.#.#.#.#.#####.#.###########.###.#.#.#.#.#.#.###.#.#.#.###.#.#####.#.#.#.#.#.#######.#####
                #.....#.....#...#.#...#.#.#.#...###.#.#...#.#.#.#.#.#.#.#.#.....#.#.#...........#...#.#.#.#.#.#.#...#.#.#...#.#.#...#...#...#...###.....#...#
                #.###.#.#####.###.#.###.#.#.###.###.#.#.###.#.#.#.#.#.#.#.#####.#.#.#.###########.###.#.#.#.#.#.#.###.#.###.#.#.#.#.###############.#####.#.#
                #...#.#.....#...#.#...#...#.....#...#.#...#.#.#.#.#.#.#.#.#...#...#.#...#.....#...###.#.#.#.#.#.#...#.#.#...#.#...#.#...###...#...#.#.....#.#
                ###.#.#####.###.#.###.###########.###.###.#.#.#.#.#.#.#.#.#.#.#####.###.#.###.#.#####.#.#.#.#.#.###.#.#.#.###.#####.#.#.###.#.#.#.#.#.#####.#
                #...#.......#...#...#.........#...#...#...#.#.#.#...#.#.#.#.#.#...#...#.#.#...#.#.....#.#.#.#.#.#...#.#.#.###.....#.#.#.....#...#...#.#.....#
                #.###########.#####.#########.#.###.###.###.#.#.#####.#.#.#.#.#.#.###.#.#.#.###.#.#####.#.#.#.#.#.###.#.#.#######.#.#.###############.#.#####
                #...#...#...#.....#.#...#.....#...#.###...#.#.#.....#.#.#.#.#.#.#...#.#.#.#...#.#.#...#.#.#.#.#.#...#.#.#.......#.#.#...#...#...#...#.#.#...#
                ###.#.#.#.#.#####.#.#.#.#.#######.#.#####.#.#.#####.#.#.#.#.#.#.###.#.#.#.###.#.#.#.#.#.#.#.#.#.###.#.#.#######.#.#.###.#.#.#.#.#.#.#.#.#.#.#
                ###...#...#.......#...#...#######...#####...#.......#...#...#...###...#...###...#...#...#...#...###...#.........#...###...#...#...#...#...#.#
                ###########################################################################################################################################.#""";

        try {
            var map = input.lines().map(s -> s.split("")).toArray(String[][]::new);

            for(var row : map) {
                for(var col : row) {
                    System.out.print(col);
                }
                System.out.println();
            }

            var allNodes = new HashSet<Node>();

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {

                    if(map[i][j].equals("#")) {
                        continue;
                    }

                    var node = new Node(new Point(i, j), new ArrayList<>());
                    allNodes.add(node);
                }
            }

            for(var node: allNodes) {
                var upPoint = new Point(node.point().row() - 1, node.point().col());
                var downPoint = new Point(node.point().row() + 1, node.point().col());
                var leftPoint = new Point(node.point().row(), node.point().col() - 1);
                var rightPoint = new Point(node.point().row(), node.point().col() + 1);

                if(allNodes.stream().anyMatch(n -> n.point().equals(upPoint))) {
                    node.connectedNodesWithWeight().put(allNodes.stream().filter(n -> n.point().equals(upPoint)).findFirst().get(), 1L);
                }
                if (allNodes.stream().anyMatch(n -> n.point().equals(downPoint))) {
                    node.connectedNodesWithWeight().put(allNodes.stream().filter(n -> n.point().equals(downPoint)).findFirst().get(), 1L);
                }
                if (allNodes.stream().anyMatch(n -> n.point().equals(leftPoint))) {
                    node.connectedNodesWithWeight().put(allNodes.stream().filter(n -> n.point().equals(leftPoint)).findFirst().get(), 1L);
                }
                if (allNodes.stream().anyMatch(n -> n.point().equals(rightPoint))) {
                    node.connectedNodesWithWeight().put(allNodes.stream().filter(n -> n.point().equals(rightPoint)).findFirst().get(), 1L);
                }
            }


            System.out.println(allNodes);

            var merged = merge(allNodes);

            System.out.println(merged);

            var startNode = merged.stream().filter(it -> it.point().equals(new Point(0, 1))).findFirst().get();
            var visitedNodes = new HashSet<Node>();
            var length = dfs(startNode, visitedNodes, 0, map.length, map[0].length);

            System.out.println(length);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long dfs(Node currentNode, HashSet<Node> visitedNodes, long currentLength, int rows, int cols) {

        if(currentNode.point().equals(new Point(rows - 1, cols - 2))) {
            return currentLength;
        }

        if(visitedNodes.contains(currentNode)) {
            return 0;
        }

        visitedNodes.add(currentNode);

        var connectedNodes = currentNode.connectedNodesWithWeight();

        return connectedNodes.keySet()
                .stream()
                .map(it -> dfs(it, new HashSet<>(visitedNodes), currentLength + connectedNodes.get(it), rows, cols))
                .mapToLong(it -> it)
                .max().getAsLong();
    }

    private static HashSet<Node> merge(HashSet<Node> allNodes) {
        var somethingChanged = true;

        while (somethingChanged) {
            somethingChanged = false;
            for (var node : allNodes) {
                var connectedNodes = node.connectedNodes();
                if (connectedNodes.size() == 2) {
                    var first = connectedNodes.get(0);
                    var second = connectedNodes.get(1);

                    var currentWeights = node.connectedNodesWithWeight();
                    var firstWeight = currentWeights.get(first);
                    var secondWeight = currentWeights.get(second);

                    var firstNodes = first.connectedNodesWithWeight();
                    var firstWithWeight = firstNodes.remove(node);
                    firstNodes.put(second, firstWithWeight + secondWeight);
                    var secondNodes = second.connectedNodesWithWeight();
                    var secondWithWeight = secondNodes.remove(node);
                    secondNodes.put(first, secondWithWeight + firstWeight);
                    somethingChanged = true;
                    allNodes.remove(node);
                    break;
                }
            }
        }

        return allNodes;
    }
}
