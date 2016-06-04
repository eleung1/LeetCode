package com.eric.solutions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q15_ThreeSumTest
{
  private Q15_ThreeSum testSubject;
  
  private int[] nums;
  private int[] nums2;
  private int[] lotsOfNums;
  
  @Before
  public void setup()
  {
    testSubject = new Q15_ThreeSum();
    
    nums = new int[]{-1, 0, 1, 2, -1, -4, -1, 4, 0};
    
    nums2 = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    
    lotsOfNums = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,
        1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,
        -9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,
        -7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
  }
  
  @Test
  public void testThreeSum_givenNull_returnNull()
  {
    assertEquals(0, testSubject.threeSum(null).size());
  }
  
  @Test
  public void testThreeSum_givenProperArray_returnProperTriplets()
  {
    List<List<Integer>> rc = testSubject.threeSum(nums);
    
    assertEquals(3, rc.size());
    
    List<Integer> list1 = rc.get(0);
    List<Integer> list2 = rc.get(1);
    List<Integer> list3 = rc.get(2);
    
    assertArrayEquals(new Integer[]{-4, 0, 4}, list1.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-1, -1, 2}, list2.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-1, 0, 1}, list3.toArray(new Integer[0]));
  }
  
  @Test
  public void testThreeSum_givenProperArray2_returnProperTriplets()
  {
    List<List<Integer>> rc = testSubject.threeSum(nums2);
    
    assertEquals(6, rc.size());
    
    List<Integer> list1 = rc.get(0);
    List<Integer> list2 = rc.get(1);
    List<Integer> list3 = rc.get(2);
    List<Integer> list4 = rc.get(3);
    List<Integer> list5 = rc.get(4);
    List<Integer> list6 = rc.get(5);
    
    assertArrayEquals(new Integer[]{-4, -2, 6}, list1.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-4, 0, 4}, list2.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-4, 1, 3}, list3.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-4, 2, 2}, list4.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-2, -2, 4}, list5.toArray(new Integer[0]));
    assertArrayEquals(new Integer[]{-2, 0, 2}, list6.toArray(new Integer[0]));
    
  }
  
  @Test
  public void testThreeSum_givenBigArray_returnProperTriplets()
  {
    long startTime = System.currentTimeMillis();
    List<List<Integer>> rc = testSubject.threeSum(lotsOfNums);
    long endTime = System.currentTimeMillis();
    System.out.println("Duration: " + (endTime - startTime));
    
    for ( List<Integer> list : rc)
    {
      System.out.println(list.get(0) + ", " + list.get(1) + ", " + list.get(2));
    }
  }
}
