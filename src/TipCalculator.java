// Assignment 3, Tip Calculator
// Name:Safal Ghimire
// StudentID: 99164249
// - JavaFX
// Description: Loads the hard-coded FXML file and builds a GUI from the file.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class that loads and displays the Tip Calculator's GUI. A
 * JavaFX app main class inherits from Application.
 * <br><br>
 * Need to add the following functionality:
 * 1) Split the final bill evenly among the party members
 * 2) Calculate the amount owed by each person
 * 3) Display the amount owed by each person
 * 
 * @author ghimirsa
 */
public class TipCalculator extends Application {

    /**
     * Loads the FXML file and generates the scene it. Then displays the GUI
     * created from the scene.
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

        /*
        To display a GUI, you must attach it to a Scene, then attach the
        Scene to the Stage.
        */
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle(" Tip Calculator"); // Displayed in window's title bar
        stage.show(); // Display the stage
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        /*
        The class main method calls class Application static launch method to
        begin executing a JavaFX app.
        */
        launch(args);
    }

}