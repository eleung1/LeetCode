package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q191_NumberOf1BitsTest
{
  private Q191_NumberOf1Bits testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q191_NumberOf1Bits();
  }
  
  @Test
  public void test()
  {
    assertEquals(1,testSubject.hammingWeight(1));
    assertEquals(1,testSubject.hammingWeight(2));
    assertEquals(2,testSubject.hammingWeight(3));
    assertEquals(3,testSubject.hammingWeight(11));
    assertEquals(5,testSubject.hammingWeight(31));
  }
}
