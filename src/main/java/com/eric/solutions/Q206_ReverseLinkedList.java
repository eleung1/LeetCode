package com.eric.solutions;

import java.util.Stack;

/**
 * Question 206: Reverse Linked List
 * 
 * Reverse a singly linked list.
 * 
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * 
 * @author Eric Leung
 *
 */
public class Q206_ReverseLinkedList
{
  /**
   * head: 1 > 2 > 3
   * 
   * reversed head: 3 > 2 > 1 
   * 
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) 
  {
    if ( head == null ) return null;
    
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode curr = head;
    
    while ( curr != null )
    {
      stack.push(curr);
      curr = curr.next;
    }
    
    ListNode reversedHead = stack.pop();
    curr = reversedHead;
    while ( !stack.isEmpty() )
    {
      curr.next = stack.pop();
      curr = curr.next;
    }
    
    curr.next = null;
    
    return reversedHead;
  }
  
  /**
   * 1 > 2 > 3
   * 
   * head=1
   * 
   * prev = 2
   * curr = 3
   * next = null
   * 
   * 1.next = null  // 1 > null
   * 
   * 2.next = 1    // 2 > 1 > null
   * 
   * head = 3
   * 
   * @param head
   * @return
   */
  public ListNode reverseListIterative(ListNode head) 
  {
    if ( head == null ) return null;
    
    if ( head.next == null ) return head;
    
    // Initialize the trio
    // prev   curr     next 
    // null     1    >   2  >   3
    //
    //       prev    curr   next
    // null < 1    <   2  >    3
    ListNode prev = null;
    ListNode curr= head;
    ListNode next = curr.next;
    
    // null   1 > 2 > 3
    // null < 1   2 > 3
    while ( next != null )
    {
      curr.next = prev;
      prev = curr;
      curr = next;
      next = next.next;
    }
    
    head = curr;
    head.next = prev;
    
    return head;
  }
  
  /**
   * 1 > 2 > 3 
   * 
   * 
   * reverse(1)
   *  head = 1
   *  second node = 2
   *  reverse(2)
   *  reversedHead = 3
   *  2.next = 1
   *  1.next = null
   *  return 3
   *  
   * reverse(2)
   *  head = 2
   *  second node = 3
   *  reverse(3) 
   *  reversedHead = 3
   *  3.next = 2
   *  2.next = null
   *  return 3
   *  
   *  
   * reverse(3)
   *   head = 3
   *   second node = null
   *   return 3
   * 
   * 
   * @param head
   * @return
   */
  public ListNode reverseListRecursive(ListNode head) 
  {
    // Reverse of a null list is null
    if ( head == null ) return null;
    
    // Reverse of a single-node list is the same list
    if ( head.next == null ) return head;
    
    //  Reverse of a n-node list is the reverse of 2nd-node to end, then append first node to the end(which was the 2nd node).
    ListNode secondNode = head.next; // keep track of the second node
    
    // reverse the sublist starting at second node, the resulting list will have second node as last node
    ListNode reversedhead = reverseListRecursive(secondNode);
    
    secondNode.next = head;
    head.next = null;
   
    return reversedhead;
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
