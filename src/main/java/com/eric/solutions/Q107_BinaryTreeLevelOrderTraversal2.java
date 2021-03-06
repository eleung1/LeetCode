package com.eric.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.eric.solutions.Q102_BinaryTreeLevelOrderTraversal.TreeNode;

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
    if ( root == null ) return new ArrayList<List<Integer>>();
    
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    Queue<TreeNode> toExplore = new LinkedList<TreeNode>();
    toExplore.add(root);
    
    while ( !toExplore.isEmpty() )
    {
      // get the size of the current level
      int currLevelSize = toExplore.size();
      List<Integer> currLevelVals = new LinkedList<Integer>();
      // add the current level nodes to the result
      for ( int i = 0; i < currLevelSize; i ++ )
      {
        TreeNode curr = toExplore.poll();
        currLevelVals.add(curr.val);
        if ( curr.left != null) toExplore.add(curr.left);
        if ( curr.right != null) toExplore.add(curr.right);
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
