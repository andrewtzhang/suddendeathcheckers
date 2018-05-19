//This is a trapped piece which cant move
//Andrew Zhang
//5/14/18

public class stuckPiece extends piece implements moveable{

    /*
    @params: where to try to move to
    @return: that it wont work
    precond: the piece is on the board
    poscond: it is unchanged
     */
    public boolean move(int destPosX, int destPosY){
        return false;
    }

    /*
    @params: color of the piece, the field
    precond: none
    poscond: the variables are initialized
     */
    public stuckPiece(boolean isBlack, piece[][] field){
        super(isBlack, field);
    }

    /*
    @return: the string representation of the piece
    precond: the isBlack variable is initialized
    poscond: same
     */
    public String toString(){
        if (isBlack()){
            return "bS";
        }else{
            return "wS";
        }
    }

    /*
    @return: to not switch the side of who plays
    precond: the piece is on the board
    poscond: same
     */
    public boolean changeSide(){
        return false;
    }
}
