import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private double health;

    public Player(String name){
        this.name = name;
        this.health = 100;
    }

    public String getName(){
        return name;
    }
    
    public double getHealth(){
        return health;
    }

    public void takeDamage(double enemyAttack){
        // Remove attack value from current PLAYER OBJECT's health.
        this.health -= enemyAttack;
        
        //If health hits zero, the player dies and the game ends.
        //Could potentially add lives and checkpoints.
        if (health <= 0) {
            System.out.println("You have died. Better luck next time.");
            System.exit(1);
        } else {
            System.out.println("Current Health: " + this.health);
        }
    }

    public void heal(double healthToAdd){
        //Adds health to current PLAYER OBJECT's health.
        this.health += healthToAdd;

        //If the player heals above 100 health, it will return the players health to 100 for logic reasons.
        if (this.health > 100) {
            this.health = 100;
        }
    }
}
