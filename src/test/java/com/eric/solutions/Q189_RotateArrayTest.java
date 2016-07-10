package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q189_RotateArrayTest
{
  private Q189_RotateArray testSubject;
  private int[] nums;
  private int[] numsSize1;
  private int[] numsSize2;
  private int[] numsSize6;
 
  @Before
  public void setup()
  {
    testSubject = new Q189_RotateArray();
    nums = new int[]{1,2,3,4,5,6,7};
    numsSize1 = new int[]{1};
    numsSize2 = new int[]{1,2};
    numsSize6 = new int[]{1,2,3,4,5,6};
  }
  
  @Test
  public void test()
  {
    testSubject.rotate(numsSize1, 1);
    assertArrayEquals(new int[]{1}, numsSize1);
    
    testSubject.rotate(nums, 3);
    assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    
    testSubject.rotate(numsSize2, 3);
    assertArrayEquals(new int[]{2,1}, numsSize2);
    
    testSubject.rotate(numsSize6, 2);
    assertArrayEquals(new int[]{5,6,1,2,3,4}, numsSize6);
  }
  
  @Test
  public void testWithBubbleUp()
  {
    
    testSubject.rotateBubbleUp(numsSize1, 1);
    assertArrayEquals(new int[]{1}, numsSize1);
    
    testSubject.rotateBubbleUp(nums, 3);
    assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    
    testSubject.rotateBubbleUp(numsSize2, 3);
    assertArrayEquals(new int[]{2,1}, numsSize2);
    
    testSubject.rotateBubbleUp(numsSize6, 2);
    assertArrayEquals(new int[]{5,6,1,2,3,4}, numsSize6);
    
  }
  
  @Test
  public void testWithReverse()
  {
    
    testSubject.rotateWithReverse(numsSize1, 1);
    assertArrayEquals(new int[]{1}, numsSize1);
    
    testSubject.rotateWithReverse(nums, 3);
    assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    
    testSubject.rotateWithReverse(numsSize2, 3);
    assertArrayEquals(new int[]{2,1}, numsSize2);
    
    testSubject.rotateWithReverse(numsSize6, 2);
    assertArrayEquals(new int[]{5,6,1,2,3,4}, numsSize6);
    
  }
  
  @Test
  public void testReverseHelper()
  {
    testSubject.reverseHelper(nums, 0, nums.length);
    assertArrayEquals(new int[]{7,6,5,4,3,2,1}, nums);
    
    testSubject.reverseHelper(numsSize1, 0, numsSize1.length);
    assertArrayEquals(new int[]{1}, numsSize1);
    
    testSubject.reverseHelper(numsSize2, 0, numsSize2.length);
    assertArrayEquals(new int[]{2,1}, numsSize2);
    
  }
  
  @Test
  public void testReverseHelper2()
  {
    int[] myNums = new int[]{1,2,3,4,5,6,7};
    testSubject.reverseHelper(myNums, 0, 2);
    assertArrayEquals(new int[]{2,1,3,4,5,6,7}, myNums);
    
    myNums = new int[]{1,2,3,4,5,6,7};
    testSubject.reverseHelper(myNums, 0, 1);
    assertArrayEquals(new int[]{1,2,3,4,5,6,7}, myNums);
    
    myNums = new int[]{1,2,3,4,5,6,7};
    testSubject.reverseHelper(myNums, 1, 3);
    assertArrayEquals(new int[]{1,3,2,4,5,6,7}, myNums);
    
    myNums = new int[]{1,2,3,4,5,6,7};
    testSubject.reverseHelper(myNums, 4, 7);
    assertArrayEquals(new int[]{1,2,3,4,7,6,5}, myNums);
  }
}