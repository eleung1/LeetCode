package com.eric.solutions;

/**
 * Question 191: Number of 1 bits
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer '11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author Eric Leung
 *
 */
public class Q191_NumberOf1Bits
{
  //you need to treat n as an unsigned value
  public int hammingWeight(int n) 
  {
    String s = Integer.toBinaryString(n);
    char[] arr = s.toCharArray();
    int count = 0;
    for ( char c: arr)
    {
      if ( c == '1' ) count ++;
    }
    
    return count;
  }
}
