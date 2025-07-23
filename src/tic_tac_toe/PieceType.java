package tic_tac_toe;
public enum PieceType {
    X("x"),
    O("o"),
    EMPTY("_");

    String value;

    PieceType(String val){
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
