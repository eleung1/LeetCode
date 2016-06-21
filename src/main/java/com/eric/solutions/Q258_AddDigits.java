package com.eric.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Question 258: Add Digits
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint: A naive implementation of the above process is trivial. Could you come up with other methods? 
 * 
 * @author Eric Leung
 *
 */
public class Q258_AddDigits
{
  public int addDigits(int num)
  {
    if ( num < 10 ) return num;
    if ( num % 9 == 0 ) return 9;
    
    // extract individual digits
    List<Integer> digits = new LinkedList<Integer>();
    
    while ( num != 0 )
    {
      digits.add(num % 10);
      num /= 10;
    }
    
    // add them together
    int sum = 0;
    for ( int i : digits )
    {
      sum += i;
    }
    
    // see how many times does 9 goes into the sum
    int nineFactor = sum / 9;
    
    return sum - (9*nineFactor);
  }
  
  public int addDigitsNaive(int num) 
  {
    if ( num < 10 ) return num;
    
    List<Integer> digits = new LinkedList<Integer>();
    
    while ( num != 0 )
    {
      digits.add(num % 10);
      num /= 10;
    }
    
    int sum = 0;
    for ( int i : digits )
    {
      sum += i;
    }
    
    if ( sum < 10 ) 
    {   
      return sum;
    }
    else
    {
      return addDigits(sum);
    }
    
  }
}
