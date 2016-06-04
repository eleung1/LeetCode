package com.eric.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Question 94: Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 * 
 * 1
 *  \
 *   2
 *   /
 *  3
 * 
 * return [1,3,2]
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Eric Leung
 *
 */
public class Q94_BinaryTreeInorderTraversal
{
  
  public List<Integer> inorderTraversal(TreeNode root) 
  {
    if ( root == null ) return new LinkedList<Integer>();
    
    List<Integer> result = inorderTraversal(root.left);
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));
    
    return result;
  }
  
  /**
   * Definition for a binary tree node provided by the question.
   */
  public class TreeNode 
  {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
