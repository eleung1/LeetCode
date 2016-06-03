package com.eric.solutions;


/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a")        >> false
 * isMatch("aa","aa")       >> true
 * isMatch("aaa","aa")      >> false
 * isMatch("aa", "a*")      >> true
 * isMatch("aa", ".*")      >> true
 * isMatch("ab", ".*")      >> true
 * isMatch("aab", "c*a*b")  >> true
 * 
 * @author Eric Leung
 *
 */
public class Q10_RegularExpressionMatching
{
  /**
   * aa   = a1a1
   * a.   = a1.1
   * 
   * cccab = c3a1b1 
   * c*ab  = c*a1b1
   * 
   * cab    = c1a1b1
   * c*ccab = c*c2a1b1
   * 
   * aaa  = a3
   * a*   = a*
   * 
   * aaa  = a3
   * a*a  = a*a
   * 
   * 
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    if ( s == null || p == null ) return false;
    
    if ( s.equals(p) ) return true;
    
    if (s.isEmpty())
    {
      if ( p.length() == 1 ) return false;
      
      if ( p.length() == 2 ) 
      {
        if ( p.charAt(1) == '*' )
        {
          return true;
        }
        else
        {
          //return isMatch(s, p.substring(2));
          return false;
        }
      }
      
      if (p.length() > 2)
      {
        if ( p.charAt(1) == '*' ) return isMatch(s, p.substring(2));
      }
      
      if ( p.length() >= 2 && p.charAt(1) != '*' || p.charAt(p.length()-1) != '*') return false;
    }
    
    if ( p.isEmpty() ) return s.isEmpty();
    
    if ( p.length() == 1 && (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') ) return false;
    
    if ( p.charAt(p.length()-1) != '*' && p.charAt(p.length()-1) != '.' && p.charAt(p.length()-1) != s.charAt(s.length()-1))
      return false;
    
    if ( p.length() >=2 && p.charAt(1) == '*' )
    {
      if ( p.length() == 2 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' ) && s.length() == 1) return true;
      
      if ( isMatch(s, p.substring(2) ) )
      {
        return true;
      }
      else
      {
        for ( int i = 0; i < s.length(); i ++ )
        {
          if ( s.charAt(i) == p.charAt(0) || p.charAt(0) == '.' )
          {
            if (isMatch(s.substring(i+1), p.substring(2)) )
            {
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        
        return false;
      }
    }
    else
    {
      if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.' )
      {
        return isMatch(s.substring(1), p.substring(1));
      }
      else
      {
        return false;
      }

    }
  }
}
