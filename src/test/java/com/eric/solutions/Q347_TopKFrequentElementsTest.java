package com.eric.solutions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q347_TopKFrequentElementsTest
{
  private Q347_TopKFrequentElements testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q347_TopKFrequentElements();
  }
 
  @Test
  public void testTopKFrequent_givenNull_returnNull()
  {
    assertNull(testSubject.topKFrequent(null, 1));
  }
  
  @Test
  public void testTopKFrequeut_givenProperIntArray_returnTopKFrequent()
  {
    //Given [1,1,1,2,2,3] and k = 2, return [1,2].
    int[] arr = new int[]{1,1,1,2,2,3};
    
    List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2));
    assertEquals(expected, testSubject.topKFrequent(arr, 2));
    
    //Given [5,3,3,2,1,3,3,1] and k = 2, return [3,1].
    int[] arr2 = new int[]{5,3,3,2,1,3,3,1};
    List<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(3,1));
    assertEquals(expected2, testSubject.topKFrequent(arr2, 2));
  }
}
