import java.io.Serializable;

public class helmet extends armour implements Serializable {

    private static final long serialVersionUID = 1L;

    public helmet(String name, int durability, int defenceRating) {
        super(name, durability, defenceRating);
    }
    
}
