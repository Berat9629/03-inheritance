package ohm.softa.a03;

public class Cat{
    private int sleep;
    private int awake;
    private int digest;

    private State currentState;
    private String name;

    public Cat(String name, int sleep, int awake, int digest){
        currentState = new SleepingState(sleep);
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.digest = digest;
    }

    public void feed(){

        if(!isHungry())
            throw new IllegalStateException("Not every cat is Garlfield");
        this.currentState = ((HungryState) currentState).feed(this);
    }

    public void tick(){
        currentState = currentState.tick(this);
    }

    public boolean isAsleep() {
        if (currentState instanceof SleepingState){
            return true;
        }
        return false;
    }

    public boolean isPlayful() {
        if (currentState instanceof PlayfulState){
            return true;
        }
        return false;
    }

    public boolean isHungry() {
        if (currentState instanceof HungryState){
            return true;
        }
        return false;
    }

    public boolean isDigesting() {
        if (currentState instanceof DigestingState){
            return true;
        }
        return false;
    }

    public boolean isDead() {
        if (currentState instanceof DeathState){
            return true;
        }
        return false;
    }

    public int getSleep(){
        return sleep;
    }

    public int getDigest(){
        return digest;
    }

    public int getAwake(){
        return awake;
    }

    public String getName(){
        return name;
    }
}
