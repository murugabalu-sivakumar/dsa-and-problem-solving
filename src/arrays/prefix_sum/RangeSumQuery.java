package arrays.prefix_sum;

import java.util.ArrayList;

public class RangeSumQuery {

  public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

    int len = A.size();
    ArrayList<Long> res = new ArrayList<>();
    ArrayList<Long> prefixSum = new ArrayList<>();

    // Calculate the prefix sum for input ArrayList
    for (int i = 0; i < len; i++) {
        if (i == 0) {
            prefixSum.add((long) A.get(i));
        } else {
            prefixSum.add((long) (prefixSum.get(i - 1) + A.get(i)));
        }
    }

    len = B.size();

    for (int i = 0; i < len; i++) {
      int left = B.get(i).get(0);
      int right = B.get(i).get(1);

        if (left == 0) {
            res.add((long) prefixSum.get(right));
        } else {
            res.add((long) (prefixSum.get(right) - prefixSum.get(left - 1)));
        }
    }

    return res;
  }
}

/*
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */
