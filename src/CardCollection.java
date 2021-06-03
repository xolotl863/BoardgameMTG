import java.util.ArrayList;
import java.util.Random;

public class CardCollection  {
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> PlayerBF = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> AIhand = new ArrayList<>();
    ArrayList<Card> AIBF = new ArrayList<>();
    ArrayList<Card> AIdeck = new ArrayList<>();
    private final int[] LandCost = new int[]{0, 0, 0, 0, 0, 0};
    int[] tmhkCost = new int[]{2, 0, 0, 0, 0, 0};
    private int limit;
    Random gen = new Random();
    Card thundermawhellkite = new Card("Thundermaw Hellkite", 5, 5, tmhkCost, false, true);
    private int[] totalMana = new int[]{0, 0, 0, 0, 0, 0};
    private int[] AItotalMana = new int[]{0, 0, 0, 0, 0, 0};
    Card mountainsPlaceholder = new Card("Mountains", 0, 0, LandCost, false, false);
    Card islandPlaceholder = new Card("Island", 0, 0, LandCost, false, false);
    Card forestPlaceholder = new Card("Forest", 0, 0, LandCost, false, false);
    Card plainsPlaceholder = new Card("Plains", 0, 0, LandCost, false, false);
    Card swampPlaceholder = new Card("Swamp", 0, 0, LandCost, false, false);





    public CardCollection () {
        for(int h = 0; h<10; h++){
            deck.add(thundermawhellkite);
            deck.add(thundermawhellkite);
            deck.add(thundermawhellkite);
            deck.add(thundermawhellkite);
            deck.add(thundermawhellkite);
            deck.add(mountainsPlaceholder);
            deck.add(islandPlaceholder);
            deck.add(forestPlaceholder);
            deck.add(plainsPlaceholder);
            deck.add(swampPlaceholder);
        }
        for(int h = 0; h<10; h++){
            AIdeck.add(thundermawhellkite);
            AIdeck.add(thundermawhellkite);
            AIdeck.add(thundermawhellkite);
            AIdeck.add(thundermawhellkite);
            AIdeck.add(thundermawhellkite);
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
                    System.out.println("you casted " + AIBF.get(AIBF.size() - 1).getName());
                } else System.out.println("Not enough mana");
                break;
        }
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

    public void AIattack(int atkIndx, int defIndx){
        if(AIBF.get(atkIndx).getStrength() > PlayerBF.get(defIndx).getToughness()) {
            PlayerBF.remove(defIndx);
        }
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

    public String toString() {
        String nums = "";
        for (int index = 0; index < deck.size(); index++)
            nums += (deck.get(index) + "  ");
        return nums;
    }
}
