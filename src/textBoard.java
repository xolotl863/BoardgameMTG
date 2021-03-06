import java.lang.management.PlatformLoggingMXBean;
import java.util.Locale;
import java.util.Scanner;

public class textBoard {


    public static void main(String[] args) {
        CardCollection cards = new CardCollection();
        int playerLife = 20, AIlife = 20, atkIndex = -1, defIndex = 0;
        Scanner scan = new Scanner(System.in);
        int AILevel = 0;
        boolean game = true, castingPhase1 = true, actionPhase1 = true, actionPhase2 = true, castingPhase2 = true, attacking = true;


        System.out.println("Which level of AI");
        String p = scan.nextLine();
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
        while (game) {
            if (cards.handFull()) {
                cards.draw();
            }
            if (cards.AIhandFull()) {
                cards.AIdraw();
            }
            while (castingPhase1) {
                castingPhase2 = true;
                System.out.println("Your HP is " + playerLife);
                System.out.println("Your hand is ");
                for (int i = 0; i < cards.hand.size(); i++) {
                    System.out.println("" + cards.hand.get(i).toString());
                }
                System.out.println("AI HP is " + AIlife);
                System.out.println("AI hand is ");
                for (int u = 0; u < cards.AIhand.size(); u++) {
                    System.out.println("" + cards.AIhand.get(u).toString());
                }
                System.out.println("Your battlefield is ");
                for (int i = 0; i < cards.PlayerBF.size(); i++) {
                    System.out.println("" + cards.PlayerBF.get(i).toString());
                }
                System.out.println("AI battlefield is ");
                for (int i = 0; i < cards.AIBF.size(); i++) {
                    System.out.println("" + cards.AIBF.get(i).toString());
                }
                System.out.println("\n");
                System.out.println("Mountains:" + cards.getMountains());
                System.out.println("Islands:" + cards.getIslands());
                System.out.println("Forests:" + cards.getForests());
                System.out.println("Swamps:" + cards.getSwamps());
                System.out.println("Plains:" + cards.getPlains());
                System.out.println("which card would you like to play");
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
                        castingPhase1 = false;
                        break;
                    }
                }
            }
            while (castingPhase2) {
                actionPhase1 = true;
                System.out.println("Your HP is " + AIlife);
                System.out.println("Your hand is ");
                for (int i = 0; i < cards.AIhand.size(); i++) {
                    System.out.println("" + cards.AIhand.get(i).toString());
                }
                System.out.println("Player 1 HP is " + playerLife);
                System.out.println("Player 1  hand is ");
                for (int i = 0; i < cards.hand.size(); i++) {
                    System.out.println("" + cards.hand.get(i).toString());
                }
                System.out.println("Your battlefield is ");
                for (int i = 0; i < cards.AIBF.size(); i++) {
                    System.out.println("" + cards.AIBF.get(i).toString());
                }
                System.out.println("Player 1 battlefield is ");
                for (int i = 0; i < cards.PlayerBF.size(); i++) {
                    System.out.println("" + cards.PlayerBF.get(i).toString());
                }
                System.out.println("\n");
                System.out.println("Swamps:" + cards.AIgetSwamps());
                System.out.println("Plains:" + cards.AIgetPlains());
                System.out.println("Mountains:" + cards.AIgetMountains());
                System.out.println("Islands:" + cards.AIgetIslands());
                System.out.println("Forests:" + cards.AIgetForests());
                if(cards.getAIHand() > 0) {
                    cards.AIcast(cards.AIgetCast(AILevel));
                }
                castingPhase2 = false;
            }
        while (actionPhase1) {
            actionPhase2 = true;
            System.out.println("Player 1, which card would you like to attack with");
            String x = scan.nextLine();
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

            if (cards.getAIBFSize() > 0) {
                cards.AIgetAttack(AILevel);
            } else playerLife -= cards.AIattackNoDef(atkIndex);
            if (cards.AIBF.get(atkIndex).getTrample()) {
                playerLife -= cards.AIattackTrample(atkIndex, defIndex);
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