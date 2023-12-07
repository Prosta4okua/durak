public class GameRules {
    private int numberOfPlayers;
    private int numberOfBots;
    private Difficulty difficulty;

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfBots() {
        return numberOfBots;
    }

    public void setNumberOfBots(int numberOfBots) {
        this.numberOfBots = numberOfBots;
    }

    public int getMaxCardsInHand() {
        return maxCardsInHand;
    }

    public void setMaxCardsInHand(int maxCardsInHand) {
        this.maxCardsInHand = maxCardsInHand;
    }

    private int maxCardsInHand;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameRules(int numberOfPlayers, int maxCardsInHand, int numberOfBots, Difficulty difficulty) {
        this.numberOfPlayers = numberOfPlayers;
        this.maxCardsInHand = maxCardsInHand;
        this.numberOfBots = numberOfBots;
        this.difficulty = difficulty;
    }

}
