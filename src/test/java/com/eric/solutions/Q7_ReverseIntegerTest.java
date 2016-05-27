package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q7_ReverseIntegerTest
{
  private Q7_ReverseInteger testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q7_ReverseInteger();
  }
  
  @Test
  public void testReverse()
  {
    assertEquals(0, testSubject.reverse(0));
    assertEquals(321, testSubject.reverse(123));
    assertEquals(-321, testSubject.reverse(-123));
    assertEquals(0, testSubject.reverse(1000000003));
  }
}
