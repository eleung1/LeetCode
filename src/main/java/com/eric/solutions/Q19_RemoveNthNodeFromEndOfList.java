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
   *       that is n nodes apart.
   *       When the end node reaches the end of the list, our start
   *       node is at the node previous to the node we want to delete.
   *       We can simply set the start node's next reference to next.next
   *       and we're done.  
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) 
  {
    if ( head == null || n < 1 ) return null; // Illegal arguments
    
    ListNode start,end;
    start = end = head;
    
    // list with one node
    if ( n == 1 && start.next == null) return null;
    
    // # of hops between start and end node.
    for ( int i = 0; i < n; i ++ )
    {
      end = end.next;
    }
    
    if ( end == null )
    {
      // if end is null after making n hops, that means we need to remove head
      return head.next;
    }
    else
    {
      while ( end.next != null )
      {
        end = end.next;
        start = start.next;
      }
    }
    
    // end node reached the end of list, which means start node is at the nth+1 node from the end.
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
   * Recursive solution.
   * 
   * Idea: Have a wrapper class around ListNode that keeps track of the position
   * of the current node from the end.
   * 
   * Base case: if we have fell off the list (i.e. head is null, then return 0 because we are 0 nodes away from end)
   * 1:  If we are at the last node, return 1
   * 2:  If we are at the 2nd last node, return 2
   * 
   * If the return value == n, we have found our node nth position from the end of list
   * 
   * @param currNodeWrapper
   * @param n
   * @param curr
   * @return
   */
  public ListNodeWrapper removeNthFromEndRecursive(ListNodeWrapper currNodeWrapper, int n)
  {
    if ( currNodeWrapper.node == null ) return new ListNodeWrapper(currNodeWrapper.node, currNodeWrapper.head, 0);
    
    ListNodeWrapper nextNodeWrapper = removeNthFromEndRecursive(new ListNodeWrapper(currNodeWrapper.node.next, currNodeWrapper.head, 0), n);
    if ( nextNodeWrapper.pos == n ) 
    { 
      // next node is the node we want to remove, simply set currNode's next to skip over the "removed" node.
      if ( currNodeWrapper.node.next == nextNodeWrapper.node) currNodeWrapper.node.next = nextNodeWrapper.node.next;
    }
    
    // Curr node's position from end is next Node's position from end plus 1
    int currPosFromEnd = nextNodeWrapper.pos + 1;
    
    // if head node is the nth from end, set head to be head.next
    if ( currPosFromEnd == n && currNodeWrapper.node == currNodeWrapper.head )
    {
      // we have to remove head here because this is the end of the recursive calls.
      currNodeWrapper.head = currNodeWrapper.head.next;
    }
    
    return new ListNodeWrapper(currNodeWrapper.node, currNodeWrapper.head, currPosFromEnd);
  }
  
  /**
   * Entry point into our recursive method
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEndRecursiveEntry(ListNode head, int n) 
  {
    if ( head == null || n < 1 ) return null; // Illegal arguments
    
    // list with one node
    if ( n == 1 && head.next == null) return null;
    
    ListNodeWrapper headWrapper = removeNthFromEndRecursive(new ListNodeWrapper(head, head, 0), n);
    
    return headWrapper.head;
  }
  
  /**
   * Experimental method that will print out the nth node from end, just to get some ideas flowing.
   * 
   * @param head
   * @param n
   * @return
   */
  public int removeNthFromEndRecursive(ListNode head, int n)
  {
    if ( head == null ) return 0;
    
    int currPos = removeNthFromEndRecursive(head.next, n) + 1;
    
    if ( currPos == n) 
    {
      System.out.println(head.val);
      return currPos;
    }
    
    return currPos;
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
   
   /**
    * Wraps the node object with its position from end of list.
    * 
    * Used in the recursive solution.
    *
    */
   public class ListNodeWrapper
   {
     int pos; // position from the end of list.
     ListNode head; // need a ref to head, so we can remove head if it is the nth node from end
     ListNode node; // node is the current node being processed as we unwind the recursive calls
     ListNodeWrapper(ListNode n, ListNode h, int p)
     {
       node = n;
       head = h;
       pos = p;
     }
   }
}
