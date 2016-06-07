package com.eric.solutions;

/**
 * Question 19 Remove Nth node from end of list
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Eric Leung
 *
 */
public class Q19_RemoveNthNodeFromEndOfList
{
  /**
   * Idea: create a "window" with a start node and and end node
   *       that is n-1 nodes apart.
   *       When the end node reaches the end of the list, our start
   *       node is at the node we want to delete.  
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) 
  {
    ListNode start = head;
    ListNode end = head;
    if ( n == 1 )
    {
      // Special case, delete last node from list.
      if ( start.next == null ) 
      {
        return null;  // list with one node
      }
      else
      {
        end = start.next;
        while ( end.next != null )
        {
          start = start.next;
          end = end.next;
        }
        start.next = null;
      }
      return head;
    }
    
    // # of hops between start and end node.
    int distance = n - 1; 
    start = head; // start window
    end = head;   // end window
    for ( int i = 0; i < distance; i ++ )
    {
      end = end.next;
    }
    
    // Advance of rolling window of size n forward.
    if ( end != null )
    {
      while ( end.next != null )
      {
        end = end.next;
        start = start.next;
      }
    }
    
    // end node reached the end of list, which means start node is at the nth node.
    start.val = start.next.val;
    start.next = start.next.next;
    
    return head;
  }
  
  /**
   * Naive approach:
   * One pass get list size
   * index = size -n = 3
   * iterate to the element at index
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEndNaive(ListNode head, int n) 
  {
    ListNode curr = head;
    int size = 0;
    
    while ( curr != null )
    {
      size ++;
      curr = curr.next;
    }
    
    int index = size - n;
    if ( index == 0 )
    {
      head = head.next;
      
    }
    else
    {
      curr = head;
      int count = 0;
      while ( count < index - 1)
      {
        curr = curr.next;
        count++;
      }
      curr.next = curr.next.next;
    }
    
    return head;
  }
  
  /**
   * Definition for singly-linked list defined by the question.
   */
   public class ListNode 
   {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
   }
   
}
