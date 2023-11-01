import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//
//        Main: Den här klassen startar spelet.
//        Den kan skapa ett nytt Game-objekt och sedan köra spelet.

        //enterUsername
        //playagain

        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        String playerName;

        while (true) {
            System.out.print("Enter your name: ");
            playerName = scan.nextLine().trim();
            if (!playerName.isEmpty()) {//make sure name is not empty
                break;
            } else {
                System.out.println("Please enter a valid name.");
            }
        }

        while (playAgain) {
            Game game = new Game(9, 10, playerName);
            game.play();

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scan.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing!");
    }

}