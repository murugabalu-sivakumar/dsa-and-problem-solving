package arrays;

import java.util.ArrayList;

public class GenerateSubArray {

  public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    int len = A.size();

    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int k = i; k <= j; k++) {
          row.add(A.get(k));
        }

        res.add(row);
      }
    }

    return res;
  }
}
