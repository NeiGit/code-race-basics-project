package ejercicios;

import menu.Menu;

import java.util.*;
import java.util.stream.Collectors;

import static menu.Calculator.CalculatorOperation;
import static menu.Calculator.calculate;
import static util.IOUtil.*;
import static util.NumberUtil.sortIntegerListAscending;
import static util.NumberUtil.sortIntegerListDescending;

public class Class2ExercisesCollections {

    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios de collections clase 2", mainMenu);

        exercises.addDelayedItem("Ejercicio 1", Class2ExercisesCollections::exercise1);
        exercises.addDelayedItem("Ejercicio 2", Class2ExercisesCollections::exercise2);
        exercises.addDelayedItem("Ejercicio 3", Class2ExercisesCollections::exercise3);
        exercises.addDelayedItem("Ejercicio 4", Class2ExercisesCollections::exercise4);
        exercises.addDelayedItem("Ejercicio 5", Class2ExercisesCollections::exercise5);
        exercises.addDelayedItem("Ejercicio 6", Class2ExercisesCollections::exercise6);
        exercises.addDelayedItem("Ejercicio 7", Class2ExercisesCollections::exercise7);
        exercises.addDelayedItem("Ejercicio 8", Class2ExercisesCollections::exercise8);
    }

    // 1 - Cargar dos listas de 5 personas indicando su nombre.
    // Luego armar un mapa de parejas por orden de llegada en cada lista.
    // Imprimir las parejas separadas por '-'.
    public static void exercise1() {
        final List<String> names1 = createListOfNames(5, "Lista 1");
        final List<String> names2 = createListOfNames(5, "Lista 2");

        final Map<String, String> couples = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            couples.put(names1.get(i), names2.get(i));
        }

        for (Map.Entry<String, String> couple : couples.entrySet()) {
            final String partner1 = couple.getKey();
            final String partner2 = couple.getValue();

            print(String.format("%s-%s", partner1, partner2));
        }
    }

    /*    2 - Crear dos listas de 5 números. Imprimir las parejas que se forman con los números en orden
                ascendente para la primera lista, y descendente para la segunda.
        Ejemplo
        Entrada:
        lista 1 -> 5, 34, 1, 309, 20
        lista 2 -> 18, 100, 92, 7, 56
        Salida:
                1-100
                5-92
                20-56
                34-18
                309-7*/
    private static void exercise2() {
        final List<Integer> numbers1 = createListOfNumbers(5, "Lista 1");
        final List<Integer> numbers2 = createListOfNumbers(5, "Lista 2");

        exercise2(numbers1, numbers2);
    }

    public static void exercise2(List<Integer> numbers1, List<Integer> numbers2) {
        final List<Integer> numbers1WithoutNegatives = numbers1
                .stream().filter(number -> number > 0)
                        .collect(Collectors.toList());

        final List<Integer> numbers2WithoutNegatives = new ArrayList<>();
        for (Integer number : numbers2) {
            if (number > 0) {
                numbers2WithoutNegatives.add(number);
            }
        }

        final List<Integer> numbers1Ordered = sortIntegerListAscending(numbers1WithoutNegatives);
        final List<Integer> numbers2Ordered = sortIntegerListDescending(numbers2WithoutNegatives);

        for(int i = 0; i < numbers1Ordered.size(); i ++) {
            print(String.format("%s-%s", numbers1Ordered.get(i), numbers2Ordered.get(i)));
        }
    }

/*    3 - Crear un enum para representar un podio: CHAMPION, SUB_CHAMPION, THIRD_PLACE.
    Ingresar el nombre y el puntaje de tres equipos y armar un mapa con el podio (enum + nombre).*/
    public static void exercise3() {
        final String team1Name = stringInput("Ingrese el nombre del primer equipo");
        final int team1Score = intInput("Ingrese el puntaje del primer equipo");

        final String team2Name = stringInput("Ingrese el nombre del segundo equipo");
        final int team2Score = intInput("Ingrese el puntaje del segundo equipo");

        final String team3Name = stringInput("Ingrese el nombre del tercer equipo");
        final int team3Score = intInput("Ingrese el puntaje del tercer equipo");

        final Map<Integer, String> teamByScore = new HashMap<>();
        teamByScore.put(team1Score, team1Name);
        teamByScore.put(team2Score, team2Name);
        teamByScore.put(team3Score, team3Name);

        if (teamByScore.size() < 3) {
            print("¡Aún no hay un podio definido!");
        } else {
            final List<Integer> unsortedScores = new ArrayList<>();
            unsortedScores.add(team1Score);
            unsortedScores.add(team2Score);
            unsortedScores.add(team3Score);

            final List<Integer> sortedScores = sortIntegerListDescending(unsortedScores);

            final Map<Podium, String> podiumMap = new LinkedHashMap<>();
            podiumMap.put(Podium.CHAMPION, teamByScore.get(sortedScores.get(0)));
            podiumMap.put(Podium.SUB_CHAMPION, teamByScore.get(sortedScores.get(1)));
            podiumMap.put(Podium.THIRD_PLACE, teamByScore.get(sortedScores.get(2)));

            podiumMap.forEach((k, v) -> print(String.format("%s-%s", k, v)));
        }
    }

/*    4 - Sin ingreso de usuario. Armar un mapa con las siguientes ligas de fútbol y sus equipos más importantes
            (mínimo 2, máximo 4): "premier-league", "serie-a", "la-liga", "primera-división".
    Imprimir con el siguiente formato:

    Equipos más representativos de premier-league:
    Manchester City, Manchester Utd, Chelsea, Liverpool*/
    public static void exercise4() {
        final Map<League, List<String>> teamsByLeague = new HashMap<>();

        final List<String> premierLeagueTeams = new ArrayList<>();
        premierLeagueTeams.add("Manchester City");
        premierLeagueTeams.add("Manchester Utd");
        premierLeagueTeams.add("Liverpool");
        teamsByLeague.put(League.PREMIER_LEAGUE, premierLeagueTeams);

        final List<String> serieATeams = new ArrayList<>();
        serieATeams.add("Milan");
        serieATeams.add("Inter");
        serieATeams.add("Juventus");
        teamsByLeague.put(League.SERIE_A, serieATeams);

        final List<String> laLigaTeams = new ArrayList<>();
        laLigaTeams.add("Barcelona");
        laLigaTeams.add("Real Madrid");
        laLigaTeams.add("Atlético Madrid");
        teamsByLeague.put(League.LA_LIGA, laLigaTeams);

        final List<String> primeraDivisionTeams = new ArrayList<>();
        primeraDivisionTeams.add("River");
        primeraDivisionTeams.add("Boca");
        primeraDivisionTeams.add("Racing");
        teamsByLeague.put(League.PRIMERA_DIVISION, primeraDivisionTeams);

        teamsByLeague.forEach((league, teams) -> {
            final String teamsJoined = String.join(", ", teams);

            print("Equipos más representativos de " + league + ":");
            print(teamsJoined);
        });
    }

    // 5 - Resolver ejercicio de colores con Collections y sin usar if. Recomendado: usar Map
    public static void exercise5() {
        final Map<Color, String> redCombinations = new HashMap<>();
        final Map<Color, String> blueCombinations = new HashMap<>();
        final Map<Color, String> yellowCombinations = new HashMap<>();
        final Map<Color, String> orangeCombinations = new HashMap<>();
        final Map<Color, String> purpleCombinations = new HashMap<>();
        final Map<Color, String> greenCombinations = new HashMap<>();

        final String lighter = " lighter";
        final String darker = " darker";

        redCombinations.put(Color.RED, Color.RED.toString());
        redCombinations.put(Color.YELLOW, Color.ORANGE.toString());
        redCombinations.put(Color.BLUE, Color.PURPLE.toString());
        redCombinations.put(Color.ORANGE, Color.ORANGE + lighter);
        redCombinations.put(Color.PURPLE, Color.PURPLE + lighter);

        blueCombinations.put(Color.BLUE, Color.BLUE.toString());
        blueCombinations.put(Color.YELLOW, Color.GREEN.toString());
        blueCombinations.put(Color.RED, Color.PURPLE.toString());
        blueCombinations.put(Color.PURPLE, Color.PURPLE.toString() + darker);
        blueCombinations.put(Color.GREEN, Color.GREEN.toString() + darker);

        yellowCombinations.put(Color.YELLOW, Color.YELLOW.toString());
        redCombinations.put(Color.RED, Color.ORANGE.toString());
        yellowCombinations.put(Color.BLUE, Color.GREEN.toString());
        yellowCombinations.put(Color.ORANGE, Color.ORANGE.toString() + lighter);
        yellowCombinations.put(Color.GREEN, Color.GREEN.toString() + lighter);

        orangeCombinations.put(Color.ORANGE, Color.ORANGE.toString());
        orangeCombinations.put(Color.YELLOW, Color.ORANGE.toString() + lighter);
        orangeCombinations.put(Color.RED, Color.ORANGE.toString() + darker);

        purpleCombinations.put(Color.PURPLE, Color.PURPLE.toString());
        purpleCombinations.put(Color.RED, Color.PURPLE.toString() + lighter);
        purpleCombinations.put(Color.BLUE, Color.PURPLE.toString() + darker);

        greenCombinations.put(Color.GREEN, Color.GREEN.toString());
        greenCombinations.put(Color.YELLOW, Color.GREEN.toString() + lighter);
        greenCombinations.put(Color.BLUE, Color.GREEN.toString() + darker);

        final Map<Color, Map<Color, String>> combinations = new HashMap<>();
        combinations.put(Color.RED, redCombinations);
        combinations.put(Color.BLUE, blueCombinations);
        combinations.put(Color.YELLOW, yellowCombinations);
        combinations.put(Color.ORANGE, orangeCombinations);
        combinations.put(Color.PURPLE, purpleCombinations);
        combinations.put(Color.GREEN, greenCombinations);

        final Color color1 = Color.fromString(stringInput("Ingrese un color").toUpperCase());
        final Color color2 = Color.fromString(stringInput("Ingrese otro color").toUpperCase());

        if (color1 == null || color2 == null) {
            print("Error");
        } else {
            final String combination = combinations.get(color1).get(color2);

            print(combination != null ? combination : Color.BROWN);
        }
    }

    /*6 - Sin ingreso de usuario. Armar e imprimir un mapa con las siete
    escalas/modos que se forman con las notas de la escala mayor de DO:
    JONICO -> "do", "re", "mi", "fa", "sol", "la", "si".
    DORICO -> "re", "mi", "fa", "sol", "la", "si", "do"
    FRIGIO -> "mi", "fa", "sol", "la"....
    LIDIO -> "fa", "sol", "la"...
    MIXOLIDIO -> "sol"...
    EOLICO -> "la" ...
    LOCRIO -> "si" ...
    ¿Es necesario cargar la lista de notas para cada key del mapa?
    ¿Y si se pide hacer lo mismo con las notas de la escala mayor de sol?
        "sol", "la", "si", "do", "re", "mi", "fa#"*/
    public static void exercise6() {
        final Map<Scale, Integer> offsetByScale = new HashMap<>();
        offsetByScale.put(Scale.JONICO, 0);
        offsetByScale.put(Scale.DORICO, 1);
        offsetByScale.put(Scale.FRIGIO, 2);
        offsetByScale.put(Scale.LIDIO, 3);
        offsetByScale.put(Scale.MIXOLIDIO, 4);
        offsetByScale.put(Scale.EOLICO, 5);
        offsetByScale.put(Scale.LOCRIO, 6);

        offsetByScale.forEach((scale, offset) -> {
            String notesJoined = "";
            int loops = 0;
            int index = offset;

            final Notes[] notes = Notes.values();
            final int notesLength = notes.length;

            while(loops < notesLength) {
                if (index == notesLength) {
                    index = 0;
                }

                notesJoined = notesJoined + notes[index];

                if (loops < notesLength - 1) {
                    notesJoined += ", ";
                }

                index ++;
                loops ++;
            }

            print(String.format("%s -> %s", scale, notesJoined));
        });
    }


    /* 7 - Ingresar un número. Mostrar la secuencia de nombres, sin usar if / switch.
    Por ejemplo 123 -> mostrar UNO-DOS-TRES.
    ¿Se puede reutilizar la solución para hacer el camino inverso? Ingresar UNO-DOS-TRES -> mostrar 123 */
    public static void exercise7() {
        // part 1
        Map<Character, Number> numberNamesByValue = new HashMap<>();
        numberNamesByValue.put('1', Number.ONE);
        numberNamesByValue.put('2', Number.TWO);
        numberNamesByValue.put('3', Number.THREE);
        numberNamesByValue.put('4', Number.FOUR);
        numberNamesByValue.put('5', Number.FIVE);
        numberNamesByValue.put('6', Number.SIX);
        numberNamesByValue.put('7', Number.SEVEN);
        numberNamesByValue.put('8', Number.EIGHT);
        numberNamesByValue.put('9', Number.NINE);

        final int num = intInput("Ingrese un número entero");

        final char[] numChars = String.valueOf(num).toCharArray();

        String numNamesJoined = "";
        for (char numChar : numChars) {
            if (!numNamesJoined.isEmpty()) {
                numNamesJoined += "-";
            }

            numNamesJoined += numberNamesByValue.get(numChar);
        }

        print(numNamesJoined);

        // part 2
        final String stringNums = stringInput("Ingrese secuencia de numeros separada por guión");

        final List<Number> listOfNumbers = Arrays.stream(stringNums.split("-"))
                .map(Number::fromString)
                .collect(Collectors.toList());

        final List<String> numCharsJoined = new ArrayList<>();

        listOfNumbers.forEach(number -> {
            Character numChar = null;
            int index = 1;

            while(numChar == null && index <= numberNamesByValue.size()) {
                final char key = Character.forDigit(index, 10);
                final Number n = numberNamesByValue.get(key);
                if (n == number) {
                    numChar = key;
                }

                index ++;
            }

            numCharsJoined.add(String.valueOf(numChar));
        });

        print(String.join("", numCharsJoined));
    }

    /*Para enfermitos….
    8 - Se puede resolver la Calculadora sin usar if para las operaciones?
    Investigar interfaz Runnable () -> o BiConsumer() o BiFunction()*/

    /*    9. Calculadora:
    Ingresar un texto: "sum", "subtract", "multiply", "divide", "percentage".
    Ingresar dos números y mostrar por pantalla el resultado de la operación.
    Mostrar "error" si la operación es inválida o si se divide por 0.*/

    public static void exercise8() {
        final CalculatorOperation operation =
                CalculatorOperation.fromString(stringInput("Ingrese una operación"));

        // validate operation
        if (operation == null) {
            print("error");
            return;
        }

        final double num1 = doubleInput("Ingrese un número");
        final double num2 = doubleInput("Ingrese otro número");

        //validate divide by zero
        if (operation == CalculatorOperation.DIVIDE && num2 == 0) {
            print("error");
            return;
        }

        //validate negative percentage
        if (operation == CalculatorOperation.PERCENTAGE && num2 < 0) {
            print("error");
            return;
        }

        print(calculate(num1, num2, operation));
    }


    private static List<String> createListOfNames(int size, String listName) {
        final List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            listOfNames.add(stringInput(String.format("Ingrese el nombre nº%s para la lista %s", i + 1, listName)));
        }

        return listOfNames;
    }

    private static List<Integer> createListOfNumbers(int size, String listName) {
        final List<Integer> listOfNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            listOfNumbers.add(intInput(String.format("Ingrese el número nº%s para la lista %s", i + 1, listName)));
        }

        return listOfNumbers;
    }

    private enum Podium {
        CHAMPION, SUB_CHAMPION, THIRD_PLACE
    }

    private enum League {
        PREMIER_LEAGUE, SERIE_A, LA_LIGA, PRIMERA_DIVISION
    }

    public enum Color {
        // primaries
        RED, BLUE, YELLOW,

        // secondaries
        ORANGE, PURPLE, GREEN,

        // other
        BROWN;

        public static Color fromString(String value) {
            return Arrays.stream(Color.values())
                    .filter(color -> color.toString().equalsIgnoreCase(value))
                    .findFirst()
                    .orElse(null);
        }
    }

    private enum Notes {
        DO, RE, MI, FA, SOL, LA, SI;
    }

    private enum Scale {
        JONICO, DORICO, FRIGIO, LIDIO, MIXOLIDIO, EOLICO, LOCRIO;
    }

    private enum Number {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

        public static Number fromString(String value) {
            Number number = null;
            int index = 0;

            final Number[] numbers = Number.values();

            while(number == null && index < numbers.length) {
                final Number n = numbers[index];

                if (n.toString().equalsIgnoreCase(value)) {
                    number = n;
                }

                index ++;
            }

            return number;
        }
    }
}
