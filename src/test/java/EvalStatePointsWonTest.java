import agent.EvalState;
import agent.MoveGenerator;
import agent.State;
import game.Deck;

import java.util.List;

public class EvalStatePointsWonTest {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck(true);
        State state = new State();

        for(int i = 0; i < 4; i++){
            state.board.add(deck.takeCard());
            state.hand.add(deck.takeCard());
        }

        List<State> childStates = MoveGenerator.generateCaptureMoves(state);
        childStates.addAll(MoveGenerator.generateCardOnBoardMoves(state));


        System.out.println("---Root state----");
        System.out.println(state);
        System.out.println("\n");

        for(State s : childStates){
            EvalState es = new EvalState(state, s, false);
            System.out.println("---------- Eval State-------------");
            System.out.println(es);
            System.out.println("\n");
        }




    }
}
