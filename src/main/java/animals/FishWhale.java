package animals;

public class FishWhale extends Fish {
    public FishWhale(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    protected String expression() {
        return "glup glop";
    }
}
