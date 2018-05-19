//Andrew Zhang
//5/14/18
//moveable pieces
interface moveable {

    /*
    @return: color of the piece
    precond: the variable is initalized
    poscond: same
     */
    boolean isBlack();

    /*
    @params: the destination of the piece
    @return: whether it was successful or not
    precond: the piece is on the board
    poscond: the piece is either moved or not
     */
    boolean move(int destPosX, int destPosY);

    /*
    @return: the string representation of the piece
    precond: the isBlack variable is initialized
    poscond: same
     */
    String toString();

    /*
    @return: whether to switch the side of who plays
    precond: the piece is on the board
    poscond: same
     */
    boolean changeSide();
}
