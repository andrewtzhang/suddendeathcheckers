public class jumper extends piece implements moveable{

    public boolean move(int destPosX, int destPosY){
        findPos();
        if (Math.abs(getPosX()-destPosX)!=2||Math.abs(getPosY()-destPosY)!=2){
            return false;
        }
        return super.move(destPosX, destPosY);
    }

    public jumper(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    public String toString(){
        if (isBlack()){
            return "bK";
        }else{
            return "wK";
        }
    }
}
