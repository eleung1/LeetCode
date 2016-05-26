package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q349_IntersectionOfTwoArraysTest
{
  private Q349_IntersectionOfTwoArrays testSubject;
  private int[] arr1;
  private int[] arr2;
  private int[] arr3;
  private int[] arr4;
  
  @Before
  public void setup()
  {
    testSubject = new Q349_IntersectionOfTwoArrays();
    arr1 = new int[]{1,2,2,1};
    arr2 = new int[]{2,2};
    arr3 = new int[]{1,2,3,4,5};
    arr4 = new int[]{2,3,4};
  }
  
  @Test
  public void testIntersection_givenNull_returnNull()
  {
    assertNull(testSubject.intersection(null, null));
    assertNull(testSubject.intersection(null, arr2));
    assertNull(testSubject.intersection(arr1, null));
  }
  
  @Test
  public void testIntersection_givenProperArray_returnIntersection()
  {
    assertArrayEquals(new int[]{2}, testSubject.intersection(arr1, arr2));
    assertArrayEquals(new int[]{2,3,4}, testSubject.intersection(arr3, arr4));
  }
}
