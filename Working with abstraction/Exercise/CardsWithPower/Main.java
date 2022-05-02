package abstractions.Exercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();

        Card card = new Card(CardSuit.valueOf(suit), Ranks.valueOf(rank));
        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRank(), card.getCardSuit(), card.getPower());
    }
}
