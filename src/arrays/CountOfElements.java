package arrays;

import java.util.ArrayList;

public class CountOfElements {

  // Takes an Arraylist of numbers, and return the count
  public int solve(ArrayList<Integer> A) {

    int len = A.size();
    // Assume 0 is the greatest element found so far / U can also initialize to 1st element of the input
    int prevMax = 0, count = 0;

    // Iterate all the elements in the input
    for (int curr : A) {
      // If a num is greater than the prev max, update the count to 1 and store curr number as Max number
      if (curr > prevMax) {
        prevMax = curr;
        count = 1;
      } else if (curr == prevMax) { // If the curr is same as max number, increment the count
        count++;
      }
    } // End of this loop will give the count of occurrence of the biggest number in the array list

    return len - count; // Ignore the count from the length of the input array
  }
}

/*
Given an array A of N integers.
Count the number of elements that have at least 1 element greater than itself.
 */
