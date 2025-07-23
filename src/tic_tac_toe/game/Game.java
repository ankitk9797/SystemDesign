package tic_tac_toe.game;

import tic_tac_toe.PieceType;
import tic_tac_toe.model.Board;
import tic_tac_toe.model.PieceO;
import tic_tac_toe.model.PieceX;
import tic_tac_toe.model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;
    Game(){
        board = new Board();
        players = new LinkedList<>();
        Player player1 = new Player("Player1", new PieceX());
        Player player2 = new Player("Player2", new PieceO());
        players.addFirst(player1);
        players.add(player2);
    }

    public void start(){
        while (true){
            board.printBoard();
            Player player = players.poll();
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.name +" turn");
            System.out.print("Enter x:");
            int x = scanner.nextInt();
            System.out.print("Enter y:");
            int y = scanner.nextInt();
            if(!board.addPiece(player.piece,x,y)){
                System.out.println("Invalid entry");
                players.addFirst(player);
            } else {
                if(isWinner(x,y))
                {
                    System.out.println(player.name + " is winner");
                    return;
                }
                players.addLast(player);
            }
        }
    }
    public boolean isWinner(int x, int y){
        boolean isWinner = true;
        for(int i=1;i<board.size;i++){
            if(board.board[x][i].pieceType == PieceType.EMPTY
                    || !(board.board[x][i].pieceType == board.board[x][0].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<board.size;i++){
            if(board.board[i][y].pieceType == PieceType.EMPTY
                    || !(board.board[i][y].pieceType == board.board[0][y].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int i=1;i<board.size;i++){
            if(board.board[i][i].pieceType == PieceType.EMPTY
                    || !(board.board[i][i].pieceType == board.board[0][0].pieceType))
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        int i=board.size-2;
        int j=1;
        while(i>=0){
            if(board.board[i][j].pieceType == PieceType.EMPTY
                    || !(board.board[i][j].pieceType == board.board[board.size-1][0].pieceType))
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
}
