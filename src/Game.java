import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Gameboard board = new Gameboard(9, 10);
        System.out.println("Welcome to the game of Minesweeper! :D ");
        System.out.println();
        board.displayBoard();

        Scanner scan = new Scanner(System.in);
        while (true) {
            int row = scan.nextInt();
            int column = scan.nextInt();
            board.revealTile(row, column);
            board.displayBoard();

        }

    }
}
//    public void isGameOver(Gameboard board) {
//      for(int row=0;row<board.getSize();row++){
//          for(int column=0;column<board.getSize();column++){
//              Tile tile= board[row][column];
//          }
//      }
//    }
//}
