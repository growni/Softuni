package abstractions.Exercise.CardRank;



public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        Ranks[] cardRanks = Ranks.values();
        for (Ranks cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank);
        }
    }
}
