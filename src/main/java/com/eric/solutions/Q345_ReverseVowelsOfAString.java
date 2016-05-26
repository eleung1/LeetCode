package com.eric.solutions;

/**
 * Question 345: Reverse Vowels of a String
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * @author Eric Leung
 *
 */
public class Q345_ReverseVowelsOfAString
{
  public String reverseVowels(String s) 
  {
    if ( s == null ) return null;
    
    char[] arr = s.toCharArray();
    
    int frontPointer = 0;
    int rearPointer = arr.length - 1;
    
    while ( frontPointer < rearPointer )
    {
      if ( isVowel(arr[frontPointer]) && isVowel(arr[rearPointer]) )
      {
        char temp = arr[frontPointer];
        arr[frontPointer] = arr[rearPointer];
        arr[rearPointer] = temp;
        
        frontPointer++;
        rearPointer--;
      }
      else
      {
        if ( !isVowel(arr[frontPointer]) ) frontPointer++;
      
        if ( !isVowel(arr[rearPointer]) ) rearPointer--;
      }
      
    }
    
    return new String(arr);
  }
  
  private boolean isVowel(char c)
  {
    String vowels = "aeiouAEIOU";
    
    return vowels.indexOf(c) != -1;
  }
}
