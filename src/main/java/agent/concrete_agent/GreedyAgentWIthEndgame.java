package agent.concrete_agent;

import agent.Agent;
import agent.EvalState;
import agent.MoveGenerator;
import agent.State;
import agent.endgame.Endgame;
import game.Card;

import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class GreedyAgentWIthEndgame implements Agent {

    State currentState;
    int cardsTaken = 0;

    @Override
    public State play() throws Exception {

        if (isLastHand()) {

            Endgame endgame = new Endgame();
            ArrayList<Card> enemyHand = endgame.calculateEnemyHand(currentState);
            this.currentState = endgame.getBestMove(currentState, enemyHand);
            return this.currentState;

        }


        ArrayList<State> moves = MoveGenerator.generateAllMoves(currentState);
        ArrayList<EvalState> evalMoves = new ArrayList<>();
        for (State s : moves) {
            evalMoves.add(new EvalState(currentState, s, false));
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
