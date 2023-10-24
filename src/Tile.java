public class Tile {
    private boolean isMine;
    private boolean isRevealed;
    //private boolean isFlagged;
    private int numAdjacentMines;

    public Tile(boolean isMine){
        this.isMine=false;
        this.isRevealed=false;
        this.numAdjacentMines=0;
    }
//    Tile:
//    isMine(): Denna metod kan returnera om rutan är en mina eller inte.
//
//            setMine(): Används för att ställa in om rutan ska innehålla en mina
//
//    isFlagged: Visas om rutan är flaggad.
//            setFlagged: Flaggar en ruta.


    public boolean isMine() {
        return isMine;
    }
    public boolean isRevealed(){
        return isRevealed;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = true;
    }

    public int getNumAdjacentMines() {
        return numAdjacentMines;
    }

    public void setNumAdjacentMines(int numAdjacentMines) {
        this.numAdjacentMines = numAdjacentMines;
    }
}
