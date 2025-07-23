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
        if(!board[x][y].pieceType.getValue().equals(PieceType.EMPTY.getValue()))
            return false;
        board[x][y]=piece;
        return true;
    }

    public boolean isWinner(int x, int y){
        boolean isWinner = true;
        for(int i=1;i<size;i++){
            if(board[x][y].pieceType.getValue().equals(PieceType.EMPTY.getValue())
               || !board[x][i].pieceType.getValue().equals(board[x][0].pieceType.getValue()))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<size;i++){
            if(board[x][y].pieceType.getValue().equals(PieceType.EMPTY.getValue())
                    || !board[i][y].pieceType.getValue().equals(board[0][y].pieceType.getValue()))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<size;i++){
            if(board[x][y].pieceType.getValue().equals(PieceType.EMPTY.getValue())
                    || !board[i][i].pieceType.getValue().equals(board[0][0].pieceType.getValue()))
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
            if(board[x][y].pieceType.getValue().equals(PieceType.EMPTY.getValue())
                    || !board[i][j].pieceType.getValue().equals(board[size-1][0].pieceType.getValue()))
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
