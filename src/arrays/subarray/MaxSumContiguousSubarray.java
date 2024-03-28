package arrays.subarray;

import java.util.List;

/**
 * Find the maximum sum of contiguous non-empty subarray within an array A of length N.
 */
public class MaxSumContiguousSubarray {

  public int maxSubArray(final List<Integer> A) {

    int res = Integer.MIN_VALUE, currSum = 0;

    // Iterate thru the input array
    for (int num : A) {
      // Keep track of current sum
      currSum += num;

      // Res has to be the max of sum calculated so far
      res = Math.max(res, currSum);

      // If by any means, the currSum becomes -ve it can not contribute to the result
      // Bcz, even if it is negative sum, we want the max value (say -4 is encountered and res is set to -4. This has to be reset, to make it take the next -1)
      if (currSum < 0) {
        currSum = 0;
      }
    }

    return res;
  }
}
