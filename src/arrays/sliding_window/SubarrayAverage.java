package arrays.sliding_window;

import java.util.ArrayList;

public class SubarrayAverage {

  public int solve(ArrayList<Integer> A, int B) {
    int len = A.size(), sum = 0;
    int res = 0, min = Integer.MAX_VALUE;

    for (int i = 0; i < B; i++) {
      sum += A.get(i);
    }

    min = sum;

    for (int i = B; i < len; i++) {
      sum += A.get(i);
      sum -= A.get(i - B);

      if (sum < min) {
        min = sum;
        res = i - B + 1;
      }
    }

    return res;
  }
}
