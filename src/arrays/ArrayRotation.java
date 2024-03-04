package arrays;

public class ArrayRotation {

  void reverse(int[] A, int start, int end) {
    int i, j;
    for (i = start, j = end; i < j; i++, j--) {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
    }
  }

  public int[] solve(int[] A, int B) {
    int n = A.length;
    B = B % n;
    reverse(A, 0, n - 1);
    reverse(A, 0, B - 1);
    reverse(A, B, n - 1);
    return A;
  }
}

/*
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
 */
