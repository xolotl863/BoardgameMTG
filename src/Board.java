import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Board extends Application {
    Group root = new Group();
    ArrayList<Card> filler;
    CardCollection cards = new CardCollection();
    private int playerLife = 20, AIlife = 20;
    Scanner scan = new Scanner(System.in);
    int atkIndex = -1, defIndex = 0;
    int AILevel = 0;
    boolean game = true, castingPhase1 = true, actionPhase1 = true, actionPhase2 = true, castingPhase2 = true, attacking = true;

    public void start(Stage primaryStage) {



        Scene scene = new Scene(root, 1920, 1080, Color.rgb(148, 235, 234));
        //scene.setOnMousePressed(this::processMousePressed);
        primaryStage.setScene(scene);
        primaryStage.show();

        //System.out.println("Which level of AI");
        String p = "1";//scan.nextLine();
        switch (p.toUpperCase()) {
            default:{
                System.out.println("invalid");
                break;
            }
            case "2 PLAYER": {
                AILevel = 0;
                break;
            }
            case "1": {
                AILevel = 1;
                break;
            }
            case "2": {
                AILevel = 2;
                break;
            }
            case "3": {
                AILevel = 3;
                break;
            }
        }
        //while (game) {
            if (cards.handFull()) {
                cards.draw();
            }
            if (cards.AIhandFull()) {
                cards.AIdraw();
            }
            updater updater = new updater(root, cards.hand, cards.deck,cards.AIhand, cards.AIdeck, cards.getTotalMana(), cards.AIgetTotalMana(), playerLife, AIlife);

            while (castingPhase1) {
                castingPhase2 = true;
                String x = "end phase";
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
                        castingPhase1 = false;
                        break;
                    }
                }
            }
            while (castingPhase2) {
                actionPhase1 = true;
                if(cards.getAIHand() > 0) {
                    cards.AIcast(cards.AIgetCast(AILevel));
                }
                castingPhase2 = false;
            }
            while (actionPhase1) {
                actionPhase2 = true;
                System.out.println("Player 1, which card would you like to attack with");
                String x = "no attack";
                switch (x.toUpperCase()) {
                    default:
                        System.out.println("invalid");
                        break;

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
                        attacking = false;
                        actionPhase1 = false;
                        break;
                    }
                }
                if (attacking) {
                    if (cards.getAIBFSize() > 0) {
                        cards.attack(atkIndex, cards.AIgetBlock(AILevel));
                    } else
                        System.out.println("No defense possible");
                    AIlife -= cards.attackNoDef(atkIndex);
                    actionPhase1 = false;
                }
            }
            while (actionPhase2) {
                castingPhase1 = true;
                if (cards.getPlayerBF() <= 0 && cards.getAIBFSize() > 0) {
                    playerLife -= cards.AIgetAttackNoDef(AILevel);
                } else if (cards.getAIBFSize() > 0) {
                    cards.AIgetAttack(AILevel);
                } else {
                    System.out.println("No attacks possible");
                    actionPhase2 = false;
                }
            }
            if (atkIndex >= 0) {
                if (cards.AIBF.get(atkIndex).getTrample()) {
                    playerLife -= cards.AIattackTrample(atkIndex, defIndex);
                }
                else if (cards.getAIBFSize() > 0) {
                    cards.AIgetAttack(AILevel);
                } else playerLife -= cards.AIattackNoDef(atkIndex);
            }
            if (playerLife <= 0) {
                game = false;
                Text end = new Text("Player 2 wins");
                end.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 200));
                root.getChildren().add(end);
            } else if (AIlife <= 0) {
                game = false;
                Text end2 = new Text(200, 200, "Player 1 wins");
                end2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 200));
                root.getChildren().add(end2);
            }
        }
    //}


    public static void main(String[] args)
    {
        launch(args);
    }

}
