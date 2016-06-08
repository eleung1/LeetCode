package com.eric.solutions;

/**
 * Q21: Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list 
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Eric Leung
 *
 */
public class Q21_MergeTwoSortedLists
{
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
  {
    if ( l1 == null ) return l2;
    if ( l2 == null ) return l1;
    
    ListNode head = null;
    
    if ( l1.val <= l2.val )
    {
      head = l1;
      l1 = l1.next;
    }
    else
    {
      head = l2;
      l2 = l2.next;
    }
    ListNode curr = head;
    
    while ( l1 != null && l2 != null )
    {
      if ( l1.val <= l2.val )
      {
        curr.next = l1;
        l1 = l1.next;
      }
      else
      {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    
    if ( l1 == null )
    {
      curr.next = l2;
    }
    else if ( l2 == null )
    {
      curr.next =l1;
    }
    
    return head;
  }
  
  /**
   * Definition for singly-linked list given by the question.
   */ 
   public class ListNode 
   {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
   }
   
}
