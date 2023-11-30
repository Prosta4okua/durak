package additional;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatistics {
    private int totalWins;
    private List<Integer> cardsLostPerGame;
    private int consecutiveWins;

    public PlayerStatistics() {
        this.totalWins = 0;
        this.cardsLostPerGame = new ArrayList<>();
        this.consecutiveWins = 0;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void incrementTotalWins() {
        totalWins++;
        consecutiveWins++;
    }

    public void addCardsLost(int cardsLost) {
        cardsLostPerGame.add(cardsLost);
    }

    public int getConsecutiveWins() {
        return consecutiveWins;
    }

    public void resetConsecutiveWins() {
        consecutiveWins = 0;
    }

    public List<Integer> getCardsLostPerGame() {
        return cardsLostPerGame;
    }

    // Додайте інші методи та геттери за потребою
}
