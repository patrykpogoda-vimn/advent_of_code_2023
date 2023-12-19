package nineteen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstTask {

    record Part(int x, int m, int a, int s) {}


    public static void main(String[] args) {
        var input = """
                px{a<2006:qkq,m>2090:A,rfg}
                pv{a>1716:R,A}
                lnx{m>1548:A,A}
                rfg{s<537:gd,x>2440:R,A}
                qs{s>3448:A,lnx}
                qkq{x<1416:A,crn}
                crn{x>2662:A,R}
                in{s<1351:px,qqz}
                qqz{s>2770:qs,m<1801:hdj,R}
                gd{a>3333:R,R}
                hdj{m>838:A,pv}
                                
                {x=787,m=2655,a=1222,s=2876}
                {x=1679,m=44,a=2067,s=496}
                {x=2036,m=264,a=79,s=2244}
                {x=2461,m=1339,a=466,s=291}
                {x=2127,m=1623,a=2188,s=1013}""";

        var blocks = input.split("\n\n");

        var workflows = blocks[0].split("\n");
        var workflowMap = new HashMap<String, String>();

        for (var workflow : workflows) {
            var parts = workflow.split("\\{");
            workflowMap.put(parts[0], parts[1].substring(0, parts[1].length() - 1));
        }

        var parts = Arrays.stream(blocks[1].split("\n")).map(line -> {
            var values = line.substring(1, line.length() - 1).split(",");
            return new Part(
                    Integer.parseInt(values[0].split("=")[1]),
                    Integer.parseInt(values[1].split("=")[1]),
                    Integer.parseInt(values[2].split("=")[1]),
                    Integer.parseInt(values[3].split("=")[1]));
        }).toList();

        System.out.println(workflowMap);
        System.out.println(parts);

        var acceptedParts = parts.stream()
                .filter(part -> checkWorkflows(part, workflowMap))
                .toList();

        System.out.println(acceptedParts);

        var result = acceptedParts.stream()
                .mapToInt(part -> part.x() + part.m() + part.a() + part.s())
                .sum();

        System.out.println(result);

    }

    private static boolean checkWorkflows(Part part, Map<String, String> workflowMap) {
        var currentWorkflow = "in";
        while(true) {
            var workflow = workflowMap.get(currentWorkflow);
            var steps = workflow.split(",");

            STEPS: for(var step : steps) {
                if(step.contains(":")) {
                    var parts = step.split(":");
                    var condition = parts[0];
                    var nextWorkflow = parts[1];

                    if(condition.contains("<")) {
                        var values = condition.split("<");
                        var field = values[0];
                        var value = Integer.parseInt(values[1]);

                        switch (field) {
                            case "x" -> {
                                if (part.x() < value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "m" -> {
                                if (part.m() < value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "a" -> {
                                if (part.a() < value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "s" -> {
                                if (part.s() < value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                        }
                    } else if(condition.contains(">")) {
                        var values = condition.split(">");
                        var field = values[0];
                        var value = Integer.parseInt(values[1]);

                        switch (field) {
                            case "x" -> {
                                if (part.x() > value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "m" -> {
                                if (part.m() > value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "a" -> {
                                if (part.a() > value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                            case "s" -> {
                                if (part.s() > value) {
                                    if(nextWorkflow.equals("R")) {
                                        return false;
                                    }
                                    if(nextWorkflow.equals("A")) {
                                        return true;
                                    }
                                    currentWorkflow = nextWorkflow;
                                    break STEPS;
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("Unknown condition");
                    }

                } else {
                    if(step.equals("R")) {
                        return false;
                    }
                    if(step.equals("A")) {
                        return true;
                    }
                    currentWorkflow = step;
                    break STEPS;
                }
            }

        }
    }
}
