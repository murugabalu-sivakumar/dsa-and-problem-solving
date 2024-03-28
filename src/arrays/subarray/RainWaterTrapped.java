package arrays.subarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a vector A of non-negative integers representing an elevation map where the width of each
 * bar is 1, compute how much water it is able to trap after raining.
 */
public class RainWaterTrapped {

  public int trap(final List<Integer> A) {

    int len = A.size();

    List<Integer> lMax = new ArrayList<>();
    List<Integer> rMax = new ArrayList<>(Collections.nCopies(len, 0));

    int max = 0, res = 0;

    // Populate prefix sum - To figure out max element to the left
    for (Integer integer : A) {
      lMax.add(max);
      max = Math.max(max, integer);
    }

    max = 0;

    // Populate prefix sum - To figure out max element to the right
    for (int i = len - 1; i >= 0; i--) {
      rMax.set(i, max);
      max = Math.max(max, A.get(i));
    }

    for (int i = 1; i < len - 1; i++) {
      // Determine the min of left max and right max
      int maxCap = Math.min(lMax.get(i), rMax.get(i));
      // Check if it can be trapped (i.e., the building's height is lesser than the value calculated)
      int currTrap = maxCap - A.get(i);

      // If it can be trapped, add it to the result
      if (currTrap > 0) {
        res += currTrap;
      }
    }

    return res;
  }
}
