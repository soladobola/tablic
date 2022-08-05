import agent.State;
import agent.endgame.Endgame;
import game.Card;
import game.Stock;
import game.util.DeckUtil;

import java.util.ArrayList;

public class EndgameNegamaxTest2 {


    // Test: p1H: J K, P2H: K K, board and stock empty


    public static void main(String[] args) throws Exception {

        ArrayList<Card> cards = DeckUtil.getStandardCards();

        ArrayList<Card> p1Hand = new ArrayList<>();
        p1Hand.add(cards.get(9));
        p1Hand.add(cards.get(48));


        System.out.println("p1 hand: ");
        System.out.println(p1Hand);

        ArrayList<Card> p2Hand = new ArrayList<>();
        p2Hand.add(cards.get(1));
        p2Hand.add(cards.get(2));


        System.out.println("p2 hand: ");
        System.out.println(p2Hand);

        ArrayList<Card> board = new ArrayList<>();
        board.add(cards.get(2));
        board.add(cards.get(8));
        board.add(cards.get(35));

        System.out.println("Board: ");
        System.out.println(board);


        State state = new State(p1Hand, new Stock(), new Stock(), board, p2Hand.size());

        Endgame endgame = new Endgame();

        State bestMove = endgame.getBestMove(state, p2Hand);
        System.out.println("Best next state: ");
        System.out.println(bestMove);

    }
}
