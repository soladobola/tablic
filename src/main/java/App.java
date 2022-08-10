import agent.*;
import agent.concrete_agent.GreedyAgent;
import agent.concrete_agent.GreedyAgentWIthEndgame;
import agent.concrete_agent.NeoAgent;
import arena.Contest;

public class App {

    public static void main(String[] args) throws Exception {

        Agent player1 = new NeoAgent();
        Agent player2 = new GreedyAgent();

        Contest contest = new Contest(player1, player2, 100);
        contest.startContest();

    }
}
