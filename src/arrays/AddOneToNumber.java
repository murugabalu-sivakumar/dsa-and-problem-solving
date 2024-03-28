package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment
 * the number represented by the digits ).
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class AddOneToNumber {

  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    int len = A.size();

    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i < len; i++) {
      // Logic to remove leading 0's in the input
      if (A.get(i) == 0 && res.isEmpty()) {
        continue;
      }

      res.add(A.get(i));
    }

    len = res.size();

    // Traverse thru the number from the end
    for (int i = len - 1; i >= 0; i--) {
      // If the number is 9 - Set its digit to 0 and proceed further
      if (res.get(i) == 9) {
        res.set(i, 0);
      } else { // When it is non-zero add 1 to it and return the result
        res.set(i, res.get(i) + 1);
        return res;
      }
    }

    // When the number is all 9's it comes here, so add 1 to most significant position and fill all 0's (999 to be returned as 1000)
    res = new ArrayList<>(Collections.nCopies(len + 1, 0));
    res.set(0, 1);

    return res;
  }
}
