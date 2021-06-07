import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardCollection  {
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> PlayerBF = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> AIhand = new ArrayList<>();
    ArrayList<Card> AIBF = new ArrayList<>();
    ArrayList<Card> AIdeck = new ArrayList<>();
    private final int[] LandCost = new int[]{0, 0, 0, 0, 0, 0};
    int[] tmhkCost = new int[]{2, 0, 0, 0, 0, 0};
    int[] sMCost = new int[]{0, 2, 0, 0, 0, 0};
    int[] wsWCost = new int[]{0, 0, 8, 0, 0, 0};
    int[] gsbCost = new int[]{0, 0, 0, 0, 4, 0};
    int[] sACost = new int[]{0, 0, 0, 2, 0, 0};
    private int limit;
    Scanner scan = new Scanner(System.in);
    Random gen = new Random();
    Card thundermawhellkite = new Card("Thundermaw Hellkite", 5, 5, tmhkCost, false, true);
    Card serraAngel = new Card("Serra Angel", 4, 4, sACost, false, true);
    Card seaMonster = new Card("Sea Monster", 6, 6, sMCost, false, false);
    Card worldspineWurm = new Card("Worldspine Wurm", 15, 15, wsWCost, true, false);
    Card griselbrand = new Card("Griselbrand", 7, 7, gsbCost, false, true);
    private int[] totalMana = new int[]{0, 0, 0, 0, 0, 0};
    private int[] tappedMana = new int[]{0, 0, 0, 0, 0, 0};
    private int[] AItotalMana = new int[]{0, 0, 0, 0, 0, 0};
    private int[] AItappedMana = new int[]{0, 0, 0, 0, 0, 0};
    Card mountainsPlaceholder = new Card("Mountains", 0, 0, LandCost, false, false);
    Card islandPlaceholder = new Card("Island", 0, 0, LandCost, false, false);
    Card forestPlaceholder = new Card("Forest", 0, 0, LandCost, false, false);
    Card plainsPlaceholder = new Card("Plains", 0, 0, LandCost, false, false);
    Card swampPlaceholder = new Card("Swamp", 0, 0, LandCost, false, false);





    public CardCollection () {
        for(int h = 0; h<10; h++){
            deck.add(thundermawhellkite);
            deck.add(serraAngel);
            deck.add(seaMonster);
            deck.add(worldspineWurm);
            deck.add(griselbrand);
            deck.add(mountainsPlaceholder);
            deck.add(islandPlaceholder);
            deck.add(forestPlaceholder);
            deck.add(plainsPlaceholder);
            deck.add(swampPlaceholder);
            deck.add(mountainsPlaceholder);
            deck.add(islandPlaceholder);
            deck.add(forestPlaceholder);
            deck.add(plainsPlaceholder);
            deck.add(swampPlaceholder);
        }
        for(int h = 0; h<10; h++){
            AIdeck.add(thundermawhellkite);
            AIdeck.add(serraAngel);
            AIdeck.add(seaMonster);
            AIdeck.add(worldspineWurm);
            AIdeck.add(griselbrand);
            AIdeck.add(mountainsPlaceholder);
            AIdeck.add(islandPlaceholder);
            AIdeck.add(forestPlaceholder);
            AIdeck.add(plainsPlaceholder);
            AIdeck.add(swampPlaceholder);
        }

    }
    public boolean handFull(){
        return hand.size() < 6;
    }
    public boolean AIhandFull(){
        return AIhand.size() < 6;
    }

    public void cast(int castNum){
        switch (hand.get(castNum).getName()) {
            case "Mountains":
                addMountains(castNum);
                break;
            case "Island":
                addIsland(castNum);
                break;
            case "Forest":
                addForest(castNum);
                break;
            case "Plains":
                addPlains(castNum);
                break;
            case "Swamp":
                addSwamps(castNum);
                break;
            default:
                if (hand.get(castNum).isEnoughMana(totalMana)) {
                    for(int i = 0 ; i< totalMana.length; i++){
                        tappedMana[i] =  totalMana[i] - hand.get(castNum).getMana(i);
                    }

                    PlayerBF.add(hand.get(castNum));
                    hand.remove(castNum);
                    System.out.println("you casted " + PlayerBF.get(PlayerBF.size() - 1).getName());
                } else System.out.println("Not enough mana");
                break;
        }
    }

    public void AIcast(int castNum){
        switch (AIhand.get(castNum).getName()) {
            case "Mountains":
                AIaddMountains(castNum);
                break;
            case "Island":
                AIaddIsland(castNum);
                break;
            case "Forest":
                AIaddForest(castNum);
                break;
            case "Plains":
                AIaddPlains(castNum);
                break;
            case "Swamp":
                AIaddSwamps(castNum);
                break;
            default:
                if (AIhand.get(castNum).isEnoughMana(AItotalMana)) {
                    AIBF.add(AIhand.get(castNum));
                    AIhand.remove(castNum);
                    for(int i = 0 ; i < AItotalMana.length; i++){
                        AItappedMana[i] = AIhand.get(castNum).getMana(i);
                        AItotalMana[i] -= AIhand.get(castNum).getMana(i);
                    }
                    System.out.println("you casted " + AIBF.get(AIBF.size() - 1).getName());
                } else System.out.println("Not enough mana");
                break;
        }
    }

    public int AIgetCast(int AIlevel){
        int castNum = 12;
        if(AIlevel == 0){
            System.out.println("Player 2, which card would you like to attack with");
             castNum = scan.nextInt();
        }
        else if(AIlevel == 1) {
            castNum = 0;
        }
        else if(AIlevel == 2){
            castNum = gen.nextInt(AIhand.size());
        }
        else if(AIlevel == 3){
            for(int x = 0; x < AIhand.size(); x++){
                if(hand.get(x).isEnoughMana(totalMana) && hand.get(castNum).getStrength() < hand.get(x).getStrength()){
                    castNum = x;
                }
            }
        }
        return castNum;
    }


    public void addMountains(int castNum){
        totalMana[0]++;
        hand.remove(castNum);
    }

    public void addIsland(int castNum){
        totalMana[1]++;
        hand.remove(castNum);
    }
    public void addForest(int castNum){
        totalMana[2]++;
        hand.remove(castNum);
    }
    public void addPlains(int castNum){
        totalMana[3]++;
        hand.remove(castNum);
    }
    public void addSwamps(int castNum){
        totalMana[4]++;
        hand.remove(castNum);
    }

    public void AIaddMountains(int castNum){
        AItotalMana[0]++;
        AIhand.remove(castNum);
    }

    public void AIaddIsland(int castNum){
        AItotalMana[1]++;
        AIhand.remove(castNum);
    }
    public void AIaddForest(int castNum){
        AItotalMana[2]++;
        AIhand.remove(castNum);
    }
    public void AIaddPlains(int castNum){
        AItotalMana[3]++;
        AIhand.remove(castNum);
    }
    public void AIaddSwamps(int castNum){
        AItotalMana[4]++;
        AIhand.remove(castNum);
    }

    public int getMountains(){
        return totalMana[0];
    }
    public int getIslands(){
        return totalMana[1];
    }
    public int getForests(){
        return totalMana[2];
    }
    public int getPlains(){
        return totalMana[3];
    }
    public int getSwamps(){
        return totalMana[4];
    }
    public int AIgetMountains(){
        return AItotalMana[0];
    }
    public int AIgetIslands(){
        return AItotalMana[1];
    }
    public int AIgetForests(){
        return AItotalMana[2];
    }
    public int AIgetPlains(){
        return AItotalMana[3];
    }
    public int AIgetSwamps(){
        return AItotalMana[4];
    }

    public int[] getTotalMana(){
        return totalMana;
    }
    public int[] AIgetTotalMana(){
        return AItotalMana;
    }

    public void draw(){
        for(int i = hand.size(); i < 7; i++) {
            int indxe = gen.nextInt(deck.size()-1);
            hand.add(deck.get(indxe));
            deck.remove(indxe);
        }
    }
    public void AIdraw(){
        for(int i = AIhand.size(); i < 7; i++) {
            int index = gen.nextInt(AIdeck.size()-1);
            AIhand.add(AIdeck.get(index));
            AIdeck.remove(index);
        }
    }

    public void attack(int atkIndx, int defIndx){
        if(PlayerBF.get(atkIndx).getStrength() > AIBF.get(defIndx).getToughness()) {
            AIBF.remove(defIndx);
        }
    }
    public int attackTrample(int atkIndx, int defIndx){
        return PlayerBF.get(atkIndx).getStrength() - AIBF.get(defIndx).getToughness();
    }
    public int AIattackTrample(int atkIndx, int defIndx){
        return AIBF.get(atkIndx).getStrength() - PlayerBF.get(defIndx).getToughness();
    }

    public void AIgetAttack(int AIlevel){
        if(AIlevel == 0){
            System.out.println("Player 2, which card would you like to attack with");
            int atkIndx = scan.nextInt();
            System.out.println("Player 1, who do you want to defend with");
            int defIndx = scan.nextInt();
            if(AIBF.get(atkIndx).getStrength() > PlayerBF.get(defIndx).getToughness()) {
                PlayerBF.remove(defIndx);
            }
        }
        else if(AIlevel == 1){
            int atkIndx = 0;
            System.out.println("Player 2 is attacking with " + AIBF.get(atkIndx).getName());
            System.out.println("Player 1, which card do you want to defend with");
            int defIndx = scan.nextInt();
            if(AIBF.get(atkIndx).getStrength() > PlayerBF.get(defIndx).getToughness()) {
                PlayerBF.remove(defIndx);
            }
        }
        else if(AIlevel == 2){
            int atkIndx = gen.nextInt(AIBF.size()-1);
            System.out.println("Player 2 is attacking with " + AIBF.get(atkIndx).getName());
            System.out.println("Player 1, which card do you want to defend with");
            int defIndx = scan.nextInt();
            if(AIBF.get(atkIndx).getStrength() > PlayerBF.get(defIndx).getToughness()) {
                PlayerBF.remove(defIndx);
            }
        }
    }
    public int AIgetAttackNoDef(int AIlevel){
        int atkIndx = 0;
        if(AIlevel == 0){
            System.out.println("Player 2, which card would you like to attack with");
            atkIndx = scan.nextInt();
        }
        else if(AIlevel == 1){
            atkIndx = 0;
            System.out.println("Player 2 is attacking with " + AIBF.get(atkIndx).getName());
        }
        else if(AIlevel == 2){
            atkIndx = gen.nextInt(AIBF.size()-1);
        }
        return atkIndx;
    }
    public int AIgetBlock(int AIlevel){
        int defIndx = 0;
        if(AIlevel == 0){
            System.out.println("Player 2, which card would you like to block with");
            defIndx = scan.nextInt();
        }
        else if(AIlevel == 1){
        }
        else if(AIlevel == 2){
            defIndx = gen.nextInt(AIBF.size()-1);
        }
        return defIndx;
    }


    public int attackNoDef(int atkIndx){
        return PlayerBF.get(atkIndx).getStrength();
    }
    public int AIattackNoDef(int atkIndx){
        return AIBF.get(atkIndx).getStrength();
    }



    public int getLimit()
    {
        return limit;
    }
    public int getAIBFSize(){
        return AIBF.size();
    }
    public int getPlayerBF(){
        return PlayerBF.size();
    }
    public int getAIHand(){
        return AIhand.size();
    }

    public String toString() {
        String nums = "";
        for (int index = 0; index < deck.size(); index++)
            nums += (deck.get(index) + "  ");
        return nums;
    }
}
