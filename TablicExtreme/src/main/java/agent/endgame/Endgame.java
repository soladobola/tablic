package agent.endgame;

import agent.MoveGenerator;
import agent.State;
import game.Card;
import game.Deck;


import java.util.ArrayList;

public class Endgame {


    public ArrayList<Card> calculateEnemyHand(State state) throws Exception {
        Deck deck = new Deck(false);
        for(Card card : state.hand) deck.remove(card);
        for(Card card : state.board) deck.remove(card);
        for(ArrayList<Card>  cards : state.myStock){
            for(Card card : cards) {deck.remove(card);}
        }

        for(ArrayList<Card>  cards : state.enemyStock){
            for(Card card : cards) {deck.remove(card);}
        }

        return deck.getCards();

    }


    public MoveValue alphaBeta(Node node, int alpha, int beta, int color){

        State state = node.getStateByColor(color);
        if(state.hand.isEmpty()){

            return new MoveValue(node.eval());
        }

        MoveValue returnMove = null;
        MoveValue bestMove = null;

        if(color == 1){

            ArrayList<State> childStates = MoveGenerator.generateAllMoves(state);
            for(State child : childStates){
                Node childNode = node.wrapIntoNode(child, -1);
                returnMove = alphaBeta(childNode, alpha, beta, -1);
                if ((bestMove == null) || (bestMove.returnValue < returnMove.returnValue)) {
                    bestMove = returnMove;
                    bestMove.returnMove = childNode;
                }
                if (returnMove.returnValue > alpha) {
                    alpha = returnMove.returnValue;
                    bestMove = returnMove;
                }
                if (beta <= alpha) {
                    bestMove.returnValue = beta;
                    bestMove.returnMove = null;
                    return bestMove; // pruning
                }

            }

            return bestMove;

        } else {

            ArrayList<State> childStates = MoveGenerator.generateAllMoves(state);
            for(State child : childStates){
                Node childNode = node.wrapIntoNode(child, 1);
                returnMove = alphaBeta(childNode, alpha, beta, 1);
                if ((bestMove == null) || (bestMove.returnValue > returnMove.returnValue)) {
                    bestMove = returnMove;
                    bestMove.returnMove = childNode;
                }
                if (returnMove.returnValue < beta) {
                    beta = returnMove.returnValue;
                    bestMove = returnMove;
                }
                if (beta <= alpha) {
                    bestMove.returnValue = alpha;
                    bestMove.returnMove = null;
                    return bestMove; // pruning
                }

            }

            return bestMove;

        }

    }


    public State getBestMove(State state, ArrayList<Card> enemyHand){

        Node startNode = new Node(state.hand, enemyHand, state.myStock, state.enemyStock, state.board);
        MoveValue move = alphaBeta(startNode, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);

        System.out.println("Eval: " + move.returnValue);

        return move.returnMove.getStateByColor(1);

    }


    public Endgame(){}

}

