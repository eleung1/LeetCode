package com.eric.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 141: Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author Eric Leung
 * 
 */
public class Q141_LinkedListCycle
{
  /**
   * Find cycle without using extra space
   * 
   * Use 2 pointers, one slow one fast.
   * One will jump one node per iteration
   * The other will jump 2 nodes per iteration
   * If the 2 nodes meet, then we have a cycle.
   * 
   * @param head
   * @return
   */
  public boolean hasCycleTwoPointers(ListNode head) 
  {
    // Some null handling, could throw an exception as another option.
    if ( head == null ) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while ( slow.next != null && fast.next != null && fast.next.next != null )
    {
      slow = slow.next;
      fast = fast.next.next;
      if ( slow == fast ) return true;
    }
    
    return false;
  }
  
  /**
   * Naive solution: 
   * Iterate through the linked list and use a set to keep 
   * track of visited nodes.  If we encounter a node that is already
   * visited, we have a cycle.
   * 
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) 
  {
    // Some null handling, could throw an exception as another option.
    if ( head == null ) return false;  
    
    Set<ListNode> visited = new HashSet<ListNode>();
    ListNode curr = head;
    while ( curr != null )
    {
      if ( visited.contains(curr) ) return true;
      visited.add(curr);
      curr = curr.next;
    }
    
    return false;
  }
  
  /**
   * Definition for singly-linked list.
   */ 
   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
   
}
