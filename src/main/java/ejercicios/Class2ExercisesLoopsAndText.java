package ejercicios;

import menu.Calculator;
import menu.Menu;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static util.IOUtil.*;
import static util.NumberUtil.*;

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

        exercises.addDelayedItem("Ejercicio 15", Class2ExercisesLoopsAndText::exercise15);
        exercises.addDelayedItem("Ejercicio 16", Class2ExercisesLoopsAndText::exercise16);

        exercises.addDelayedItem("Ejercicio 17", Class2ExercisesLoopsAndText::exercise17);
        exercises.addDelayedItem("Ejercicio 18", Class2ExercisesLoopsAndText::exercise18);
        exercises.addDelayedItem("Ejercicio 19", Class2ExercisesLoopsAndText::exercise19);
        exercises.addDelayedItem("Ejercicio 20", Class2ExercisesLoopsAndText::exercise20);
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
        final int num = intInput("Ingrese un número entero", i -> i > 0);

        for (int i = 2; i <= num; i += 2) {
            print(i);
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
        final String character = stringInput("Ingrese una letra", s -> s.length() == 1).toLowerCase();

        final int originalLength = text.length();
        final int lengthWithoutCharacter = text.replace(character, "").length();

        final int occurrencesOfCharacter = originalLength - lengthWithoutCharacter;

        print(occurrencesOfCharacter);
    }

/*    8- Ingresar un texto. Devolver un texto conteniendo las vocales primero y luego las consonantes.
    Eliminar los espacios.*/
    public static void exercise8() {
        final String text = stringInput("Ingrese un texto");

        final String textWithoutSpaces = text.replace(" ", "");

        String vocals = "";
        String consonants = "";
        for (char c : textWithoutSpaces.toCharArray()) {
            if (isConsonant(c)) {
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
            result += stringInput("Ingrese un caracter", s -> s.length() == 1);
        }

        print(result);
    }

/*    11- Ingresar un número entero de 6 cifras.
    Mostrar la secuencia de números ordenada de forma ascendente. Utilizar tipo de dato double.
    Ej.: entrada = 874396, salida = 346789*/
    public static void exercise11() {
        inputAndSortNumbersAscending(6);
    }

    // 12- Idem 11- indicando primero la cantidad de cifras a ingresar. Mínimo 2 cifras Máximo 8
    // ¿Se puede reutilizar la solución del ej 11?
    public static void exercise12() {
        final int digits = intInput("Ingrese un número entero entre 2 y 8", i -> i >= 2 && i <= 8);

        inputAndSortNumbersAscending(digits);
    }

    public static void inputAndSortNumbersAscending(int digits) {
        final long num = intInput(String.format("Ingrese un número entero de %s cifras", digits), i -> String.valueOf(i).length() == digits);

        print(sortLongDigitsAscending(num));
    }

/*  13- Ingresar un número entero de 3 cifras. Mostrar los siguientes 3 números de 3 cifras que contengan esas 3 cifras.
    En caso de llegar al máximo, empezar de nuevo.
    Ej.: entrada 312 - salida: 321, 123, 132*/
    public static void exercise13() {
        final int num = intInput("Ingrese un número entero de 3 cifras", i -> String.valueOf(i).length() == 3);

        final List<Integer> digitList = Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final List<Integer> nextOccurrenceCandidateDigits = new ArrayList<>(digitList);

        final List<Integer> occurrences = new ArrayList<>();
        int lastOccurrence;

        // check if is the greatest by sorting desc
        final List<Integer> digitsListSortedDescending = sortIntegerListDescending(digitList);
        final int greatestOccurrence = getIntFromIntegerList(digitsListSortedDescending);

        // check if is the smallest by sorting asc
        final List<Integer> digitsListSortedAscending = sortIntegerListAscending(digitList);
        final int smallestOccurrence = getIntFromIntegerList(digitsListSortedAscending);

        final int lastIndex = nextOccurrenceCandidateDigits.size() - 1;

        while (occurrences.size() < 3) {
            final int nextOccurrenceCandidate = getIntFromIntegerList(nextOccurrenceCandidateDigits);
            if (nextOccurrenceCandidate == greatestOccurrence) {
                lastOccurrence = greatestOccurrence;
                occurrences.add(lastOccurrence);
            } else if (nextOccurrenceCandidate == smallestOccurrence) {
                // swap last two digits. For example, 1234 -> 1243.

                final int lastDigit = nextOccurrenceCandidateDigits.get(lastIndex);
                final int preLastDigit = nextOccurrenceCandidateDigits.get(lastIndex - 1);

                nextOccurrenceCandidateDigits.remove(lastIndex);
                nextOccurrenceCandidateDigits.add(lastIndex, preLastDigit);

                nextOccurrenceCandidateDigits.remove(lastIndex - 1);
                nextOccurrenceCandidateDigits.add(lastIndex - 1, lastDigit);

                lastOccurrence = getIntFromIntegerList(nextOccurrenceCandidateDigits);

            } else {
                Integer smallerFromEnd = null;
                int smallerFromEndIndex = lastIndex;
                while (smallerFromEnd == null && smallerFromEndIndex >= 1) {
                    final int firstFromRight = nextOccurrenceCandidateDigits.get(smallerFromEndIndex);
                    final int secondFromRight = nextOccurrenceCandidateDigits.get(smallerFromEndIndex - 1);

                    if (secondFromRight < firstFromRight) {
                        smallerFromEnd = secondFromRight;
                    }

                    smallerFromEndIndex --;
                }

                final List<Integer> intsRightToSmallerFromEnd = nextOccurrenceCandidateDigits.subList(smallerFromEndIndex + 1, lastIndex + 1);
                int minIntRightToSmallerFromEnd = Integer.MAX_VALUE;
                int minIntRightToSmallerFromEndIndex = 0; // todo acá tengo que obtener el indice pero de la otra lista

                for (int i = 0; i < intsRightToSmallerFromEnd.size(); i ++) {
                    final int candidate = intsRightToSmallerFromEnd.get(i);
                    if (candidate < minIntRightToSmallerFromEnd) {
                        minIntRightToSmallerFromEnd = candidate;
                        minIntRightToSmallerFromEndIndex = i;
                    }
                }

                nextOccurrenceCandidateDigits.remove(smallerFromEndIndex);
                nextOccurrenceCandidateDigits.add(smallerFromEndIndex, minIntRightToSmallerFromEnd);

                nextOccurrenceCandidateDigits.remove(minIntRightToSmallerFromEndIndex);
                nextOccurrenceCandidateDigits.add(minIntRightToSmallerFromEndIndex, smallerFromEnd);

                final List<Integer> nextCandidateRightSideAscending = new ArrayList<>(
                        sortIntegerListAscending(nextOccurrenceCandidateDigits.subList(smallerFromEndIndex + 1, lastIndex + 1)));

                List<Integer> nextCandidateLeftSide = new ArrayList<>(nextOccurrenceCandidateDigits.subList(0, smallerFromEndIndex));

                nextOccurrenceCandidateDigits.clear();
                nextOccurrenceCandidateDigits.addAll(nextCandidateLeftSide);
                nextOccurrenceCandidateDigits.addAll(nextCandidateRightSideAscending);

                lastOccurrence = getIntFromIntegerList(nextOccurrenceCandidateDigits);
            }

            print(lastOccurrence);
            occurrences.add(lastOccurrence);
        }
    }

    private static int getIntFromIntegerList(List<Integer> integerList) {
        return Integer.parseInt(integerList.stream().map(String::valueOf).collect(Collectors.joining()));
    }

/*    15- Ingresar un número del 1 al 10 y un caracter.
    Imprimir un cuadro de "-" con una escalera descendente formada con ese caracter.
    Por ejemplo
    Entrada: 6 y 'a'
    Salida:
    a-----
    aa----
    aaa---
    aaaa--
    aaaaa-
    aaaaaa*/
    public static void exercise15() {
        buildPicture(((characters, dashes, character) ->
                print(buildNTimesCharacter(characters, character) + buildNTimesCharacter(dashes, "-"))));
    }

    /*    16- Ingresar un número del 1 al 10 y un caracter. Imprimir una pirámide con ese caracter.
    Por ejemplo
    Entrada: 6 y 'a'
    Salida:
    -----aa-----
    ----aaaa----
    ---aaaaaa---
    --aaaaaaaa--
    -aaaaaaaaaa-
    aaaaaaaaaaa
    ¿Se puede reutilizar la solución del ejercicio anterior?
    */
    public static void exercise16() {
        buildPicture((characters, dashes, character) ->
                print(buildNTimesCharacter(dashes, "-")
                    + buildNTimesCharacter(characters, character)
                    + buildNTimesCharacter(characters, character)
                    + buildNTimesCharacter(dashes, "-")));
    }

    public static void buildPicture(TriConsumer consumer) {
        final int steps = intInput("Ingrese un número del 1 al 10", i -> i > 1 && i <= 10);
        final String character = stringInput("Ingrese un caracter", s -> s.length() == 1);

        for (int step = 1; step <= steps; step++) {
            final int dashes = steps - step;
            final int characters = step;

            consumer.consume(characters, dashes, character);
        }
    }

    @FunctionalInterface
    private interface TriConsumer {
        void consume(int characters, int dashes, String character);
    }

    public static String buildNTimesCharacter(int n, String character) {
        String nTimesCharacter = "";

        for (int i = 0; i < n; i++) {
            nTimesCharacter += character;
        }

        return nTimesCharacter;
    }

/*    17- Ingresar un número entero del 1 al 19.
    Randomizar un número entero positivo (tipo de dato long) cuya cantidad de cifras sea el número ingresado.*/
    public static void exercise17() {
        final int digits = intInput("Ingrese un número entero del 1 al 19", i -> i >= 1 && i <= 19);

        final long randomPositiveLong = randomizePositiveLong(digits);

        print(randomPositiveLong);
    }

/*    18- Billetera
    Ingresar un monto inicial de balance (double).
    Ingresar operación: 1 = ingreso, 2 = extracción, 3 = terminar.
    Si se elige ingreso, ingresar un monto y descontarle el 30% de ganancias (redondear a entero). Sumar al balance
    Si se elige extracción, ingresar un monto y descontarlo del balance. No puede bajar de 0.
    Al finalizar mostrar el balance.*/
    public static void exercise18() {
        double balance = doubleInput("Ingrese un balance inicial de billetera");

        WalletOperation walletOperation = WalletOperation.promptChoice();

        while (walletOperation != WalletOperation.END) {
            if (walletOperation == WalletOperation.DEPOSIT) {
                final double depositAmount = doubleInput("Ingrese monto a depositar", d -> d > 0);
                final int tax = (int) Calculator.calculate(depositAmount, 30, Calculator.CalculatorOperation.PERCENTAGE);

                balance += (depositAmount - tax);
                print(String.format("Se han depositado exitosamente $%s", depositAmount));

            } else if (walletOperation == WalletOperation.EXTRACTION) {
                final double extractionAmount = doubleInput("Ingrese monto a extraer", d -> d > 0);

                if (extractionAmount <= balance) {
                    balance -= extractionAmount;
                    print(String.format("Se han extraido exitosamente $%s", extractionAmount));
                } else {
                    print("Fondos insuficientes para realizar la extracción");
                }
            }

            print(String.format("Balance: $%s", balance));

            walletOperation = WalletOperation.promptChoice();
        }
    }

    /*19- Movimiento
    Nivel 1. Nos encontramos en una habitación de 4x4 (metros).
    Ingresar un número para avanzar un metro: 1 = adelante, 2 = atrás, 3 = izquierda, 4 = derecha, cualquier otro = terminar.
    Informar cuando se llegue a una pared y no permitir el avance en esa dirección. En cada paso mostrar las coordenadas, empezando siempre en [0-0].
    Nivel 2. Ingresar el metraje del recinto (siempre cubo). Ej.: ingreso 10, la habitación será de 10x10.
    Nivel 3. Rectángulo. Ej.: ingreso 4 y 6, la habitación es de 4x6.*/

    public static void exercise19() {
        final int xMax = intInput("Ingrese largo del recinto en metros", i -> i > 1);
        final int yMax = intInput("Ingrese ancho del recinto en metros", i -> i > 1);

        executeExercise19(xMax, yMax);
    }

    public static void executeExercise19(int xMax, int yMax) {
        int x = 0;
        int y = 0;

        printPositionInRoom(xMax, yMax, x, y);

        Movement movement = Movement.promptChoice();

        while (movement != Movement.END) {
            switch (movement) {
                case FORWARD:
                    if (y < xMax) {
                        y ++;
                    } else {
                        print("Wall reached");
                    }
                    break;
                case BACK:
                    if (y > 0) {
                        y --;
                    } else {
                        print("Wall reached");
                    }
                    break;
                case LEFT:
                    if (x > 0) {
                        x --;
                    } else {
                        print("Wall reached");
                    }
                    break;
                case RIGHT:
                    if (x < yMax) {
                        x ++;
                    } else {
                        print("Wall reached");
                    }
                    break;
            }

            printPositionInRoom(xMax, yMax, x, y);

            movement = Movement.promptChoice();
        }
    }

    private static void printPositionInRoom(int xMax, int yMax, int x, int y) {
        final String BLANK = " ";
        final String emptyPosition = "X" + BLANK;
        final String playerPosition = "O" + BLANK;
        for (int i = yMax; i >= 0; i --) {
            if (i != y) {
                print(buildNTimesCharacter(xMax, emptyPosition));
            } else {
                String lineWithPosition = "";

                lineWithPosition += buildNTimesCharacter(x, emptyPosition);
                lineWithPosition += playerPosition;
                lineWithPosition += buildNTimesCharacter(xMax - x - 1, emptyPosition);

                print(lineWithPosition);
            }
        }
    }

    /*
    20- Juego: ordenar secuencias de números
    Se trata de un juego de 19 niveles.
    Termina cuando el usuario ingresa 'exit' o cuando resuelve el último nivel.
    En el primer nivel se randomiza un número entero de 3 cifras positivo y se le pide al usuario que ingrese la secuencia en orden ascendente.
    Utilizar tipo de dato long.
    Por ejemplo, si el programa muestra "839" el usuario tiene que ingresar "389".
    En cada nivel se suma una cifra al desafío. Cada nivel superado suma el doble de puntos, siendo 100 el puntaje del nivel 1.
    Se puede fallar un máximo de 3 veces, en caso de superar esa cantidad finalizar el juego mostrando “Game over”.
    Mostrar en cada paso el nivel en el que se está, el puntaje ganado del nivel y el puntaje final.
    Al finalizar indicar el puntaje final.

    Extra -> si el usuario gana el juego, ¿puede volver a jugar manteniendo su score?
     */

    public static void exercise20() {
        final BiFunction<Integer, Long, String> promptChoice = (level, challenge) ->
                stringInput(String.format("Nivel %s - Ordene este numero de forma ascendente o 'exit' para terminar: %s", level, challenge));

        final String exit = "exit";

        int level = 1;
        int challengeDigits = 3;
        int levelScore = 100;
        int lives = 3;
        int userScore = 0;

        long challenge = randomizePositiveLong(challengeDigits);

        String userInput = promptChoice.apply(level, challenge);

        while (!userInput.equalsIgnoreCase(exit) && level <= 19 && lives > 0) {
            final String resolvedChallenge = sortLongDigitsAscending(challenge);

            if (userInput.equals(resolvedChallenge)) {
                print(String.format("¡Muy bien! Has ganado %s puntos", levelScore));
                userScore += levelScore;

                print(String.format("Puntaje acumulado: %s puntos", userScore));

                level ++;
                levelScore *= 2;
                challengeDigits ++;
                challenge = randomizePositiveLong(challengeDigits);
            } else {
                lives --;
                print(String.format("¡Mal! Te quedan %s intentos", lives));
            }

            if (lives > 0) {
                userInput = promptChoice.apply(level, challenge);
            }
        }

        if (level > 19) {
            print("¡Felicitaciones, ha ganado el juego!");
        } else if (lives == 0) {
            print("Game over");
        }

        print(String.format("Último nivel ganado: %s - Puntaje final: %s", level - 1 > 0 ? level - 1 : "-", userScore));
    }

    private static String sortLongDigitsAscending(long challenge) {
        final List<Integer> digitList = new ArrayList<>(Arrays.asList(String.valueOf(challenge).split("")))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final List<Integer> integersSorted = sortIntegerListAscending(digitList);

        return integersSorted.stream().map(String::valueOf).collect(Collectors.joining());
    }


    private static long randomizePositiveLong(int digits) {
        final Random random = new Random();
        final long randomLong = random.nextLong();

        final String stringResult = String.valueOf(randomLong)
                .replace("-", "")
                .substring(0, digits);

        return Long.parseLong(stringResult);
    }


    private static boolean isConsonant(char value) {
        final char[] consonants = new char[] {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        return isInArray(value, consonants);
    }

    private static boolean isVocal(char value) {
        final char[] vocals = new char[] {'a', 'e', 'i', 'o', 'u'};

        return isInArray(value, vocals);
    }

    private static boolean isInArray(char value, char[] array) {
        boolean isInArray = false;

        final String charToLowerCase = String.valueOf(value).toLowerCase();

        final char c = charToLowerCase.toCharArray()[0];

        int index = 0;

        while(!isInArray && index < array.length) {
            isInArray = c == array[index];
            index ++;
        }

        return isInArray;
    }

    private enum WalletOperation {
        DEPOSIT, EXTRACTION, END;

        public static WalletOperation promptChoice() {
            return fromChoice(intInput("Ingrese una operación: 1 = ingreso, 2 = extracción, 3 = terminar", i -> i >= 1 && i <= 3));
        }

        public static WalletOperation fromChoice(int choice) {
            switch (choice) {
                case 1:
                    return DEPOSIT;
                case 2:
                    return EXTRACTION;
                case 3:
                    return END;
            }

            return null;
        }
    }

    private enum Movement {
        FORWARD, BACK, LEFT, RIGHT, END;

        public static Movement promptChoice() {
            return fromChoice(intInput("Ingrese un movimiento: 1 = adelante, 2 = atrás, 3 = izquierda, 4 = derecha, cualquier otro = terminar"));
        }

        public static Movement fromChoice(int choice) {
            switch (choice) {
                case 1:
                    return FORWARD;
                case 2:
                    return BACK;
                case 3:
                    return LEFT;
                case 4:
                    return RIGHT;
                default:
                    return END;
            }
        }
    }

}
