package snake_ladder;

public class Cell {
    Jump jump;

    Cell(){
        this.jump =null;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
