package agent;

public class EvalState {

    // Add all child states?
   private State prevState;
   public State state;
   public int pointsWon;

   public EvalState(State prevState, State state){

       this.prevState = prevState;
       this.state = state;
       this.pointsWon = state.myStock.totalPoints() - prevState.myStock.totalPoints();
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
