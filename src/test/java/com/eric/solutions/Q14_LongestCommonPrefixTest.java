package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q14_LongestCommonPrefixTest
{
  private Q14_LongestCommonPrefix testSubject;
  private String[] strings1;
  private String[] strings2;
  
  @Before
  public void setup()
  {
    testSubject = new Q14_LongestCommonPrefix();
    
    strings1 = new String[]{"abc"};
    
    strings2 = new String[]{"abcd", "abc", "ab"};
  }
  
  @Test
  public void testLongestCommonPrefix_givenNull_returnEmptyString()
  {
    assertEquals("", testSubject.longestCommonPrefix(null));
  }
  
  @Test
  public void testLongestCommonPrefix_givenProperStrings_returnProperLongestSubstring()
  {
    assertEquals("abc", testSubject.longestCommonPrefix(strings1));
    assertEquals("ab", testSubject.longestCommonPrefix(strings2));
  }
}
