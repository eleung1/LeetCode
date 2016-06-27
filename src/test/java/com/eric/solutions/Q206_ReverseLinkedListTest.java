package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q206_ReverseLinkedList.ListNode;

public class Q206_ReverseLinkedListTest
{
  private Q206_ReverseLinkedList testSubject;
  private ListNode head;
  private ListNode head2;
  
  @Before
  public void setup()
  {
    testSubject = new Q206_ReverseLinkedList();
    
    head = testSubject.new ListNode(1);
    head.next = testSubject.new ListNode(2);
    head.next.next = testSubject.new ListNode(3);
    
    head2 = testSubject.new ListNode(1);
    head2.next = testSubject.new ListNode(2);
  }
  
  @Test
  public void test()
  {
    assertNull(testSubject.reverseList(null));
    
    ListNode reversedHead2 = testSubject.reverseList(head2);
    assertEquals(2, reversedHead2.val);
    assertEquals(1, reversedHead2.next.val);
    assertNull(reversedHead2.next.next);
    
    ListNode reversedHead = testSubject.reverseList(head);
    assertEquals(3, reversedHead.val);
    assertEquals(2, reversedHead.next.val);
    assertEquals(1, reversedHead.next.next.val);
    assertNull(reversedHead.next.next.next);
  }
  
  @Test
  public void testRecursive()
  {
    ListNode reversedHead = testSubject.reverseListRecursive(head);
    assertEquals(3, reversedHead.val);
    assertEquals(2, reversedHead.next.val);
    assertEquals(1, reversedHead.next.next.val);
    assertNull(reversedHead.next.next.next);
  }
  
  @Test
  public void testIterative()
  {
    ListNode reversedHead = testSubject.reverseListIterative(head);
    assertEquals(3, reversedHead.val);
    assertEquals(2, reversedHead.next.val);
    assertEquals(1, reversedHead.next.next.val);
    assertNull(reversedHead.next.next.next);
  }
}
