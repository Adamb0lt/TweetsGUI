/***************************************************************************
* Author: Adam Walters
* Date: May 8, 2023
*
* This program creates a GUI through JavaFX that reads out information on Tweets from the MakeTweetsArray class. 
* It keeps the same functionality that would have been in the original MakeTweetsArray in
* terms of what is needed as input and output for within the original MakeTweetsArray.
* The same functionality is carried through.
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
    private Tweets tweets;// for accessing the tweets
    private Label message, blank1; //messages and what will be the blank text
    private TextField indexChoice;//textfield for user to choose index of tweet 
    private TextArea details;//Textarea to display everything about the tweet chosen
    private Button search, clear, exit; //buttons that perfom actions 

    public void start(Stage stage) throws Exception {
        
                
        GridPane root = new GridPane();

        // Set up elements like buttons and labels
        Label choice = new Label("Enter the Index of Tweet:");
        indexChoice = new TextField();
        search = new Button("Search");
        clear = new Button("Clear");
        exit = new Button("Exit");
        details = new TextArea();
        message = new Label("");
        blank1 = new Label("");

        // Add positions to each of the different buttons, labels, etc...
        root.add(choice, 0, 0);
        root.add(indexChoice, 1, 0);
        root.add(search, 2, 0);
        root.add(details, 0, 1, 3, 1);
        root.add(clear, 1, 2);
        root.add(exit, 2, 2);
        root.add(message, 0, 3, 3, 1);
        root.add(blank1, 0, 4, 3, 1);

        // Set up button actions that are based on methods below 
        search.setOnAction(e -> enterChoice());
        clear.setOnAction(e -> clearText());
        exit.setOnAction(e -> Platform.exit());

        // Set up scene and show stage
        Scene scene = new Scene(root, 500, 250);
        stage.setScene(scene);
        stage.setTitle("TweetWindow");
        stage.setResizable(false);
        stage.show();
        
        // Load tweets
        MakeTweetsArray.load();
        

    }

    private void enterChoice() {
    // gives default blank text to any previous messages and details from textfield
    double num1;
    message.setText("");
    details.setText("");
    try {
        num1 = Double.parseDouble(indexChoice.getText()); // user must enter a number. Index used for checking in if and else statements
        int index = (int) num1; // also if they place a decimal, the decimal will be dropped and turned to an integer value
        if (index < 0) {
            message.setText("Please enter a positive integer for the index."); //if index number is not positive
        } else if (index >= MakeTweetsArray.TweetObjects.length) {//if choice of index is greater than or equal to length, then this error message pops up instructing user on what to enter
            message.setText("Index out of bounds. Please enter a valid index from 0 to "
                    + (MakeTweetsArray.TweetObjects.length - 1) + ".");
        } else if (MakeTweetsArray.TweetObjects[index] == null) {// if tweet object is null
            message.setText("No valid tweet found at index " + index);
        } else {// if index number is positive and in range of "length-1", then it outputs the information in textArea
            details.setText(MakeTweetsArray.TweetObjects[index].toString());
        }
    } catch (NumberFormatException e) {//if user doesnt enter a number at all
        message.setText("Please enter a valid number.");
        indexChoice.selectAll();
        indexChoice.requestFocus();
    }
}

    private void clearText() {//clears both the textfield and areafield and places in blanktext
        indexChoice.clear();
        details.clear();
        blank1.setText("");
    }

    public static void main(String[] args) {//for launching GUI
        launch();
    }
} 
