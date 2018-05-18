public class stuckPiece extends piece{
    public boolean move(int initPosX, int initPosY, int destPosX, int destPosY){
        return false;
    }
    public stuckPiece(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }
}
