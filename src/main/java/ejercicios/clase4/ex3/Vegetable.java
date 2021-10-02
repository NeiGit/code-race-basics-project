package ejercicios.clase4.ex3;

import java.util.Objects;

public abstract class Vegetable extends Food {
    private final VegetableType type;

    public Vegetable(VegetableType type, double pricePerKg, String name) {
        super(pricePerKg, name);

        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vegetable)) {
            return false;
        }

        final Vegetable other = (Vegetable) obj;

        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.name);
    }
}
