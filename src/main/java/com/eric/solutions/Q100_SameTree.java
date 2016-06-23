package com.eric.solutions;

/**
 * Question 100: Same Tree
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @author Eric Leung
 * 
 */
public class Q100_SameTree
{
  public boolean isSameTree(TreeNode p, TreeNode q) 
  {
    if ( p == null && q == null ) return true;
    
    if ( p == null && q != null || p != null && q == null ) return false;
    
    if ( p.val == q.val )
    {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    else
    {
      return false;
    }
  }
  
  /**
   * Definition for a binary tree node.
   */
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
   
}
