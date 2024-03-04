package arrays.prefix_sum;

import java.util.ArrayList;

public class EquilibriumIndex {

  public int solve(ArrayList<Integer> A) {

    int len = A.size();

    ArrayList<Long> prefixSum = new ArrayList<>();
    ArrayList<Long> postfixSum = new ArrayList<>();

    prefixSum.add((long) 0);

    for (int i = 0; i < len; i++)
      prefixSum.add((long) A.get(i) + prefixSum.get(i));

    for (int i = 0; i <= len; i++)
      postfixSum.add((long) 0);

    for (int i = len - 1; i >= 0; i--)
      postfixSum.set(i, (long) A.get(i) + postfixSum.get(i + 1));

    for (int i = 1; i <= len; i++) {
      if (prefixSum.get(i - 1).equals(postfixSum.get(i)))
        return i - 1;
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
