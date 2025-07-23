package snake_ladder;

public class Dice {
    int noOfDice;

    Dice(int n){
        this.noOfDice = n;
    }

    public int rollDice(){
        int count=0;
        for(int i=1;i<=noOfDice;i++){
            count+=(int)(Math.random() * 6) + 1;
        }
        return count;
    }
}
