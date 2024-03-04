package arrays.prefix_sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The BuyAndSellStock class provides a method to calculate the maximum profit that can be obtained
 * by buying and selling a stock from a given list of prices.
 */
public class BuyAndSellStock {

  /**
   * Calculates the maximum profit that can be obtained by buying and selling a stock.
   *
   * @param A The list of stock prices.
   * @return The maximum profit that can be obtained.
   */
  public int maxProfit(final List<Integer> A) {

    // Get the size of the input list
    int len = A.size();

    // Initialize variables to store the maximum profit and the current maximum price encountered
    int res = 0, currMax = Integer.MIN_VALUE;

    // Initialize an ArrayList to store the maximum prices encountered from each index onwards
    ArrayList<Integer> postfix = new ArrayList<>(Collections.nCopies(len, 0));

    // Calculate the maximum prices encountered from each index onwards
    for (int i = len - 1; i >= 0; i--) {
      currMax = Math.max(currMax, A.get(i));
      postfix.set(i, currMax);
    }

    // Calculate the maximum profit by finding the difference between the maximum price from the current index onwards
    // and the price at the current index, and then finding the maximum difference among all indices
      for (int i = 0; i < len; i++) {
          res = Math.max(res, postfix.get(i) - A.get(i));
      }

    // Return the maximum profit
    return res;
  }
}

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */
