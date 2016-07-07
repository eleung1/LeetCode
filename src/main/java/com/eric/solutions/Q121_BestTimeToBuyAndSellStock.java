package com.eric.solutions;

import java.util.Stack;

/**
 * Question 121: Best Time to Buy and Sell Stock
 * 
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author Eric Leung
 * 
 */
public class Q121_BestTimeToBuyAndSellStock
{  
  
  /**
   * Optimized version.  O(n)
   * 
   * Idea: 
   * Given: [7, 1, 5, 3, 6, 4]
   * 
   * When we look at the nth element, we want to find the difference between it
   * and the max value of the rest:
   * 7 [1, 5, 3, 6, 4] max: 6
   *    1 [5, 3, 6, 4] max: 6
   *       5 [3, 6, 4] max: 6
   *          3 [6, 4] max: 6
   *             6 [4] max: 4
   * 
   * We can generate a stack of max element for the subarrays by iterating through the array backwards, and keep track of the 
   * current max:
   * 
   * 7, 1, 5, 3, 6, [4] max: 4
   * 7, 1, 5, 3, [6, 4] max: 6 
   * 7, 1, 5, [3, 6, 4] max: 6
   * 7, 1, [5, 3, 6, 4] max: 6
   * 7, [1, 5, 3, 6, 4] max: 6
   * 7, [1, 5, 3, 6, 4] max: 6
   * 
   * Now with this stack, we can iterate through the array and find the difference between the curr element and 
   * the popped top element of the stack.  The one with the biggest difference is our max profit.
   * 
   * @param prices
   * @return
   */
  public int maxProfitWithStack(int[] prices)
  {
    if ( prices == null || prices.length == 0 ) return 0;
    
    Stack<Integer> maxPriceStack = new Stack<Integer>();
    
    // Generate our stack of max values from back to front 
    // no need to look at 0th element because that's day 0 and we can only buy on day 0
    int max = 0;
    for ( int i = prices.length-1; i > 0; i-- )
    {
      if ( prices[i] > max ) max = prices[i];
      maxPriceStack.push(max);
    }
    
    int maxProfit = 0;
    // no need to look at the last entry because you cannot make a profit by buying on that day (we have no data on the next day)
    for ( int i = 0; i < prices.length-1; i++ )
    {
      int currProfit = maxPriceStack.pop() - prices[i];
      if ( currProfit > maxProfit ) maxProfit = currProfit;
    }
    
    return maxProfit;
  }
  
  /**
   * Naive solution.  O(n^2)
   * Not accepted by LeetCode.com
   * 
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) 
  {
    if ( prices == null || prices.length == 0 ) return 0;
    
    int maxProfit = 0;
    
    for ( int i = 0; i < prices.length; i ++ )
    {
      for ( int j = i + 1; j < prices.length; j ++ )
      {
        int currProfit = prices[j] - prices[i]; 
        if ( currProfit > maxProfit )
        {
          maxProfit = currProfit;
        }
      }
    }
    
    return maxProfit;
  }
  
}
