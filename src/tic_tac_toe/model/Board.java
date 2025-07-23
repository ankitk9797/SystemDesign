package tic_tac_toe.model;

import tic_tac_toe.PieceType;

public class Board {
    public int size;
    public Piece[][] board;

    public Board(){
        size = 3;
        board = new Piece[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=new PieceEmpty();
            }
        }
    }

    public boolean addPiece(Piece piece, int x, int y){
        if(x>=3 || y>=3 || x<0 || y<0)
            return false;
        if(!(board[x][y].pieceType == PieceType.EMPTY))
            return false;
        board[x][y]=piece;
        return true;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j].pieceType.getValue()+ "  ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
