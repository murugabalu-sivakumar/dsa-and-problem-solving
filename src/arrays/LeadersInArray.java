package arrays;

import java.util.ArrayList;

public class LeadersInArray {

  public ArrayList<Integer> solve(ArrayList<Integer> A) {

    int len = A.size();
    int maxFromRight = Integer.MIN_VALUE;
    ArrayList<Integer> maxElements = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();

      for (int i = 0; i < len; i++) {
          maxElements.add(0);
      }

    int count = 0;

    for (int i = len - 1; i >= 0; i--) {
      if (A.get(i) > maxFromRight) {
        maxFromRight = A.get(i);
        maxElements.set(count++, maxFromRight);
      }
    }

      for (int i = 0; i < count; i++) {
          res.add(maxElements.get(i));
      }

    return res;
  }
}

/*
Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

NOTE: The rightmost element is always a leader.
 */
