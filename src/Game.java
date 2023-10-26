import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

//        Game: Den här klassen kontrollerar spelets logik. Den håller koll på spelets status (pågående, vunnet, förlorat),
//        startar ett nytt spel, och kanske även kontrollerar spelarens interaktioner.


        Gameboard board = new Gameboard(9, 10);
        System.out.println("Welcome to the game of Minesweeper! " );
        System.out.println();
        board.displayBoard();


        while (true) {
            int row = scan.nextInt();
            int column = scan.nextInt();
            board.revealTile(row, column);
            board.displayBoard();
            board.showAllTiles();
        }
    }
    public void openTile(){


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
