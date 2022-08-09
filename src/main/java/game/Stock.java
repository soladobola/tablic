package game;

import java.util.*;

public class Stock implements Iterable<ArrayList<Card>> {
    private HashMap<String, ArrayList<Card>> stock;

    public Stock() {
        stock = new HashMap<>();
    }

    public Stock(HashMap<String, ArrayList<Card>> stock){
         this.stock = stock;
    }



    public List<Card> get(String symbol){
        if(!stock.containsKey(symbol)){
            return new ArrayList<>();
        }

        return stock.get(symbol);
    }


    public void add(String key, Card card){
        if(!stock.containsKey(card.getSymbol())){
            stock.put(card.getSymbol(), new ArrayList<Card>());
        }

        stock.get(card.getSymbol()).add(card);

    }


    // TODO: Test this function
    public int totalPoints(){
        int total = 0;
        for(ArrayList<Card> entry : stock.values()){
            for(Card card : entry){
                total += card.getPoints();
            }
        }

        return total;
    }



    public Stock clone(){

        HashMap<String, ArrayList<Card>> mapClone = new HashMap<>();

        for (Map.Entry<String, ArrayList<Card>> entry : stock.entrySet()) {
            String key = entry.getKey();
            ArrayList<Card> value = entry.getValue();
            mapClone.put(key, new ArrayList<Card>(value));

        }

        return new Stock(mapClone);

    }



    @Override
    public String toString() {
        return "Stock{" +
                "stock=" + stock +
                '}';
    }

    @Override
    public Iterator<ArrayList<Card>> iterator() {
        return new StockIterator(this.stock);
    }
}
