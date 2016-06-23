package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q171_ExcelSheetColumnNumberTest
{
  private Q171_ExcelSheetColumnNumber testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q171_ExcelSheetColumnNumber();
  }
 
  @Test
  public void testTitleToNumber()
  {
    assertEquals(1,testSubject.titleToNumber("A"));
    assertEquals(2,testSubject.titleToNumber("B"));
    assertEquals(3,testSubject.titleToNumber("C"));
    assertEquals(26,testSubject.titleToNumber("Z"));
    assertEquals(27,testSubject.titleToNumber("AA"));
    assertEquals(28,testSubject.titleToNumber("AB"));
  }
}
