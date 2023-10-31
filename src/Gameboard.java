import java.util.Random;

public class Gameboard {

//    initializeBoard(): Denna metod kan användas för att skapa brädet och placera ut minor på slumpmässiga platser.
//    displayBoard(): Denna metod kan användas för att visa brädet för spelaren.
//    Kanske visa okända rutor som frågetecken, flaggade rutor som flaggor, etc.

//    Gameboard: Den här klassen representerar spelbrädet. Den håller koll på alla tiles (rutor),
//    samt kanske checka statusen på en tile (om det är en bomb, om den är markerad, etc).
    private static Tile[][] board;
    //Skapar en 2D-array av spelbrädan bestående av Tile.
    private int size;
    private int numMines;

    public Gameboard(int size, int numMines) {
        //Tar in hur stort spelbrädet ska vara och hur många minor.
        this.size = size;
        this.numMines = numMines;
        this.board = new Tile[size][size];
        initializeBoard();
    }

    public int getSize() {
        return size;
    }

    private void initializeBoard() {
        //Fyller brädan med tomma rutor
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Tile(false);
            }
        }

        //Placerar ut minor på spelbrädet på slumpmässiga platser.
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!board[row][col].isMine()) {
                //Om rutan inte håller en mina redan, ska en mina placeras

                board[row][col] = new Tile(true);
                minesPlaced++;
            }
        }

    }

    public void displayBoard() {
//        //Ritar ut spelbrädet

        //Bomb = Rött kryss = "X ";
        //Inte undersökt ruta = "."
        //Undersökt ruta utan bomber bredvid = 0;
        //Undersökt ruta med bomber bredvid = 1+;

        System.out.print("  |");
        for(int col=0; col<board.length;col++){
            System.out.print(" " + col + "  ");
        }
        System.out.println();
        System.out.print("--|");
        for(int col=0;col< board.length;col++){
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

            for(int col=0;col<board.length;col++){
                System.out.print("___|");
            }
            System.out.println();
        }

    }
    public void revealTile(int row, int col) {
        //Kontrollerar att det är inom spelplanets gränser och att rutan inte redan är avslöjad.
        if (row >= 0 && row < size && col >= 0 && col < size && !board[row][col].isRevealed()) {
            board[row][col].reveal();
        }
    }

    public int countAdjacentMines(int row, int col) {

        //Räknar antalet minor precis bredvid en ruta.

        int count = 0;


        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Hoppa över den aktuella rutan
                if (i == 0 && j == 0) {
                    continue;
                }

                int adjacentRow = row + i;
                int adjacentCol = col + j;

                // Kontrollera om den närliggande rutan är inom brädet
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
        //Kontrollerar att det är inom spelbrädets gränser.
        return row >= 0 && row < size && col >= 0 && col < size;
    }
    public void showAllTiles() {

        for(int row=0;row< board.length;row++){
            for(int column=0;column< board.length;column++){
                revealTile(row,column);
            }
        }
        displayBoard();
    }
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size  && !board[row][col].isRevealed();
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




