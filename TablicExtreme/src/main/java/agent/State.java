package agent;

import game.Card;
import game.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {

    public ArrayList<Card> hand;
    public Stock myStock;
    public Stock enemyStock;
    public ArrayList<Card> board;

    int enemyCardCount;


    public State(){
        hand = new ArrayList<>();
        board = new ArrayList<>();
        myStock = new Stock();
        enemyStock = new Stock();
    }

    public State(ArrayList<Card> hand, Stock myStock, Stock enemyStock, ArrayList<Card> board, int enemyCardCount) {
        this.hand = hand;
        this.myStock = myStock;
        this.enemyStock = enemyStock;
        this.board = board;
        this.enemyCardCount = enemyCardCount;
    }

    public State clone(){

        ArrayList<Card> handClone = new ArrayList<>(this.hand);
        ArrayList<Card> boardClone = new ArrayList<>(this.board);

        return new State(handClone, myStock.clone(), enemyStock.clone(), boardClone, this.enemyCardCount);
    }

}
