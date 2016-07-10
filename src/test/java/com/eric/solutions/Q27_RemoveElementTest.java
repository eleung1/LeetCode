package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q27_RemoveElementTest
{
  private Q27_RemoveElement testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q27_RemoveElement();
  }
  
  @Test
  public void test()
  {
    int[] nums = new int[]{3,2,2,3};
    assertEquals(2, testSubject.removeElement(nums, 3));
    assertArrayEquals(new int[]{2,2,3,3}, nums);
    
    nums = new int[]{2,2,3};
    assertEquals(1, testSubject.removeElement(nums, 2));
    assertArrayEquals(new int[]{3,2,2}, nums);
    
    nums = new int[]{0,4,4,0,4,4,4,0,2};
    assertEquals(4, testSubject.removeElement(nums, 4));
    assertArrayEquals(new int[]{0,2,0,0,4,4,4,4,4}, nums);
    
    nums = new int[]{4,2,0,2,2,1,4,4,1,4,3,2};
    assertEquals(8, testSubject.removeElement(nums, 4));
        
  }
}
