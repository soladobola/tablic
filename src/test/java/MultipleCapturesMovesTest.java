import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MultipleCapturesMovesTest {


    private static boolean isHasCommonElement(List<Integer> arr1, List<Integer> arr2){
        for(int e : arr1){
            if(arr2.contains(e)) return true;
        }
        return false;
    }

    private static List<List<Integer>> generateMultiCaptureMoves(List<List<Integer>> singleCaptures){

        List<List<Integer>> moves = new ArrayList<>();

        for(int i = 0; i < singleCaptures.size(); i++){
            for(int j = i + 1; j < singleCaptures.size(); j++){
                List<Integer> arr1 = singleCaptures.get(i);
                List<Integer> arr2 = singleCaptures.get(j);
                if(isHasCommonElement(arr1, arr2)) continue;
                ArrayList<Integer> newMove = new ArrayList<>(arr1);
                newMove.addAll(arr2);
                moves.add(newMove);
            }
        }

        return moves;

    }




    public static void main(String[] args) {

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();

        arr1.add(0);
        arr1.add(2);
        arr2.add(3);
        arr3.add(0); arr3.add(1);

        List<List<Integer>> moves = new ArrayList<>();
        moves.add(arr1);
        moves.add(arr2);
        moves.add(arr3);

        System.out.println("Result: ");
        System.out.println(generateMultiCaptureMoves(moves));
    }





}
