package snake_ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    Cell[][] cells;

    Board(int size, int noOfSnakes, int noOfLadder){
        this.size = size;
        cells = new Cell[size][size];
        initialize();
        addSnakesLadders(noOfSnakes, noOfLadder);
    }

    private void initialize(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j]= new Cell();
            }
        }
    }

    private void addSnakesLadders(int numberOfSnakes, int numberOfLadders){

        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump(snakeHead, snakeTail);

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump(ladderStart, ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            numberOfLadders--;
        }

    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }

}
