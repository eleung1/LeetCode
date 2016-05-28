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
  /**
   * Extract the digits one by one from right to left.
   * Then reconstruct the integer in reverse.
   * 
   * 123 = 100 + 23 + 3
   * 
   * 123      % 10   = 3   |  3 / 1 = 3     | while check:(123 / 10 = 12)  
   * 123-3    % 100  = 20  |  20 / 10 = 2   | while check:(120 / 100 = 1)
   * 123-3-20 % 1000 = 100 |  100 / 100 = 1 | while check:(100 / 1000 = 0)
   * 
   * @param x The given integer
   * @return The reversed integer
   */
  public int reverse(int x)
  {  
    int power = 1;
    int result = 0;
    
    // Extract the digits and store them in reversed order
    while ( x / Math.pow(10, power) != 0 )
    {
      int remainder = (int) (x % Math.pow(10, power));
      x -= remainder;
      int digit = (int) (remainder / Math.pow(10, power-1)); 
      
      try
      {
        result = Math.addExact(Math.multiplyExact(result, 10), digit);
      }
      catch ( ArithmeticException e )
      {
        // integer overflow
        return 0;
      }
      
      power++;
    }
    
    return result;
  }
  
  /**
   * Convert x to string, reverse string, then convert it back to int.
   * 
   * @param x The given integer
   * @return The reversed integer
   */
  public int reverseStr(int x) 
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
  
  /**
   * Concise solution from a user on leetcode.com
   * 
   * @param x
   * @return
   */
  public int reverseConcise(int x){
    long r = 0;
    while(x != 0){
        r = r*10 + x%10;
        x /= 10;
    }
    if(r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
        return (int)r;
    else
        return 0;
  }
}
