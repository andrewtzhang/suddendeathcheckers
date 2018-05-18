public class piece {
    private boolean isBlack;
    private piece[][] field;

    public piece(boolean isBlack, piece[][] field){
        this.isBlack = isBlack;
        this.field = field;
    }

    public boolean isBlack() {
        return isBlack;
    }


    public boolean move(int initPosX, int initPosY, int destPosX, int destPosY){
        if (!canMove(initPosX, initPosY, destPosX, destPosY)){
            return false;
        }

        if (Math.abs(initPosX-destPosX)==1&&Math.abs(initPosY-destPosY)==1){
            field[destPosY][destPosX] = field[initPosY][initPosX];
            field[initPosY][initPosX] = null;
            return true;
        }

        if(!canJump(initPosX, initPosY, destPosX, destPosY)){
            return false;
        }
        jump(initPosX, initPosY, destPosX, destPosY);
        return true;
    }

    private void jump(int initPosX, int initPosY, int destPosX, int destPosY){
        int jumpPosX = (initPosX+destPosX)/2;
        int jumpPosY = (initPosY+destPosY)/2;

        field[destPosY][destPosX] = field[initPosY][initPosX];
        field[initPosY][initPosX] = null;
        field[jumpPosY][jumpPosX] = null;
    }

    private boolean canMove(int initPosX, int initPosY, int destPosX, int destPosY){
        //bounds check
        if(!(initPosX<field[0].length&&initPosX>-1&&
                initPosY<field.length&&initPosY>-1&&
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
        if (!otherRules(initPosX, initPosY, destPosX, destPosY)){
            return false;
        }
        return true;
    }

    private boolean canJump(int initPosX, int initPosY, int destPosX, int destPosY){
        int jumpPosX = (initPosX+destPosX)/2;
        int jumpPosY = (initPosY+destPosY)/2;

        if (!canMove(initPosX, initPosY, destPosX, destPosY)){
            return false;
        }

        if(Math.abs(initPosX-destPosX)!=2||Math.abs(destPosY-initPosY)!=2){
            return false;
        }

        if(field[jumpPosY][jumpPosX]==null){
            return false;
        }

        if(field[initPosY][initPosX].isBlack()==field[jumpPosY][jumpPosX].isBlack()){
            return false;
        }

        return true;
    }

    private boolean otherRules(int initPosX, int initPosY, int destPosX, int destPosY){
        //BLACK GOES DOWN, WHITE GOES UP
        if (isBlack&&initPosY-destPosY>0){
            return false;
        }
        if (!isBlack&&initPosY-destPosY<0){
            return false;
        }
        //is more than 2 away
        if (Math.abs(initPosX-destPosX)>2&&Math.abs(initPosY-destPosY)>2){
            return false;
        }
        return true;
    }
}
