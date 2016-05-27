package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q3_LongestSubstringWithoutRepeatingCharactersTest
{
  private Q3_LongestSubstringWithoutRepeatingCharacters testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q3_LongestSubstringWithoutRepeatingCharacters();
  }
  
  @Test
  public void testLengthOfLongestSubstring_givenNull_returnZero()
  {
    assertEquals(0, testSubject.lengthOfLongestSubstring(null));
    assertEquals(0, testSubject.lengthOfLongestSubstring(""));
  }
  
  @Test
  public void testLengthOfLongestSubstring_givenProperString_returnLongestSubstringLength()
  {
    assertEquals(1, testSubject.lengthOfLongestSubstring("c"));
    assertEquals(2, testSubject.lengthOfLongestSubstring("au"));
    assertEquals(3, testSubject.lengthOfLongestSubstring("pwwkew"));
    assertEquals(1, testSubject.lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, testSubject.lengthOfLongestSubstring("abcabcbb"));
  }
}
