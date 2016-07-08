package com.eric.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question 102: Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * 
 * 
 * @author Eric Leung
 *
 */
public class Q102_BinaryTreeLevelOrderTraversal
{
  /**
   * BFS solution
   * 
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) 
  {
    if ( root == null ) return new ArrayList<List<Integer>>();
   
    List<List<Integer>> result = new ArrayList<List<Integer>>();
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
      result.add(currLevelVals);
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
