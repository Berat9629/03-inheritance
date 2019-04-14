package ohm.softa.a03;

public class DigestingState extends State {

    private int hungry;
    public DigestingState(int duration, int hungry){
        super(duration);
        this.hungry = hungry;
    }
    public State successor(Cat cat) {
        return new PlayfulState(hungry - cat.getDigest());
    }
}
