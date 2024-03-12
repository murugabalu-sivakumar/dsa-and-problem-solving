package sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Selection sort is a simple sorting algorithm that works by repeatedly selecting the minimum
 * element from the unsorted portion of the array and moving it to the beginning of the array.
 * Here's how it works:
 * <p>
 * The algorithm divides the input array into two parts: the sorted portion and the unsorted
 * portion. Initially, the sorted portion is empty and the unsorted portion contains all elements of
 * the array.
 * <p>
 * In each iteration of the algorithm, it finds the minimum element from the unsorted portion of the
 * array.
 * <p>
 * Once the minimum element is found, it swaps it with the first element of the unsorted portion,
 * thereby moving it to the sorted portion.
 * <p>
 * After each iteration, the size of the sorted portion increases by one, and the size of the
 * unsorted portion decreases by one.
 * <p>
 * The algorithm continues this process until the entire array is sorted.
 * <p>
 * Selection sort has a time complexity of O(n^2) in the worst case, where n is the number of
 * elements in the array. Despite its simplicity, selection sort is inefficient for large arrays and
 * is mainly used for educational purposes or for sorting small arrays where other more efficient
 * sorting algorithms are not necessary.
 */
public class SelectionSort {

  /**
   * The sort method sorts the input list of integers in ascending order using selection sort
   * algorithm.
   *
   * @param A The list of integers to be sorted.
   * @return The sorted list of integers.
   */
  public static List<Integer> sort(List<Integer> A) {

    // Get the size of the input list
    int len = A.size();

    // Initialize a variable to store the index of the minimum element
    int minIndex = 0;

    // Iterate through the list using selection sort algorithm
    for (int i = 0; i < len; i++) {

      // Initialize the minIndex to the current index
      minIndex = i;

      // Find the index of the minimum element in the remaining unsorted portion of the list
      for (int j = i + 1; j < len; j++) {
        if (A.get(j) < A.get(minIndex)) {
          minIndex = j;
        }
      }

      // Swap the current element with the minimum element
      int temp = A.get(i);
      A.set(i, A.get(minIndex));
      A.set(minIndex, temp);
    }

    // Return the sorted list
    return A;
  }

  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(10, 20, 14, 15, 30, 12, 6);
    List<Integer> res = sort(nums);
    res.forEach(System.out::println);
  }
}
