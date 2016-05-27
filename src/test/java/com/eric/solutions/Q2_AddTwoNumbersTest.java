package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q2_AddTwoNumbers.ListNode;

public class Q2_AddTwoNumbersTest
{
  private Q2_AddTwoNumbers testSubject;
  private ListNode list1;
  private ListNode list2;
  
  @Before
  public void setup()
  {
    testSubject = new Q2_AddTwoNumbers();
    list1 = testSubject.new ListNode(2);
    list1.next = testSubject.new ListNode(4);
    list1.next.next = testSubject.new ListNode(3);
    
    list2 = testSubject.new ListNode(5);
    list2.next = testSubject.new ListNode(6);
    list2.next.next = testSubject.new ListNode(4);
  }
  
  @Test
  public void testAddTwoNumbers_givenNull_returnNull()
  {
    assertNull(testSubject.addTwoNumbers(null, null));
    assertNull(testSubject.addTwoNumbers(list1, null));
    assertNull(testSubject.addTwoNumbers(null, list2));
  }
  
  @Test
  public void testAddTwoNumbers_givenProperListNodes_returnSum()
  {
    // (2 > 4 > 3) + (5 > 6 > 4) = (7 > 0 > 8)
    ListNode result = testSubject.addTwoNumbers(list1, list2);
    assertEquals(7, result.val);
    assertEquals(0, result.next.val);
    assertEquals(8, result.next.next.val);
    assertNull(result.next.next.next);
  }
  
}
