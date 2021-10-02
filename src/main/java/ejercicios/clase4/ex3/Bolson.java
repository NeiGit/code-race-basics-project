package ejercicios.clase4.ex3;

import util.IOUtil;

import java.util.HashMap;
import java.util.Map;

public class Bolson {
    public static final int MAX_CAPACITY_IN_KG = 20;

    private final Map<Food, Double> kgByFood;

    private double finalPrice;

    public Bolson() {
        this.kgByFood = new HashMap<>();
        this.finalPrice = 0;
    }

    public void addFood(Food food, double kg) {
        if (spaceAvailable(kg)) {
            if (kgByFood.containsKey(food)) {
                final double kgs = kgByFood.get(food);

                kgByFood.put(food, kgs + kg);
            } else {
                kgByFood.put(food, kg);
            }

            this.finalPrice += food.getPricePerKg() * kg;
        } else {
            IOUtil.print(String.format("No hay capacidad para almacenar %s kgs", kg));
        }
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    protected Map<Food, Double> getKgByFood() {
        return kgByFood;
    }

    private boolean spaceAvailable(double kg) {
        final double totalKgInBolson = kgByFood.values().stream().reduce(0d, Double::sum);

        return totalKgInBolson + kg <= MAX_CAPACITY_IN_KG;
    }
}
