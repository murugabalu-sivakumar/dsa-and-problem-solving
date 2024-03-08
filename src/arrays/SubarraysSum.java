package arrays;

import java.util.ArrayList;

public class SubarraysSum {

  public Long subarraySum(ArrayList<Integer> A) {
    int len = A.size();
    long sum = 0, occurence = 0;

    for (int i = 1; i <= len; i++) {
      occurence = (long) i * (len - i + 1);
      sum += (long) (A.get(i - 1) * occurence);
    }

    return sum;
  }
}

/**
 * You are given an integer array A of length N. You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by
 * deleting zero or more elements from either end of the array. A subarray sum denotes the sum of
 * all the elements of that subarray.
 * <p>
 * Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes
 */
