import additional.PlayerStatistics;

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Card> hand;
    private PlayerStatistics statistics;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.statistics = new PlayerStatistics();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void showHand() {
        System.out.println(name + "'s hand: " + hand);
    }

    public boolean hasCard(Card card) {
        return hand.contains(card);
    }

    public Card playCard(Card card) {
        if (hand.remove(card)) {
            System.out.println(name + " plays " + card);
            return card;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStatistics getStatistics() {
        return statistics;
    }
}