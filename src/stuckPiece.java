public class stuckPiece extends piece implements moveable{
    public boolean move(int destPosX, int destPosY){
        return false;
    }

    public stuckPiece(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    public String toString(){
        if (isBlack()){
            return "bS";
        }else{
            return "wS";
        }
    }
}
