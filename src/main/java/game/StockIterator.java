package game;

import java.util.*;

public class StockIterator implements Iterator<ArrayList<Card>>{

    Set<Map.Entry<String, ArrayList<Card>>> entrySet;
    Iterator<Map.Entry<String, ArrayList<Card>>> it;


    public StockIterator(HashMap<String, ArrayList<Card>> stock){
        this.entrySet = stock.entrySet();
        this.it = entrySet.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public ArrayList<Card> next() {
        Map.Entry<String, ArrayList<Card>> me = it.next();
        return me.getValue();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
