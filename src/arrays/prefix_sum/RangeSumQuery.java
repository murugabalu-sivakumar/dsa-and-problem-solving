package arrays.prefix_sum;

import java.util.ArrayList;

public class RangeSumQuery {

  public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

    int len = A.size();

    ArrayList<Long> prefixSum = new ArrayList<>();
    ArrayList<Long> res = new ArrayList<>();

    prefixSum.add((long) A.get(0));

    for (int i = 1; i < len; i++) {
      prefixSum.add(prefixSum.get(i - 1) + A.get(i));
    }

    for (ArrayList<Integer> queries : B) {
      int left = queries.get(0);
      int right = queries.get(1);

      res.add(prefixSum.get(right) - ((left > 0) ? prefixSum.get(left - 1) : 0));
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
