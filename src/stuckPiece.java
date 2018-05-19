public class stuckPiece extends piece implements moveable{
    
    /*
    @params:
    @return:
    precond:
    poscond:
     */
    public boolean move(int destPosX, int destPosY){
        return false;
    }

    /*
    @params:
    @return:
    precond:
    poscond:
     */
    public stuckPiece(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    /*
    @return:
    precond:
    poscond:
     */
    public String toString(){
        if (isBlack()){
            return "bS";
        }else{
            return "wS";
        }
    }
}
