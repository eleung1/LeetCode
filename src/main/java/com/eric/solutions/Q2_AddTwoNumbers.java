package com.eric.solutions;

/**
 * Question 2: Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Eric Leung
 *
 */
public class Q2_AddTwoNumbers
{
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
  {
    if ( l1 == null || l2 == null ) return null;
    
    ListNode resultHead = null;
    ListNode currNode = null;
    
    ListNode currL1 = l1;
    ListNode currL2 = l2;
    
    int carry = 0;
    while ( currL1 != null || currL2 != null || carry > 0 )
    {
      int sum = carry;
      
      if ( currL1 != null )
      {
        sum += currL1.val; 
        currL1 = currL1.next;
      }
      
      if ( currL2 != null ) 
      {
        sum += currL2.val; 
        currL2 = currL2.next;
      }
      
      int currDigit = sum % 10;
      carry = sum / 10;
      
      if ( resultHead == null )
      {
        resultHead = new ListNode(currDigit);
        currNode = resultHead;
      }
      else
      {
        currNode.next = new ListNode(currDigit);
        currNode = currNode.next;
      }
      
    }
    
    return resultHead;
  }
  
  class ListNode
  {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
  }
}
