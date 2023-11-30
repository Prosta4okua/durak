import java.util.ArrayList;
import java.util.List;

class Table {
    private final List<Card> cardsOnTable;

    public Table() {
        cardsOnTable = new ArrayList<>();
    }

    public void addToTable(Card card) {
        cardsOnTable.add(card);
    }

    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void clearTable() {
        cardsOnTable.clear();
    }
}