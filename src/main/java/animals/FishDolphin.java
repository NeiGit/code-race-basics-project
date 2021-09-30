package animals;

public class FishDolphin extends Fish {
    public FishDolphin(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    protected String movement() {
        return "nadando con estilo";
    }
}
