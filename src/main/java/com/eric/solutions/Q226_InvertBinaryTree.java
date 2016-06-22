package com.eric.solutions;

/**
 * Invert a binary tree.
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *    
 *    to
 *    
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * @author Eric Leung
 *
 */
public class Q226_InvertBinaryTree
{
  public TreeNode invertTree(TreeNode root) 
  {
    if ( root == null ) return null;
    
    // Swap left and right child of root
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    // recursively do the same for the subtrees
    invertTree(root.left);
    invertTree(root.right);
    
    return root;
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
