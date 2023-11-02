import java.util.Random;

public class Gameboard {

    //Gameboard: This class represents the gameboard. It keeps track of the tiles and
    // contains the visual presentation of the gameboard.

    private static Tile[][] board;
    //Creates a 2D-array of the gameboard containing tiles.
    private int size;
    private int numMines;

    public Gameboard(int size, int numMines) {
        // Takes in the size of the game board and the number of mines
        this.size = size;
        this.numMines = numMines;
        this.board = new Tile[size][size];
        initializeBoard();
    }

    public int getSize() {
        return size;
    }

    private void initializeBoard() {
        //Fills the board with empty tiles
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Tile(false);
            }
        }
    }

    public void placeMines() {
        //Places mines on the board on random places
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!board[row][col].isMine()) {
                //If the tile does not already contain a mine, a mine will be placed.

                board[row][col] = new Tile(true);
                minesPlaced++;
            }
        }
    }

    public void displayBoard() {
        //Draws the board.
        //Bomb = Red cross(X)


        System.out.print("  |");
        for (int col = 0; col < board.length; col++) {
            System.out.print(" " + col + "  ");
        }
        System.out.println();
        System.out.print("--|");
        for (int col = 0; col < board.length; col++) {
            System.out.print("---|");
        }
        System.out.println();


        for (int row = 0; row < size; row++) {

            System.out.print(row + " | ");
            for (int col = 0; col < size; col++) {
                Tile tile = board[row][col];
                if (tile.isRevealed()) {
                    if (tile.isMine()) {
                        System.out.print("\u001B[31mX\u001B[0m | ");
                    } else {
                        // Display the count of adjacent mines
                        int adjacentMines = countAdjacentMines(row, col);
                        System.out.print(adjacentMines + " | ");
                    }
                } else if (tile.isFlagged()) {
                    System.out.print("\u001B[31mF\u001B[0m | ");
                } else {
                    System.out.print(". | ");
                }
            }
            System.out.println();
            System.out.print("  |");

            for (int col = 0; col < board.length; col++) {
                System.out.print("___|");
            }
            System.out.println();
        }

    }

    public void revealTile(int row, int col) {
        //Reveal the board up to the nearest higher number than 0, if a zero is encountered.

        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col].isRevealed()) {
            return; // Return if the tile is out of bounds or already revealed.
        }

        board[row][col].reveal();

        if (board[row][col].isMine()) {
            return; // Return if it's a mine.
        }

        if (countAdjacentMines(row, col) == 0) {
        // If it's a "0" tile, reveal all nearby tiles with "0" until a higher number is revealed
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int adjacentRow = row + i;
                    int adjacentCol = col + j;
                    if (isWithinBoard(adjacentRow, adjacentCol)) {
                        revealTile(adjacentRow, adjacentCol);
                    }
                }
            }
        }
    }
    public int countAdjacentMines(int row, int col) {

        //Counts the number of mines adjacent to a tile.

        int count = 0;


        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                //Skips the actual square
                if (i == 0 && j == 0) {
                    continue;
                }

                int adjacentRow = row + i;
                int adjacentCol = col + j;

                //Controls if the adjacent is within the board.
                if (isWithinBoard(adjacentRow, adjacentCol)) {
                    Tile adjacentTile = board[adjacentRow][adjacentCol];
                    if (adjacentTile.isMine()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isWithinBoard(int row, int col) {
       //Controls if it's within board.
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public void showAllTiles() {

        //Reveals all tiles.
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                revealTile(row, column);
            }
        }
        displayBoard();
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && !board[row][col].isRevealed();
    }

    public Tile getTile(int row, int col) {

        if (isWithinBoard(row, col)) {
            return board[row][col];
        }
        return null;
    }

    public void toggleFlag(int row, int col) {
        if (isWithinBoard(row, col)) {
            board[row][col].toggleFlag();
        }
    }
}




