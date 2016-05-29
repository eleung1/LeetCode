package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Q9_PalindromeNumberTest
{
  private Q9_PalindromeNumber testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q9_PalindromeNumber();
  }
  
  @Test
  public void testIsPalindrome()
  {
    assertTrue(testSubject.isPalindrome(1));
    assertTrue(testSubject.isPalindrome(11));
    assertTrue(testSubject.isPalindrome(121));
    
    assertFalse(testSubject.isPalindrome(-1));
    assertFalse(testSubject.isPalindrome(-2147447412));
  }
  
  @Test
  public void testReverseInt()
  {
    assertEquals(0, testSubject.reverse(0));
    assertEquals(1, testSubject.reverse(1));
    assertEquals(321, testSubject.reverse(123));
    assertEquals(-321, testSubject.reverse(-123));
    assertEquals(1, testSubject.reverse(100));
    
    try
    {
      assertEquals(0, testSubject.reverse(1000000003));
      Assert.fail("Overflow, Arithmetic exception was not thrown");
    }
    catch( ArithmeticException e )
    {
      
    }
  }
}
