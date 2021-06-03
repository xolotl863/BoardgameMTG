import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    boolean game = true, castingPhase = true, actionPhase = true;
    int atkIndex = -1;


    public void start(Stage primaryStage) {


        updater updater = new updater(root, filler, playerLife, AIlife);

        Scene scene = new Scene(root, 1920, 1080, Color.rgb(148, 235, 234));
        //scene.setOnMousePressed(this::processMousePressed);
        primaryStage.setScene(scene);
        primaryStage.show();
        while (game) {
            if (cards.handFull()) {
                cards.draw();
            }
            while (castingPhase) {
                actionPhase = true;

                String x = scan.nextLine();
                switch (x.toUpperCase()) {
                    default: {
                        System.out.println("invalid");
                        break;
                    }
                    case "0": {
                        cards.cast(0);
                        break;
                    }
                    case "1": {
                        cards.cast(1);
                        break;
                    }
                    case "2": {
                        cards.cast(2);
                        break;
                    }
                    case "3": {
                        cards.cast(3);
                        break;
                    }
                    case "4": {
                        cards.cast(4);
                        break;
                    }
                    case "5": {
                        cards.cast(5);
                        break;
                    }
                    case "6": {
                        cards.cast(6);
                        break;
                    }
                    case "REDRAW": {
                        cards.hand.clear();
                        cards.draw();
                        break;
                    }
                    case "END PHASE": {
                        castingPhase = false;
                        break;
                    }
                }
            }
            while (actionPhase) {
                castingPhase = true;
                System.out.println("Player 1, which card would you like to attack with");
                String x = scan.nextLine();
                switch (x.toUpperCase()) {
                    default:
                        System.out.println("invalid");

                    case "1": {
                        atkIndex = 0;
                        break;
                    }
                    case "2": {
                        atkIndex = 1;
                        break;
                    }
                    case "3": {
                        atkIndex = 2;
                        break;
                    }
                    case "4": {
                        atkIndex = 3;
                        break;
                    }
                    case "5": {
                        atkIndex = 4;
                        break;
                    }
                    case "6": {
                        atkIndex = 5;
                        break;
                    }
                    case "7": {
                        atkIndex = 6;
                        break;
                    }
                    case "8": {
                        atkIndex = 7;
                        break;
                    }
                    case "9": {
                        atkIndex = 8;
                        break;
                    }
                    case "10": {
                        atkIndex = 9;
                        break;
                    }
                    case "NO ATTACK": {
                        actionPhase = false;
                        break;
                    }
                }
                if(atkIndex >= 0) {
                    System.out.println("Player 2, which card would you like to block with");
                    String y = scan.nextLine();
                    switch (y.toUpperCase()) {
                        default:
                            System.out.println("invalid");

                        case "0": {
                            cards.attack(atkIndex, 0);
                            actionPhase = false;
                            break;
                        }
                        case "1": {
                            cards.attack(atkIndex, 1);
                            actionPhase = false;
                            break;
                        }
                        case "2": {
                            cards.attack(atkIndex, 2);
                            actionPhase = false;
                            break;
                        }
                        case "3": {
                            cards.attack(atkIndex, 3);
                            actionPhase = false;
                            break;
                        }
                        case "4": {
                            cards.attack(atkIndex, 4);
                            actionPhase = false;
                            break;
                        }
                        case "5": {
                            cards.attack(atkIndex, 5);
                            actionPhase = false;
                            break;
                        }
                        case "6": {
                            cards.attack(atkIndex, 6);
                            actionPhase = false;
                            break;
                        }
                        case "NO BLOCK": {
                            AIlife -= cards.attackNoDef(atkIndex);
                            actionPhase = false;
                            break;
                        }
                    }
                    if (playerLife <= 0) {
                        game = false;
                        System.out.println("Player 2 wins");
                    } else if (AIlife <= 0) {
                        game = false;
                        System.out.println("Player 1 wins");
                    }
                }
            }
        }
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}