import java.util.Scanner;

public class DurakGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створюємо менеджер авторизації
        AuthManager authManager = new AuthManager();

        // Реєстрація нового користувача
        System.out.print("Enter a username for registration: ");
        String regUsername = scanner.nextLine();
        System.out.print("Enter a password for registration: ");
        String regPassword = scanner.nextLine();

        if (authManager.registerUser(regUsername, regPassword)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists. Registration failed.");
        }

        // Авторизація існуючого користувача
        System.out.print("Enter your username for login: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter your password for login: ");
        String loginPassword = scanner.nextLine();

        if (authManager.authenticateUser(loginUsername, loginPassword)) {

            System.out.print("Do you want to load a saved game? (yes/no): ");
            String loadOption = scanner.nextLine().toLowerCase();

            if (loadOption.equals("yes")) {
                GameSaveManager saveManager = new GameSaveManager();
                DurakGameController loadedGame = saveManager.loadGame();

                if (loadedGame != null) {

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

                    loadedGame.playGame();
                } else {
                    // Обробка помилки завантаження гри
                }
            } else {
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

            System.out.println("Login successful!");


        } else {
            System.out.println("Invalid username or password. Login failed.");
        }

        scanner.close();

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