/***************************************************************************
 * Author: Adam Walters
 * Date: May 8, 2023
 *
 * This program creates a GUI through JavaFX that reads out information on Tweets
 * from the MakeTweetsArray class. It keeps the same functionality that would
 * have been in the original MakeTweetsArray in terms of what is needed as input
 * and output for within the original MakeTweetsArray. The same functionality is
 * carried through.
 ***************************************************************************/
package TweetsProj;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TweetWindow extends Application {
    private Tweets tweets; // Reference to Tweets class for accessing Tweet information
    private Label message, blank1; // Labels for messages and spacing
    private TextField indexChoice; // Text field for user to input the index of the Tweet
    private TextArea details; // Text area to display Tweet details
    private Button search, clear, exit; // Buttons for performing actions

    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();

        // Set up GUI elements
        Label choice = new Label("Enter the Index of Tweet:");
        indexChoice = new TextField();
        search = new Button("Search");
        clear = new Button("Clear");
        exit = new Button("Exit");
        details = new TextArea();
        message = new Label("");
        blank1 = new Label("");

        // Add elements to the layout grid
        root.add(choice, 0, 0);
        root.add(indexChoice, 1, 0);
        root.add(search, 2, 0);
        root.add(details, 0, 1, 3, 1);
        root.add(clear, 1, 2);
        root.add(exit, 2, 2);
        root.add(message, 0, 3, 3, 1);
        root.add(blank1, 0, 4, 3, 1);

        // Set up button actions based on methods below
        search.setOnAction(e -> enterChoice());
        clear.setOnAction(e -> clearText());
        exit.setOnAction(e -> Platform.exit());

        // Set up the scene and display the stage
        Scene scene = new Scene(root, 500, 250);
        stage.setScene(scene);
        stage.setTitle("TweetWindow");
        stage.setResizable(false);
        stage.show();

        // Load tweets from MakeTweetsArray
        MakeTweetsArray.load();
    }

    private void enterChoice() {
        // Reset any previous messages and clear text from the text field and area
        double num1;
        message.setText("");
        details.setText("");

        try {
            num1 = Double.parseDouble(indexChoice.getText()); // Parse the user's input as a number
            int index = (int) num1; // Convert the number to an integer (drops decimals if present)

            if (index < 0) {
                message.setText("Please enter a positive integer for the index.");
            } else if (index >= MakeTweetsArray.TweetObjects.length) {
                message.setText("Index out of bounds. Please enter a valid index from 0 to "
                        + (MakeTweetsArray.TweetObjects.length - 1) + ".");
            } else if (MakeTweetsArray.TweetObjects[index] == null) {
                message.setText("No valid tweet found at index " + index);
            } else {
                // Display the Tweet information in the text area
                details.setText(MakeTweetsArray.TweetObjects[index].toString());
            }
        } catch (NumberFormatException e) {
            message.setText("Please enter a valid number.");
            indexChoice.selectAll();
            indexChoice.requestFocus();
        }
    }

    private void clearText() {
        // Clear the text field and text area, and reset the blank text label
        indexChoice.clear();
        details.clear();
        blank1.setText("");
    }

    public static void main(String[] args) {
        // Launch the GUI application
        launch();
    }
}
