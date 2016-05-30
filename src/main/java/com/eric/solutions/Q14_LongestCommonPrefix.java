package com.eric.solutions;

/**
 * Question 14: Longest Common Prefix.
 * 
 * Write a function to find the longest common prefix string amongst 
 * an array of strings.
 * 
 * @author Eric Leung
 *
 */
public class Q14_LongestCommonPrefix
{
  public String longestCommonPrefix(String[] strs) 
  {
    if ( strs == null || strs.length == 0 ) return "";
    if ( strs.length == 1 ) return strs[0];
    
    String s1 = strs[0];
    
    for ( int i = 0; i < s1.length(); i ++ )
    {
      char c = s1.charAt(i);
      
      for ( int j = 0; j < strs.length; j ++ )
      {
        if ( strs[j].length() <= i || strs[j].charAt(i) != c )
        {
          return strs[j].substring(0, i);
        }
      }
    }
    
    return s1;
  }
}
