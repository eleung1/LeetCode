package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q169_MajorityElementTest
{
  private Q169_MajorityElement testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q169_MajorityElement();
  }
  
  @Test
  public void testMajorityElement_givenProperArray_returnMajorityElement()
  {
    assertEquals(1, testSubject.majorityElement(new int[]{1}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,1}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,1,2}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,2,1}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,1,1,2}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,1,1,2,2}));
    assertEquals(2, testSubject.majorityElement(new int[]{1,1,1,2,2,2}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,1,1,1,2,2,2}));
    assertEquals(1, testSubject.majorityElement(new int[]{1,2,1,1,2,1,2}));
  }
}
