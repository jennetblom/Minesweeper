// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Gameboard gameboard = new Gameboard(9,10);
        gameboard.displayBoard();




    }


}

//import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Gameboard gameboard = new Gameboard(9, 10);
//        System.out.println("Welcome to the game of Minesweeper! :D");
//        System.out.println();
//        gameboard.displayBoard();
//
//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            System.out.print("Enter row and column to reveal (e.g., 0 0): ");
//            int row = scan.nextInt();
//            int column = scan.nextInt();
//
//            if (row < 0 || row >= gameboard.getSize() || column < 0 || column >= gameboard.getSize()) {
//                System.out.println("Invalid input. Please enter valid coordinates.");
//                continue;
//            }
//
//            gameboard.revealTile(row, column);
//            gameboard.displayBoard();
//
//            if (gameboard.isGameOver()) {
//                System.out.println("Game over! You hit a mine.");
//                break;
//            }
//        }
//    }
//}