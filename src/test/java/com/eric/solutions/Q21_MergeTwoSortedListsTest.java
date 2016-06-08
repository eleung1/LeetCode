package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q21_MergeTwoSortedLists.ListNode;

public class Q21_MergeTwoSortedListsTest
{
  private Q21_MergeTwoSortedLists testSubject;
  private ListNode list1;
  private ListNode list2;
  
  @Before
  public void setup()
  {
    testSubject = new Q21_MergeTwoSortedLists();
    
    list1 = testSubject.new ListNode(1);
    list1.next = testSubject.new ListNode(3);
    list1.next.next = testSubject.new ListNode(5);
    
    list2 = testSubject.new ListNode(2);
    list2.next = testSubject.new ListNode(4);
    list2.next.next = testSubject.new ListNode(6);
  }
  
  @Test
  public void testMergeTwoLists_givenBothNull_returnNull()
  {
    assertNull(testSubject.mergeTwoLists(null, null));
  }
  
  @Test
  public void testMergeTwoLists_givenOneNull_returnTheOtherList()
  {
    ListNode head = testSubject.mergeTwoLists(null, list2);
    assertEquals(2, head.val);
    assertEquals(4, head.next.val);
    assertEquals(6, head.next.next.val);
    assertNull(head.next.next.next);
  }
  
  @Test
  public void testMergeTwoLists_givenProperLists_returnMergedList()
  {
    ListNode head = testSubject.mergeTwoLists(list1, list2);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertEquals(4, head.next.next.next.val);
    assertEquals(5, head.next.next.next.next.val);
    assertEquals(6, head.next.next.next.next.next.val);
    assertNull(head.next.next.next.next.next.next);
  }
}
