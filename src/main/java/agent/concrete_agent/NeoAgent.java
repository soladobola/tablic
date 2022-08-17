package agent.concrete_agent;

import agent.*;
import agent.endgame.Endgame;
import game.Card;

import java.util.ArrayList;
import java.util.List;
import static java.util.Comparator.comparing;

public class NeoAgent implements Agent {

    State currentState;
    int cardsTaken = 0;

    @Override
    public State play() throws Exception {


        if(isLastHand()){

            Endgame endgame = new Endgame();
            ArrayList<Card> enemyHand = endgame.calculateEnemyHand(currentState);
            this.currentState = endgame.getBestMove(currentState, enemyHand);
            return this.currentState;

        }


        // get all capture moves
        List<State> captures = MoveGenerator.generateCaptureMoves(this.currentState);

        // Wrap states in eval object
        List<EvalState> evalCaptures = Heuristics.wrapToEval(this.currentState, captures);
        List<EvalState> evalCapturesWithPoints = Heuristics.getCapturesWithPoints(evalCaptures);

        // Flow


        if(evalCapturesWithPoints.size() > 0){
            // Sort captures
            evalCaptures.sort(comparing(EvalState::getPoints).reversed());
            this.currentState = evalCaptures.get(0).state;

        } else {
            List<State> allMoves = MoveGenerator.generateAllMoves(this.currentState);
            List<EvalState> allEvalMoves = Heuristics.wrapToEval(this.currentState, allMoves);
            // TODO: min/max sum cap
            allEvalMoves.sort(comparing(EvalState::getSumCapToEnemy));
            this.currentState = allEvalMoves.get(0).state;

        }


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
        this.cardsTaken = 0;
    }

    private boolean isLastHand(){
        return cardsTaken > 18;
    }


}
