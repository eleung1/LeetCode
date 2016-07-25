package com.eric.solutions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q22_GenerateParenthesesTest
{
  private Q22_GenerateParentheses testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q22_GenerateParentheses();
  }
  
  @Test
  public void testGenerateParentheses_given0_returnEmptyList()
  {
    List<String> result = testSubject.generateParentheses(0);
    assertEquals(0, result.size());
  }
  
  // TODO: Work in progress
  //@Test
  public void testGenerateParentheses_given1_returnProperList()
  {
    assertArrayEquals(new String[]{"()"}, testSubject.generateParentheses(1).toArray(new String[0]));
    
    assertArrayEquals(new String[]{"()()","(())"}, testSubject.generateParentheses(2).toArray(new String[0]));
    
    List<String> result = testSubject.generateParentheses(3);
    List<String> expected = new ArrayList<String>(Arrays.asList(new String[]{"((()))","(()())","(())()","()(())","()()()"}));
    assertTrue(result.size() == expected.size() && result.containsAll(expected) && expected.containsAll(result));
    
    
    result = testSubject.generateParentheses(4);
    expected = new ArrayList<String>(Arrays.asList(new String[]{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"}));
    assertEquals(expected.size(), result.size());
    assertTrue(result.containsAll(expected) && expected.containsAll(result));
  }
}
