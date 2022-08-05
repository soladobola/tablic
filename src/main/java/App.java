import agent.*;
import agent.concrete_agent.GreedyAgent;
import agent.concrete_agent.GreedyAgentWIthEndgame;
import arena.Contest;

public class App {

    public static void main(String[] args) throws Exception {

        Agent player1 = new GreedyAgent();
        Agent player2 = new GreedyAgentWIthEndgame();

        Contest contest = new Contest(player1, player2, 100);
        contest.startContest();

    }
}
