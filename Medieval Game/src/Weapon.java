import java.io.Serializable;

public class Weapon implements Serializable{

    private static final long serialVersionUID = 1L;

    private final String name;
    private final int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
