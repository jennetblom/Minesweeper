import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        
        String playerName = "";

        Game game = new Game(9, 10, playerName);
        game.enterUsername();
        game.playAgain();

        System.out.println("Thanks for playing!");
    }

}