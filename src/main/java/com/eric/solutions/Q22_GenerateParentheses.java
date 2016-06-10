package com.eric.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question 22: Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 
 * @author Eric Leung
 *
 */
public class Q22_GenerateParentheses
{
  public List<String> generateParentheses(int n)
  {
    List<String> result = new ArrayList<String>();
    
    if ( n <= 0 ) return result;
    
    if ( n == 1 )
    {
      result.add("()");
      return result;
    }
    
    List<String> prevResults = generateParentheses(n-1);
    Set<String> currResults = new HashSet<String>();
    for ( String s : prevResults )
    {
      currResults.add("()" + s);
      currResults.add(s + "()");
      currResults.add("(" + s + ")");
    }
    
    result.addAll(currResults);
    return result;
  }
  
  
  
  public List<String> generateParenthesesNaive(int n) 
  {
    List<String> result = new ArrayList<String>();
    Set<String> resultSet = new HashSet<String>();
    
    if ( n == 0 ) return result;
    
    char[] arr = new char[n*2];
    
    for ( int i = 0 ; i < arr.length; i ++ )
    {
      arr[i] = i < n ? '(' : ')';
    }
    
    String baseCase = new String(arr);
    
    resultSet.add(baseCase);
    
    int forwardIndex = n-1;
    while ( forwardIndex < arr.length - 2)
    {
      char temp = arr[forwardIndex];
      arr[forwardIndex] = arr[forwardIndex+1];
      arr[forwardIndex+1] = temp;
      forwardIndex++;
      
      resultSet.add(new String(arr));
    }
    
    arr = baseCase.toCharArray();
    int backIndex = n;
    while ( backIndex > 1)
    {
      char temp = arr[backIndex];
      arr[backIndex] = arr[backIndex-1];
      arr[backIndex-1] = temp;
      backIndex--;
      
      resultSet.add(new String(arr));
    }
    
    for ( int i = 0; i < arr.length; i ++ )
    {
      arr[i] = i%2==0 ? '(' : ')';
    }
    resultSet.add(new String(arr));
    
    for ( String s: resultSet)
    {
      result.add(s);
    }
    
    return result;
  }
}
