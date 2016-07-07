package com.eric.solutions;

/**
 * Question 24: Swap nodes in pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author Eric Leung
 * 
 */
public class Q24_SwapNodesInPairs
{
  
  /**
   * H
   * 1 > 2 > 3 > 4
   * 
   * H
   * 2 > 1 > 3 > 4
   * 
   *         H
   * 2 > 1 > 3 > 4
   *         H  
   * 2 > 1 > 4 > 3
   *
   * Solve this recursively.
   * 
   * Swap the curr 1st and 2nd node, then recursively
   * swap the sub-list(starting at 3rd node)'s 1st and 2nd node...
   * 
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head)
  {
    if ( head == null ) return null;
    
    // list of one node, no need to swap
    if ( head.next == null ) return head;
    
    ListNode temp = head;
    ListNode thirdNode = head.next.next;  // keep track of third node, this is the next sub-list we need to swap
    head = head.next;
    head.next = temp;
    
    head.next.next = swapPairs(thirdNode);
    
    return head;
  }
  
  /**
   * Definition for singly-linked list.
   */ 
   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
   
}
