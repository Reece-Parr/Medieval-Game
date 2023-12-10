import java.io.Serializable;

public class shirt extends armour implements Serializable {

    private static final long serialVersionUID = 1L;

    public shirt(String name, int durability, int defenceRating) {
        super(name, durability, defenceRating);
    }
}