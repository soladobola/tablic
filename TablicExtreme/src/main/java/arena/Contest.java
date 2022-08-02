package arena;

import agent.Agent;

public class Contest {

    Agent p1, p2;
    int numOfGames;
    Manager manager;

    int p1Win = 0;
    int p2Win = 0;

    public Contest(Agent p1, Agent p2, int numOfGames){
        this.p1 = p1;
        this.p2 = p2;
        this.numOfGames = numOfGames;
    }

    public void startContest() throws Exception {

        for(int i = 0; i < numOfGames; i++){

            manager = new Manager(p1, p2);
            manager.playGame();
            if(manager.player1.getCurrentState().myStock.totalPoints() >
               manager.player2.getCurrentState().myStock.totalPoints()){
                p1Win++;
            } else {
                p2Win++;
            }

        }

        float p1WinRate = (float)p1Win/(p1Win+p2Win)*100;
        System.out.println("Player 1: " + p1Win + " won times ("+ (int)p1WinRate +"%)");
        System.out.println("Player 2: " + p2Win + " won times ("+ (int)(100-p1WinRate)  +"%)");


    }

}
