import ejercicios.Class1Exercises;
import ejercicios.Class2Exercises;
import ejercicios.ExampleExerciseBundle;
import menu.Menu;

public class Main {

    public static void main(String[] args) {
        final Menu mainMenu = new Menu("Ejercicios");

        ExampleExerciseBundle.subscribeToMenu(mainMenu);
        Class1Exercises.subscribeToMenu(mainMenu);
        Class2Exercises.subscribeToMenu(mainMenu);

        mainMenu.execute();
    }
}
