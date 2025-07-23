package snake_ladder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;
    Player winner;

    Game(int size, int noOfPlayers, int noOfDice, int noOfSnakes, int noOfLadder){
        players = new LinkedList<>();
        board = new Board(size, noOfSnakes, noOfLadder);
        dice = new Dice(noOfDice);
        winner = null;
        for(int i=1;i<=noOfPlayers;i++){
            addPlayer(i);
        }
    }

    private void addPlayer(int n){
        Player player = new Player("Player"+n);
        players.addLast(player);
    }

    public void start(){
        while(winner == null) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.name + " current position is: " + playerTurn.position);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.position + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.position = playerNewPosition;

            System.out.println("player turn is:" + playerTurn.name + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = playerTurn;
            }

        }

        System.out.println("WINNER IS:" + winner.name);

    }

    private Player findPlayerTurn() {

        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }


    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
