package com.eric.solutions;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * 
 * @author Eric Leung
 *
 */
public class Q20_ValidParentheses
{
  /**
   * Idea: iterate through string, push open brackets onto stack.
   *       if we encouter a close bracket, pop stack and compare.
   *       if they match, continue.  other it is not valid.
   * 
   * @param s
   * @return
   */
  public boolean isValid(String s) 
  {
    if ( s == null ) return false;
    if ( s.length() == 0 || s.length() % 2 != 0 ) return false;
    
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<Character>();
    
    for ( int i = 0; i < arr.length; i ++ )
    {
      if ( arr[i] == '(' || arr[i] == '{' || arr[i] == '[')
      {
        stack.push(arr[i]);
      }
      else
      {
        if ( stack.isEmpty() ) return false;
        char openBracket = stack.pop().charValue();
        if ( openBracket != '(' && arr[i] == ')' ||
             openBracket != '{' && arr[i] == '}' ||
             openBracket != '[' && arr[i] == ']' ) return false;
      }
    }
    
    return stack.isEmpty();
  }
}
