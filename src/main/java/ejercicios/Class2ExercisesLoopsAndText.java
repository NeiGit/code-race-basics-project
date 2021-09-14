package ejercicios;

import menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.IOUtil.*;
import static util.NumberUtil.isEven;
import static util.NumberUtil.sortIntegerListAscending;

public class Class2ExercisesLoopsAndText {
    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios de ciclos / texto clase 2", mainMenu);

        exercises.addDelayedItem("Ejercicio 1", Class2ExercisesLoopsAndText::exercise1);
        exercises.addDelayedItem("Ejercicio 2", Class2ExercisesLoopsAndText::exercise2);
        exercises.addDelayedItem("Ejercicio 3", Class2ExercisesLoopsAndText::exercise3);
        exercises.addDelayedItem("Ejercicio 4", Class2ExercisesLoopsAndText::exercise4);
        exercises.addDelayedItem("Ejercicio 5", Class2ExercisesLoopsAndText::exercise5);
        exercises.addDelayedItem("Ejercicio 6", Class2ExercisesLoopsAndText::exercise6);
        exercises.addDelayedItem("Ejercicio 7", Class2ExercisesLoopsAndText::exercise7);
        exercises.addDelayedItem("Ejercicio 8", Class2ExercisesLoopsAndText::exercise8);
        exercises.addDelayedItem("Ejercicio 9", Class2ExercisesLoopsAndText::exercise9);
        exercises.addDelayedItem("Ejercicio 10", Class2ExercisesLoopsAndText::exercise10);
        exercises.addDelayedItem("Ejercicio 11", Class2ExercisesLoopsAndText::exercise11);
        exercises.addDelayedItem("Ejercicio 12", Class2ExercisesLoopsAndText::exercise12);
        exercises.addDelayedItem("Ejercicio 13", Class2ExercisesLoopsAndText::exercise13);
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

/*    8- Ingresar un texto. Devolver un texto conteniendo las vocales primero y luego las consonantes.
    Eliminar los espacios.*/
    public static void exercise8() {
        final String text = stringInput("Ingrese un texto");

        final String textWithoutSpaces = text.replace(" ", "");

        String vocals = "";
        String consonants = "";
        for (char c : textWithoutSpaces.toCharArray()) {
            if (isConsonant(c)) { // todo refactor isVocals & isConsonant
                consonants += c;
            } else if (isVocal(c)) {
                vocals += c;
            }
        }

        print(vocals + consonants);
    }

    // 9- Ingresar números hasta que la suma de todos supere 100.
    public static void exercise9() {
        int sum = 0;

        while(sum <= 100) {
            sum += intInput("Ingrese un número entero");
            print(sum);
        }
    }

    // 10- Ingresar un número n. Ingresar n cantidad de caracteres. Mostrar la concatenación.
    public static void exercise10() {
        final int num = intInput("Ingrese un número entero");

        String result = "";
        for(int i = 0; i < num; i ++) {
            String c = "";
            while(c.length() != 1) {
                c = stringInput("Ingrese un caracter");
            }

            result += c;
        }

        print(result);
    }

/*    11- Ingresar un número entero de 6 cifras.
    Mostrar la secuencia de números ordenada de forma ascendente. Utilizar tipo de dato double.
    Ej.: entrada = 874396, salida = 346789*/
    public static void exercise11() {
        final int num = intInput("Ingrese un número entero de 6 cifras", i -> String.valueOf(i).length() == 6); // todo validation Predicate, functional interface

        final List<String> digitStringList = new ArrayList<>(Arrays.asList(String.valueOf(num).split("")));

        final List<Integer> digits = new ArrayList<>(); //todo map!
        for (String digitString : digitStringList) {
            digits.add(Integer.parseInt(digitString));
        }

        final List<Integer> digitsSortedAsc = sortIntegerListAscending(digits);

        String digitsSortedAscJoined = "";
        for (Integer digitSortedAsc : digitsSortedAsc) { //todo map!
            digitsSortedAscJoined += digitSortedAsc;
        }

        print(digitsSortedAscJoined);
    }

    // 12- Idem 11- indicando primero la cantidad de cifras a ingresar. Mínimo 2 cifras Máximo 8
    // ¿Se puede reutilizar la solución del ej 11?
    public static void exercise12() { // todo es igual al 11!!!
        final int size = intInput("Ingrese un número entero de 6 cifras", i -> i >= 2 && i <= 8);
        final int num = intInput("Ingrese un número entero de " + size + " cifras", i -> String.valueOf(i).length() == size);

        final List<String> digitStringList = new ArrayList<>(Arrays.asList(String.valueOf(num).split(""))); // todo refactor

        final List<Integer> digits = new ArrayList<>(); //todo map!
        for (String digitString : digitStringList) {
            digits.add(Integer.parseInt(digitString));
        }

        final List<Integer> digitsSortedAsc = sortIntegerListAscending(digits);

        String digitsSortedAscJoined = "";
        for (Integer digitSortedAsc : digitsSortedAsc) { //todo map!
            digitsSortedAscJoined += digitSortedAsc;
        }

        print(digitsSortedAscJoined);
    }

/*  13- Ingresar un número entero de 3 cifras. Mostrar los siguientes 3 números de 3 cifras que contengan esas 3 cifras.
    En caso de llegar al máximo, empezar de nuevo.
    Ej.: entrada 312 - salida: 321, 123, 132*/
    public static void exercise13() {
        final int num = intInput("Ingrese un número entero de 3 cifras", i -> String.valueOf(i).length() == 3);

        final List<String> digitStringList = new ArrayList<>(Arrays.asList(String.valueOf(num).split(""))); // todo refactor

        final List<Integer> digits = new ArrayList<>(); //todo map!
        for (String digitString : digitStringList) {
            digits.add(Integer.parseInt(digitString));
        }

        int occurrences = 0;
        List<Integer> lastOccurrenceDigits = new ArrayList<>(digits);

        while(occurrences < 3) {
            List<Integer> nextNumberDigits = new ArrayList<>(lastOccurrenceDigits);

            boolean changed = false;
            int index = 0;

            final List<Integer> integers = sortIntegerListAscending(lastOccurrenceDigits);

            while(!changed && index < nextNumberDigits.size()) {
                final int min = integers.get(index);
                if (min < (lastOccurrenceDigits.get(index))) {
                    nextNumberDigits.add(index, min);
                    nextNumberDigits.remove((Integer) min);
                    changed = true;
                    lastOccurrenceDigits = nextNumberDigits;
                } else {
                    index ++;
                }
            }

            String nextNumber = "";
            for (Integer digitSortedAsc : nextNumberDigits) { //todo map!
                nextNumber += digitSortedAsc;
            }

            print(nextNumber);

            occurrences ++;
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

    private static boolean isVocal(char value) {
        final char[] consonants = new char[] {'a', 'e', 'i', 'o', 'u'};

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
