import additional.GameRules;
import additional.PlayerStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DurakGameController {
    private Deck deck;
    private List<Player> players;
    private Table table;
    private String trumpSuit;
    private GameRules gameRules;

    public DurakGameController(GameRules gameRules) {
        this.gameRules = gameRules;
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.table = new Table();
        this.trumpSuit = deck.getTrumpSuit();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void dealCards() {
        for (int i = 0; i < 6; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.addToHand(card);
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        // Головний цикл гри
        while (true) {
            for (Player currentPlayer : players) {
                Player opponentPlayer = getOpponent(currentPlayer);
                playTurn(currentPlayer, opponentPlayer, table, deck, scanner);

                if (isGameEnd()) {
                    updatePlayerStatistics();
                    printWinner();
                    scanner.close();
                    return;
                }
            }
        }
    }

    private void updatePlayerStatistics() {
        for (Player player : players) {
            PlayerStatistics statistics = getPlayerStatistics(player);
            statistics.incrementTotalWins();
            updateConsecutiveWins(player);
            calculateAverageCardsLost(player);
        }
    }

    private void updateConsecutiveWins(Player player) {
        PlayerStatistics statistics = getPlayerStatistics(player);
        if (player.getHand().isEmpty()) {
            statistics.resetConsecutiveWins();
        }
    }

    private void calculateAverageCardsLost(Player player) {
        PlayerStatistics statistics = getPlayerStatistics(player);
        List<Integer> cardsLostPerGame = statistics.getCardsLostPerGame();
        if (!cardsLostPerGame.isEmpty()) {
            int totalCardsLost = 0;
            for (int cardsLost : cardsLostPerGame) {
                totalCardsLost += cardsLost;
            }
            double averageCardsLost = (double) totalCardsLost / cardsLostPerGame.size();
            // Додайте обробку середньої кількості карт, програних гравцем у грі
        }
    }

    private PlayerStatistics getPlayerStatistics(Player player) {
        // Логіка отримання або створення об'єкту PlayerStatistics для гравця
        return player.getStatistics();
    }



    private Player getOpponent(Player currentPlayer) {
        for (Player player : players) {
            if (!player.equals(currentPlayer)) {
                return player;
            }
        }
        return null;
    }

    private void playTurn(Player currentPlayer, Player opponentPlayer, Table table, Deck deck,
                          Scanner scanner) {
        System.out.println("\n" + currentPlayer.getHand());
        System.out.println("Cards on the table: " + table.getCardsOnTable());
        System.out.println("Trump suit: " + trumpSuit);
        System.out.print(currentPlayer.getName() + ", choose a card to play: ");
        String selectedRank = scanner.next();
        Card selectedCard = findCardByRank(currentPlayer, selectedRank);

        while (selectedCard == null || !currentPlayer.hasCard(selectedCard)) {
            System.out.println("Invalid selection. Try again.");
            System.out.print("Choose a card to play: ");
            selectedRank = scanner.next();
            selectedCard = findCardByRank(currentPlayer, selectedRank);
        }

        currentPlayer.playCard(selectedCard);
        table.addToTable(selectedCard);

        // Гравець бере нову карту після кожного ходу
        if (deck.size() > 0) {
            currentPlayer.addToHand(deck.drawCard());
        }
    }

    private Card findCardByRank(Player player, String rank) {
        for (Card card : player.getHand()) {
            if (card.getRank().equalsIgnoreCase(rank)) {
                return card;
            }
        }
        return null;
    }

    private boolean isGameEnd() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return deck.size() == 0;
    }

    private void printWinner() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                System.out.println(player.getName() + " wins!");
            }
        }
    }
}