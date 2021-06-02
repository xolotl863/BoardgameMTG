import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class CardCollection  {
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> PlayerBF = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> AIhand = new ArrayList<>();
    ArrayList<Card> AIBF = new ArrayList<>();
    ArrayList<Card> AIdeck = new ArrayList<>();
    private int count = 0;
    private final int[] LandCost = new int[]{0, 0, 0, 0, 0, 0};
    int[] tmhkCost = new int[]{2, 0, 0, 0, 0, 3};
    private int limit;
    Random gen = new Random();
    Card thundermawhellkite = new Card("Thundermaw Hellkite", 5, 5, tmhkCost);
    private int[] totalMana = new int[]{0, 0, 0, 0, 0, 0};
    Card mountainsPlaceholder = new Card("Mountains", 0, 0, LandCost);
    Card islandPlaceholder = new Card("Island", 0, 0, LandCost);
    Card forestPlaceholder = new Card("Forest", 0, 0, LandCost);
    Card plainsPlaceholder = new Card("Plains", 0, 0, LandCost);
    Card swampPlaceholder = new Card("Swamp", 0, 0, LandCost);





    public CardCollection () {
        hand.add(thundermawhellkite);
        hand.add(thundermawhellkite);
        hand.add(mountainsPlaceholder);
        hand.add(mountainsPlaceholder);
        hand.add(mountainsPlaceholder);
        hand.add(mountainsPlaceholder);
        hand.add(mountainsPlaceholder);
        for(int i = 0; i < 7; i++) {
            AIhand.add(thundermawhellkite);
        }

    }
    public boolean handFull(){
        if(hand.size() >= 6) return true;
        else return false;
    }
    public void cast(int castNum){
        if(hand.get(castNum).getName().equals("Mountains")) addMountains(castNum);
        else if(hand.get(castNum).getName().equals("Island")) addIsland(castNum);
        else if(hand.get(castNum).getName().equals("Forest")) addForest(castNum);
        else if(hand.get(castNum).getName().equals("Plains")) addPlains(castNum);
        else if(hand.get(castNum).getName().equals("Swamp")) addSwamps(castNum);

        else {
            if(hand.get(castNum).isEnoughMana(totalMana)) {
                PlayerBF.add(hand.get(castNum));
                hand.remove(castNum);
                System.out.println("you casted " + PlayerBF.get(PlayerBF.size() - 1).getName());
            }
        }
    }

    public String AIcast(int castNum){
        AIBF.add(thundermawhellkite);
        AIhand.remove(castNum);
        return "opponent casted " + thundermawhellkite.getName();
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
    public void draw(){
        for(int i = hand.size(); i==7; i++) {
            int indxe = gen.nextInt(deck.size());
            hand.set(i, deck.get(indxe));
            deck.remove(indxe);
        }
    }

    public void attack(int atkIndx, int defIndx){
        if(PlayerBF.get(atkIndx).getStrength() > AIBF.get(defIndx).getToughness()) {
            AIBF.remove(defIndx);
        }
    }


    public int attackNoDef(int atkIndx){
        return PlayerBF.get(atkIndx).getStrength();
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
