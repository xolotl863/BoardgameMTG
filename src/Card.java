

public class Card {
    // array of data
    private int strength, defense;
    private String name;
    private int count = 0;
    private int[] manaCost; //red blue green white black colorless

    /**
     * Constructor for objects of class NumberData
     */
    public Card(String title, int power, int toughness, int[] mana) {
        name = title;
        strength = power;
        defense = toughness;
        mana = manaCost;

    }

    public int getStrength() {
        return strength;
    }

    public int getToughness() {
        return defense;
    }

    public String getName() {
        return name;
    }


    public int[] getMana(int num) {
        return manaCost;
    }

    public boolean isEnoughMana(int[] totalMana) {
        for (int t = 0; t <= 4; t++) {
            if (totalMana[t] - manaCost[t] >= 0) {
                totalMana[t] -= manaCost[t];
            } else return false;
        }
        int uncolored = 0;
        for (int z = 0; z <= 4; z++) {
            uncolored += totalMana[z];
        }
        if (uncolored >= manaCost[5]) return true;
    }

    public String toString() {
        String report = new String("");
        report.concat("\t" + name + "[" + strength + "/" + defense + "]");
        return report;
    }


}