package agent.concrete_agent;

import agent.Agent;
import agent.State;
import game.Card;

public class NeoAgent implements Agent {

    State currentState;

    @Override
    public State play() {
        return null;
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
