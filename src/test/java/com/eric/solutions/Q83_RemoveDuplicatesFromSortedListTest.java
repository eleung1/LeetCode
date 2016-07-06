package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q83_RemoveDuplicatesFromSortedList.ListNode;

public class Q83_RemoveDuplicatesFromSortedListTest
{
  private Q83_RemoveDuplicatesFromSortedList testSubject;
  private ListNode head1;
  private ListNode head2;
  
  @Before
  public void setup()
  {
    testSubject = new Q83_RemoveDuplicatesFromSortedList();
    
    // 1-node list
    head1 = testSubject.new ListNode(1);
    
    // general list
    head2 = testSubject.new ListNode(1);
    head2.next = testSubject.new ListNode(1);
    head2.next.next = testSubject.new ListNode(2);
    head2.next.next.next = testSubject.new ListNode(3);
    head2.next.next.next.next = testSubject.new ListNode(3);
  }
  
  @Test
  public void test()
  {
    assertNull(testSubject.deleteDuplicates(null));
    
    // De-dup list of size 1
    ListNode dedupHead1 = testSubject.deleteDuplicates(head1);
    assertEquals(1, dedupHead1.val);
    assertNull(dedupHead1.next);
    
    // De-dup list of size n
    ListNode dedupHead2 = testSubject.deleteDuplicates(head2);
    assertEquals(1, dedupHead2.val);
    assertEquals(2, dedupHead2.next.val);
    assertEquals(3, dedupHead2.next.next.val);
    assertNull(dedupHead2.next.next.next);
  }
}
