import agent.State;
import game.Deck;
import game.util.DeckUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck();
        State state = new State();

        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());

        System.out.println(state.board);

        List<List<Integer>> values = state.permuteAces(state.board);

        System.out.println(values);


        /*
       ArrayList<Integer> values = new ArrayList<>();
       values.add(1);
       values.add(2);
       values.add(3);
       values.add(4);



       System.out.println(state.subsetSum(values, 4));
        */


    }
}
