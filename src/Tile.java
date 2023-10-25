public class Tile {

    private boolean isMine;
    private boolean isRevealed;


    public Tile(boolean isMine){
        this.isMine=isMine;
        this.isRevealed=false;
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

}
