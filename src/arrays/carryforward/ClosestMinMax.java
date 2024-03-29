package arrays.carryforward;

import java.util.ArrayList;

public class ClosestMinMax {

  public int solve(ArrayList<Integer> A) {
    int len = A.size();

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int res = Integer.MAX_VALUE;

    // Find the MIN and MAX Elements
    for (Integer integer : A) {
      min = Math.min(min, integer);
      max = Math.max(max, integer);
    }

    int lastMinIndex = -1, lastMaxIndex = -1;

    if (min == max) {
      return 1;
    }

    for (int i = 0; i < len; i++) {
      if (A.get(i) == min) { // If the current element is min
        if (lastMaxIndex != -1) // If a max was already found
        {
          res = Math.min(res,
              i - lastMaxIndex + 1); // Calculate the length and see if it is min than prev computed
        }

        lastMinIndex = i; // Update the curr Index as lastMinIndex
      } else if (A.get(i) == max) { // If the current element is max
        if (lastMinIndex != -1) // If a min was already found
        {
          res = Math.min(res, i - lastMinIndex + 1);
        }

        lastMaxIndex = i; // Update the curr Index as lastMinIndex
      }
    }

    return res;
  }
}

/*
Given an array A, find the size of the smallest sub array such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.
 */
