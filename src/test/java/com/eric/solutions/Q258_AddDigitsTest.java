package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q258_AddDigitsTest
{
  private Q258_AddDigits testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q258_AddDigits();
  }
  
  @Test
  public void testAddDigits_givenNumLessThan10_returnNum()
  {
    assertEquals(0, testSubject.addDigits(0));
    assertEquals(5, testSubject.addDigits(5));
    assertEquals(9, testSubject.addDigits(9));
  }
  
  @Test
  public void testAddDigits_givenNumGreaterThan10_returnSumOfDigitsLessThan10()
  {
    assertEquals(1, testSubject.addDigits(10));
    assertEquals(4, testSubject.addDigits(22));
    assertEquals(1, testSubject.addDigits(55));
    assertEquals(9, testSubject.addDigits(99));
  }
}
