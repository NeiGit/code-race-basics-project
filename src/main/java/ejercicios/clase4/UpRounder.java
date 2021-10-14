package ejercicios.clase4;

import java.math.BigDecimal;

public class UpRounder implements Rounder {
    private static UpRounder instance;

    private UpRounder() {}

    public static UpRounder getInstance() {
        if (instance == null) {
            instance = new UpRounder();
        }

        return instance;
    }
    
    @Override
    public double round(double result) {
        final BigDecimal bigDecimal = BigDecimal.valueOf(result);

        return bigDecimal.setScale(2, BigDecimal.ROUND_UP).doubleValue();
    }
}

