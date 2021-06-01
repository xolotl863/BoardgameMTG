import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Board extends Application {
    Group root = new Group();
    ArrayList<Card> filler;
    CardCollection cards = new CardCollection();
    private int playerLife = 20, AIlife = 20;
    private int greenCounter = 0, whiteCounter = 0, blackCounter = 0, redCounter = 0, blueCounter = 0;
    Scanner scan = new Scanner(System.in);
    private boolean game = true;


    public int getplayerLife(){
        return playerLife;
    }


    public void start(Stage primaryStage) {


        updater updater = new updater(root, filler, 20, 20, 0);

        Scene scene = new Scene(root, 1920, 1080, Color.rgb(148, 235, 234));
        //scene.setOnMousePressed(this::processMousePressed);
        primaryStage.setScene(scene);
        primaryStage.show();

        if (getplayerLife() <= 0) {
            System.out.println("AI wins");
            System.out.println("Game over");
            game = false;
        } else if (AIlife <= 0) {
            System.out.println("You win");
            System.out.println("Game over");
            game = false;

        }
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}