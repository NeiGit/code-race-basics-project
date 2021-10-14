package ejercicios.clase4;

import java.math.BigDecimal;

public class DownRounder implements Rounder {
    private static DownRounder instance;

    private DownRounder() {}

    public static DownRounder getInstance() {
        if (instance == null) {
            instance = new DownRounder();
        }

        return instance;
    }

    @Override
    public double round(double result) {
        final BigDecimal bigDecimal = BigDecimal.valueOf(result);

        return bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
