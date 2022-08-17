package agent;

import agent.endgame.Endgame;
import game.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Heuristics {

    public static Map<Integer, String> valuesMap;
    static {
       valuesMap = new HashMap<>();
       valuesMap.put(1, "A");
       valuesMap.put(2, "2");
       valuesMap.put(10, "10");
       valuesMap.put(11, "A");
       valuesMap.put(12, "J");
       valuesMap.put(13, "Q");
       valuesMap.put(14, "K");

    }


    public static State getBestMove(State state) throws Exception {
        Endgame endgame = new Endgame();
        ArrayList<Card> enemyHand = endgame.calculateEnemyHand(state);
        return endgame.getBestMove(state, enemyHand);
    }

    // Note: true means that enemy may have that card
    public static boolean doesEnemyHasCard(String symbol, State state){
        int myStockCount = state.myStock.get(symbol).size();
        int enemyStockCount = state.enemyStock.get(symbol).size();
        int handCount = 0;
        for(Card card : state.hand){
            if(card.getSymbol().equals(symbol)){
                handCount++;
            }
        }

        return myStockCount + enemyStockCount + handCount != 4;
    }

    public static State maximizePoints(State root, List<State> states) {
        List<EvalState> evalStates = wrapToEval(root, states);
        evalStates.sort(comparing(EvalState::getPoints).reversed());
        return evalStates.get(0).state;
    }

    public static State maximizePoints(List<EvalState> states){
        states.sort(comparing(EvalState::getPoints).reversed());
        return states.get(0).state;
    }


    public static List<EvalState> wrapToEval(State root, List<State> states){
        List<EvalState> result = new ArrayList<>();
        for(State state : states){
            result.add(new EvalState(root, state, true));
        }
        return result;
    }

    public static List<EvalState> getCapturesWithPoints(List<EvalState> states){

        return states.stream().filter(x->x.pointsWon > 0).collect(Collectors.toList());

    }



}