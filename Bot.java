import additional.Difficulty;

public class Bot extends Player{
    Difficulty difficulty;
    public Bot(String name, Difficulty difficulty) {
        super(name);

        this.difficulty = difficulty;
    }


}
