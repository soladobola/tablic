package arena;

import agent.Agent;

public class Contest {

    Agent p1, p2;
    int numOfGames;
    Manager manager;

    int p1Win = 0;
    int p2Win = 0;
    int remi = 0;
    int splitPrint;

    public Contest(Agent p1, Agent p2, int numOfGames, int splitPrint) {
        this.p1 = p1;
        this.p2 = p2;
        this.numOfGames = numOfGames;
        this.splitPrint = splitPrint;
    }

    public void startContest() throws Exception {

        for (int i = 0; i < numOfGames; i++) {
            p1.reset();
            p2.reset();
            manager = new Manager(p1, p2);
            manager.playGame();

            checkResult(p1, p2);

            if (i % splitPrint == 0 && i > 0) {
                System.out.println("------ Games played: " + i);
                printStatistics();
            }

        }
        System.out.println("Final statistics:");
        printStatistics();
    }

    private void printStatistics() {
        float p1WinRate = (float) p1Win / (p1Win + p2Win + remi) * 100;
        float remiRate = (float) remi / (p1Win + p2Win + remi) * 100;

        float p1AbsoluteWinRate = (float) p1Win / (p1Win + p2Win) * 100;
        System.out.println("Player 1: " + p1Win + " won times (" + (int) p1WinRate + "%) (absolute: " + (int) p1AbsoluteWinRate + "%)");
        System.out.println("Player 2: " + p2Win + " won times (" + (int) (100 - p1WinRate - remiRate) + "%) (absolute: " + (int) (100 - p1AbsoluteWinRate) + "%)");
        System.out.println("Remi: " + remi + " (" + (int) remiRate + "%)");
    }


    private int getPlayerScore(Agent player, Agent enemy) {
        int score = player.getCurrentState().myStock.totalPoints();
        int playerCardCount = player.getCurrentState().myStock.size();
        int enemyCardCount = enemy.getCurrentState().myStock.size();
        if (playerCardCount > enemyCardCount) score += 3;
        return score;
    }

    private void checkResult(Agent p1, Agent p2) {
        int p1Score = getPlayerScore(p1, p2);
        int p2Score = getPlayerScore(p2, p1);


        if (p1Score > p2Score) {
            p1Win++;
        } else if (p1Score < p2Score) {
            p2Win++;
        } else {
            remi++;
        }
    }

}