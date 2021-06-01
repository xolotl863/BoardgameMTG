import javax.swing.*;
import java.util.ArrayList;

public class CardCollection  {
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> PlayerBF = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> AIhand = new ArrayList<>();
    ArrayList<Card> AIBF = new ArrayList<>();
    ArrayList<Card> AIdeck = new ArrayList<>();
    private int count = 0;
    private int[] LandCost = new int[]{0, 0, 0, 0, 0, 0};
    private int limit;
    Card thundermawhellkite = new Card("Thundermaw Hellkite", 5, 5, {2, 0, 0, 0, 0, 3});
    private int[] totalMana {0, 0, 0, 0, 0, 0};
    Card mountainsPlaceholder = new Card("Mountains", 0, 0, LandCost);
    Card islandPlaceholder = new Card("Island", 0, 0, LandCost);
    Card forestPlaceholder = new Card("Forest", 0, 0, LandCost);
    Card plainsPlaceholder = new Card("Plains", 0, 0, LandCost);
    Card swampPlaceholder = new Card("Swamp", 0, 0, LandCost);





    public CardCollection () {
        for(int i = 0; i < 7; i++) {
            hand.add(thundermawhellkite);
        }

    }
    public boolean handFull(){
        if(hand.size() >= 6) return true;
        else return false;
    }
    public void cast(int castNum){
        if(hand.get(castNum).getName() == "Mountains") addMountain(castNum);
        else if(hand.get(castNum).getName() == "Island") addForest(castNum);
        else if(hand.get(castNum).getName() == "Forest") addForest(castNum);
        else if(hand.get(castNum).getName() == "Plains") addPlains(castNum);
        else if(hand.get(castNum).getName() == "Swamp") addSwamps(castNum);

        else {
            if(isEnoughMana()) {
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
        manaCost[0]++;
        hand.remove(castNum);
    }

    public void addIsland(int castNum){
        manaCost[1]++;
        hand.remove(castNum);
    }
    public void addForest(int castNum){
        manaCost[2]++;
        hand.remove(castNum);
    }
    public void addPlains(int castNum){
        manaCost[3]++;
        hand.remove(castNum);
    }
    public void addSwamps(int castNum){
        manaCost[4]++;
        hand.remove(castNum);
    }

    public int[] getTotalMana(){
        return totalMana;
    }
    public void draw(){
        //int handSize = hand.size();
        //for(int i = handSize; i==6; i++){
        //    hand.set(i, deck.get(0));
        //    deck.remove(0);
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
