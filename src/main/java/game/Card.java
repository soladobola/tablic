package game;

import java.util.ArrayList;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return points == card.points && values.equals(card.values) && symbol.equals(card.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, symbol, points);
    }

    @Override
    public String toString() {
        return "Card{" +
                "values=" + values +
                ", symbol='" + symbol + '\'' +
                ", points=" + points +
                '}' + "\n";
    }





}
