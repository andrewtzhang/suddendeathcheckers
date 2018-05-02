import java.util.Scanner;

public class board {
    static private final int SIZE_X = 8;
    static private final int SIZE_Y = 8;
    private piece[][] field;
    private static Scanner in = new Scanner(System.in);

    public board(){
        //TODO: variable size??????
        field = new piece[SIZE_Y][SIZE_X];

        for (int row = 0; row<3; row++){
            for (int col = 0; col<SIZE_X-1; col+=2){//HARDCODED
                field[row][((row+1)%2) + (col)]=new piece(true);
            }
        }

        for (int row = 0; row<3; row++){
            for (int col = 0; col<SIZE_X-1; col+=2){//HARDCODED
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

        field[destPosY][destPosX] = field[initPosY][initPosX];
        field[initPosY][initPosX] = null;
        field[jumpPosY][jumpPosX] = null;
        //TODO: MAKE CONSECUTIVE JUMPS SELECTABLE
        //TODO: IMPLEMENT KINGS AND DIRECTION
        boolean repeat = true;
        int newPosX = initPosX;
        int newPosY = initPosY;
        /*while(repeat){
            boolean[] arr = possJumps(newPosX,newPosY);

            System.out.println("0, NE. "+arr[0]);
            System.out.println("1, SE. "+arr[1]);
            System.out.println("2, SW. "+arr[2]);
            System.out.println("3, NW. "+arr[3]);
            System.out.println("Which one do you choose?");
            switch (in.nextInt()){
                case 0:

            }
        }*/

        /*out:
        for (int x = -2; x<=2; x += 4){
            for (int y = -2; y<=2; y += 4){
                if(move(destPosX,destPosY,destPosX+x,destPosY+y))
                    break out;
            }
        }*/
        return true;
    }

    public boolean[] possJumps(int initPosX, int initPosY){ //outputs stuff clockwise
        boolean[] neSeSwNw = new boolean[4];
        neSeSwNw[0]=canJump(initPosX,initPosY,initPosX+2,initPosY+2);
        neSeSwNw[1]=canJump(initPosX,initPosY,initPosX+2,initPosY-2);
        neSeSwNw[2]=canJump(initPosX,initPosY,initPosX-2,initPosY-2);
        neSeSwNw[3]=canJump(initPosX,initPosY,initPosX-2,initPosY+2);
        return neSeSwNw;
    }
    public void rngDie(){
        int rngY = (int)(Math.random()*SIZE_Y);//HARDCODED
        int rngX = (int)(((rngY+1)%2) + (Math.random()*3*2));
        field[rngY][rngX] = null;
    }

    public boolean canMove(int initPosX, int initPosY, int destPosX, int destPosY){
        if(!(initPosX<SIZE_X&&initPosX>-1&&
            initPosY<SIZE_Y&&initPosY>-1&&
            destPosX<SIZE_X&&destPosX>-1&&
            destPosY<SIZE_Y&&destPosY>-1)){
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

        if(field[initPosY][initPosX].isDown()==field[jumpPosY][jumpPosX].isDown()){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String out ="";
        for (int row = 0; row < 8; row++){//HARDCODED
            out += "|";
            for (int col = 0; col < 9; col++){
                if(col == 8)
                {
                    String rowValue = Integer.toString(row);
                    out += rowValue;
                }
                else{
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

            }
            out+="\n";
        }
        for(int col = 0; col < 8; col++){
            out += " ";
            out += Integer.toString(col);
        }
        return out;
        /*String out ="";
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
        return out;*/
    }
}
