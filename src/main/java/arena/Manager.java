package arena;

import agent.Agent;
import agent.State;
import game.Deck;

import java.io.IOException;

public class Manager {

    public Agent player1;
    public Agent player2;


    Deck deck;

    public Manager(Agent p1, Agent p2) throws Exception {
        this.player1 = p1;
        this.player2 = p2;

        deck = new Deck(true);

        // Initialize State
        this.player1.setCurrentState(new State());
        this.player2.setCurrentState(new State());
    }

    private void dealCards(){
        //System.out.println("Dealing...");
        for(int i = 0; i < 6; i++){
            player1.addCardToHand(this.deck.takeCard());
            player2.addCardToHand(this.deck.takeCard());
        }
    }

    // Note: Only player1 board is set because he is on the move
    private void setBoardCards(){
        for(int i = 0; i < 4; i++){
            player1.getCurrentState().board.add(this.deck.takeCard());
        }
    }

    public void playGame() throws Exception {
        setBoardCards();
        while(deck.getSize() > 0){
            dealCards();
            for(int i = 0; i < 6; i++){

                State newState = player1.play();

                player2.getCurrentState().enemyStock = newState.myStock;
                player2.getCurrentState().board = newState.board;
                player2.getCurrentState().enemyCardCount = newState.hand.size();

                newState = player2.play();

                player1.getCurrentState().enemyStock = newState.myStock;
                player1.getCurrentState().board = newState.board;
                player1.getCurrentState().enemyCardCount = newState.hand.size();


            }

            // after all rounds we will be at original player1 and player2 because of math :)
            switchPlayer();

        }

    }


    private void switchPlayer(){
        Agent temp = player1;
        player1 = player2;
        player2 = temp;
    }

}
