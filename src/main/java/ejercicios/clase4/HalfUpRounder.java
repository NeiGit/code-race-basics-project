package ejercicios.clase4;

import java.math.BigDecimal;

public class HalfUpRounder implements Rounder {
    private static HalfUpRounder instance;

    private HalfUpRounder() {}

    public static HalfUpRounder getInstance() {
        if (instance == null) {
            instance = new HalfUpRounder();
        }

        return instance;
    }
    
    @Override
    public double round(double result) {
        final BigDecimal bigDecimal = BigDecimal.valueOf(result);

        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
