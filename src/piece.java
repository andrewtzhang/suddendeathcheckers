//This is a standard checkers piece
//Andrew Zhang
//5/14/18
public class piece implements moveable{
    private boolean isBlack;
    static private piece[][] field;
    private int posX, posY;

    /*
    @return: the x position of the piece
    precond: the variable is initalized
    poscond: same
     */
    public int getPosX() {
        return posX;
    }

    /*
    @return: the y position of the piece
    precond: the variable is initalized
    poscond: same
     */
    public int getPosY() {
        return posY;
    }

    /*
    @return: color of the piece
    precond: the variable is initalized
    poscond: same
     */
    public boolean isBlack() {
        return isBlack;
    }

    /*
    precond: the piece is in the field
    poscond: the position of the piece is in the variables
     */
    public void findPos(){
        for (int r = 0; r < field.length; r++){
            for (int c = 0; c < field[r].length; c++){
                if (field[r][c]==this){
                    posX = c;
                    posY = r;
                }
            }
        }
    }

    /*
    @params: color of the piece, the field
    precond: none
    poscond: the variables are initialized
     */
    public piece(boolean isBlack, piece[][] field){
        this.isBlack = isBlack;
        this.field = field;
    }

    /*
    @params: the destination of the piece
    @return: whether it was successful or not
    precond: the piece is on the board
    poscond: the piece is either moved or not
     */
    public boolean move(int destPosX, int destPosY){
        findPos();
        if (!canMove(destPosX, destPosY)){
            return false;
        }

        if (Math.abs(posX -destPosX)==1&&Math.abs(posY -destPosY)==1){
            field[destPosY][destPosX] = field[posY][posX];
            field[posY][posX] = null;
            return true;
        }
        if(!canJump(destPosX, destPosY)){
            return false;
        }
        jump(destPosX, destPosY);
        return true;
    }

    /*
    @params: where to jump to
    @return: whether it was successful
    precond: the piece is on the board
    poscond: the piece is either moved or not
     */
    private void jump(int destPosX, int destPosY){
        findPos();
        int jumpPosX = (posX +destPosX)/2;
        int jumpPosY = (posY +destPosY)/2;

        field[destPosY][destPosX] = field[posY][posX];
        field[posY][posX] = null;
        field[jumpPosY][jumpPosX] = null;
    }

    /*
    @params: where you want to move to
    @return: whether you can or not
    precond: the piece is on the board
    poscond: same
     */
    public boolean canMove(int destPosX, int destPosY){
        findPos();
        //bounds check
        if(!(posX <field[0].length&& posX >-1&&
                posY <field.length&& posY >-1&&
                destPosX<field[0].length&&destPosX>-1&&
                destPosY<field.length&&destPosY>-1)){
            return false;
        }
        //does it exist?
        if (field[destPosY][destPosX]!=null){
            return false;
        }
        //Checks places
        if (((destPosX+destPosY)%2)==0){
            return false;
        }
        if (!otherRules(destPosX, destPosY)){
            return false;
        }
        return true;
    }

    /*
    @params: where you want to jump to
    @return: whether you can or not
    precond: the piece is on the board
    poscond: same
     */
    public boolean canJump(int destPosX, int destPosY){
        findPos();
        int jumpPosX = (posX +destPosX)/2;
        int jumpPosY = (posY +destPosY)/2;

        if (!canMove(destPosX, destPosY)){
            return false;
        }

        if(Math.abs(posX -destPosX)!=2||Math.abs(destPosY- posY)!=2){
            return false;
        }

        if(field[jumpPosY][jumpPosX]==null){
            return false;
        }

        if(field[posY][posX].isBlack()==field[jumpPosY][jumpPosX].isBlack()){
            return false;
        }

        return true;
    }

    /*
    @params: where you want to move to
    @return: whether the move complies with the pieces own rules
    precond: the piece is on the board
    poscond: same
     */
    private boolean otherRules(int destPosX, int destPosY){
        findPos();
        //BLACK GOES DOWN, WHITE GOES UP
        if (isBlack&& posY -destPosY>0){
            return false;
        }
        if (!isBlack&& posY -destPosY<0){
            return false;
        }
        //is more than 2 away
        if (Math.abs(posX -destPosX)>2&&Math.abs(posY -destPosY)>2){
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
            return "B ";
        }else{
            return "W ";
        }
    }

    /*
    @return: whether to switch the side of who plays
    precond: the piece is on the board
    poscond: same
     */
    public boolean changeSide(){
        if ((canJump(posX+2,posY+2)||canJump(posX-2,posY+2))&&isBlack()){
            return false;
        }
        if ((canJump(posX+2,posY-2)||canJump(posX-2,posY-2))&&(!isBlack())){
            return false;
        }
        return true;
    }
}
