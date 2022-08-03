package arena;

import agent.Agent;

public class Contest {

    Agent p1, p2;
    int numOfGames;
    Manager manager;

    int p1Win = 0;
    int p2Win = 0;
    int remi = 0;

    public Contest(Agent p1, Agent p2, int numOfGames){
        this.p1 = p1;
        this.p2 = p2;
        this.numOfGames = numOfGames;
    }

    public void startContest() throws Exception {

        for(int i = 0; i < numOfGames; i++){
            p1.reset();
            p2.reset();
            manager = new Manager(p1, p2);
            manager.playGame();
            if(manager.player1.getCurrentState().myStock.totalPoints() >
                    manager.player2.getCurrentState().myStock.totalPoints()){
                p1Win++;
            } else if(manager.player1.getCurrentState().myStock.totalPoints() <
                    manager.player2.getCurrentState().myStock.totalPoints()) {

                p2Win++;
            }

            else {
                remi++;
            }

        }

        float p1WinRate = (float)p1Win/(p1Win+p2Win+remi)*100;
        float remiRate = (float)remi/(p1Win+p2Win+remi)*100;
        System.out.println("Player 1: " + p1Win + " won times ("+ (int)p1WinRate +"%)");
        System.out.println("Player 2: " + p2Win + " won times ("+ (int)(100-p1WinRate-remiRate)  +"%)");
        System.out.println("Remi: " + remi + " ("+ (int)remiRate +"%)");


    }

}