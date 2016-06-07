package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q19_RemoveNthNodeFromEndOfList.ListNode;

public class Q19_RemoveNthNodeFromEndOfListTest
{
  private Q19_RemoveNthNodeFromEndOfList testSubject;
  private ListNode head1;
  private ListNode head_singleNode;
  @Before
  public void setup()
  {
    testSubject = new Q19_RemoveNthNodeFromEndOfList();
    
    head_singleNode = testSubject.new ListNode(1);
    
    head1 = testSubject.new ListNode(1);
    head1.next = testSubject.new ListNode(2);
    head1.next.next = testSubject.new ListNode(3);
    head1.next.next.next = testSubject.new ListNode(4);
    head1.next.next.next.next = testSubject.new ListNode(5);
    
    head_singleNode = testSubject.new ListNode(1);
  }
  
  @Test
  public void testRemoveNthFromEnd_givenSingleNode_returnNull()
  {
    ListNode head = testSubject.removeNthFromEnd(head_singleNode, 1);
    assertNull(head);
  }
  
  @Test
  public void testRemoveNthFromEndNaive_givenSingleNode_returnNull()
  {
    ListNode head = testSubject.removeNthFromEndNaive(head_singleNode, 1);
    assertNull(head);
  }
  
  @Test
  public void testRemoveNthFromEnd_givenProperParams_returnProperResult()
  {
    // remove second last node
    ListNode head = testSubject.removeNthFromEnd(head1, 2);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertEquals(5, head.next.next.next.val);
    assertNull(head.next.next.next.next);
    
    // remove last node
    head = testSubject.removeNthFromEnd(head1, 1);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertNull(head.next.next.next);
    
  }
  
  @Test
  public void testRemoveNthFromEndNaive_givenProperParams_returnProperResult()
  {
    // remove second last node
    ListNode head = testSubject.removeNthFromEndNaive(head1, 2);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertEquals(5, head.next.next.next.val);
    assertNull(head.next.next.next.next);
    
    // remove last node
    head = testSubject.removeNthFromEndNaive(head1, 1);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertNull(head.next.next.next);
    
  }
}
