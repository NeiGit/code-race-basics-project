package ejercicios.clase4.ex2;

import menu.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analysis {
    private static final double FEVER_THRESHOLD = 37;
    private static final int UP_BEATS_THRESHOLD = 80;
    private static final int SYMPTOMS_THRESHOLD = 2;
    public static final int FIFTY_PERCENT = 50;
    public static final int FULL_QUARANTINE = 30;
    public static final int PARTIAL_QUARANTINE = 15;
    public static final int EIGHTY_PERCENT = 80;

    public static boolean hasCodeVid(Person person) {
        final List<Function<Person, Boolean>> tests = new ArrayList<>();
        tests.add(Analysis::hasFever);
        tests.add(Analysis::hasCough);
        tests.add(Analysis::hasUpBeats);

        int amountOfSymptoms = 0;
        int amountOfTests = tests.size();
        int testIndex = 0;

        while (amountOfSymptoms < SYMPTOMS_THRESHOLD && testIndex < amountOfTests) {
            if (tests.get(testIndex).apply(person)) {
                amountOfSymptoms ++;
            }

            testIndex ++;
        }

        return amountOfSymptoms >= SYMPTOMS_THRESHOLD;
    }

    public static Quarantine checkForQuarantine(City city) {
        final Quarantine quarantine;

        final List<Person> people = city.getPeople();
        final List<Person> contagious = people.stream().filter(Analysis::hasCodeVid).collect(Collectors.toList());

        final int totalPeople = people.size();

        final double percentageOfContagious =
                Calculator.calculate(contagious.size(), totalPeople, Calculator.CalculatorOperation.PERCENTAGE);

        if (percentageOfContagious >= FIFTY_PERCENT) {
            final boolean majorityWithFever = hasMajorityWithFever(contagious);
            final int days = percentageOfContagious > EIGHTY_PERCENT ? FULL_QUARANTINE : PARTIAL_QUARANTINE;

            quarantine = new Quarantine(city, days, majorityWithFever);

        } else {
            quarantine = null;
        }

        return quarantine;
    }

    private static boolean hasMajorityWithFever(List<Person> contagious) {
        int amountWithFever = 0;

        for (Person person : contagious) {
            if (hasFever(person)) {
                amountWithFever ++;
            }
        }

        final double percentageWithFever =
                Calculator.calculate(amountWithFever, contagious.size(), Calculator.CalculatorOperation.PERCENTAGE);

        return percentageWithFever >= FIFTY_PERCENT;
    }

    private static boolean hasFever(Person person) {
        return person.getTemperature() >= FEVER_THRESHOLD;
    }

    private static boolean hasCough(Person person) {
        return person.hasCough();
    }

    private static boolean hasUpBeats(Person person) {
        final int beatsPerTenSeconds = person.getBeatsPerTenSeconds();
        final int beatsPerMinute = beatsPerTenSeconds * 6;

        return beatsPerMinute >= UP_BEATS_THRESHOLD;
    }
}
