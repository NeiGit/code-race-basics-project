package ejercicios;

import menu.Menu;

import static util.IOUtil.intInput;
import static util.IOUtil.print;

public class Class1Exercises {

    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios condicionales clase 1", mainMenu);

        exercises.addItem("Ejercicio 1", Class1Exercises::exercise1);
        exercises.addItem("Ejercicio 2", Class1Exercises::exercise2);
        exercises.addItem("Ejercicio 3", Class1Exercises::exercise3);
        exercises.addItem("Ejercicio 4", Class1Exercises::exercise4);
        exercises.addItem("Ejercicio 5", Class1Exercises::exercise5);
    }

    // 1. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    public static void exercise1() {
        int num = intInput("Ingrese un numero entero");

        if (num > 0) {
            print(true);
        }
    }

    // 2. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    // En caso de ser negativo, y sólo si está entre -10 y -20, indicar ‘true’ por pantalla.
    public static void exercise2() {
        int num = intInput("Ingrese un numero entero");

        if (num > 0) {
            print(true);
        } else if (num < -10 && num > -20) {
            print(true);
        }
    }

    // 3. Ingresar un número entero. En caso de ser positivo y mayor que 10 indicar true por pantalla.
    public static void exercise3() {
        int num = intInput("Ingrese un numero entero");

        if (num > 10) {
            print(true);
        }
    }

    // 4. Ingresar dos números, 'a' y 'b'. En caso de que 'a' sea positivo, mostrar 'true' si 'b' es positivo.
    // En caso de que 'a' sea negativo, mostrar 'true' si 'b' es negativo.
    public static void exercise4() {
        int a = intInput("Ingrese un numero entero a");
        int b = intInput("Ingrese un numero entero b");

        if (a > 0) {
            if (b > 0) {
                print(true);
            }
        } else if (b < 0) {
            print(true);
        }
    }

    // 5. Ingresar tres números. Mostrar “true” cada vez que el número ingresado sea par.
    public static void exercise5() {
        int a = intInput("Ingrese un numero entero a");
        if (a % 2 == 0) {
            print("a: " + true);
        }

        int b = intInput("Ingrese un numero entero b");
        if (b % 2 == 0) {
            print("b: " + true);
        }

        int c = intInput("Ingrese un numero entero c");
        if (c % 2 == 0) {
            print("c: " + true);
        }
    }
}
