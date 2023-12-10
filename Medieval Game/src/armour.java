import java.io.Serializable;

public class armour implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String name;
    private int durability;
    private int defenceRating;

    public armour (String name, int durability, int defenceRating) {
        this.name = name;
        this.durability = durability;
        this.defenceRating = defenceRating;
    }

    public void reduceDurability (int damage) {
        durability -= damage;
        if (durability <= 0) {
            System.out.println("Your " + name + " has been destroyed. It cannot be repaired and must be sold for scrap.");
            defenceRating = 0;
        }
    }

    public void repairArmour (int amount) {
        durability += amount;
        if (durability > 100) {
            durability = 100;
        }
    }

    public int getDefenceRating() {
        return (int) (defenceRating * (durability / 100));
    }

    @Override
    public String toString() {
        return name + ", Defence Rating: " + defenceRating + "\n";
    }
}
