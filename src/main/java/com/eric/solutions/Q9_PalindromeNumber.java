package com.eric.solutions;

/**
 * Question 9: Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1): 
 *   Assumption: No, negative integers are not palindromes
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. How would you handle such case?
 *   Assumption: Overflow are not treated as palindromes.
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author Eric Leung
 *
 */
public class Q9_PalindromeNumber
{
  public boolean isPalindrome(int x) 
  {
    boolean result = false;
    
    if ( x < 0 ) return false;
    
    try
    {
      result = x == reverse(x);
    }
    catch ( ArithmeticException e)
    {
      return false;
    }
    
    return result;
  }
  
  public int reverse(int x)
  {
    long result = 0;
    
    while ( x != 0 )
    {
      result = result * 10 + x % 10;
      x /= 10;
    }
    
    if ( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE )
      throw new ArithmeticException();
    
    return (int) result;
  }
}
