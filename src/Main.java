import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Main: This class creates a new Game-object and runs the game.

        String playerName = "";

        Game game = new Game(10, 10, playerName);
        game.enterUsername();
        game.playAgain();

    }
}