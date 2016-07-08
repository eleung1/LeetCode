package com.eric.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    if ( root == null ) return new LinkedList<List<Integer>>();
    
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    List<Integer> currLevelVals = new ArrayList<Integer>();
    
    // Root level
    currLevelVals.add(root.val);
    result.addFirst(currLevelVals);
    
    // Generate list of next level nodes
    Queue<TreeNode> nextLevelNodes = new LinkedList<TreeNode>();
    if ( root.left != null ) nextLevelNodes.add(root.left);
    if ( root.right != null) nextLevelNodes.add(root.right);
    
    while ( !nextLevelNodes.isEmpty() ) 
    {
      // Set list of curr level node to be the previous next, and empty the list of next level nodes
      Queue<TreeNode> currLevelNodes = nextLevelNodes;
      nextLevelNodes = new LinkedList<TreeNode>();
      currLevelVals = new ArrayList<Integer>();
      for ( TreeNode node: currLevelNodes )
      {
        currLevelVals.add(node.val);
        
        // populate next level nodes again.  
        if ( node.left != null ) nextLevelNodes.add(node.left);
        if ( node.right != null ) nextLevelNodes.add(node.right);
      }
      result.addFirst(currLevelVals);
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
