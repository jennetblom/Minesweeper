// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        Gameboard gameboard= new Gameboard();
       // gameboard.iniatialiseBoard();

        char[][] board = new Board().newBoard(); // Initialize the game board

        Board.printBoard(board); // Print out empty game board

    }
}