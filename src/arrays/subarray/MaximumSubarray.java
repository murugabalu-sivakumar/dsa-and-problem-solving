package arrays.subarray;

import java.util.ArrayList;

public class MaximumSubarray {

  public int maxSubarray(int A, int B, ArrayList<Integer> C) {
    int sum = 0, maxSum = 0;

    for (int i = 0; i < A; i++) {
      sum = 0;
      for (int j = i; j < A; j++) {
        sum += C.get(j);

        if (sum <= B) {
          maxSum = Math.max(sum, maxSum);
        } else {
          break;
        }
      }
    }

    return maxSum;
  }
}

/**
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements)
 * so that the sum of contiguous elements is maximum. But the sum must not exceed B.
 */
