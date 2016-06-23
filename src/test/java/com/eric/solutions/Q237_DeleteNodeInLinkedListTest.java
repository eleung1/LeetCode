package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q237_DeleteNodeInLinkedList.ListNode;

public class Q237_DeleteNodeInLinkedListTest
{
  private Q237_DeleteNodeInLinkedList testSubject;
  
  private ListNode head;
  
  @Before
  public void setup()
  {
    testSubject = new Q237_DeleteNodeInLinkedList();
    
    head = testSubject.new ListNode(1);
    head.next = testSubject.new ListNode(2);
    head.next.next = testSubject.new ListNode(3);
    head.next.next.next = testSubject.new ListNode(4);
  }
  
  @Test
  public void testDeleteNode()
  {
    //1 -> 2 -> 3 -> 4 
    ListNode deleteMe = head.next.next; // delete 3
    testSubject.deleteNode(deleteMe);
    
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(4, head.next.next.val);
    assertNull(head.next.next.next);
  }
}
