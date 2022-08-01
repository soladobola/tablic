package agent;

import game.Card;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {

    public ArrayList<Card> hand;
    public HashMap<String, ArrayList<Card>> history;
    public ArrayList<Card> board;

    int enemyCardCount;


    public State(){
        hand = new ArrayList<>();
        board = new ArrayList<>();
        history = new HashMap<>();
    }

    public State(ArrayList<Card> hand, HashMap<String, ArrayList<Card>> history, ArrayList<Card> board, int enemyCardCount) {
        this.hand = hand;
        this.history = history;
        this.board = board;
        this.enemyCardCount = enemyCardCount;
    }

}
