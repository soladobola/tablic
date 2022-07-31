package agent;

import game.Card;
import java.util.ArrayList;
import java.util.HashMap;

public class State {

    ArrayList<Card> hand;
    HashMap<String, ArrayList<Card>> history;
    ArrayList<Card> board;

    int enemyCardCount;

    public ArrayList<State> generateAllStates(){
        return null;
    }


    // [1, 5, 8, 4, 2]
    //[11, ...]

   // 13

   // => [[1, 2], [1, 2, 3], [0, 4]]


    // 8
    // 2, 3, 4, 5, .. n
    //(8, 2) + (8, 3) + (8, 8)





}
