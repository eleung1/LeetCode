package com.eric.solutions;

/**
 * Question 171: Excel sheet column number
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 * 
 *    A -> 1
 *    B -> 2
 *    C -> 3
 *    ...
 *    Z -> 26
 *    AA -> 27
 *    AB -> 28 
 * 
 * @author Eric Leung
 *
 */
public class Q171_ExcelSheetColumnNumber
{
  /**
   * Idea: calculate it like it's in base 26.
   * 
   * A = (26^0) * 1 = 1
   * AA = (26^1) * 1 + (26^0) * 1 = 27
   * 
   * 
   * @param s
   * @return
   */
  public int titleToNumber(String s) 
  {
    if ( s == null || s.length() == 0 ) return 0;
    
    int result = 0;
    s=s.toUpperCase();
    char[] arr = s.toCharArray();
    for ( int i = 0; i < arr.length; i ++ )
    {
      // A is 65 in ASCII
      result += Math.pow(26, arr.length - 1 - i) * ((int)arr[i]-64);
    }
    
    return result;
  }
}
