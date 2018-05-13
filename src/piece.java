public class piece {
    private boolean goesDown;

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    private boolean isKing;

    public piece(boolean goesDown){
        this.goesDown = goesDown;
    }

    public boolean isDown() {
        return goesDown;
    }


}
