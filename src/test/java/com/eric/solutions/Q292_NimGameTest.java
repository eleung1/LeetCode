package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q292_NimGameTest
{
  private Q292_NimGame testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new Q292_NimGame();
  }
  
  @Test
  public void testCanWinNim_givenNoStones_returnFalse()
  {
    assertFalse(testSubject.canWinNim(0));
  }
  
  @Test
  public void testCanWinNum_givenLessThan4Stones_returnTrue()
  {
    assertTrue(testSubject.canWinNim(1));
    assertTrue(testSubject.canWinNim(2));
    assertTrue(testSubject.canWinNim(3));
  }
  
  @Test
  public void testCanWinNum()
  {
    assertFalse(testSubject.canWinNim(4));
    assertTrue(testSubject.canWinNim(5));
    assertTrue(testSubject.canWinNim(6));
    assertTrue(testSubject.canWinNim(7));
    assertFalse(testSubject.canWinNim(8));
  }
}
