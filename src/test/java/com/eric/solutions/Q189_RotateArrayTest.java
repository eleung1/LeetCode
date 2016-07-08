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
  
  @Before
  public void setup()
  {
    testSubject = new Q189_RotateArray();
    nums = new int[]{1,2,3,4,5,6,7};
    numsSize1 = new int[]{1};
    numsSize2 = new int[]{1,2};
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
  }
}
