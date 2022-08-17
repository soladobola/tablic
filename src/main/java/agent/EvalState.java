package agent;

import game.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EvalState {

   private State prevState;
   public State state;
   public int pointsWon;
   public int sumCapToEnemy;

   public boolean canEnemyTakes;


   public EvalState(State prevState, State state, boolean advance){

       this.prevState = prevState;
       this.state = state;
       this.pointsWon = state.myStock.totalPoints() - prevState.myStock.totalPoints();
       this.sumCapToEnemy = 0;

       if(advance){
            calculateSumCapToEnemy();
            calculateIfEnemyCanTakes();
       }

   }


   private void calculateIfEnemyCanTakes(){
       // Hard to implement

       this.canEnemyTakes = false;
   }

   private void calculateSumCapToEnemy(){
       int sumValue = 0;
       for(Map.Entry<Integer, String> entry : Heuristics.valuesMap.entrySet()){
           if(Heuristics.doesEnemyHasCard(entry.getValue(), this.state)){
               List<List<Integer>> permutedValues = MoveGenerator.permuteAces(this.state.board);
               int tempSum = 0;
               for(List<Integer> values : permutedValues){
                   tempSum = Integer.max(tempSum, MoveGenerator.subsetSum(values, entry.getKey()).size());
               }
               sumValue += tempSum;
           }
       }

       this.sumCapToEnemy = sumValue;
   }

    public int getSumCapToEnemy() {
        return sumCapToEnemy;
    }

    public int getPoints(){
       return pointsWon;
    }

    @Override
    public String toString() {
        return this.state.toString() + "\n" +
                "Points won: " + this.pointsWon + "\n";
    }
}
