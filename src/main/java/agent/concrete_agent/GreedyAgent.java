package agent.concrete_agent;

import agent.Agent;
import agent.EvalState;
import agent.MoveGenerator;
import agent.State;
import game.Card;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

public class GreedyAgent implements Agent {


    State currentState;

    @Override
    public State play() {
        ArrayList<State> moves = MoveGenerator.generateAllMoves(currentState);
        // Wrap to eval object
        ArrayList<EvalState> evalMoves = new ArrayList<>();
        for(State s : moves){
            evalMoves.add(new EvalState(currentState, s));
        }

        evalMoves.sort(comparing(EvalState::getPoints).reversed());

        this.currentState = evalMoves.get(0).state;
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
