package ejercicios;

import menu.Menu;

import static util.IOUtil.*;
import static util.NumberUtil.isEven;

public class Class2Exercises {
    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios de ciclos / texto clase 2", mainMenu);

        exercises.addItem("Ejercicio 1", Class2Exercises::exercise1);
        exercises.addItem("Ejercicio 2", Class2Exercises::exercise2);
        exercises.addItem("Ejercicio 3", Class2Exercises::exercise3);
        exercises.addItem("Ejercicio 4", Class2Exercises::exercise4);
        exercises.addItem("Ejercicio 5", Class2Exercises::exercise5);
        exercises.addItem("Ejercicio 6", Class2Exercises::exercise6);
        exercises.addItem("Ejercicio 7", Class2Exercises::exercise7);
    }

    /*1- Ingresar un número. Mostrar todos los números hasta llegar a su opuesto.*/
    public static void exercise1() {
        final int num = intInput("Ingrese un número entero");
        final int oppositeNum = num * -1;

        final int step = num < 0 ? 1 : -1;

        int numToPrint = num;

        while(numToPrint != oppositeNum + step) {
            print(numToPrint);
            numToPrint += step;
        }
    }

    /*2- Ingresar un número. Mostrar todos los múltiplos de 2 anteriores a ese número.*/
    public static void exercise2() {
        final int num = intInput("Ingrese un número entero");

        if (num < 0) {
            print("El número ingresado es negativo");
        } else {
            for (int i = 2; i <= num; i += 2) {
                print(i);
            }
        }
    }

    // 3- Ingresar números, 0 para terminar. Indicar si el número ingresado es par.
    public static void exercise3() {
        final String promptMessage = "Ingrese un número entero. 0 para terminar";

        int num = intInput(promptMessage);

        while(num != 0) {
            if (num % 2 == 0) {
                print(true);
            }

            num = intInput(promptMessage);
        }
    }

/*    4- Ingresar números, 0 para terminar. Si el número es par, ingresar otro número e indicar si la
    suma de ambos es par (IOUtil.print(true)). Si la suma es impar, o el primer número lo es,
    indicar que es impar (IOUtil.print(false)).*/
    public static void exercise4() {
        final String promptMessage = "Ingrese un número entero. 0 para terminar";

        int num1 = intInput(promptMessage);

        while(num1 != 0) {
            print(isEven(num1) && isEven(intInput(promptMessage)));

            num1 = intInput(promptMessage);
        }
    }

    // 5- Ingresar un texto. Mostrar la secuencia de caracteres de forma inversa.
    public static void exercise5() {
        final String text = stringInput("Ingrese un texto");

        final char[] charArray = text.toCharArray();

        String result = "";

        for (int i = charArray.length - 1; i >= 0; i--) {
            result += charArray[i];
        }

        print(result);
    }

    // 6- Ingresar un texto. Mostrar sólo las consonantes en mayúscula.
    public static void exercise6() {
        final String text = stringInput("Ingrese un texto").toUpperCase();

        final char[] charArray = text.toCharArray();

        String result = "";

        for (char c : charArray) {
            if (isConsonant(c)) {
                result += c;
            }
        }

        print(result);
    }

    // 7- Ingresar un texto y una letra.
    // Mostrar la cantidad de ocurrencias de esa letra ignorando mayúsculas/minúsculas.
    public static void exercise7() {
        final String text = stringInput("Ingrese un texto").toLowerCase();
        final String character = stringInput("Ingrese una letra").toLowerCase();

        if (character.length() != 1) {
            print("Ingreso inválido");
        } else {
            final int originalLength = text.length();
            final int lengthWithoutCharacter = text.replace(character, "").length();

            final int occurrencesOfCharacter = originalLength - lengthWithoutCharacter;

            print(occurrencesOfCharacter);
        }
    }

    private static boolean isConsonant(char value) {
        final char[] consonants = new char[] {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        final String charToLowerCase = String.valueOf(value).toLowerCase();

        final char c = charToLowerCase.toCharArray()[0];

        boolean isConsonant = false;
        int index = 0;

        while(!isConsonant && index < consonants.length) {
            isConsonant = c == consonants[index];
            index ++;
        }

        return isConsonant;
    }

}
