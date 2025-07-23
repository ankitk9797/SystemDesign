package snake_ladder;

public class Player {
    String name;
    int position;

    Player(String name){
        this.name=name;
        this.position=0;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
}
