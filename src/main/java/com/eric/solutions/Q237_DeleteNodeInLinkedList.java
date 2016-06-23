package com.eric.solutions;

/**
 * Question 237: Delete node in a linked list
 * 
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your
 * function.
 * 
 * @author Eric Leung
 * 
 */
public class Q237_DeleteNodeInLinkedList
{
  /**
   * Since it will not be the tail, simply set the curr node's value
   * to be the value of the next node, then set curr node's next to be 
   * next node's next.
   * 
   * @param node
   */
  public void deleteNode(ListNode node) 
  {
    if ( node.next != null ) 
    {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
  
  /**
   * Definition for singly-linked list.
   * 
   */
   public class ListNode 
   {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
   
}
