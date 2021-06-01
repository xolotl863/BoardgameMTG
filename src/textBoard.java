import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Scanner;

public class textBoard {


    public static void main(String[] args) {
        ArrayList<Card> filler;
        CardCollection cards = new CardCollection();
        int playerLife = 20, AIlife = 20, atkIndex;
        int greenCounter = 0, whiteCounter = 0, blackCounter = 0, redCounter = 0, blueCounter = 0;
        Scanner scan = new Scanner(System.in);
        boolean game = true, castingPhase = true, actionPhase = true;

        while (game) {
            while (castingPhase) {
                //if (!cards.handFull()) {
                //    cards.draw();
                //}
                System.out.println("Your HP is " + playerLife);
                System.out.println("Your hand is ");
                for (int i = 0; i < 7; i++) {
                    System.out.println("" + cards.hand.get(i).getName() + " \t [" + cards.hand.get(i).getStrength() + "/" + cards.hand.get(i).getToughness() + "]");
                }
                System.out.println("AI HP is " + AIlife);
                System.out.println("AI hand is ");
                for (int i = 0; i < 7; i++) {
                    System.out.println("" + cards.hand.get(i).getName() + " \t [" + cards.hand.get(i).getStrength() + "/" + cards.hand.get(i).getToughness() + "]");
                }
                System.out.println("");
                System.out.println("Swamps:" + blackCounter);
                System.out.println("Plains:" + whiteCounter);
                System.out.println("Mountains:" + redCounter);
                System.out.println("Islands:" + blueCounter);
                System.out.println("Forests::" + greenCounter);
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
                    case "FOREST": {
                        greenCounter++;
                        System.out.println("you played a forest. current forest number is: " + greenCounter);
                        break;
                    }
                    case "SWAMP": {
                        blackCounter++;
                        System.out.println("you played a swamp. current swamp number is: " + blackCounter);
                        break;
                    }
                    case "MOUNTAIN": {
                        redCounter++;
                        System.out.println("you played a mountain. current mountain number is: " + redCounter);
                        break;
                    }
                    case "ISLAND": {
                        blueCounter++;
                        System.out.println("you played an island. current island number is: " + blueCounter);
                        break;
                    }
                    case "PLAINS": {
                        whiteCounter++;
                        System.out.println("you played a plains. current plains number is: " + whiteCounter);
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

                    case "0": {
                        atkIndex = 0;
                        break;
                    }
                    case "1": {
                        atkIndex = 1;
                        break;
                    }
                    case "2": {
                        atkIndex = 2;
                        break;
                    }
                    case "3": {
                        atkIndex = 3;
                        break;
                    }
                    case "4": {
                        atkIndex = 4;
                        break;
                    }
                    case "5": {
                        atkIndex = 5;
                        break;
                    }
                    case "6": {
                        atkIndex = 6;
                        break;
                    }
                }
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
                        playerLife-=cards.attackNoDef(atkIndex);
                        break;
                    }
                }
                    if (playerLife <= 0) {
                        game = false;
                        System.out.printf("Player 2 wins");
                    } else if (AIlife <= 0) {
                        game = false;
                        System.out.println("Player 1 wins");
                    }
            }
        }
    }
}