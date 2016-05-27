package com.eric.solutions;

/**
 * Question 342: Power of Four
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 1, 4, 16, 64, 256, 1024
 * 
 * 
 * @author Eric Leung
 *
 */
public class Q342_PowerOfFour
{
  public boolean isPowerOfFour(int num) 
  {
    int i = 0;
    
    while ( Math.pow(4, i) <= num )
    {
      if ( Math.pow(4, i) == num )
      {
        return true;
      }
      else
      {
        i++;
      }
    }
    
    return false;
  }
}
