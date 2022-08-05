package game.util;

import game.Card;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DeckUtil {

    private static Card readCard(String[] data){

        // TODO: just create hashmap ....
        ArrayList<Integer> values = new ArrayList<>();
        String symbol = data[2];
        int points = 0;

        // try to parse symbol to int
        boolean parsable = true;

        try {
            Integer.parseInt(data[2]);
        } catch(Exception ex) {
            parsable = false;
        }

        if(parsable) {

            int value = Integer.parseInt(data[2]);
            values.add(value);

            if (value == 10) points = 1;
            if (value == 10 && data[1].equals("DIAMOND")) points++; // Double ten

            if (value == 2 && data[1].equals("CLUB")) points = 1; // Small two

        }
        else {

            // A, J, Q, K
            points = 1;

            if(symbol.equals("A")){
                values.add(1);
                values.add(11);

            }

            if(symbol.equals("J")) values.add(12);
            if(symbol.equals("Q")) values.add(13);
            if(symbol.equals("K")) values.add(14);

        }

        return new Card(values, symbol, points);

    }

    public static ArrayList<Card> getStandardCards() throws Exception {

        ArrayList<Card> cards = new ArrayList<>();

        try {
            File myObj = new File("./resources/cards.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ", 3);

                cards.add(readCard(data));

            }
            myReader.close();
        }
        catch(Exception ex){
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }

        return cards;
    }

}
