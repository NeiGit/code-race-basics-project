package animals;

public class Cat extends WalkerAnimal {
    public Cat(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    public String expression() {
        return "miau";
    }

    @Override
    protected String movement() {
        return super.movement() + " en cuatro patas";
    }

}
