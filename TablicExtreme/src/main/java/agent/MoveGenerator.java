package agent;

import game.Card;

import java.lang.reflect.Array;
import java.util.*;

public class MoveGenerator {

    public static ArrayList<State> generateCardOnBoardMoves(State state){
        // TODO: Investigate shallow copy problem
        ArrayList<State> moves = new ArrayList<>();

        for(int i = 0; i < state.hand.size(); i++){

            // Shallow copy can be problem??
            ArrayList<Card> handClone = new ArrayList<>(state.hand);
            ArrayList<Card> boardClone = new ArrayList<>(state.board);

            boardClone.add(handClone.remove(i));

            moves.add(new State(handClone, state.myStock.clone(), state.enemyStock.clone(), boardClone, state.enemyCardCount));

        }

        return moves;
    }

    // TODO: Multiple capture
    public static ArrayList<State> generateCaptureMoves(State state){
        ArrayList<State> states = new ArrayList<>();

        Set<List<Integer>> uniqueCaptures = new HashSet<>();

        // Indexes corresponds with Card objects in state.board
        for(int handCardInd = 0; handCardInd < state.hand.size(); handCardInd++){
            List<List<Integer>> permutedValues = permuteAces(state.board);
            for(List<Integer> values : permutedValues){

                for(int target : state.hand.get(handCardInd).getValue()) {
                    List<List<Integer>> sums = subsetSum(values, target);

                    uniqueCaptures.addAll(sums);
                }
            }

            // Construct state
            for(List<Integer> sumPair : uniqueCaptures){

                // mess, somehow indexes are shifted
                State currentState = state.clone();
                // Ok removing element
                currentState.myStock.add(state.hand.get(handCardInd).getSymbol(), currentState.hand.remove(handCardInd));

                // delete elements safe! set to null, remove all at the end
                for(int i : sumPair){
                    currentState.myStock.add(currentState.board.get(i).getSymbol(), currentState.board.get(i));
                    currentState.board.set(i, null);
                }

                currentState.board.removeAll(Collections.singleton(null));
                states.add(currentState);
            }

            uniqueCaptures.clear();

        }

        return states;
    }


    public static ArrayList<State> generateAllMoves(State state){
        ArrayList<State> moves = generateCardOnBoardMoves(state);
        moves.addAll(generateCaptureMoves(state));
        return moves;
    }


    public static List<List<Integer>> subsetSum(List<Integer> values, int target){

        List<List<Integer>> solution = new ArrayList<>();
        int n = values.size();

        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            int m = 1;
            int tempSum = 0;
            for (int j = 0; j < n; j++)
            {
                if ((i & m) > 0)
                {
                    temp.add(j);
                    tempSum += values.get(j);
                    if(tempSum > target) break;
                }
                m = m << 1;
            }
            if(tempSum == target) solution.add(temp);
        }

        return solution;
    }

    public static List<List<Integer>> permuteAces(ArrayList<Card> board){
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> acesInd = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        for(int i = 0; i < board.size(); i++){
            values.add(board.get(i).getValue().get(0));
            if(board.get(i).getSymbol().equals("A")) acesInd.add(i);
        }

        changeAces(result, values, acesInd, 0);
        return result;
    }

    private static void changeAces(List<List<Integer>> result, List<Integer> values, List<Integer> indexes, int current){
        if(current >= indexes.size()){
            result.add(values);
            return;
        }

        List<Integer> branch1 = new ArrayList<>(values);
        List<Integer> branch2 = new ArrayList<>(values);

        branch1.set(indexes.get(current), 1);
        branch2.set(indexes.get(current), 11);

        changeAces(result, branch1, indexes, current + 1);
        changeAces(result, branch2, indexes, current + 1);

    }



}
