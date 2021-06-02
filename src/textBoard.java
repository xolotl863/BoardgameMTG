import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class textBoard {


    public static void main(String[] args) {
        ArrayList<Card> filler;
        CardCollection cards = new CardCollection();
        int playerLife = 20, AIlife = 20, atkIndex = -1;
        int greenCounter = 0, whiteCounter = 0, blackCounter = 0, redCounter = 0, blueCounter = 0;
        Scanner scan = new Scanner(System.in);
        boolean game = true, castingPhase = true, actionPhase = true;

        while (game) {
            while (castingPhase) {
                if (!cards.handFull()) {
                    cards.draw();
                }

                System.out.println("Your HP is " + playerLife);
                System.out.println("Your hand is ");
                for (int i = 0; i < cards.hand.size(); i++) {
                    System.out.println("" + cards.hand.get(i).toString());
                }
                System.out.println("AI HP is " + AIlife);
                //System.out.println("AI hand is ");
                //for (int i = 0; i < cards.AIhand.size(); i++) {
                //    System.out.println("" + cards.hand.get(i).toString());
                //}
                System.out.println("Your battlefield is ");
                for (int i = 0; i < cards.PlayerBF.size(); i++) {
                    System.out.println("" + cards.PlayerBF.get(i).toString());
                }
                System.out.println("AI battlefield is ");
                for (int i = 0; i < cards.AIBF.size(); i++) {
                    System.out.println("" + cards.AIBF.get(i).toString());
                }
                System.out.println("\n");
                System.out.println("Swamps:" + cards.getSwamps());
                System.out.println("Plains:" + cards.getPlains());
                System.out.println("Mountains:" + cards.getMountains());
                System.out.println("Islands:" + cards.getIslands());
                System.out.println("Forests:" + cards.getForests());
                System.out.println("which card would you like to play");
                String x = scan.nextLine();
                switch (x.toUpperCase()) {
                    default:
                        System.out.println("invalid");

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
                    case "END PHASE": {
                        castingPhase = false;
                        break;
                    }
                }
            }
            while (actionPhase) {
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
                            break;
                        }
                        case "1": {
                            cards.attack(atkIndex, 1);
                            break;
                        }
                        case "2": {
                            cards.attack(atkIndex, 2);
                            break;
                        }
                        case "3": {
                            cards.attack(atkIndex, 3);
                            break;
                        }
                        case "4": {
                            cards.attack(atkIndex, 4);
                            break;
                        }
                        case "5": {
                            cards.attack(atkIndex, 5);
                            break;
                        }
                        case "6": {
                            cards.attack(atkIndex, 6);
                            break;
                        }
                        case "NO BLOCK": {
                            playerLife -= cards.attackNoDef(atkIndex);
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
}