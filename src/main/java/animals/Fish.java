package animals;

public class Fish extends Animal {

    public Fish(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    protected String expression() {
        return "glup";
    }

    @Override
    protected String movement() {
        return "nadando";
    }
}
