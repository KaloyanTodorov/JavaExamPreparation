import java.util.HashMap;
import java.util.Scanner;

public class P02_MagicCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputHand = scanner.nextLine();
        String[] hands = inputHand.split(" "); // == String[] hand = scanner.nextLine().split("\\s+");
        String oddOrEven = scanner.nextLine();
        String magicCard = scanner.nextLine();
        String magicCardValue = magicCard.replaceAll("[SHDC]", "");
        char magicCardSuit = magicCard.replaceAll("[0-9JQKA]+", "").charAt(0);
        int sum = 0;

        HashMap<Character,Integer> specialValues = new HashMap<>();
        specialValues.put('J', 120);
        specialValues.put('Q', 130);
        specialValues.put('K', 140);
        specialValues.put('A', 150);

        int magicSum = 0;
        int i = 0;
        if (oddOrEven.equals("odd")) {
            i = 1;
        }

        for (; i < hands.length; i += 2) {
            String card = hands[i];
            int cardValue = 0;

            if (isSpecial(card)) {
                cardValue = specialValues.get(card.charAt(0));
            } else {
                cardValue = Integer.parseInt(card.replaceAll("[SHDC]", "")) * 10;

                }
            if (card.contains(magicCardValue)) {
                cardValue *= 3;
            } else if (card.indexOf(magicCardSuit) >= 0) {
                cardValue *= 2;
            }
            magicSum += cardValue;
        }

        System.out.println(magicSum);
    }

    private static boolean isSpecial(String s) {
        if (s.charAt(0) == 'J' || s.charAt(0) == 'Q' || s.charAt(0) == 'K' || s.charAt(0) == 'A') {
            return true;
        } else {
            return false;
        }
    }
}
