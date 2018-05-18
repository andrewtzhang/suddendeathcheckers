import java.util.Scanner;

public class board {
    static private final int SIZE_X = 8;
    static private final int SIZE_Y = 8;
    private piece[][] field;
    private static Scanner in = new Scanner(System.in);
    private boolean blackTurn = true;//BLACK MOVES FIRST AND IMPLEMENT

    
    public board(){
        //TODO: variable size??????
        field = new piece[SIZE_Y][SIZE_X];

        for (int row = 0; row<3; row++){
            for (int col = 0; col<SIZE_X-1; col+=2){//HARDCODED TOP TS BLACK
                field[row][((row+1)%2) + (col)]=new piece(true, field);
            }
        }

        for (int row = 0; row<3; row++){
            for (int col = 0; col<SIZE_X-1; col+=2){//HARDCODED
                field[row+5][((row)%2) + (col)]=new piece(false, field);
            }
        }
    }

    public boolean move(int initPosX, int initPosY, int destPosX, int destPosY){
        return field[initPosY][initPosX].move(destPosX,destPosY);
    }

    public void rngDie(){
        int rngY = (int)(Math.random()*SIZE_Y);//HARDCODED
        int rngX = (int)(((rngY+1)%2) + (Math.random()*3*2));
        field[rngY][rngX] = null;
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

    public boolean isBlackTurn(){
        return blackTurn;
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
                        out += field[row][col].toString();
                        }else{
                        out += "  ";
                    }
                    out += "|";
                }

            }
            out+="\n";
        }
        for(int col = 0; col < 8; col++){
            out += "  ";
            out += Integer.toString(col);
        }
        return out;
    }
}
