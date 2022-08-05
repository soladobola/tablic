import agent.State;
import agent.endgame.Endgame;
import agent.endgame.Node;
import game.Card;
import game.Stock;
import game.util.DeckUtil;

import java.util.ArrayList;

public class EndgameNegamaxTest {

    public static void main(String[] args) throws Exception {

        // Test -> p1Hand: Q 3 7, p2Hand: 2 3, board: 8 5 A, p1 first

        ArrayList<Card> cards = DeckUtil.getStandardCards();

        ArrayList<Card> p1Hand = new ArrayList<>();
        p1Hand.add(cards.get(10));
        p1Hand.add(cards.get(1));
        p1Hand.add(cards.get(5));

        System.out.println("p1 hand: ");
        System.out.println(p1Hand);

        ArrayList<Card> p2Hand = new ArrayList<>();
        p2Hand.add(cards.get(26));
        p2Hand.add(cards.get(27));

        System.out.println("p2 hand: ");
        System.out.println(p2Hand);

        ArrayList<Card> board = new ArrayList<>();
        board.add(cards.get(6));
        board.add(cards.get(3));
        board.add(cards.get(12));

        System.out.println("Board: ");
        System.out.println(board);


        State state = new State(p1Hand, new Stock(), new Stock(), board, p2Hand.size());

        Endgame endgame = new Endgame();

        State bestMove = endgame.getBestMove(state, p2Hand);
        System.out.println("Best next state: ");
        System.out.println(bestMove);


    }


}
