package animals;

public class Duck extends Animal {
    public Duck(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    public String expression() {
        return "cuack";
    }

    @Override
    protected String movement() {
        return "volando";
    }

}
