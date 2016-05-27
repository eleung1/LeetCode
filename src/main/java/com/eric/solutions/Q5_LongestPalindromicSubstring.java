package com.eric.solutions;

/**
 * Question 5: Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * 
 * @author Eric Leung
 *
 */
public class Q5_LongestPalindromicSubstring
{
  /**
   * Optimized for the problem's assumption of max String length 1000.
   * 
   * @param s The given String, max length 1000.
   * @return The longest palindromic substring
   */
  public String longestPalindrome(String s)
  {
    if ( s == null || s.length() > 1000) return null;
    
    char[] arr = s.toCharArray();
    // Examine the substrings of different lengths, starting at string length
    int currLength = arr.length;
    
    while ( currLength > 0 )
    {
      for ( int i = 0; i < arr.length; i ++ )
      {
        if ( i + currLength > arr.length ) 
        {
          break;
        }
        
        if ( isPalindrome(arr, i, i+currLength-1) ) 
        {
          return new String(arr, i, currLength);
        }
      }
      
      currLength--;
    }
    
    return null;
  }
  
  /**
   * Helper method to check if a sub-portion of the given char array is a palindrome
   * 
   * @param arr The char array
   * @param startIndex Start index inclusive
   * @param endindex End index inclusive
   * @return True if the characters between startIndex and endIndex represents a palindrome.
   */
  public boolean isPalindrome(char[] arr, int startIndex, int endIndex)
  {
    if ( arr == null ) return false;
    
    while ( startIndex < endIndex )
    {
      if ( arr[startIndex] != arr[endIndex] )
      {
        return false;
      }
      
      startIndex++;
      endIndex--;
    }
    
    return true;
  }
  
  /**
   * Non-optimized version.
   * 
   * Also note that substring() was O(1) prior to Java 7 update 6.  It used to create a new String
   * with the same underlying char[] with a different offset and length.
   * 
   * However, with Java 7 update 6, substring() now copies all chars to a new String which is O(n).
   * 
   * @param s
   * @return
   */
  public String longestPalindromeNonOptimized(String s) 
  {
    if ( s == null ) return null;
    
    String longestPalindrome = "";
    
    for ( int i = 0; i <= s.length(); i ++ )
    {
      for ( int j = i+1; j <= s.length(); j ++ )
      {
        if ( j - i > longestPalindrome.length() )
        {
          String substring = s.substring(i, j);
          if ( isPalindrome(substring) )
          {
            longestPalindrome = substring;
          }
        }
      }
    }
    return longestPalindrome;
  }
  
  /**
   * Helper method to check if a string is a palindrome
   * 
   * @param s The given String
   * @return True if s is a palindrome.  False otherwise.
   */
  public boolean isPalindrome(String s)
  {
    if ( s == null ) return false;
    
    char[] arr = s.toCharArray();
    
    for ( int i = 0; i < arr.length / 2; i ++ )
    {
      if ( arr[i] != arr[arr.length - i - 1] )
        return false;
    }
    
    return true;
  }
  
}
