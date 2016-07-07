package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q24_SwapNodesInPairs.ListNode;

public class Q24_SwapNodesInPairsTest
{
  private Q24_SwapNodesInPairs testSubject;
  private ListNode head1;
  private ListNode head2;
  private ListNode head3;
  
  @Before
  public void setup()
  {
    testSubject = new Q24_SwapNodesInPairs();
    head1 = testSubject.new ListNode(1);
    
    head2 = testSubject.new ListNode(1);
    head2.next = testSubject.new ListNode(2);
    
    head3 = testSubject.new ListNode(1);
    head3.next = testSubject.new ListNode(2);
    head3.next.next = testSubject.new ListNode(3);
    head3.next.next.next = testSubject.new ListNode(4);
  }
  
  @Test
  public void test()
  {
    assertNull(testSubject.swapPairs(null));
    
    ListNode head1Swapped = testSubject.swapPairs(head1);
    assertEquals(1, head1Swapped.val);
    assertNull(head1Swapped.next);
    
    ListNode head2Swapped = testSubject.swapPairs(head2);
    assertEquals(2, head2Swapped.val);
    assertEquals(1, head2Swapped.next.val);
    assertNull(head2Swapped.next.next);
    
    ListNode head3Swapped = testSubject.swapPairs(head3);
    assertEquals(2, head3Swapped.val);
    assertEquals(1, head3Swapped.next.val);
    assertEquals(4, head3Swapped.next.next.val);
    assertEquals(3, head3Swapped.next.next.next.val);
  }
}
