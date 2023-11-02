import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Game: This class controls the logic of the game.
    //It keeps track of the gamestate(running, won or lost), creates a new game and controls the interaction with the player.
    private static String playerName;
    static Scanner scan = new Scanner(System.in);
    private Gameboard board;
    boolean playAgain = true;

    public Game(int size, int numMines, String playerName) {

        this.board = new Gameboard(size, numMines);
        this.playerName = playerName;
    }

    public void enterUsername() {
        //The player writes out a username
        while (true) {
            System.out.println();
            System.out.println("\uD83D\uDCA3 WELCOME TO MINESWEEPER! \uD83D\uDCA3");
            System.out.println();

            System.out.print("Enter your name: ");
            playerName = scan.nextLine().trim();
            if (!playerName.isEmpty()) {//make sure name is not empty
                break;
            } else {
                System.out.println("Please enter a valid name.");
            }
        }
    }

    public void chooseTile() {

        //The player writes a row and column in a string, and the method converts it to a number.

        int row = 0;
        int column = 0;

        while (true) {
            try { //Try/catch to ensure proper input
                System.out.print(playerName + ": Enter row and column to reveal (e.g. 00): ");
                String input = scan.nextLine();
                if (input.length() != 2) {
                    System.out.println("Invalid input. Please enter two digits for row and column.");
                    continue;
                }


                row = Character.getNumericValue(input.charAt(0));
                column = Character.getNumericValue(input.charAt(1));

                if(!board.isValidMove(row,column)){
                    System.out.println("This tile is taken :(");
                }

                if (board.isValidMove(row, column)) {
                    break;
                }


            } catch (java.util.InputMismatchException e) { //Returnerar ifall man anger fler än 2 fel input
                System.out.println("Invalid input! Please enter two numbers between " + "1 - " + board.getSize());
                scan.nextLine(); // Clear the input buffer
            }
        }

        revealOrFlag(row, column);
    }

    public void revealOrFlag(int row, int column) {
        //The player can choose between revealing or flagging/unflagging a tile.

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
        //The play-loop should run until the player has won or lost.
        boolean gameOver = false;
        board.placeMines();

        do {
            board.displayBoard();
            this.chooseTile();

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
        //If there is a mine that's been revealed on the gameboard, the player loses.
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
        //The player wins if it manages to open every tile that's not a mine.
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

    public void playAgain() {
        //Checks if the player wants to play again.
        while (playAgain) {
            Game game = new Game(10, 10, playerName);
            game.play();

            while (true) {
                System.out.print("Play again? (yes/no): ");
                String playAgainInput = scan.nextLine().toLowerCase();

                if (playAgainInput.equals("yes")) {
                    playAgain = true;
                    break;
                } else if (playAgainInput.equals("no")) {
                    System.out.println("Thanks for playing!");
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Sorry, I didn't really understand what you meant! Please enter 'yes' or 'no'.");
                }
            }
        }
    }
}
