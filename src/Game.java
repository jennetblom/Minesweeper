import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    private Gameboard board;

    public Game(int size, int numMines) {
//        Game: Den här klassen kontrollerar spelets logik. Den håller koll på spelets status (pågående, vunnet, förlorat),
//        startar ett nytt spel, och kanske även kontrollerar spelarens interaktioner.
        this.board = new Gameboard(size, numMines);
    }

    public void openTile() {
        System.out.println("Which tile do you want to choose? Choose which row and column!");
        
        String input = scan.nextLine();

        int row = Character.getNumericValue(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
  
        Tile selectedTile = board.getTile(row, column);

        if (selectedTile != null) {
            String action = "";

            while (!action.equalsIgnoreCase("R") && !action.equalsIgnoreCase("F")) {
                System.out.println("Do you want to reveal (R) or flag/unflag (F) the tile?");
                action = scan.nextLine();
                if (!action.equalsIgnoreCase("R") && !action.equalsIgnoreCase("F")) {
                    System.out.println("Incorrect input, please try again!");
                }
            }

            if (action.equalsIgnoreCase("R")) {
                board.revealTile(row, column);
         

            } else if (action.equalsIgnoreCase("F")) {
                board.toggleFlag(row, column);
            }
        } else {
            System.out.println("Invalid position, please try again!");
        }

    }
    public void play() {
      
        boolean gameOver = false;
        do {
            // board.showAllTiles();
            board.displayBoard();
            this.openTile();

            if (isGameLost()) {
                board.showAllTiles();
                System.out.println("Game Over!");
                gameOver = true;
            }
            if (isGameWon()) {
                board.showAllTiles();
                System.out.println("You have won");
                gameOver = true;
            }

        } while (!gameOver);
    }

    public boolean isGameLost() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                Tile tile = board.getTile(row, column);
                if (tile.isMine() && tile.isRevealed())
                    return true;
            }
        }
        return false;
    }

    public boolean isGameWon() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                Tile tile = board.getTile(row, column);

                if (tile.isMine() && tile.isRevealed()) {
                    return false;
                } else if (!tile.isMine() && !tile.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

}
