package com.eric.solutions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class Q350_IntersectionOfTwoArrays2Test
{
  private Q350_IntersectionOfTwoArrays2 testSubject;
  private int[] arr1;
  private int[] arr2;
  private int[] arr3;
  private int[] arr4;
  
  @Before
  public void setup()
  {
    testSubject = new Q350_IntersectionOfTwoArrays2();
    arr1 = new int[]{1,2,2,1};
    arr2 = new int[]{2,2};
    arr3 = new int[]{1,2,3,3,3,4,5};
    arr4 = new int[]{2,3,3,4};
  }
  
  @Test
  public void testIntersection_givenNull_returnNull()
  {
    assertNull(testSubject.intersect(null, null));
    assertNull(testSubject.intersect(null, arr2));
    assertNull(testSubject.intersect(arr1, null));
    
    // Sorted version
    assertNull(testSubject.intersectSorted(null, null));
    assertNull(testSubject.intersectSorted(null, arr2));
    assertNull(testSubject.intersectSorted(arr1, null));
  }
  
  @Test
  public void testIntersection_givenProperArray_returnIntersection()
  {
    assertArrayEquals(new int[]{2,2}, testSubject.intersect(arr1, arr2));
    assertArrayEquals(new int[]{2,3,3,4}, testSubject.intersect(arr3, arr4));
    
    // Sorted version
    assertArrayEquals(new int[]{2,2}, testSubject.intersect(arr1, arr2));
    assertArrayEquals(new int[]{2,3,3,4}, testSubject.intersect(arr3, arr4));
  }
}
