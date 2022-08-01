import agent.MoveGenerator;
import agent.State;
import game.Deck;

import java.util.ArrayList;

public class GenerateCardOnBoardMovesTest {

    // Test done. Success!
    public static void main(String[] args) throws Exception {

        Deck deck = new Deck(false);
        State state = new State();

        state.hand.add(deck.takeCard());
        state.hand.add(deck.takeCard());
        state.hand.add(deck.takeCard());

        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());
        state.board.add(deck.takeCard());

        System.out.println("Hand cards: ");
        System.out.println(state.hand);
        System.out.println("-------------------------");
        System.out.println("Board cards: ");
        System.out.println(state.board);

        ArrayList<State> states = MoveGenerator.generateCardOnBoardMoves(state);

        for(State s : states){
            System.in.read();
            System.out.println("State hand: ");
            System.out.println(s.hand);
            System.out.println("State board: ");
            System.out.println(s.board);

            System.out.println("---------------------------");
        }

    }

}
