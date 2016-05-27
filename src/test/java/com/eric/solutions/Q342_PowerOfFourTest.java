package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q342_PowerOfFourTest
{
  private Q342_PowerOfFour testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q342_PowerOfFour();
  }
  
  @Test
  public void testIsPowerOfFour()
  {
    assertFalse(testSubject.isPowerOfFour(0));
    assertFalse(testSubject.isPowerOfFour(2));
    assertFalse(testSubject.isPowerOfFour(3));
    assertFalse(testSubject.isPowerOfFour(5));
    assertTrue(testSubject.isPowerOfFour(1));
    
    assertTrue(testSubject.isPowerOfFour(4));
    assertTrue(testSubject.isPowerOfFour(16));
  }
}
