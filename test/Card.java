class Card {
    private String rank;
    private String suit;
    private boolean isTrump;

    public Card(String rank, String suit, boolean isTrump) {
        this.rank = rank;
        this.suit = suit;
        this.isTrump = isTrump;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isTrump() {
        return isTrump;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + (isTrump ? " (trump)" : "");
    }
}