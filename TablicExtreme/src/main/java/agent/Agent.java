package agent;

import game.Card;

public interface Agent {
    State play() throws Exception;
    State getCurrentState();
    void setCurrentState(State state);

    void addCardToHand(Card card);

    void reset();
}
