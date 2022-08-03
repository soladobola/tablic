package agent;

import game.Card;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAgent implements Agent{

    State currentState;

    @Override
    public State play() {
        ArrayList<State> moves = MoveGenerator.generateAllMoves(this.currentState);
        int randomMove = ThreadLocalRandom.current().nextInt(moves.size());
        this.currentState = moves.get(randomMove);
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
