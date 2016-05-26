package com.eric.solutions;

/**
 * Question 344: Reverse String
 * 
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * @author Eric Leung
 * 
 */
public class Q344_ReverseString
{
  public String reverseString(String s)
  {
    if (s == null) return null;

    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length / 2; i++)
    {
      char temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }

    return new String(arr);
  }
}
