import agent.endgame.Endgame;
import agent.State;
import game.Card;
import game.Deck;

import java.util.ArrayList;

public class EndgameCardPredictionTest {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck(true);
        State state = new State();
        // 4 cards on board
        for(int i = 0; i < 4; i++){
            state.board.add(deck.takeCard());
        }

        for(int i = 0; i < 18; i++){
            Card tempCard = deck.takeCard();
            state.myStock.add(tempCard.getSymbol(), tempCard);
        }

        for(int i = 0; i < 18; i++){
            Card tempCard = deck.takeCard();
            state.enemyStock.add(tempCard.getSymbol(), tempCard);
        }


        ArrayList<Card> enemyHand = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            state.hand.add(deck.takeCard());
            enemyHand.add(deck.takeCard());
        }

        Endgame endgame = new Endgame();
        System.out.println("Real enemy hand: ");
        System.out.println(enemyHand);

        System.out.println("Predicted enemy hand: ");
        System.out.println(endgame.calculateEnemyHand(state));

    }
}
