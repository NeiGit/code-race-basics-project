package ejercicios.clase4.ex3;

import java.util.Objects;

public abstract class Fruit extends Food {
    private final FruitState state;

    public Fruit(FruitState state, double pricePerKg, String name) {
        super(pricePerKg, name);

        this.state = state;
    }

    @Override
    public double getPricePerKg() {
        return super.getPricePerKg() * this.state.getPriceMultiplier();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit)) {
            return false;
        }

        final Fruit other = (Fruit) obj;

        return this.name.equals(other.name) && this.state == other.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }
}
