package com.eric.solutions;

/**
 * Question 8: String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until 
 * the first non-whitespace character is found. Then, starting from this character, 
 * takes an optional initial plus or minus sign followed by as many numerical digits 
 * as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral 
 * number, which are ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral 
 * number, or if no such sequence exists because either str is empty or it contains 
 * only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the correct 
 * value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author Eric Leung
 *
 */
public class Q8_StringToInteger
{
  /**
   * "123"
   * 
   * 0 + 1 = 1
   * 10 + 2 = 12
   * 120 + 3 = 123
   * 
   * @param str Given a string of integers
   * @return The integer version of the str.
   */
  public int myAtoi(String str)
  {
    if ( str == null ) return 0;
    str = str.trim();
    if ( str.length() == 0 ) return 0;
    
    long result = 0;
    int startIndex = 0;
    char[] arr = str.toCharArray();
    if ( arr[0] == '-' || arr[0] == '+') startIndex +=1;
    for ( int i = startIndex; i < arr.length; i ++ )
    {
      int currInt = Character.getNumericValue(arr[i]);
      if ( currInt < 0 || currInt > 9 ) break;
      
      if ( arr[0] == '-' )
      {
        result = (result * 10) - Character.getNumericValue(arr[i]);
        if ( result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
      }
      else
      {
        result = (result * 10) + Character.getNumericValue(arr[i]);
        if ( result > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
      }
    }

    return (int) result;
  }
}
