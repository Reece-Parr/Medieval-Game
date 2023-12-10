import java.io.Serializable;

public class shoes extends armour implements Serializable {

    private static final long serialVersionUID = 1L;

    public shoes(String name, int durability, int defenceRating) {
        super(name, durability, defenceRating);
    }
    
}
