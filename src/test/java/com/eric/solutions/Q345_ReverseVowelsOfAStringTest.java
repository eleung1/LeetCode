package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q345_ReverseVowelsOfAStringTest
{
  private Q345_ReverseVowelsOfAString testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q345_ReverseVowelsOfAString();
  }
  
  @Test
  public void testReverseVowels_givenNull_returnNull()
  {
    assertNull(testSubject.reverseVowels(null));
  }
  
  @Test
  public void testReverseVowels_givenEmpty_returnEmpty()
  {
    assertEquals("", testSubject.reverseVowels(""));
  }
  
  @Test
  public void testReverseVowels_givenProperString_returnStringWithReverseVowels()
  {
    assertEquals("holle", testSubject.reverseVowels("hello"));
    assertEquals("hOllo WErld", testSubject.reverseVowels("hEllo WOrld"));
    assertEquals("aHA", testSubject.reverseVowels("AHa"));
  }
}
