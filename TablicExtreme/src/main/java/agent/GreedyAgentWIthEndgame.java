package agent;

import agent.endgame.Endgame;
import game.Card;

import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class GreedyAgentWIthEndgame implements Agent {

    State currentState;
    int cardsTaken = 0;

    @Override
    public State play() throws Exception {
        if(cardsTaken <= 18) {

            ArrayList<State> moves = MoveGenerator.generateAllMoves(currentState);
            // Wrap to eval object
            ArrayList<EvalState> evalMoves = new ArrayList<>();
            for (State s : moves) {
                evalMoves.add(new EvalState(currentState, s));
            }

            evalMoves.sort(comparing(EvalState::getPoints).reversed());

            this.currentState = evalMoves.get(0).state;
            return this.currentState;

        } else {

            Endgame endgame = new Endgame();
            ArrayList<Card> enemyHand = endgame.calculateEnemyHand(currentState);
            this.currentState = endgame.getBestMove(currentState, enemyHand);
            return currentState;

        }
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
}
