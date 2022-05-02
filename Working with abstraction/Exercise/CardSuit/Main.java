package abstractions.Exercise.CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuit[] cardSuits = CardSuit.values();
        for (CardSuit carSuit: cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", carSuit.ordinal(), carSuit);
        }
    }
}
