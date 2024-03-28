package arrays.subarray;

import java.util.ArrayList;

/**
 * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2,
 * ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and
 * flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and
 * vice-versa.
 * <p>
 * Your aim is to perform ATMOST one operation such that in the final string number of 1s is
 * maximized.
 * <p>
 * If you don't want to perform the operation, return an empty array. Else, return an array
 * consisting of two elements denoting L and R. If there are multiple solutions, return the
 * lexicographically smallest pair of L and R.
 * <p>
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b <
 * d.
 */
public class Flip {

  public ArrayList<Integer> flip(String A) {
    int len = A.length();
    ArrayList<Integer> res = new ArrayList<>();

    int currSum = 0, maxSum = 0, left = 0, right = 0;

    for (int i = 0; i < len; i++) {
      // No consists of 0's or 1's
      // To find the contributing factor (Kadane's algorithm)
      //    - 0 contributes to 1
      //    - 1 contributes to -1
      currSum += (A.charAt(i) == '1' ? -1 : 1);

      // Check if currSum is ? maxSum - Possible answer - So store it to the output
      if (currSum > maxSum) {
        maxSum = currSum;
        res = new ArrayList<>();
        // Keep track of left and right to be returned at last
        res.add(left + 1);
        res.add(right + 1);
      }

      // If the currSum gets to be negative, reset the curr sum as it no longer contributes to the solution
      // Update the left and right index
      if (currSum < 0) {
        currSum = 0;
        left = i + 1; // Since the array index is 1 based
        right = i + 1;
      } else { // If this keeps contributing the result, move the right pointer
        right++;
      }
    }

    if (maxSum == 0) {
      return new ArrayList<>();
    }

    return res;
  }
}
