package seventh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstTask {


    //from strongest to weakest A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2
    static HashMap<Character, Integer> strengths = new HashMap<>();

    public static void main(String[] args) {
        strengths.put('A', 13);
        strengths.put('K', 12);
        strengths.put('Q', 11);
        strengths.put('J', 10);
        strengths.put('T', 9);
        strengths.put('9', 8);
        strengths.put('8', 7);
        strengths.put('7', 6);
        strengths.put('6', 5);
        strengths.put('5', 4);
        strengths.put('4', 3);
        strengths.put('3', 2);
        strengths.put('2', 1);

        var inut = """
                32T3K 765
                T55J5 684
                KK677 28
                KTJJT 220
                QQQJA 483""";


        var lines = inut.split("\n");

        record CardToBidAndStrength (String card, Integer bid, Integer strength) {}

        var cardToBids = new HashSet<CardToBidAndStrength>();

        for (var line : lines) {
            var parts = line.split(" ");
            var card = parts[0];
            var bid = Integer.parseInt(parts[1]);

            var cardTypeStrength = assessCardTypeStrength(card);

            cardToBids.add(new CardToBidAndStrength(card, bid, cardTypeStrength));
        }


        var sorted = cardToBids.stream().sorted((a, b) -> {
            if (a.strength().equals(b.strength())) {
                return compareLetters(b.card(), a.card());
            } else {
                return b.strength().compareTo(a.strength());
            }
        }).toList();

        System.out.println(sorted);

        var result = 0;

        for(int i = 0; i < sorted.size(); i++) {
            result += sorted.get(i).bid() * (sorted.size() - i);
        }


        System.out.println(result);
    }



    private static int compareLetters(String card, String card1) {

        for(int i = 0; i < 5; i++) {
            if (strengths.get(card.charAt(i)) > strengths.get(card1.charAt(i))) return 1;
            if (strengths.get(card.charAt(i)) < strengths.get(card1.charAt(i))) return -1;
        }
        return 0;
    }

    private static Integer assessCardTypeStrength(String card) {

        //check all letters are same (five)

        var letters= new HashMap<Character, Integer>();

        for(int i = 0; i < card.length(); i++) {
            if(letters.containsKey(card.charAt(i))) {
                letters.put(card.charAt(i), letters.get(card.charAt(i)) + 1);
            } else {
                letters.put(card.charAt(i), 1);
            }
        }

        if (letters.size() == 1) return 7;
        if(letters.size() == 2 && letters.containsValue(4)) return 6;
        if(letters.size() == 2 && letters.containsValue(3) && letters.containsValue(2)) return 5;
        if(letters.size() == 3 && letters.containsValue(3) && letters.containsValue(1)) return 3;
        if(letters.size() == 3 && letters.containsValue(2) && letters.containsValue(1)) return 2;
        if(letters.size() == 4) return 1;
        if(letters.size() == 5) return 0;

        throw new RuntimeException("Should not happen");
    }
}
