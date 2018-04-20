public class board {
    private piece[][] field = new piece[8][8];

    public board(){
        //TODO: variable size??????

        for (int row = 0; row<3; row++){
            for (int col = 0; col<7; col+=2){//HARDCODED
                field[row][((row+1)%2) + (col)]=new piece(true);
            }
        }

        for (int row = 0; row<3; row++){
            for (int col = 0; col<7; col+=2){
                field[row+5][((row)%2) + (col)]=new piece(false);
            }
        }
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

        int jumpPosX = (initPosX+destPosX)/2;
        int jumpPosY = (initPosY+destPosY)/2;

        field[destPosY][destPosX] = field[initPosX][initPosY];
        field[initPosY][initPosX] = null;
        field[jumpPosY][jumpPosX] = null;
        //TODO: MAKE CONSECUTIVE JUMPS SELECTABLE
        //TODO: IMPLEMENT KINGS AND DIRECTION
        out:
        for (int x = -2; x<=2; x += 4){
            for (int y = -2; y<=2; y += 4){
                if(move(destPosX,destPosY,destPosX+x,destPosY+y))
                    break out;
            }
        }
        return true;
    }

    public void rngDie(){
        //TODO: KILL IN NO-MANS-LAND?????????
        int rngY = (int)(Math.random()*8);//HARDCODED
        int rngX = (int)(((rngY+1)%2) + (Math.random()*3*2));
        field[rngY][rngX] = null;
    }

    public boolean canMove(int initPosX, int initPosY, int destPosX, int destPosY){
        if(!(initPosX<8&&initPosX>-1&&//hardcoded
            initPosY<8&&initPosY>-1&&
            destPosX<8&&destPosX>-1&&
            destPosY<8&&destPosY>-1)){
            System.out.println("y");
            return false;
        }
        /*(!((initPosX>=7||initPosX<=0)||//HARDCODED
                (initPosY>=7||initPosY<=0)||
                (destPosX>=7||destPosX<=0)||
                (destPosY>=7||destPosY<=0)))*/

        if (field[initPosY][initPosX]==null||field[destPosY][destPosX]!=null){
            return false;//TODO: REMOVE ==null BC IT SUCKS
        }

        if (((destPosX+destPosY)%2)==0){
            System.out.println(((destPosX+destPosY)%2));
            return false;
        }

        if (Math.abs(initPosX-destPosX)>2&&Math.abs(initPosY-destPosY)>2){
            return false;
        }

        return true;
    }

    public boolean canJump(int initPosX, int initPosY, int destPosX, int destPosY){
        int jumpPosX = (initPosX+destPosX)/2;
        int jumpPosY = (initPosY+destPosY)/2;

        if(Math.abs(initPosX-destPosX)!=2||Math.abs(destPosY-initPosY)!=2){
            return false;
        }

        if(field[initPosY][initPosX].isDown()==field[jumpPosY][jumpPosY].isDown()){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String out ="";
        for (int row = 0; row < 8; row++){//HARDCODED
            out += "|";
            for (int col = 0; col < 8; col++){
                if (field[row][col]!=null){
                if (field[row][col].isDown()){
                    out += "B";
                } else {
                    out += "W";
                }}else{
                    out += " ";
                }
                out += "|";
            }
            out+="\n";
        }
        return out;
    }
}
