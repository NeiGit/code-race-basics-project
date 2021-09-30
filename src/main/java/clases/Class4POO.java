package clases;

import animals.*;

import java.util.ArrayList;
import java.util.List;

import static util.IOUtil.*;

public class Class4POO {
    public static void mainWithObjects() {
        final List<Animal> animals = new ArrayList<>();

        String choice = stringInput("Ingrese tipo de animal: dog | cat | duck | fish | chicken | 0 para terminar", c ->
                c.equals("dog") || c.equals("cat") || c.equals("duck") || c.equals("fish") || c.equals("chicken") || c.equals("0")
        );

        while (!choice.equals("0")) {
            final String name = stringInput("Ingrese un nombre");
            final String stringNameSpeaker = stringInput("Ingrese true o false para determinar si el animal sabe decir su nombre",
                    c -> c.equals("true") || c.equals("false"));
            final boolean speaker = Boolean.parseBoolean(stringNameSpeaker);
            final int amountOfExpressions = intInput("Ingrese cantidad de expresiones", i -> i > 0);

            switch (choice) {
                case "dog":
                    animals.add(new Dog(name, speaker, amountOfExpressions));
                    break;
                case "cat":
                    animals.add(new Cat(name, speaker, amountOfExpressions));
                    break;
                case "duck":
                    animals.add(new Duck(name, speaker, amountOfExpressions));
                    break;
                case "fish":
                    final String fishType = stringInput("Ingrese tipo de pez: dolphin | whale | 0 no especifica",
                            c -> c.equals("dolphin") || c.equals("whale") || c.equals("0"));

                    switch (fishType) {
                        case "0":
                            animals.add(new Fish(name, speaker, amountOfExpressions));
                            break;
                        case "dolphin":
                            animals.add(new FishDolphin(name, speaker, amountOfExpressions));
                            break;
                        case "whale":
                            animals.add(new FishWhale(name, speaker, amountOfExpressions));
                            break;
                    }
                    break;
                case "chicken":
                    animals.add(new Chicken(name, speaker, amountOfExpressions));
                    break;
            }

            choice = stringInput("Ingrese tipo de animal: dog | cat | duck | fish | chicken | 0 para terminar", c ->
                    c.equals("dog") || c.equals("cat") || c.equals("duck") || c.equals("fish") || c.equals("chicken") || c.equals("0")
            );
        }

        animals.forEach(Animal::express);
    }
}
