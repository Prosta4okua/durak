import additional.Difficulty;
import additional.GameRules;
import additional.ProgramSettings;

import java.util.Scanner;

public class DurakGame {
    public static void main(String[] args) {
        ProgramSettings programSettings = setupProgramSettings();

        GameRules gameRules = setupGameRules();

        DurakGameController gameController = new DurakGameController(gameRules);

        for (int i = 0; i < gameRules.getNumberOfBots(); i++) {
            gameController.addPlayer(new Bot("bot " + i, gameRules.getDifficulty()));
        }

        for (int i = 0; i < gameRules.getNumberOfPlayers(); i++) {
            gameController.addPlayer(new Player("Danya"));
        }

        // Роздаємо карти гравцям
        gameController.dealCards();

        // Починаємо гру
        gameController.playGame();
    }

    private static GameRules setupGameRules() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();

        System.out.print("Enter the maximum number of cards in hand: ");
        int maxCardsInHand = scanner.nextInt();

        System.out.print("Enter the number of bots: ");
        int numberOfBots = scanner.nextInt();

        System.out.println("Enter diffuculty: ");
        Difficulty difficulty = Difficulty.EASY;

        return new GameRules(numberOfPlayers, maxCardsInHand, numberOfBots, difficulty);
    }

    private static ProgramSettings setupProgramSettings() {
        Scanner scanner = new Scanner(System.in);
        ProgramSettings programSettings = new ProgramSettings();

        System.out.print("Enter language preference: ");
        String language = scanner.nextLine();
        programSettings.getGameSettings().setLanguage(language);

        System.out.print("Enable sound? (true/false): ");
        boolean soundEnabled = scanner.nextBoolean();
        programSettings.getGameSettings().setSoundEnabled(soundEnabled);

        System.out.print("Enable graphics? (true/false): ");
        boolean graphicsEnabled = scanner.nextBoolean();
        programSettings.getGameSettings().setGraphicsEnabled(graphicsEnabled);

        return programSettings;
    }
}