import java.io.*;

class GameSaveManager {
    private static final String SAVE_FILE_PATH = "game_save.ser";

    public void saveGame(DurakGameController gameController) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_PATH))) {
            outputStream.writeObject(gameController);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    public DurakGameController loadGame() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE_PATH))) {
            DurakGameController loadedGame = (DurakGameController) inputStream.readObject();
            System.out.println("Game loaded successfully.");
            return loadedGame;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game: " + e.getMessage());
        }
        return null;
    }
}