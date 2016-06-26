package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q13_RomanToIntegerTest
{
  private Q13_RomanToInteger testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q13_RomanToInteger();
  }
  
  @Test
  public void test()
  {
    assertEquals(1, testSubject.romanToInt("I"));
    assertEquals(2, testSubject.romanToInt("II"));
    assertEquals(3, testSubject.romanToInt("III"));
    assertEquals(4, testSubject.romanToInt("IV"));
    
    assertEquals(5, testSubject.romanToInt("V"));
    assertEquals(6, testSubject.romanToInt("VI"));
    assertEquals(7, testSubject.romanToInt("VII"));
    assertEquals(8, testSubject.romanToInt("VIII"));
    
    assertEquals(9, testSubject.romanToInt("IX"));
    
    assertEquals(10, testSubject.romanToInt("X"));
    
    assertEquals(11, testSubject.romanToInt("XI"));
    assertEquals(12, testSubject.romanToInt("XII"));
    assertEquals(13, testSubject.romanToInt("XIII"));
    assertEquals(14, testSubject.romanToInt("XIV"));
    assertEquals(15, testSubject.romanToInt("XV"));
    assertEquals(16, testSubject.romanToInt("XVI"));
    assertEquals(17, testSubject.romanToInt("XVII"));
    assertEquals(18, testSubject.romanToInt("XVIII"));
    assertEquals(19, testSubject.romanToInt("XIX"));
    assertEquals(20, testSubject.romanToInt("XX"));
    
    assertEquals(21, testSubject.romanToInt("XXI"));
    assertEquals(24, testSubject.romanToInt("XXIV"));
    assertEquals(25, testSubject.romanToInt("XXV"));
    assertEquals(27, testSubject.romanToInt("XXVII"));
    assertEquals(29, testSubject.romanToInt("XXIX"));
    
    assertEquals(30, testSubject.romanToInt("XXX"));
    assertEquals(34, testSubject.romanToInt("XXXIV"));
    assertEquals(35, testSubject.romanToInt("XXXV"));
    assertEquals(37, testSubject.romanToInt("XXXVII"));
    assertEquals(39, testSubject.romanToInt("XXXIX"));
    
    assertEquals(40, testSubject.romanToInt("XL"));
    assertEquals(41, testSubject.romanToInt("XLI"));
    assertEquals(44, testSubject.romanToInt("XLIV"));
    assertEquals(45, testSubject.romanToInt("XLV"));
    assertEquals(47, testSubject.romanToInt("XLVII"));
    assertEquals(49, testSubject.romanToInt("XLIX"));
    
    assertEquals(50, testSubject.romanToInt("L"));
    assertEquals(59, testSubject.romanToInt("LIX"));
    
    assertEquals(60, testSubject.romanToInt("LX"));
    assertEquals(69, testSubject.romanToInt("LXIX"));
    
    assertEquals(70, testSubject.romanToInt("LXX"));
    assertEquals(79, testSubject.romanToInt("LXXIX"));
    
    assertEquals(80, testSubject.romanToInt("LXXX"));
    assertEquals(89, testSubject.romanToInt("LXXXIX"));
    
    assertEquals(90, testSubject.romanToInt("XC"));
    assertEquals(99, testSubject.romanToInt("XCIX"));
    
    assertEquals(501, testSubject.romanToInt("DI"));
    assertEquals(550, testSubject.romanToInt("DL"));
    
    assertEquals(707, testSubject.romanToInt("DCCVII"));
    
    assertEquals(900, testSubject.romanToInt("CM"));
    
    assertEquals(1800, testSubject.romanToInt("MDCCC"));
    
    assertEquals(3999, testSubject.romanToInt("MMMCMXCIX"));
  }
}
