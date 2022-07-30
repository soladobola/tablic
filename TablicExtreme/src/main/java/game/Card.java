package game;

import java.util.ArrayList;

public class Card {


    private ArrayList<Integer> values;
    private String symbol;
    private int points;


    public Card(ArrayList<Integer> values, String symbol, int points) {
        this.values = values;
        this.symbol = symbol;
        this.points = points;
    }

    public ArrayList<Integer> getValue() {
        return values;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPoints() {
        return points;
    }


    @Override
    public String toString() {
        return "Card{" +
                "values=" + values +
                ", symbol='" + symbol + '\'' +
                ", points=" + points +
                '}';
    }
}
