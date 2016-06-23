package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q242_ValidAnagramTest
{
  private Q242_ValidAnagram testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q242_ValidAnagram();
  }
  
  @Test
  public void testIsAnagram_cornerCases()
  {
    assertFalse(testSubject.isAnagram(null, null));
    
    assertFalse(testSubject.isAnagram("a", null));
    assertFalse(testSubject.isAnagram(null, "a"));
    
    assertTrue(testSubject.isAnagram("", ""));
    assertTrue(testSubject.isAnagram("a", "a"));
    
  }
  
  @Test
  public void testIsAnagram_givenProperStrings_returnProperResults()
  {
    assertTrue(testSubject.isAnagram("cat", "tac"));
    assertTrue(testSubject.isAnagram("cat", "tca"));
    assertFalse(testSubject.isAnagram("cat", "tcb"));
    assertTrue(testSubject.isAnagram("anagram", "nagaram"));
  }
}
