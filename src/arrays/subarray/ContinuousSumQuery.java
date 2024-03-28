package arrays.subarray;

import java.util.ArrayList;
import java.util.Collections;

/**
 * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
 * When the devotees come to the temple, they donate some amount of coins to these beggars. Each
 * devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars
 * sitting next to each other.
 * <p>
 * Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L
 * <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
 * provided they don't fill their pots by any other means. For ith devotee B[i][0] = L, B[i][1] = R,
 * B[i][2] = P, given by the 2D array B
 */
public class ContinuousSumQuery {

  public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

    ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(A, 0));

    for (ArrayList<Integer> devotee : B) {
      int left = devotee.get(0) - 1;
      int right = devotee.get(1) - 1;
      int coins = devotee.get(2);

      // Since each devotee is gonna donate to beggars from Left to Right (all-inclusive)
      // Mark the left index with the coins that devotee is gonna give
      res.set(left, res.get(left) + coins);

      // Replace the right + 1 position to negative coins, so it is decreased (when calculated cumulatively)
      if (right < A - 1) {
        res.set(right + 1, res.get(right + 1) - coins);
      }
    }

    for (int i = 1; i < A; i++) {
      res.set(i, res.get(i - 1) + res.get(i));
    }

    return res;
  }
}
