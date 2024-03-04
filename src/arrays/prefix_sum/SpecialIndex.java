package arrays.prefix_sum;

import java.util.ArrayList;

public class SpecialIndex {

  public int solve(ArrayList<Integer> A) {
    int len = A.size(), evenSum = 0, oddSum = 0, res = 0;
    ArrayList<Integer> prefixEven = new ArrayList<>();
    ArrayList<Integer> prefixOdd = new ArrayList<>();

    for (int i = 0; i < len; i++) {
      if (i % 2 == 0) {
        evenSum += A.get(i);
      } else {
        oddSum += A.get(i);
      }

      prefixEven.add(evenSum);
      prefixOdd.add(oddSum);
    }

    for (int i = 0; i < len; i++) {
      if (i == 0) {
        evenSum = prefixOdd.get(len - 1) - prefixOdd.get(0);
        oddSum = prefixEven.get(len - 1) - prefixEven.get(0);
      } else {
        evenSum = prefixEven.get(i - 1) + prefixOdd.get(len - 1) - prefixOdd.get(i);
        oddSum = prefixOdd.get(i - 1) + prefixEven.get(len - 1) - prefixEven.get(i);
      }

        if (evenSum == oddSum) {
            res++;
        }
    }

    return res;
  }
}

/*
Given an array, arr[] of size N,
the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 */
