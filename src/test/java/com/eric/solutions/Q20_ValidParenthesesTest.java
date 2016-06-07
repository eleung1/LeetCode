package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q20_ValidParenthesesTest
{
  private Q20_ValidParentheses testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q20_ValidParentheses();
  }
  
  @Test
  public void testIsValid_givenNull_returnNull()
  {
    assertFalse(testSubject.isValid(null));
    
    assertFalse(testSubject.isValid(""));
  }
  
  @Test
  public void testIsValid_givenValidParentheses_returnProperResponse()
  {
    assertTrue(testSubject.isValid("()"));
    assertTrue(testSubject.isValid("{}"));
    assertTrue(testSubject.isValid("[]"));
    assertTrue(testSubject.isValid("()[]{}"));
    assertTrue(testSubject.isValid("()()()()()()()()()()()"));
    
    assertFalse(testSubject.isValid("(]"));
    assertFalse(testSubject.isValid("([)]"));
    assertFalse(testSubject.isValid("()()()()()(})()()()()()"));
  }
}
