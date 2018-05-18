public class jumper extends piece {
    public boolean move(int initPosX, int initPosY, int destPosX, int destPosY){
        if (Math.abs(initPosX-destPosX)!=2||Math.abs(initPosY-destPosY)!=2){
            return false;
        }
        return super.move(initPosX, initPosY, destPosX, destPosY);
    }
    public jumper(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }
}
