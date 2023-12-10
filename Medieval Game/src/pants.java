import java.io.Serializable;

public class pants extends armour implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public pants(String name, int durability, int defenceRating) {
        super(name, durability, defenceRating);
    }
}
