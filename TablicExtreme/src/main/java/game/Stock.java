package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    private HashMap<String, ArrayList<Card>> stock;

    public Stock() {
        stock = new HashMap<>();
    }

    public Stock(HashMap<String, ArrayList<Card>> stock){
         this.stock = stock;
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


    // Ugly cast!! TODO: Fix it
    public Stock clone(){
        return new Stock((HashMap<String, ArrayList<Card>>) this.stock.clone());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock=" + stock +
                '}';
    }


    // TODO: Search API
}
