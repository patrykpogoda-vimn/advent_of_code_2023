package fiveteen;

public class FirstTask {

    public static void main(String[] args) {
        var input = """
                rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7""";

        var codes = input.split(",");
        long sum = 0;

        for(var code : codes) {
            long current = 0;

            for(char c : code.toCharArray()) {
                current += (int) c;
                current *= 17;
                current %= 256;
            }

            System.out.println(current);
            sum += current;
        }

        System.out.println(sum);
    }
}
