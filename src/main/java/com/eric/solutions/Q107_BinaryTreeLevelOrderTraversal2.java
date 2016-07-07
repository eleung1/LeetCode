package com.eric.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 107: Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its bottom-up level order traversal as:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 * 
 * @author Eric Leung
 *
 */
public class Q107_BinaryTreeLevelOrderTraversal2
{
  public List<List<Integer>> levelOrderBottom(TreeNode root) 
  {
    if ( root == null ) return null;
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    if ( root.left == null || root.right == null )
    {
      List<Integer> currLevel = new ArrayList<Integer>();
      currLevel.add(root.val);
      result.add(currLevel);
    }
    else
    {
      /*
      List<List<Integer>> leftChildLevel = levelOrderBottom(root.left);
      List<List<Integer>> rightChildLevel = levelOrderBottom(root.right);
      
      List<Integer> currLevel = new ArrayList<Integer>();
      currLevel.add(root.val);
      
      result.add(currLevel);
      */
    }
    
    return result;
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
