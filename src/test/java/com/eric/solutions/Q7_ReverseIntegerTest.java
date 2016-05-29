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
  public void testSingle()
  {
    assertEquals(1, testSubject.reverse(1));
  }
  
  @Test
  public void testReverse()
  {
    assertEquals(0, testSubject.reverse(0));
    assertEquals(1, testSubject.reverse(1));
    assertEquals(321, testSubject.reverse(123));
    assertEquals(-321, testSubject.reverse(-123));
    assertEquals(1, testSubject.reverse(100));
    assertEquals(0, testSubject.reverse(1000000003));
  }
  
  @Test
  public void testReverse_strVersion()
  {
    assertEquals(0, testSubject.reverseStr(0));
    assertEquals(321, testSubject.reverseStr(123));
    assertEquals(-321, testSubject.reverseStr(-123));
    assertEquals(1, testSubject.reverseStr(100));
    assertEquals(0, testSubject.reverseStr(1000000003));
  }
}
