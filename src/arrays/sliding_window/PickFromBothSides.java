package arrays.sliding_window;

import java.util.ArrayList;

/**
 * You are given an integer array A of size N.
 * <p>
 * You have to perform B operations. In one operation, you can remove either the leftmost or the
 * rightmost element of the array A.
 * <p>
 * Find and return the maximum possible sum of the B elements that were removed after the B
 * operations.
 * <p>
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 * <p>
 * Remove 3 elements from front and 0 elements from the back, OR Remove 2 elements from front and 1
 * element from the back, OR Remove 1 element from front and 2 elements from the back, OR Remove 0
 * elements from front and 3 elements from the back.
 */
public class PickFromBothSides {

  public int solve(ArrayList<Integer> A, int B) {
    int len = A.size();

    int sum = 0;

    for (int i = 0; i < B; i++) {
      sum += A.get(i);
    }

    int ans = sum;
    int back = B - 1;

    for (int i = len - 1; i >= len - B; i--) {
      sum += A.get(i);
      sum -= A.get(back--);

      ans = Math.max(ans, sum);
    }

    return ans;
  }
}
