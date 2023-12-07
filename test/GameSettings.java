public class GameSettings {
    private String language;
    private boolean soundEnabled;
    private boolean graphicsEnabled;

    public GameSettings() {
        this.language = "English";  // За замовчуванням встановлено англійську мову
        this.soundEnabled = true;
        this.graphicsEnabled = true;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public boolean isGraphicsEnabled() {
        return graphicsEnabled;
    }

    public void setGraphicsEnabled(boolean graphicsEnabled) {
        this.graphicsEnabled = graphicsEnabled;
    }
}