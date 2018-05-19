public class piece implements moveable{
    private boolean isBlack;
    private piece[][] field;
    private int posX, posY;

    /*
    @return:
    precond:
    poscond:
     */
    public int getPosX() {
        return posX;
    }

    /*
    @return:
    precond:
    poscond:
     */
    public int getPosY() {
        return posY;
    }

    /*
    @return:
    precond:
    poscond:
     */
    public boolean isBlack() {
        return isBlack;
    }

    /*
    precond:
    poscond:
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
    @params:
    precond:
    poscond:
     */
    public piece(boolean isBlack, piece[][] field){
        this.isBlack = isBlack;
        this.field = field;
    }

    /*
    @params:
    @return:
    precond:
    poscond:
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
    @params:
    @return:
    precond:
    poscond:
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
    @params:
    @return:
    precond:
    poscond:
     */
    private boolean canMove(int destPosX, int destPosY){
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
            System.out.println(((destPosX+destPosY)%2));
            return false;
        }
        if (!otherRules(destPosX, destPosY)){
            return false;
        }
        return true;
    }

    /*
    @params:
    @return:
    precond:
    poscond:
     */
    private boolean canJump(int destPosX, int destPosY){
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
    @params:
    @return:
    precond:
    poscond:
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
    @return:
    precond:
    poscond:
     */
    public String toString(){
        if (isBlack()){
            return "B ";
        }else{
            return "W ";
        }
    }

    //TODO this shiite

    /*
    @return:
    precond:
    poscond:
     */
    public boolean changeSide(){
        return true;
    }
}
