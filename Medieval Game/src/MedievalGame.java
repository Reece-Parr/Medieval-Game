import java.util.Scanner;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MedievalGame {
    // Instance Variables
    private Player player;

    public static void main(String[] stg) {
        Scanner console = new Scanner(System.in);
        MedievalGame game = new MedievalGame();

        game.player = game.Start(console);

        game.save(); //Temporary to remove error.

        System.out.println(game.player);
    }


    public Player Start(Scanner console) {
        Player player;
        System.out.println("Welcome to The Final Kingdom!");
        System.out.println("Tell me, have you been here before?");
        System.out.print("Enter 'y' to load a game, or 'n' for a new game ");
        String userAnswer = console.next().toLowerCase();
        
        while(true){
            addDelay(1000);
            if (userAnswer.equals("y")) {
                System.out.print("Please enter your previous character's name: ");
                player = load(console.next(), console);
                break;
            } else if (userAnswer.equals("n")) {
                System.out.print("Please enter a character name: ");
                String newName = console.next();
                player = new Player(newName);
                break;
            } else {
                System.out.print("Sorry, I only speak common tongue. Please enter 'y' to load a game, or 'n to start a new game: ");
                userAnswer = console.next();
            }
        }
        
        return player;
    }

    private void save() {
        String fileName = player.getName() + ".svr";
        try {
            FileOutputStream userSaveFile = new FileOutputStream(fileName);
            ObjectOutputStream playerSave = new ObjectOutputStream(userSaveFile);
            playerSave.writeObject(player);
            //playerSave.close();
        } catch(IOException e) {
            System.out.println("There was an error with saving your game, note that progress may be lost! Please try again.");
        }
    }

    private Player load(String name, Scanner console) {
        Player loadedPlayer;
        try {
            FileInputStream userLoadFile = new FileInputStream(name + ".svr");
            ObjectInputStream playerLoad = new ObjectInputStream(userLoadFile);
            loadedPlayer = (Player) playerLoad.readObject();
        } catch (IOException | ClassNotFoundException e) {
            addDelay(1500);
            System.out.println("There was an error loading your save!");
            System.out.println("Please check for spelling mistakes. If all is correct then the save may no longer exist.");
            addDelay(5000);
            System.out.println("We have created a new character with the name " + name + " in the meantime.");
            addDelay(2000);
            loadedPlayer = new Player(name);
        }
        return loadedPlayer;
    }

    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
