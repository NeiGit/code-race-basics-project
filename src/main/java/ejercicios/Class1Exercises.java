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
        exercises.addItem("Ejercicio 6", Class1Exercises::exercise6);
        exercises.addItem("Ejercicio 7", Class1Exercises::exercise7);

    }

    // 1. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    public static void exercise1() {
        int num = intInput("Ingrese un numero entero");

        if (num > 0) {
            printTrue();
        }
    }

    // 2. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    // En caso de ser negativo, y sólo si está entre -10 y -20, indicar ‘true’ por pantalla.
    public static void exercise2() {
        int num = intInput("Ingrese un numero entero");

        if (num > 0) {
            printTrue();
        } else if (num < -10 && num > -20) {
            printTrue();
        }
    }

    // 3. Ingresar un número entero. En caso de ser positivo y mayor que 10 indicar true por pantalla.
    public static void exercise3() {
        int num = intInput("Ingrese un numero entero");

        if (num > 10) {
            printTrue();
        }
    }

    // 4. Ingresar dos números, 'a' y 'b'. En caso de que 'a' sea positivo, mostrar 'true' si 'b' es positivo.
    // En caso de que 'a' sea negativo, mostrar 'true' si 'b' es negativo.
    public static void exercise4() {
        int a = intInput("Ingrese un numero entero a");
        int b = intInput("Ingrese un numero entero b");

        if (a > 0) {
            if (b > 0) {
                printTrue();
            }
        } else if (b < 0) {
            printTrue();
        }
    }

    // 5. Ingresar tres números. Mostrar “true” cada vez que el número ingresado sea par.
    public static void exercise5() {
        int a = intInput("Ingrese un numero entero a");
        if (isEven(a)) {
            print("a: " + true);
        }

        int b = intInput("Ingrese un numero entero b");
        if (isEven(b)) {
            print("b: " + true);
        }

        int c = intInput("Ingrese un numero entero c");
        if (isEven(c)) {
            print("c: " + true);
        }
    }

/*    6. Ingresar dos números, 'a' y 'b'. En caso de que ambos sean positivos, para cada uno mostrar 'true' si el resultado
    de sumarle 1 es par. De modo contrario hacer la misma operación pero sólo para 'a'.*/
    public static void exercise6() {
        final int a = intInput("Ingrese un numero entero a");
        final int b = intInput("Ingrese un numero entero b");

        if (a > 0 && b > 0 && isEven(b + 1)) {
            printTrue();
        }

        if (isEven(a + 1)) {
            printTrue();
        }
    }

/*   7. Ingresar tres números 'a', 'b' y 'c'. En caso de que 'a' sea positivo y la suma de 'b' y 'c' sea un número positivo,
    mostrar 'true'. Si esto último no sucede pero la resta entre 'a' y 'b' es negativa, también mostrar 'true'.
    En todos los demás casos indicar por pantalla si la resta de los tres números es igual a 0.*/
    public static void exercise7() {
        final int a = intInput("Ingrese un numero entero a");
        final int b = intInput("Ingrese un numero entero b");
        final int c = intInput("Ingrese un numero entero c");

        if (isPositive(a)) {
            if (isPositive(b + c) || isNegative(a - b)) {
                printTrue();
            }
        }

        if ((a - b - c) == 0) {
            printTrue();
        }
    }

    // ----------- Libraries --------------

    private static boolean isPositive(int num) {
        return num > 0;
    }

    private static boolean isNegative(int num) {
        return num < 0;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static void printTrue() {
        print(true);
    }
}
