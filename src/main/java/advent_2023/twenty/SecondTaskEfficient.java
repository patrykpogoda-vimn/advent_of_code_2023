package advent_2023.twenty;

import java.util.HashMap;
import java.util.List;

public class SecondTaskEfficient {

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
            int buttonPushesVq = 0;
            int buttonPushesTf = 0;
            int buttonPushesLn = 0;
            int buttonPushesDb = 0;


            int buttonPushes = 0;

            while(buttonPushesVq == 0 || buttonPushesTf == 0 || buttonPushesLn == 0 || buttonPushesDb == 0) {

                buttonPushes++;
                stack.push(new Low(null, "broadcaster"));

                while (!stack.isEmpty()) {
                    var pulse = stack.pop();
                    var to = nodes.get(pulse.to());

                    if (to == null) {
                        continue;
                    }

                    var pulses = to.receivePulse(pulse);

                    if(to.getName().equals("tg")){
                        var conjunction = (Conjunction) to;
                        if(buttonPushesVq == 0 && conjunction.incomingNodes.get("vq") instanceof High) {
                            buttonPushesVq = buttonPushes;
                        }
                        if(buttonPushesTf == 0 && conjunction.incomingNodes.get("tf") instanceof High) {
                            buttonPushesTf = buttonPushes;
                        }
                        if(buttonPushesLn == 0 && conjunction.incomingNodes.get("ln") instanceof High) {
                            buttonPushesLn = buttonPushes;
                        }
                        if(buttonPushesDb == 0 && conjunction.incomingNodes.get("db") instanceof High) {
                            buttonPushesDb = buttonPushes;
                        }
                    }

                    stack.addAll(pulses);
                }
            }

            System.out.println("Button pushes: " + buttonPushes);
            System.out.println("Button pushes vq: " + buttonPushesVq);
            System.out.println("Button pushes tf: " + buttonPushesTf);
            System.out.println("Button pushes ln: " + buttonPushesLn);
            System.out.println("Button pushes db: " + buttonPushesDb);


            System.out.println("result = " + ((long) buttonPushesVq * buttonPushesTf * buttonPushesLn * buttonPushesDb));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
