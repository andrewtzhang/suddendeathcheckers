public class king extends piece {
    public king(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    private boolean otherRules(int initPosX, int initPosY, int destPosX, int destPosY){
        //is more than 2 away
        if (Math.abs(initPosX-destPosX)>2&&Math.abs(initPosY-destPosY)>2){
            return false;
        }
        return true;
    }
}
