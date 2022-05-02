package abstractions.Exercise.CardsWithPower;

public class Card {
    private CardSuit cardSuit;
    private Ranks cardRank;
    private int power;

    public Card(CardSuit cardSuit, Ranks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public Ranks getCardRank() {
        return cardRank;
    }

    public void setCardRank(Ranks cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        //suitPower + rankPower
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public void setPower(int power) {
        this.power = power;
    }
}
