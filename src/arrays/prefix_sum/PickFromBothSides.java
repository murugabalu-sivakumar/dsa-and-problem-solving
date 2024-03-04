package arrays.prefix_sum;

import java.util.ArrayList;

public class PickFromBothSides {

  public int solve(ArrayList<Integer> A, int B) {

    int len = A.size(), currSum = 0, res = Integer.MIN_VALUE;

    ArrayList<Integer> prefix = new ArrayList<>();
    ArrayList<Integer> postfix = new ArrayList<>();

    int sum = 0;

    prefix.add(0);

    for (int i = 0; i < len; i++) {
      sum += A.get(i);
      prefix.add(sum);
    }

    for (int i = 0; i < len; i++) {
      postfix.add(sum);
      sum -= A.get(i);
    }

    postfix.add(0);

    // System.out.println("Prefix: " + prefix);
    // System.out.println("Postfix: " + postfix);

    for (int i = 0; i <= B; i++) {
      currSum = 0;

      // Get i elements from prefix
      currSum += prefix.get(i);
      // getPrefixElements(prefix, i);

      // Get B-i elements from postfix
      currSum += postfix.get(len - (B - i));
      // getPostfixElements(postfix, B-i);

      // System.out.println("Curr Sum: " + currSum);
      res = Math.max(res, currSum);
    }

    return res;
  }

  // public int getPrefixElements(ArrayList<Integer> prefix, int noOfElements) {
  //     return prefix.get(noOfElements);
  // }

  // public int getPostfixElements(ArrayList<Integer> postfix, int noOfElements) {
  //     return postfix.get(postfix.size()-noOfElements-1);
  // }
}

/*
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.
 */
