import game.Deck;
import game.util.DeckUtil;

public class App {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck();
        int count = 0;
        while(true) {
            System.in.read();
            count++;
            System.out.println(deck.takeCard());
            System.out.println(count);
        }


    }
}
