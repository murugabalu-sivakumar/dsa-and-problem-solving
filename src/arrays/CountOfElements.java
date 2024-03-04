package arrays;

import java.util.ArrayList;

public class CountOfElements {

  public int solve(ArrayList<Integer> A) {

    int len = A.size();
    int maxValue = 0, count = 0;

    for (int num : A) {
      if (num > maxValue) {
        maxValue = num;
        count = 1;
      } else if (num == maxValue) {
        count++;
      }
    }

    return len - count;
  }
}

/*
Given an array A of N integers.
Count the number of elements that have at least 1 element greater than itself.
 */
