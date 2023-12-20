package advent_2023.twenty;

import java.util.HashMap;
import java.util.List;

public class FirstTask {

    interface Pulse {
        String from();
        String to();
    }

    record High(String from, String to) implements Pulse {
        @Override
        public String from() {
            return from;
        }

        @Override
        public String to() {
            return to;
        }
    }

    record Low(String from, String to) implements Pulse {
        @Override
        public String from() {
            return from;
        }

        @Override
        public String to() {
            return to;
        }
    }

    interface Node {
        List<? extends Pulse> receivePulse(Pulse pulse);

        List<String> getOutputNodes();

        String getName();
    }

    static class FlipFlop implements Node {
        boolean on = false;

        private final List<String> outputNodes;
        private final String name;

        FlipFlop(String name, List<String> outputNodes) {
            this.name = name;
            this.outputNodes = outputNodes;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<? extends Pulse> receivePulse(Pulse pulse) {
            if (pulse instanceof Low) {
                on = !on;

                if(on) {
                    return outputNodes.stream().map(output -> new High(this.name, output)).toList();
                }
                else {
                    return outputNodes.stream().map(output -> new Low(this.name, output)).toList();
                }
            } else {
                return List.of();
            }
        }

        @Override
        public List<String> getOutputNodes() {
            return outputNodes;
        }

        @Override
        public String toString() {
            return "FlipFlop{" +
                    "on=" + on +
                    ", outputNodes=" + outputNodes +
                    '}';
        }
    }

    static class Conjunction implements Node {
        private final HashMap<String, Pulse> incomingNodes = new HashMap<>();

        private final List<String> outputNodes;
        private final String name;

        Conjunction(String name, List<String> outputNodes) {
            this.name = name;
            this.outputNodes = outputNodes;
        }

        @Override
        public String getName() {
            return name;
        }

        public void addIncomingNode(Node node) {
            incomingNodes.put(node.getName(), new Low(null, null));
        }

        @Override
        public List<? extends Pulse>  receivePulse(Pulse pulse) {
            incomingNodes.put(pulse.from(), pulse);

            if(incomingNodes.values().stream().allMatch(p -> p instanceof High)) {
                return outputNodes.stream().map(output -> new Low(this.name, output)).toList();
            }
            else {
                return outputNodes.stream().map(output -> new High(this.name, output)).toList();
            }
        }

        @Override
        public List<String> getOutputNodes() {
            return outputNodes;
        }

        @Override
        public String toString() {
            return "Conjunction{" +
                    "incomingNodes=" + incomingNodes +
                    ", outputNodes=" + outputNodes +
                    '}';
        }
    }

    static class Broadcaster implements Node {

        private final List<String> outputNodes;

        private final String name;

        Broadcaster(String name, List<String> outputNodes) {
            this.name = name;
            this.outputNodes = outputNodes;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<? extends Pulse>  receivePulse(Pulse pulse) {
            if(pulse instanceof Low) {
                return outputNodes.stream().map(output -> new Low(this.name, output)).toList();
            } else {
                return outputNodes.stream().map(output -> new High(this.name, output)).toList();
            }
        }

        @Override
        public List<String> getOutputNodes() {
            return outputNodes;
        }

        @Override
        public String toString() {
            return "Broadcaster{" +
                    "outputNodes=" + outputNodes +
                    "}";
        }
    }


    public static void main(String[] args) {
        var input = """
                %vg -> lf, vd
                %dr -> kg
                %cn -> mv, pt
                %rq -> bk, gr
                %vp -> lp, bk
                %kg -> lv
                %lv -> jc, tp
                %sj -> rm, vd
                %jc -> tp, qr
                %km -> tp, dr
                %jx -> cn
                &vd -> tf, lf, nb, cx, hx, lr
                %lp -> jt, bk
                %vj -> ps
                broadcaster -> km, lr, xh, rf
                %dj -> pt, gc
                %cg -> vd, hx
                &ln -> tg
                %fl -> pt, sk
                %lm -> tr, bk
                %lr -> vd, vg
                &pt -> vq, rf, cm, jx, rg
                %cx -> gp
                %gp -> vd, sj
                &db -> tg
                %st -> vd
                %jt -> bk
                %jh -> lm, bk
                %xf -> bd, tp
                %gc -> cm, pt
                &tp -> dr, km, kg, db, vj, qr
                %ps -> xf, tp
                %rf -> pt, dj
                %lf -> nb
                %bd -> tp, gg
                %dk -> tp, vj
                %mn -> jh, bk
                &tg -> rx
                %ql -> bk, zx
                %tr -> bk, vp
                %sk -> pt
                %nb -> cg
                %sb -> vd, cx
                %qr -> dk
                %xh -> bk, ql
                %rg -> sd
                %hx -> sb
                %sd -> pt, jx
                %gr -> bk, mn
                %gg -> tp
                %zx -> rq
                &bk -> xh, ln, zx
                %rm -> st, vd
                %hq -> fl, pt
                &vq -> tg
                %cm -> rg
                &tf -> tg
                %mv -> pt, hq""";


        var lines = input.split("\n");

        var nodes = new HashMap<String, Node>();
        var lowPulseCounter = 0;
        var highPulseCounter = 0;

        for (var line : lines) {
            var parts = line.split(" -> ");

            var name = parts[0].substring(1);
            var type  = parts[0].charAt(0);
            var outputNodes = List.of(parts[1].split(", "));

            if(name.equals("roadcaster")) {
                nodes.put("broadcaster", new Broadcaster("broadcaster",outputNodes));
                continue;
            }

            var node = switch (type) {
                case '&' -> new Conjunction(name, outputNodes);
                case '%' -> new FlipFlop(name, outputNodes);
                default -> throw new IllegalStateException();
            };


            nodes.put(name, node);
        }

        for(var node : nodes.values()) {
            for(var outputNode : node.getOutputNodes()) {
                var nodeToReceive = nodes.get(outputNode);

                if(nodeToReceive instanceof Conjunction con) {
                    con.addIncomingNode(node);
                }
            }
        }

        System.out.println(nodes);

        try {
            var stack = new Stack<Pulse>();

            for(int i = 0; i < 1000; i++) {
                stack.push(new Low(null, "broadcaster"));

                while (!stack.isEmpty()) {
                    var pulse = stack.pop();
                    var to = nodes.get(pulse.to());

                    System.out.println("From: " + pulse.from() + " to: " + pulse.to());

                    if (pulse instanceof Low) {
                        lowPulseCounter++;
                    } else {
                        highPulseCounter++;
                    }

                    if (to == null) {
                        continue;
                    }

                    var pulses = to.receivePulse(pulse);
                    System.out.println("Pulses: " + pulses);

                    stack.addAll(pulses);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return;
        }

        System.out.println("Pulse counter: " + (lowPulseCounter + highPulseCounter));
        System.out.println("Low pulse counter: " + lowPulseCounter);
        System.out.println("High pulse counter: " + highPulseCounter);
        System.out.println("Result: " + (lowPulseCounter * highPulseCounter));
    }
}
