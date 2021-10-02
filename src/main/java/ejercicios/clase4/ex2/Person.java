package ejercicios.clase4.ex2;

public class Person {
    private final double temperature;
    private final boolean cough;
    private final int beatsPerTenSeconds;

    public Person(double temperature, boolean cough, int beatsPerTenSeconds) {
        this.temperature = temperature;
        this.cough = cough;
        this.beatsPerTenSeconds = beatsPerTenSeconds;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean hasCough() {
        return cough;
    }

    public int getBeatsPerTenSeconds() {
        return beatsPerTenSeconds;
    }
}
