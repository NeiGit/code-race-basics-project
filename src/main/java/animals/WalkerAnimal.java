package animals;

public abstract class WalkerAnimal extends Animal {
    public WalkerAnimal(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    protected String movement() {
        return "caminando";
    }
}
