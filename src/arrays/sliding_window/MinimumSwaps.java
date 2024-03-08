package arrays.sliding_window;

import java.util.ArrayList;

public class MinimumSwaps {

  public int solve(ArrayList<Integer> A, int B) {
    int len = A.size();
    int count = 0, maxElements = 0, res = Integer.MAX_VALUE;

    for (int i = 0; i < len; i++) {
      if (A.get(i) <= B) {
        count++;
      }
    }

    for (int i = 0; i < count; i++) {
      if (A.get(i) > B) {
        maxElements++;
      }
    }

    // System.out.println("Elements to be swapped: " + maxElements);
    res = Math.min(res, maxElements);

    for (int i = count; i < len; i++) {
      if (A.get(i) > B) {
        maxElements++;
      }

      if (A.get(i - count) > B) {
        maxElements--;
      }

      // System.out.println("Elements to be swapped: " + maxElements);
      res = Math.min(res, maxElements);
    }

    return res;
  }
}

/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps
 * required to bring all the numbers less than or equal to B together.
 * <p>
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 */
