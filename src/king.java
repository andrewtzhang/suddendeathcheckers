public class king extends piece implements moveable{
    public king(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    private boolean otherRules(int destPosX, int destPosY){
        //is more than 2 away
        if (Math.abs(getPosX()-destPosX)>2&&Math.abs(getPosY()-destPosY)>2){
            return false;
        }
        return true;
    }

    public String toString(){
        if (isBlack()){
            return "bK";
        }else{
            return "wK";
        }
    }
}
