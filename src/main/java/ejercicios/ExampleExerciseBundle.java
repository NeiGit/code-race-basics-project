package ejercicios;

import menu.Menu;

import static util.IOUtil.*;

public class ExampleExerciseBundle {

    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios de ejemplo", mainMenu);

        exercises.addItem("Ejercicio 1 - ingresar edad", ExampleExerciseBundle::exercise1);
        exercises.addItem("Ejercicio 2 - ingresar nombre", ExampleExerciseBundle::exercise2);
    }

    private static void exercise1() {
        final int age = intInput("Ingrese su edad");
        exercise1(age);
    }

    public static void exercise1(int age) {
        print("Tiene " + age + " años");
    }

    private static void exercise2() {
        final String name = stringInput("Ingrese su nombre");
        exercise2(name);
    }

    public static void exercise2(String name) {
        print("Su nombre es " + name);
    }

}
