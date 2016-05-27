package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q1_TwoSumTest
{
  private Q1_TwoSum testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q1_TwoSum();
  }
  
  @Test
  public void testTwoSum_givenNull_returnNull()
  {
    assertNull(testSubject.twoSum(null, 1));
  }
  
  @Test
  public void testTwoSum_givenProperInput_returnTwoSum()
  {
    int[] arr = new int[]{2,7,11,15};
    
    assertArrayEquals(new int[]{0,1}, testSubject.twoSum(arr, 9));
    
    assertArrayEquals(new int[]{2,3}, testSubject.twoSum(arr, 26));
  }
}
