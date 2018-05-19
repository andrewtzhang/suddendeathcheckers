//This is a piece that can only jump
/*
 jake jenson
 5/16/18
 */

public class jumper extends piece implements moveable{

    /*
    @params: where to jump to
    @return: whether it was successful
    precond: the piece is on the board
    poscond: the piece is either moved or not
     */
    public boolean move(int destPosX, int destPosY){
        findPos();
        if (Math.abs(getPosX()-destPosX)!=2||Math.abs(getPosY()-destPosY)!=2){
            return false;
        }
        return super.move(destPosX, destPosY);
    }

    /*
    @params: color of the piece, the field
    precond: none
    poscond: the variables are initialized
     */
    public jumper(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    /*
    @return: the string representation of the piece
    precond: the isBlack variable is initialized
    poscond: same
     */
    public String toString(){
        if (isBlack()){
            return "bK";
        }else{
            return "wK";
        }
    }
}
