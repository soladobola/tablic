package game;

import game.util.DeckUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(boolean random) throws Exception {
        cards = DeckUtil.getStandardCards();

        if(random)
            shuffle();
    }

    public Card takeCard(){
        if(cards.size() > 0)
        return cards.remove(0);
        else return null;
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public int getSize(){
        return cards.size();
    }

    public void print(){
        for(Card card : cards){
            System.out.println(card);
        }
    }

}
