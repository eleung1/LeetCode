package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q326_PowerOfThreeTest
{
  private Q326_PowerOfThree testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q326_PowerOfThree();
  }
  
  @Test
  public void test()
  {
    assertTrue(testSubject.isPowerOfThree(1));
    assertTrue(testSubject.isPowerOfThree(3));
    assertTrue(testSubject.isPowerOfThree(9));
    assertTrue(testSubject.isPowerOfThree(27));
    assertTrue(testSubject.isPowerOfThree(81));
    assertTrue(testSubject.isPowerOfThree(243));
    
    assertFalse(testSubject.isPowerOfThree(-3));
    assertFalse(testSubject.isPowerOfThree(0));
    assertFalse(testSubject.isPowerOfThree(6));
    assertFalse(testSubject.isPowerOfThree(28));
    assertFalse(testSubject.isPowerOfThree(82));
    assertFalse(testSubject.isPowerOfThree(242));
  }
  
  @Test
  public void testRecursion()
  {
    assertTrue(testSubject.isPowerOfThreeRecursion(1));
    assertTrue(testSubject.isPowerOfThreeRecursion(3));
    assertTrue(testSubject.isPowerOfThreeRecursion(9));
    assertTrue(testSubject.isPowerOfThreeRecursion(27));
    assertTrue(testSubject.isPowerOfThreeRecursion(81));
    assertTrue(testSubject.isPowerOfThreeRecursion(243));
    
    assertFalse(testSubject.isPowerOfThreeRecursion(-3));
    assertFalse(testSubject.isPowerOfThreeRecursion(0));
    assertFalse(testSubject.isPowerOfThreeRecursion(6));
    assertFalse(testSubject.isPowerOfThreeRecursion(28));
    assertFalse(testSubject.isPowerOfThreeRecursion(82));
    assertFalse(testSubject.isPowerOfThreeRecursion(242));
  }
}
