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
        jump(initPosX, initPosY, destPosX, destPosY);
        //TODO: MAKE CONSECUTIVE JUMPS SELECTABLE DONE
        //TODO: IMPLEMENT KINGS AND DIRECTION DONE
        boolean repeat = true;
        int newPosX = destPosX;
        int newPosY = destPosY;

        /*
        while(repeat){
            boolean[] arr = possJumps(newPosX,newPosY);
            boolean oof = true;
            for (boolean bool:
                 arr) {
                if(bool){
                    oof = false;
                }
            }
            if (!oof){
                repeat = false;
                break;
            }
            System.out.println(toString());
            System.out.println("X: "+newPosX+"\tY: "+newPosY);
            System.out.println("0, NE. "+arr[0]);
            System.out.println("1, SE. "+arr[1]);
            System.out.println("2, SW. "+arr[2]);
            System.out.println("3, NW. "+arr[3]);
            boolean choose = false;
            for (boolean b:
                 arr) {
                if (b==true){
                    choose = true;
                }
            }
            if (choose) {
                System.out.println("Which one do you choose?");
                int choice = in.nextInt();
                switch (choice) {
                    case 0:
                        if (arr[choice]) {
                            jump(newPosX, newPosY, newPosX + 2, newPosY + 2);
                            newPosX = +2;
                            newPosY = +2;
                        }//else{
                        //System.out.println("Choose a valid option");
                        //continue bad;
                    //}
                        break;
                    case 1:
                        if (arr[choice]) {
                            jump(newPosX, newPosY, newPosX + 2, newPosY - 2);
                            newPosX = +2;
                            newPosY = -2;
                        }//else{
                        //System.out.println("Choose a valid option");
                        //continue bad;
                    //}
                        break;
                    case 2:
                        if (arr[choice]) {
                            jump(newPosX, newPosY, newPosX - 2, newPosY - 2);
                            newPosX = -2;
                            newPosY = -2;
                        }//else{
                        //System.out.println("Choose a valid option");
                        //continue bad;
                    //}
                        break;
                    case 3:
                        if (arr[choice]) {
                            jump(newPosX, newPosY, newPosX - 2, newPosY + 2);
                            newPosX = -2;
                            newPosY = +2;
                        }//else{
                        //System.out.println("Choose a valid option");
                        //continue bad;
                    //}
                        break;

                }
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

    private void jump(int initPosX, int initPosY, int destPosX, int destPosY){
        int jumpPosX = (initPosX+destPosX)/2;
        int jumpPosY = (initPosY+destPosY)/2;

        field[destPosY][destPosX] = field[initPosY][initPosX];
        field[initPosY][initPosX] = null;
        field[jumpPosY][jumpPosX] = null;
    }

    private boolean[] possJumps(int initPosX, int initPosY){ //outputs stuff clockwise
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

    private boolean canMove(int initPosX, int initPosY, int destPosX, int destPosY){
        if(!(initPosX<SIZE_X&&initPosX>-1&&
            initPosY<SIZE_Y&&initPosY>-1&&
            destPosX<SIZE_X&&destPosX>-1&&
            destPosY<SIZE_Y&&destPosY>-1)){
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

    public int amtBlack(){
        int amtBlack = 0;
        for (piece[] row:
             field) {
            for (piece p:
                 row) {
                if (p != null){
                    if (p.isBlack()){
                        amtBlack++;
                    }
                }
            }
        }
        return amtBlack;
    }

    public int amtWhite(){
        int amtWhite = 0;
        for (piece[] row:
                field) {
            for (piece p:
                    row) {
                if (p != null){
                    if (!p.isBlack()){
                        amtWhite++;
                    }
                }
            }
        }
        return amtWhite;
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
                        if (field[row][col].isBlack()){
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
                if (field[row][col].isBlack()){
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
