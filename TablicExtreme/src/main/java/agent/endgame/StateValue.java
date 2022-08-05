package agent.endgame;

public class StateValue {
    public int returnValue;
    public Node returnState;

    public StateValue() {
        returnValue = 0;
    }

    public StateValue(int returnValue) {
        this.returnValue = returnValue;
    }

    public StateValue(int returnValue, Node returnState) {
        this.returnValue = returnValue;
        this.returnState = returnState;
    }
}
