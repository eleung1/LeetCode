package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q141_LinkedListCycle.ListNode;

public class Q141_LinkedListCycleTest
{
  private Q141_LinkedListCycle testSubject;
  private ListNode headNoCycle;
  private ListNode headWithCycle;
  
  @Before
  public void setup()
  {
    testSubject = new Q141_LinkedListCycle();
    
    headNoCycle = testSubject.new ListNode(1);
    headNoCycle.next = testSubject.new ListNode(2);
    headNoCycle.next.next = testSubject.new ListNode(3);
    
    headWithCycle = testSubject.new ListNode(1);
    ListNode node2 = testSubject.new ListNode(2);
    headWithCycle.next = node2; 
    headWithCycle.next.next = testSubject.new ListNode(3);
    headWithCycle.next.next.next = node2; // cycle!
  }
  
  @Test
  public void test()
  {
    assertFalse(testSubject.hasCycle(null));
    assertFalse(testSubject.hasCycle(headNoCycle));
    assertTrue(testSubject.hasCycle(headWithCycle));
  }
  
  @Test
  public void testTwoPointers()
  {
    assertFalse(testSubject.hasCycleTwoPointers(null));
    assertFalse(testSubject.hasCycleTwoPointers(headNoCycle));
    assertTrue(testSubject.hasCycleTwoPointers(headWithCycle));
  }
}
