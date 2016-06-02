package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q10_RegularExpressionMatchingTest
{
  private Q10_RegularExpressionMatching testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q10_RegularExpressionMatching();
  }
  
  @Test
  public void testIsMatch_givenNull_returnFalse()
  {
    assertFalse(testSubject.isMatch(null, null));
    assertFalse(testSubject.isMatch(null, "a"));
    assertFalse(testSubject.isMatch("a", null));
  }
  
  @Test
  public void testIsMatch_givenProperString_returnProperResult()
  {
    
    assertFalse(testSubject.isMatch("aa","a"));
    assertFalse(testSubject.isMatch("aaa","aa"));
    
    assertTrue(testSubject.isMatch("aa", "a."));
    assertTrue(testSubject.isMatch("aa","aa"));
    
    assertTrue(testSubject.isMatch("aba","a.."));
    
    assertTrue(testSubject.isMatch("a", "a*"));
    
    assertTrue(testSubject.isMatch("aa", "a*"));
    assertTrue(testSubject.isMatch("aaa", "a*"));
    
    assertTrue(testSubject.isMatch("ab", "c*a*b"));
    assertTrue(testSubject.isMatch("cab", "c*a*b"));
    
    assertFalse(testSubject.isMatch("cdab", "c*a*b"));
    
    assertTrue(testSubject.isMatch("a", "ab*"));
    
    assertFalse(testSubject.isMatch("ab", ".*c"));
    
    assertFalse(testSubject.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    
    assertFalse(testSubject.isMatch("baaabaacaacaacbca", "b*c*c*.*.*bba*b*"));
    
    
  }
}
