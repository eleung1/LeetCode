package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q121_BestTimeToBuyAndSellStockTest
{
  private Q121_BestTimeToBuyAndSellStock testSubject;
  private int[] prices = new int[]{1};
  private int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
  private int[] prices2 = new int[]{7, 6, 5, 4, 3, 2, 1};
  
  @Before
  public void setup()
  {
    testSubject = new Q121_BestTimeToBuyAndSellStock();
  }
  
  @Test
  public void test()
  {
    assertEquals(0, testSubject.maxProfit(null));
    assertEquals(0, testSubject.maxProfit(prices));
    assertEquals(5, testSubject.maxProfit(prices1));
    assertEquals(0, testSubject.maxProfit(prices2));
  }
  
  @Test
  public void testStackVersion()
  {
    assertEquals(0, testSubject.maxProfitWithStack(null));
    assertEquals(0, testSubject.maxProfitWithStack(prices));
    assertEquals(5, testSubject.maxProfitWithStack(prices1));
    assertEquals(0, testSubject.maxProfitWithStack(prices2));
  }
}
