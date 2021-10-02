package ejercicios.clase4.ex2;

public class Quarantine {
    private final City city;
    private final int days;
    private final boolean antiFeverMeds;

    public Quarantine(City city, int days, boolean antiFeverMeds) {
        this.city = city;
        this.days = days;
        this.antiFeverMeds = antiFeverMeds;
    }

    public City getCity() {
        return city;
    }

    public int getDays() {
        return days;
    }

    public boolean isAntiFeverMeds() {
        return antiFeverMeds;
    }
}
