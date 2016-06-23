package com.eric.solutions;

import java.util.Arrays;

/**
 * Question 242: Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @author Eric Leung
 * 
 */
public class Q242_ValidAnagram
{
  public boolean isAnagram(String s, String t) 
  {
    if ( s == null || t == null ) return false;
    
    if ( s.length() != t.length() ) return false;
    
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    
    Arrays.sort(sArr);
    Arrays.sort(tArr);
    
    return Arrays.equals(sArr, tArr);
  }
}
