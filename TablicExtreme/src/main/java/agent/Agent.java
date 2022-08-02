package agent;

import game.Card;

public interface Agent {
    State play();
    State getCurrentState();
    void setCurrentState(State state);

    void addCardToHand(Card card);
}
