package animals;

public class Chicken extends WalkerAnimal {
    public Chicken(String name, boolean speaker, int amountOfExpressions) {
        super(name, speaker, amountOfExpressions);
    }

    @Override
    public String expression() {
        return "cocoroco";
    }

    @Override
    protected String movement() {
        return super.movement() + " en dos patas";
    }

}
