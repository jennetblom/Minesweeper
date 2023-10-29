import javax.swing.plaf.synth.SynthOptionPaneUI;
//import java.util.Scanner;

//public class Game {

//    public static void main(String[] args) {
//
//        Gameboard board = new Gameboard(9, 10);
//        System.out.println("Welcome to the game of Minesweeper! :D ");
//        System.out.println();
//        board.displayBoard();
//
//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            int row = scan.nextInt();
//            int column = scan.nextInt();
//            board.revealTile(row, column);
//            board.displayBoard();
//
//        }
//
//    }
//}
//    public void isGameOver(Gameboard board) {
//      for(int row=0;row<board.getSize();row++){
//          for(int column=0;column<board.getSize();column++){
//              Tile tile= board[row][column];
//          }
//      }
//    }
//}

//import java.util.Scanner;
//import java.util.InputMismatchException;//kolla så att användaren anger en siffra och inte en bokstav
//public class Game {
//    public static void main(String[] args) {
//        boolean playAgain = true;//spela igen?
//        Scanner scan = new Scanner(System.in);
//
//        while (playAgain) {
//            Gameboard gameboard = new Gameboard(9, 10);
//            System.out.println("Welcome to the game of Minesweeper! :D");
//            System.out.println();
//            gameboard.displayBoard();
//
//            boolean gameOver = false;
//
//            while (!gameOver) {
//                System.out.print("Enter row and column to reveal (e.g., 0 0): ");
//                int row = scan.nextInt();
//                int column = scan.nextInt();
//
//                if (row < 0 || row >= gameboard.getSize() || column < 0 || column >= gameboard.getSize()) {
//                    System.out.println("Invalid input. Please enter two numbers with a space between.");
//                    continue;
//                }
//
//                gameboard.revealTile(row, column);
//                gameboard.displayBoard();
//
//                if (gameboard.isGameOver()) {
//                    System.out.println("Game over! You hit a mine.");
//                    gameOver = true;
//                }
//            }catch (InputMismatchException) {
//                System.out.println("Hey!");
//                scan.nextLine();
//            }
//
//            System.out.print("Play again? (yes/no): ");
//            String playAgainInput = scan.next().toLowerCase();
//
//            if (!playAgainInput.equals("yes")) {
//                playAgain = false;
//            }
//        }
//        System.out.println("Thanks for playing!");
//    }
//}

import java.util.Scanner;

public class Game {

    private static String playerName;
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);

        while (playAgain) {
            Gameboard gameboard = new Gameboard(9, 10);
            System.out.println("Welcome to the game of Minesweeper! :D");
            System.out.println();
            gameboard.displayBoard();

            boolean gameOver = false;

            // Ask for the user's name
            while (true) {
                System.out.print("Enter your name: ");
                playerName = scan.nextLine().trim();
                if (!playerName.isEmpty()) {//make sure name is not empty
                    break;
                } else {
                    System.out.println("Please enter a valid name.");
                }
            }

            while (!gameOver) {
                try {
                    System.out.print(playerName + ", Enter row and column to reveal (e.g., 00): ");
                    String input = scan.next();
                    if (input.length() != 2) {
                        System.out.println("Invalid input. Please enter two digits for row and column.");
                        continue;
                    }

                    int row = Character.getNumericValue(input.charAt(0));
                    int column = Character.getNumericValue(input.charAt(1));

                    if (row < 0 || row >= gameboard.getSize() || column < 0 || column >= gameboard.getSize()) {
                        System.out.println("Invalid input. Please enter valid coordinates.");
                        continue;
                    }



//                    System.out.print("Enter row and column to reveal (e.g., 0 0): ");
//                    int row = scan.nextInt();
//                    int column = scan.nextInt();
//
//                    if (row < 0 || row >= gameboard.getSize() || column < 0 || column >= gameboard.getSize()) {
//                        System.out.println("Invalid input. Please enter two digits for row and column.");
//                        continue;
//                    }

                    gameboard.revealTile(row, column);
                    gameboard.displayBoard();

                    if (gameboard.isGameOver()) {
                        System.out.println("Game over! You hit a mine.");
                        gameOver = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("That´s a NO! Please enter two numbers between " + "1 - " + gameboard.getSize());
                    scan.nextLine(); // Clear the input buffer
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scan.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
