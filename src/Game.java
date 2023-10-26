import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    private Gameboard board;
    public Game(int size, int numMines) {
//        Game: Den här klassen kontrollerar spelets logik. Den håller koll på spelets status (pågående, vunnet, förlorat),
//        startar ett nytt spel, och kanske även kontrollerar spelarens interaktioner.
        this.board=new Gameboard( size,numMines);

    }
    public void openTile(){
        System.out.println("Which tile do you want to choose? Choose which row and column!");
        int row = scan.nextInt();
        int column = scan.nextInt();
        board.revealTile(row, column);
    }
    public void play(){
        while(true) {
            board.displayBoard();
            this.openTile();
        }
    }
}

