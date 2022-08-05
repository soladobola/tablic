import agent.MoveGenerator;
import agent.State;
import game.Deck;

import java.util.ArrayList;

public class GenerateCaptureMovesTest {

    public static void main(String[] args) throws Exception {
        Deck deck = new Deck(true);
        State state = new State();

        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());

        state.hand.add(deck.takeCard());
        state.hand.add(deck.takeCard());
        state.hand.add(deck.takeCard());

        System.out.println("---- Hand ------");
        System.out.println(state.hand);
        System.out.println("---- Board ------");
        System.out.println(state.board);

        System.out.println("--------------States------------------");

        ArrayList<State> states = MoveGenerator.generateCaptureMoves(state);

        for(State s : states){
            System.out.println("---- State hand ------");
            System.out.println(s.hand);
            System.out.println("---- State board ------");
            System.out.println(s.board);
            System.out.println(s.myStock);

        }

        System.out.println("Done.");

    }

}
