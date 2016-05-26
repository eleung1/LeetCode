package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q344_ReverseStringTest
{
  private Q344_ReverseString testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q344_ReverseString();
  }
  
  @Test
  public void testReverseString_givenNull_returnNull()
  {
    assertNull(testSubject.reverseString(null));
  }
  
  @Test
  public void testReverseString_givenEmptyString_returnEmptyString()
  {
    assertEquals("", testSubject.reverseString(""));
  }
  
  @Test
  public void testReverseString_givenProperString_returnReversedString()
  {
    // length 1
    assertEquals("a", testSubject.reverseString("a"));
    
    // Even length: 4
    assertEquals("ekac", testSubject.reverseString("cake"));
    
    // Odd length: 5
    assertEquals("olleh", testSubject.reverseString("hello"));
  }
}
