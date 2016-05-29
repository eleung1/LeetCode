package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q8_StringToIntegerTest
{
  private Q8_StringToInteger testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q8_StringToInteger();
  }
  
  @Test
  public void testMyAtoi_givenInvalidArgument_return0()
  {
    assertEquals(0, testSubject.myAtoi(null));
    assertEquals(0, testSubject.myAtoi("a"));
    assertEquals(0, testSubject.myAtoi(""));
  }
  
  @Test
  public void testMyAtoi_givenProperString_returnProperInt()
  {
    assertEquals(1, testSubject.myAtoi("1"));
    assertEquals(123, testSubject.myAtoi("123"));
    assertEquals(-123, testSubject.myAtoi("-123"));
    assertEquals(1, testSubject.myAtoi("+1"));
    assertEquals(1, testSubject.myAtoi("1a"));
    assertEquals(-12, testSubject.myAtoi("  -0012a42"));
    assertEquals(2147483647, testSubject.myAtoi("2147483648"));
    assertEquals(-2147483648, testSubject.myAtoi("-2147483648"));
    assertEquals(2147483647, testSubject.myAtoi("9223372036854775809"));
  }
}
