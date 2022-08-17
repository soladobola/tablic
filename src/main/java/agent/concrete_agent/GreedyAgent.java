package agent.concrete_agent;

import agent.*;
import game.Card;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

public class GreedyAgent implements Agent {


    State currentState;

    @Override
    public State play() {
        ArrayList<State> moves = MoveGenerator.generateAllMoves(currentState);
        this.currentState = Heuristics.maximizePoints(this.currentState, moves);

        return this.currentState;

    }

    @Override
    public State getCurrentState() {
        return this.currentState;
    }

    @Override
    public void setCurrentState(State state) {
        this.currentState = state;
    }

    @Override
    public void addCardToHand(Card card) {
        this.currentState.hand.add(card);
    }

    @Override
    public void reset() {

    }
}
