package tic_tac_toe.model;

import tic_tac_toe.PieceType;

public class Board {
    int size;
    Piece[][] board;

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

    public boolean isWinner(int x, int y){
        boolean isWinner = true;
        for(int i=1;i<size;i++){
            if(board[x][i].pieceType == PieceType.EMPTY
               || !(board[x][i].pieceType == board[x][0].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<size;i++){
            if(board[i][y].pieceType == PieceType.EMPTY
                    || !(board[i][y].pieceType == board[0][y].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<size;i++){
            if(board[i][i].pieceType == PieceType.EMPTY
                    || !(board[i][i].pieceType == board[0][0].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        int i=size-2;
        int j=1;
        while(i>=0){
            if(board[i][j].pieceType == PieceType.EMPTY
                    || !(board[i][j].pieceType == board[size-1][0].pieceType))
            {
                isWinner = false;
                break;
            }
            i--;
            j++;
        }
        if(isWinner)
            return true;
        return false;
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
