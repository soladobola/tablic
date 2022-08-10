package agent.endgame;

import agent.State;
import game.Card;
import game.Stock;

import java.util.ArrayList;
import java.util.List;

// Consistent eval function
public class Node {

    List<Card> p1Hand, p2Hand;
    Stock p1Stock, p2Stock;
    ArrayList<Card> board;


    public Node(List<Card> p1Hand, List<Card> p2Hand, Stock p1Stock, Stock p2Stock, ArrayList<Card> board) {
        this.p1Hand = p1Hand;
        this.p2Hand = p2Hand;
        this.p1Stock = p1Stock;
        this.p2Stock = p2Stock;
        this.board = board;

    }



    public Node wrapIntoNode(State state, int color){
        ArrayList<Card> p1H = null, p2H = null;
        ArrayList<Card> brd = new ArrayList<>(state.board);
        Stock p1S = null, p2S = null;

        switch (color){

            case 1:
                // if color is 1 then p2 made a move!
                p1H = new ArrayList<>(this.p1Hand);
                p1S = p1Stock.clone();
                p2H = new ArrayList<>(state.hand);
                p2S = state.myStock.clone();
                break;


            case -1:
                p1H = new ArrayList<>(state.hand);
                p1S = state.myStock.clone();
                p2H = new ArrayList<>(this.p2Hand);
                p2S = p2Stock.clone();

                break;

        }

        return new Node(p1H, p2H, p1S, p2S, brd);
    }


    // Should be ok
    public State getStateByColor(int color){

        State state = new State();
        state.board = new ArrayList<>(this.board);

        // Enemy stock not important
        switch (color){
            case 1:
                state.myStock = p1Stock.clone();
                state.hand = new ArrayList<>(this.p1Hand);
                state.enemyCardCount = p2Hand.size();
                break;
            case -1:
                state.myStock = p2Stock.clone();
                state.hand = new ArrayList<>(this.p2Hand);
                state.enemyCardCount = p1Hand.size();
                break;
        }

        return state;
    }




    public int eval(){
        int p1CardCount = p1Stock.size();
        int p2CardCount = p2Stock.size();
        int weight = p1CardCount > p2CardCount ? 3 : -3;
        if(p1CardCount == p2CardCount) weight = 0;

        return p1Stock.totalPoints() - p2Stock.totalPoints() + weight;
    }


}