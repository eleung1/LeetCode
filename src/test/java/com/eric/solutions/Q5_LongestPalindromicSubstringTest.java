package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q5_LongestPalindromicSubstringTest
{
  private Q5_LongestPalindromicSubstring testSubject;
  private char[] arr;
  private String longString;
  
  @Before
  public void setup()
  {
    testSubject = new Q5_LongestPalindromicSubstring();
    arr = new char[]{'a', 'b', 'C', 'D', 'z', 'D', 'C', 'b', 'a'};
    longString = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
  }
  
  @Test
  public void testIsPalindrome_givenNull_returnFalse()
  {
    assertFalse(testSubject.isPalindrome(null));
    assertFalse(testSubject.isPalindrome(null, 0, arr.length));
  }
  
  @Test
  public void testIsPalindrome_givenProperString_returnProperResponse()
  {
    assertTrue(testSubject.isPalindrome("a"));
    assertTrue(testSubject.isPalindrome("aa"));
    assertTrue(testSubject.isPalindrome("aaa"));
    assertTrue(testSubject.isPalindrome("abcba"));
    assertTrue(testSubject.isPalindrome("abCDzDCba"));
    
    assertFalse(testSubject.isPalindrome("ab"));
    assertFalse(testSubject.isPalindrome("abc"));
    assertFalse(testSubject.isPalindrome("Hello World"));
    
  }
  
  @Test
  public void testIsPalindrome_givenProperCharArray_returnProperResponse()
  {
    assertTrue(testSubject.isPalindrome(arr, 0, arr.length-1));
    assertFalse(testSubject.isPalindrome(arr, 1, arr.length-1));
    assertTrue(testSubject.isPalindrome(arr, 2, 6));
  }
  
  @Test
  public void testLongestPalindrome_givenNull_returnNull()
  {
    assertNull(testSubject.longestPalindrome(null));
  }
  
  @Test
  public void testLongestPalindrome_givenProperString_returnProperLongestPalindrome()
  {
    // The whole string is a palindrome
    assertEquals("a", testSubject.longestPalindrome("a"));
    assertEquals("aa", testSubject.longestPalindrome("aa"));
    assertEquals("aaa", testSubject.longestPalindrome("aaa"));
    assertEquals("abcba", testSubject.longestPalindrome("abcba"));
    assertEquals("abCDzDCba", testSubject.longestPalindrome("abCDzDCba"));
    
    // Palindrome in the middle
    assertEquals("aaa", testSubject.longestPalindrome("bqaaazz"));
    assertEquals("aba", testSubject.longestPalindrome("bqtyabaoozz"));
    
    // Palindrome in the front
    assertEquals("tttt", testSubject.longestPalindrome("ttttbqaaazz"));
    assertEquals("ttttttt", testSubject.longestPalindrome("tttttttbqtyabaoozz"));
    
    // Palindrome in the back
    assertEquals("ooooooo", testSubject.longestPalindrome("ttttbqaaazzooooooo"));
    assertEquals("oooooooo", testSubject.longestPalindrome("tttttttbqtyabaoozzoooooooo"));
    
    // Long string
    assertEquals("gykrkyg", testSubject.longestPalindrome(longString));
  }
}
