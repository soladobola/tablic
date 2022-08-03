package agent.endgame;

import agent.MoveGenerator;
import agent.State;
import game.Card;
import game.Deck;


import java.util.ArrayList;

public class Endgame {

    // TODO: Implement faster way
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


    public int negamax(Node node, int color){

        State state = node.getStateByColor(color);
        if(state.hand.isEmpty()){
            return color*node.eval();
        }

        int value = Integer.MIN_VALUE;
        ArrayList<State> childStates = MoveGenerator.generateAllMoves(state);
        for(State child : childStates){
            // wrap in Node object, maybe neg?
            Node nextNode  = node.wrapIntoNode(child, -color);
            value = Integer.max(value, -negamax(nextNode, -color));
        }

        return value;
    }



    public Endgame(){}

}

