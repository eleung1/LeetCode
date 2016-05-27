package com.eric.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 3: Longest substring without repeating characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a 
 * substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Eric Leung
 *
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters
{
  public int lengthOfLongestSubstring(String s) 
  {
    if ( s == null || s.length() == 0) return 0;
    
    int longestLength = 1;
    
    for ( int i = 0; i < s.length(); i++ )
    {
      Set visited = new HashSet();
      visited.add(s.charAt(i));
      int currUniqueLength = 1;
      for ( int j = i + 1; j < s.length(); j++ )
      {
        if ( visited.contains(s.charAt(j)))
        {
          break;
        }
        else
        {
          visited.add(s.charAt(j));
          currUniqueLength++; 
        }
      }
      
      if ( currUniqueLength > longestLength ) longestLength = currUniqueLength;
    }
    
    return longestLength;
  }
}
