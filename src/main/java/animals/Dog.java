package animals;

public class Dog extends WalkerAnimal {
    public Dog(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    public String expression() {
        return "guau";
    }

    @Override
    protected String movement() {
        return super.movement() + " en cuatro patas";
    }

}
