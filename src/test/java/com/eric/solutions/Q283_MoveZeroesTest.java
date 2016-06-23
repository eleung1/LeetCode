package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q283_MoveZeroesTest
{
  private Q283_MoveZeroes testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q283_MoveZeroes();
  }
  
  @Test
  public void testShiftLeft()
  {
    int[] arr = new int[]{0,2,3};
    testSubject.shiftLeft(arr, 0);
    assertArrayEquals(new int[]{2,3,0}, arr);
    
    
    int[] arr2 = new int[]{1,2,0,4,5,6};
    testSubject.shiftLeft(arr2, 2);
    assertArrayEquals(new int[]{1,2,4,5,6,0}, arr2);
  }
  
  @Test
  public void testMoveZeroes_givenNull_returnNull()
  {
    int[] arr = null;
    testSubject.moveZeroes(arr);
    assertNull(arr);
  }
  
  @Test
  public void testMoveZeroes_givenProperArray_returnProperArray()
  {
    int[] arr = new int[]{0};
    testSubject.moveZeroes(arr);
    assertArrayEquals(new int[]{0}, arr);
    
    int[] arr1 = new int[]{1};
    testSubject.moveZeroes(arr1);
    assertArrayEquals(new int[]{1}, arr1);
    
    int[] noZeroesArr = new int[]{1,2};
    testSubject.moveZeroes(noZeroesArr);
    assertArrayEquals(new int[]{1,2}, noZeroesArr);
    
    int[] someZeroesArr = new int[]{0, 1, 0, 3, 12};
    testSubject.moveZeroes(someZeroesArr);
    assertArrayEquals(new int[]{1,3,12,0,0}, someZeroesArr);
    
    int[] arr2 = new int[]{0,0,1};
    testSubject.moveZeroes(arr2);
    assertArrayEquals(new int[]{1,0,0}, arr2);
  }
}
