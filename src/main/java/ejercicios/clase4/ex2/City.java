package ejercicios.clase4.ex2;

import java.util.List;

public class City {
    private final String name;
    private final List<Person> people;

    public City(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public List<Person> getPeople() {
        return people;
    }
}
