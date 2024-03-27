package arrays.carryforward;

public class SpecialSequence {

  public int solve(String A) {

    int MOD = 1000 * 1000 * 1000 + 7;
    int aCount = 0, res = 0;

    for (int i = 0; i < A.length(); i++) {
        if (A.charAt(i) == 'A') {
            aCount++;
        } else if (A.charAt(i) == 'G') {
            res += aCount;
            res = res % MOD;
        }
    }

    return res;
  }
}

/*
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 */
