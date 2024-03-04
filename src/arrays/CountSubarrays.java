package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubarrays {

  public int solve(ArrayList<Integer> A) {
    int len = A.size();
    int res = 0, left = 0, right = 0, MOD = 1000 * 1000 * 1000 + 7;

    Map<Integer, Integer> hMap = new HashMap<>();

    while (right < len) {
      int currElement = A.get(right);

      hMap.put(currElement, hMap.getOrDefault(A.get(right), 0) + 1);

      while (hMap.get(currElement) > 1) {
        hMap.put(A.get(left), hMap.get(A.get(left)) - 1);
        left++;
      }

      res += (right - left + 1);
      res = res % MOD;
      right++;
    }

    return res;

  }
}

/*
Misha likes finding all Sub arrays of an Array. Now she gives you an array A of N elements and told you to find the number of arrays of A, that have unique elements.

Since the number of arrays could be large, return value % 109 +7.
 */
