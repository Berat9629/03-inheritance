package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    private int t = 0;
    private final int duration;

    public int getTime(){
        return t;
    }

    public int getDuration(){
        return duration;
    }

    protected State(int duration){
        this.duration = duration;
    }
    final State tick(Cat cat){
        t = t +1;
        if(t < duration){
            return this;
        }
        else{
            return successor(cat);
        }
    }
    abstract State successor(Cat cat);
}
