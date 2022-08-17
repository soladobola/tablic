package agent.concrete_agent;

import agent.*;
import agent.endgame.Endgame;
import game.Card;

import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class GreedyAgentWIthEndgame implements Agent {

    State currentState;
    int cardsTaken = 0;

    @Override
    public State play() throws Exception {

        if(isLastHand()){
            this.currentState = Heuristics.getBestMove(this.currentState);
            return this.currentState;
        }

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
        cardsTaken++;
        this.currentState.hand.add(card);
    }

    @Override
    public void reset() {
        cardsTaken = 0;
    }

    private boolean isLastHand() {
        return cardsTaken > 18;
    }
}
