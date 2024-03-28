package arrays.subarray;

import java.util.ArrayList;

public class GoodSubarrays {

  public int solve(ArrayList<Integer> A, int B) {

    int len = A.size();
    int sum = 0, res = 0, noOfElements = 0;

    for (int i = 0; i < len; i++) {
      sum = 0;
      for (int j = i; j < len; j++) {
        noOfElements = j - i + 1;
        sum += A.get(j);

        if (noOfElements % 2 == 0 && sum < B) {
          res++;
        } else if (noOfElements % 2 != 0 && sum > B) {
          res++;
        }
      }
    }

    return res;
  }
}

/**
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 */
