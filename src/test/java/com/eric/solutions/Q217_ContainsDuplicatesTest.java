package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q217_ContainsDuplicatesTest
{
  private Q217_ContainsDuplicate testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q217_ContainsDuplicate();
  }
  
  @Test
  public void testContainsDuplicate()
  {
    assertTrue(testSubject.containsDuplicate(new int[]{1,1}));
    assertFalse(testSubject.containsDuplicate(new int[]{1,2}));
    assertTrue(testSubject.containsDuplicate(new int[]{1,2,1}));
  }
}   
