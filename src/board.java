public class board {
    static private final int SIZE_X = 8;
    static private final int SIZE_Y = 8;
    private piece[][] field;
    private boolean blackTurn = true;//BLACK MOVES FIRST
    private int pastPosX = -1, pastPosY = -1;

    /*
    precond: none
    poscond: a new board is initialized with pieces both sides
     */
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

    /*
    @params: position of piece to move and destination
    @return: whether it was successful
    precond: there is a board w/ pieces
    poscond: the piece is either moved or not
     */
    public boolean move(int initPosX, int initPosY, int destPosX, int destPosY){
        if (field[initPosY][initPosX].isBlack()!=blackTurn){
            return false;
        }
        if (pastPosX!=-1&&pastPosY!=-1){
            if (initPosX!=pastPosX&&initPosY!=pastPosY){
                return false;
            }
        }
        piece p = field[initPosY][initPosX];
        boolean moved = field[initPosY][initPosX].move(destPosX,destPosY);
        if(p.changeSide()){
            blackTurn = !blackTurn;
            pastPosX = -1;
            pastPosY = -1;
        } else {
            pastPosX = initPosX;
            pastPosY = initPosY;
        }

        for (int x = 0; x<field[0].length;x++){
            if (field[0][x]!=null){
                if (!field[0][x].isBlack()){
                    field[0][x] = new piece(field[0][x].isBlack(),field);
                }
            }
        }

        for (int x = 0; x<field[SIZE_Y-1].length;x++){
            if (field[SIZE_Y-1][x]!=null){
                if (field[SIZE_Y-1][x].isBlack()){
                    field[SIZE_Y-1][x] = new piece(field[SIZE_Y-1][x].isBlack(),field);
                }
            }
        }
        int rngY = (int)(Math.random()*SIZE_Y);//HARDCODED
        int rngX = (int)(((rngY+1)%2) + (Math.random()*3*2));
        if (field[rngY][rngX] != null) {
            field[rngY][rngX] = new piece(field[rngY][rngX].isBlack(),field);
        }
        rngDie();
        return moved;
    }

    /*
    precond: there is a valid board
    poscond: one position on the board (doesnt have to have a piece) is killed
     */
    public void rngDie(){
        int rngY = (int)(Math.random()*SIZE_Y);//HARDCODED
        int rngX = (int)(((rngY+1)%2) + (Math.random()*3*2));
        field[rngY][rngX] = null;
    }

    /*
    @return: amount of black pieces
    precond: there is a board
    poscond: same
     */
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

    /*
    @return: amount of white pieces
    precond: there is a board
    poscond: same
     */
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

    /*
    @return: whether it is black sides turn
    precond: the variable is initalized
    poscond: same
     */
    public boolean isBlackTurn(){
        return blackTurn;
    }

    /*
    @return: A representation of the board
    precond: there is a board
    poscond: same
     */
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
