package com.eric.solutions;

/**
 * Question 7: Reverse Integer
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * @author eleung
 *
 */
public class Q7_ReverseInteger
{
  public int reverse(int x) 
  {
    int i = x;
    int multiplyer = 1;
    if ( i < 0 )
    {
      i = i * -1;
      multiplyer = -1;
    }
    
    String s = Integer.toString(i);
    s = reverse(s);
    
    int result = 0;
    
    try
    {
      result = Integer.parseInt(s) * multiplyer;
    }
    catch (NumberFormatException e)
    {
      result = 0;
    }
    
    return result;
    
  }
  
  public String reverse(String s)
  {
    char[] arr = s.toCharArray();
    
    for ( int i = 0; i < arr.length / 2; i ++ )
    {
      char temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp; 
    }
    
    return new String(arr);
  }
}
