package com.eric.solutions;

/**
 * Question 13: Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Eric Leung
 *
 */
public class Q13_RomanToInteger
{
  /**
   * Some rules:
   * I
   * II
   * III
   * IV
   * V
   * VI
   * VII
   * VIII
   * IX
   * X
   * 
   * Start with:
   * I 1
   * V 5
   * X 10
   * L 50
   * C 100
   * D 500
   * M 1000
   * 
   * I before V or X means 1 less
   * X before L or C means 10 less (i.e. 40 is XL
   * C before D or M means 100 less (i.e. 400 is CD, 900 is CM)
   * 
   * @param s
   * @return
   */
  public int romanToInt(String s) 
  {
    int result = 0;
    
    if ( s.startsWith("XL") )
    {
      result += 40 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("XC") )
    {
      result += 90 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("CD") )
    {
      result += 400 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("CM") )
    {
      result += 900 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("L") )
    {
      result += 50 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("C") )
    {
      result += 100 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("D") )
    {
      result += 500 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("M") )
    {
      result += 1000 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("IX"))
    {
      result += 9 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("X") )
    {
      result += 10 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("IV"))
    {
      result += 4 + romanToInt(s.substring(2));
    }
    else if ( s.startsWith("V"))
    {
      result += 5 + romanToInt(s.substring(1));
    }
    else if ( s.startsWith("I"))
    {
      result += 1 + romanToInt(s.substring(1));
    }
  
    return result;
  }
}
