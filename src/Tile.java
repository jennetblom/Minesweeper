public class Tile {

    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;


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
        //Avslöjar en ruta på spelbrädet
        isRevealed = true;
    }
    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlag() {
        isFlagged = !isFlagged;
    }
}
