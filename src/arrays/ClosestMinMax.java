package arrays;

import java.util.ArrayList;

public class ClosestMinMax {

  public int solve(ArrayList<Integer> A) {
    int len = A.size();

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int res = Integer.MAX_VALUE;

    for (Integer num : A) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    // System.out.println("MIN: " + min);
    // System.out.println("MAX: " + max);

    int lastMinIndex = -1, lastMaxIndex = -1;

      if (min == max) {
          return 1;
      }

    for (int i = 0; i < len; i++) {
      if (A.get(i) == min) {
          if (lastMaxIndex != -1) {
              res = Math.min(res, i - lastMaxIndex + 1);
          }

        lastMinIndex = i;
      } else if (A.get(i) == max) {
          if (lastMinIndex != -1) {
              res = Math.min(res, i - lastMinIndex + 1);
          }

        lastMaxIndex = i;
      }
    }

    return res;
  }
}

/*
Given an array A, find the size of the smallest sub array such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.
 */
