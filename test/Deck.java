import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;
    private String trumpSuit;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
        determineTrumpSuit();
    }

    private void initializeDeck() {
        String[] ranks = {"6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                boolean isTrump = false;
                // Один з варіантів визначення козиру, можливо, вам зручніше вказати його інакше
                if (suit.equals("Hearts")) {
                    isTrump = true;
                }
                cards.add(new Card(rank, suit, isTrump));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    private void determineTrumpSuit() {
        // Простий вибір першої карти у колоді як козирної, можна модифікувати за потреби
        if (!cards.isEmpty()) {
            trumpSuit = cards.get(0).getSuit();
            System.out.println("Trump suit is: " + trumpSuit);
        }
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }

    public String getTrumpSuit() {
        return trumpSuit;
    }
}