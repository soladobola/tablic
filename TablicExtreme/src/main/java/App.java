import agent.*;
import arena.Contest;
import arena.Manager;
import game.Deck;
import game.util.DeckUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        Agent player1 = new GreedyAgent();
        Agent player2 = new RandomAgent();

        Contest contest = new Contest(player1, player2, 10000);
        contest.startContest();


    }
}
