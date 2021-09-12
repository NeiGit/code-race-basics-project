import ejercicios.Class1Exercises;
import ejercicios.Class2ExercisesCollections;
import ejercicios.Class2ExercisesLoopsAndText;
import ejercicios.ExampleExerciseBundle;
import menu.Menu;

public class Main {

    public static void main(String[] args) {
        final Menu mainMenu = new Menu("Ejercicios");

        ExampleExerciseBundle.subscribeToMenu(mainMenu);

        Class1Exercises.subscribeToMenu(mainMenu);
        Class2ExercisesLoopsAndText.subscribeToMenu(mainMenu);
        Class2ExercisesCollections.subscribeToMenu(mainMenu);

        mainMenu.execute();
    }
}
