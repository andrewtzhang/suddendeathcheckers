//This is a piece which can move in all directions
/*
jake jenson
5/16/18
 */

public class king extends piece implements moveable{

    /*
    @params: color of the piece, the field
    precond: none
    poscond: the variables are initialized
     */
    public king(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    /*
    @params: where you want to move to
    @return: whether the move complies with the pieces own rules
    precond: the piece is on the board
    poscond: same
     */
    private boolean otherRules(int destPosX, int destPosY){
        //is more than 2 away
        if (Math.abs(getPosX()-destPosX)>2&&Math.abs(getPosY()-destPosY)>2){
            return false;
        }
        return true;
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

    /*
    @return: whether to switch the side of who plays
    precond: the piece is on the board
    poscond: same
     */
    public boolean changeSide(){
        if (canJump(getPosX()+2,getPosY()+2)||canJump(getPosX()-2,getPosY()+2)||canJump(getPosX()+2,getPosY()-2)||canJump(getPosX()-2,getPosY()-2)){
            return false;
        }
        return true;
    }
}
