package sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one
 * item at a time. It iterates over the input data, comparing each element with the elements before
 * it and moving it to its correct position.
 * <p>
 * Here's how insertion sort works:
 * <p>
 * It starts with the second element (index 1) of the array and compares it with the elements before
 * it. If the current element is smaller than the previous element, it swaps them, and continues to
 * compare and swap until the current element is in its correct position relative to the elements
 * before it. It repeats this process for each element in the array, gradually building up the
 * sorted array from left to right. Insertion sort is an efficient algorithm for sorting small
 * arrays or nearly sorted arrays, but it becomes less efficient as the size of the array increases.
 * Its time complexity is O(n^2) in the worst case, where n is the number of elements in the array.
 */
public class InsertionSort {

  /**
   * Sorts the given list of integers using the insertion sort algorithm. Insertion sort iterates
   * over the list and repeatedly swaps adjacent elements if they are in the wrong order, until the
   * entire list is sorted.
   *
   * @param A the list of integers to be sorted
   * @return the sorted list of integers
   */
  public static List<Integer> sort(List<Integer> A) {
    int len = A.size();

    // Iterate over the list
    for (int i = 1; i < len; i++) {
      // Iterate backwards from the current element
      for (int j = i - 1; j >= 0; j--) {
        // If the current element is greater than the next element, swap them
        if (A.get(j) > A.get(j + 1)) {
          int temp = A.get(j);
          A.set(j, A.get(j + 1));
          A.set(j + 1, temp);
        } else {
          // If the current element is in the correct position, break out of the loop
          break;
        }
      }
    }

    return A;
  }

  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(10, 20, 14, 15, 30, 12, 6);
    List<Integer> res = sort(nums);
    res.forEach(System.out::println);
  }
}
