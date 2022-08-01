import agent.MoveGenerator;
import agent.State;
import game.Deck;
import game.util.DeckUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck(true);
        State state = new State();

        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());

        System.out.println(state.board);

        List<List<Integer>> values = MoveGenerator.permuteAces(state.board);

        System.out.println(values);



    }
}
