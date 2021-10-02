package ejercicios.clase4.ex3;

public abstract class Food {
    private final double pricePerKg;
    protected final String name;

    public Food(double pricePerKg, String name) {
        this.pricePerKg = pricePerKg;
        this.name = name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}
