public class Tile {

    //A tile represents a square on the gameboard.
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;

    //When the tile is first created, the information of the tile is hidden.
    public Tile(boolean isMine) {
        this.isMine = isMine;
        this.isRevealed = false;
        this.isFlagged = false;
    }
    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        //Reveals a tile
        isRevealed = true;
    }
    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlag() {
        isFlagged = !isFlagged;
    }
}
