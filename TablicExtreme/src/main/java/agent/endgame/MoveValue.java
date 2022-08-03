package agent.endgame;

public class MoveValue {
    public int returnValue;
    public Node returnMove;

    public MoveValue() {
        returnValue = 0;
    }

    public MoveValue(int returnValue) {
        this.returnValue = returnValue;
    }

    public MoveValue(int returnValue, Node returnMove) {
        this.returnValue = returnValue;
        this.returnMove = returnMove;
    }
}
