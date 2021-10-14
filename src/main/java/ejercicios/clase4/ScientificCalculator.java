package ejercicios.clase4;

import static jdk.nashorn.internal.objects.Global.Infinity;

// 1. Separar redondeo en una clase/objeto aparte Rounder. Pasar por constructor. STRATEGY

// 2. Convertir cada clase de redondeo a un singleton. SINGLETON

// 3. El cliente quiere seguir utilizando el constructor de la calculadora parametrizando un int,
// no quiere adaptarse a la lógica nueva del objeto Rounder.
// ¿Se puede incorporar el patrón factory method para permitir esta retrocompatibilidad?

// 4. El cliente quiere tener la posibilidad de contar con los tres tipos de redondeo para cada cálculo que quiera realizar.
// Es decir, al elegir dos numeros quiere poder construir rápidamente todas las variantes de la calculadora,
// sin tener que estar cargando de nuevo los números. ¿Se puede resolver con el patrón Builder?
//
// Iterar sobre las calculadoras construidas comparando el resultado de todas sus operaciones. BUILDER


public class ScientificCalculator extends Calculator {
    private final Rounder rounder;

    public ScientificCalculator(double num1, double num2) {
        super(num1, num2);

        this.rounder = fromRoundingMode(1);
    }

    public ScientificCalculator(double num1, double num2, int roundingMode) {
        super(num1, num2);

        this.rounder = fromRoundingMode(roundingMode);
    }

    public ScientificCalculator(double num1, double num2, Rounder rounder) {
        super(num1, num2);

        this.rounder = rounder;
    }


    @Override
    public double sum() {
        return round(super.sum());
    }

    @Override
    public double subtract() {
        return round(super.subtract());
    }

    @Override
    public double multiply() {
        return round(super.multiply());
    }

    @Override
    public double divide() {
        try {
            return round(super.divide());
        } catch (CalculatorException e) {
            return Infinity;
        }
    }


    public double power() {
        return round(Math.pow(num1, num2));
    }

    public double root() {
        if (num1 < 0) {
            return 0;
        } else {
            return round(Math.pow(num1, 1.0 / num2));
        }
    }

    private double round(double result) {
        return this.rounder.round(result);
    }

    public static Rounder fromRoundingMode(int roundingMode) {
        switch (roundingMode) {
            case 1:
                return UpRounder.getInstance();
            case 2:
                return DownRounder.getInstance();
            case 3:
                return HalfUpRounder.getInstance();
        }

        throw new RuntimeException("Invalid value for roundingMode");
    }

    public static class Builder {
        private double num1;
        private double num2;
        private Rounder rounder;

        public ScientificCalculator build() {
            return new ScientificCalculator(num1, num2, rounder);
        }

        public Builder withNum1(double num1) {
            this.num1 = num1;

            return this;
        }

        public Builder withNum2(double num2) {
            this.num2 = num2;

            return this;
        }

        public Builder withRounder(Rounder rounder) {
            this.rounder = rounder;

            return this;
        }
    }
}
