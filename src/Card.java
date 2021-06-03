import java.util.Arrays;

public class Card {
    // array of data
    private int strength, defense;
    private String name;
    private int count = 0;
    private int[] manaCost; //red blue green white black colorless
    boolean isTrample, isFlying;


    public Card(String title, int power, int toughness, int[] mana, boolean trample, boolean flying) {
        name = title;
        strength = power;
        defense = toughness;
        manaCost = mana;
        isTrample = trample;
        isFlying = flying;
    }

    public int getStrength() { return strength; }

    public int getToughness() {
        return defense;
    }

    public String getName() {
        return name;
    }
    public boolean getTrample(){return isTrample;}
    public boolean getFlying(){return isFlying;}


    public int[] getMana() {
        return manaCost;
    }

    public boolean isEnoughMana(int[] totalMana) {
        for (int t = 0; t < 6; t++) {
            if (totalMana[t] - manaCost[t] < 0) {
                return false;
            }
        }
        return true;
        //int uncolored = 0;
        //for (int z = 0; z <= 4; z++) {
        //    uncolored += totalMana[z];
        //}
        //if (uncolored >= manaCost[5]) return true;
        //else return false;
    }

    public String toString() {
        String report = new String("");
        report = report.concat("" + name + "\t"+ "[" + strength + "/" + defense + "]" + "\t" + Arrays.toString(manaCost));
        return report;
    }


}