package arena;

import agent.Agent;
import agent.State;
import game.Deck;

public class Manager {

    Agent player1;
    Agent player2;

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
        for(int i = 0; i < 3; i++){
            player1.addCardToHand(this.deck.takeCard());
            player2.addCardToHand(this.deck.takeCard());
        }
    }

    // TODO: Make this function better
    // Note: Only player1 board is set because he is on the move
    private void setBoardCards(){
        for(int i = 0; i < 4; i++){
            player1.getCurrentState().board.add(this.deck.takeCard());
        }
    }

    // TODO: Player to go first is changed after each deal
    public void playGame(){
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

        }

        System.out.println("Player 1: " + player1.getCurrentState().myStock.totalPoints() + " points");
        System.out.println("Player 2: " + player2.getCurrentState().myStock.totalPoints() + " points");

    }

}
