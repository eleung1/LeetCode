package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q19_RemoveNthNodeFromEndOfList.ListNode;

public class Q19_RemoveNthNodeFromEndOfListTest
{
  private Q19_RemoveNthNodeFromEndOfList testSubject;
  private ListNode head1;
  private ListNode head_singleNodeList;
  private ListNode head_twoNodesList;
  @Before
  public void setup()
  {
    testSubject = new Q19_RemoveNthNodeFromEndOfList();
    
    head_singleNodeList = testSubject.new ListNode(1);
    
    
    
    head1 = testSubject.new ListNode(1);
    head1.next = testSubject.new ListNode(2);
    head1.next.next = testSubject.new ListNode(3);
    head1.next.next.next = testSubject.new ListNode(4);
    head1.next.next.next.next = testSubject.new ListNode(5);
    
    head_singleNodeList = testSubject.new ListNode(1);
    
    head_twoNodesList = testSubject.new ListNode(1);
    head_twoNodesList.next = testSubject.new ListNode(2);
  }
  
  @Test
  public void testRemoveNthFromEnd_givenSingleNode_returnNull()
  {
    ListNode head = testSubject.removeNthFromEnd(head_singleNodeList, 1);
    assertNull(head);
  }
  
  @Test
  public void testRemoveNthFromEnd_given2NodeListRemove2ndNode_return1stNode()
  {
    ListNode head = testSubject.removeNthFromEnd(head_twoNodesList, 1);
    assertEquals(1, head.val);
    assertNull(head.next);
  }
  
  @Test
  public void testRemoveNthFromEnd_given2NodeListRemove1stNode_return2ndNode()
  {
    ListNode head = testSubject.removeNthFromEnd(head_twoNodesList, 2);
    assertEquals(2, head.val);
    assertNull(head.next);
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
  
  // --- Naive solution test
  @Test
  public void testRemoveNthFromEndNaive_givenSingleNode_returnNull()
  {
    ListNode head = testSubject.removeNthFromEndNaive(head_singleNodeList, 1);
    assertNull(head);
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
  
  // --- Recursive solution tests
  
  @Test
  public void testRemoveNthFromEndRecursive_givenProperList_printOut4()
  {
    // This method simply prints out the value of the node that is nth position from the end
    // 1 > 2 > 3 > 4 > 5
    // Remove 2nd from end (4), result list is 1 > 2 > 3 > 5
    testSubject.removeNthFromEndRecursive(head1, 2);
  }
  
  @Test
  public void testRemoveNthFromEndRecursive_givenProperList_returnListWithNthNodeRemoved()
  {
    // 1 > 2 > 3 > 4 > 5
    // Remove 2nd from end (4), result list is 1 > 2 > 3 > 5
    ListNode head = testSubject.removeNthFromEndRecursiveEntry(head1, 2);
    
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertEquals(5, head.next.next.next.val);
    assertNull(head.next.next.next.next);
    
  }
  
  @Test
  public void testRemoveNthFromEndRecursive_givenSingleNode_returnNull()
  {
    ListNode head = testSubject.removeNthFromEndRecursiveEntry(head_singleNodeList, 1);
    assertNull(head);
  }
  
  @Test
  public void testRemoveNthFromEndRecursive_given2NodeListRemove2ndNode_return1stNode()
  {
    ListNode head = testSubject.removeNthFromEndRecursiveEntry(head_twoNodesList, 1);
    assertEquals(1, head.val);
    assertNull(head.next);
  }
  
  @Test
  public void testRemoveNthFromEndRecursive_given2NodeListRemove1stNode_return2ndNode()
  {
    ListNode head = testSubject.removeNthFromEndRecursiveEntry(head_twoNodesList, 2);
    assertEquals(2, head.val);
    assertNull(head.next);
  }
  
}
