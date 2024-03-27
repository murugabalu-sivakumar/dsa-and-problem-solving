package arrays.prefix_sum;

import java.util.ArrayList;

public class EquilibriumIndex {

  public int solve(ArrayList<Integer> A) {

    int len = A.size();
    int sum1 = 0, sum2 = 0;

    // Find the total sum of the input array
    for (int num : A) {
      sum1 += num;
    }

    for (int i = 0; i < len; i++) {
      // Calculate the leftover sum (final sum - currElement and keep updating 1 by 1)
      sum1 -= A.get(i);

      if (sum1 == sum2) // If sum1 and sum2 are equal, then we have found the Equilibrium Index
      {
        return i;
      }

      // Keep track of elements traversed sum
      sum2 += A.get(i);
    }

    return -1;
  }
}

/*
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 */
