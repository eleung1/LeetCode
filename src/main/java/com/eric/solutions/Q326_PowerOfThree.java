package com.eric.solutions;

/**
 * Question 326: Power of Three
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * @author Eric Leung
 * 
 */
public class Q326_PowerOfThree
{
  /**
   * 3^0 = 1
   * 3^1 = 3
   * 3^2 = 9
   * 3^3 = 27
   * 3^4 = 81
   * 3^5 = 243
   * 
   * @param n
   * @return
   */
  public boolean isPowerOfThree(int n) 
  {
    if ( n < 1 ) return false;
    if ( n == 1 ) return true;
    
    while ( n > 1 )
    {
      if ( n % 3 != 0 ) return false;
      n /= 3;
    }
    
    return true;
  }
  
  public boolean isPowerOfThreeRecursion(int n)
  {
    if ( n <= 0 ) return false;
    if ( n == 1 ) return true;
    if ( n % 3 != 0 ) return false;
    
    return isPowerOfThreeRecursion(n/3);
  }
}
