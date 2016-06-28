package com.eric.solutions;

import java.util.Stack;

/**
 * Question 235: Lowest Common Ancestor of a Binary Search Tree.
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two 
 * nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be 
 * a descendant of itself)."
 * 
 *       _______6______
 *      /              \
 *   ___2__          ___8__
 *  /      \        /      \
 *  0      _4       7       9
 *        /  \
 *        3   5
 *
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of 
 * nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 
 * @author Eric Leung
 *
 */
public class Q235_LowestCommonAncestorBinarySearchTree
{
  /**
   * Idea: 
   * Since the TreeNode has no reference to its parent, we need to traverse down from root to find
   * p and q, on the way we should keep track of the visited nodes which are p and q's parents (in a stack).
   * After we find p and q, we can examine the size of the 2 stacks leading up to p and q.  If they are the 
   * same size, it means they are at the same level.  If they are of different size, then the one with the
   * bigger size is down deeper in the tree.  We can pop the deeper node's parent until we are at the same
   * level as the other parent and check and see if they share the same ancestor.  If not the we pop
   * one from each stack and compare.  If we have reach the root and there is still no match, 
   * then the root is the LCA. 
   * 
   * Pseudo code:
   * If p == q, return p
   * From root, traverse down to find p and keep track of the visited nodes in a stack.
   * From root, traverse down to find q and keep track of the visited nodes in a stack.
   * If the stacks are same size, pop the top of both stacks, compare until we find a match
   * If the stacks are not the same size, pop the top of the bigger stack until same size. Compare
   * until we find a match.
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
  {
    if ( root == null || p == null || q == null ) return null;
    
    // if one of the node is the root, then the root is the LCA
    if ( root == p || root == q ) return root;
    
    // if p and q is the same node, then it is the LCA
    if ( p == q ) return p;
    
    // Find path to p and q from root
    Stack<TreeNode> pParents = findPath(root, p);
    Stack<TreeNode> qParents = findPath(root, q);
    
    // p or q is not part of this tree, no point on continuing to find LCA
    if ( pParents == null || qParents == null ) return null;
    
    // start the search of LCA in the same level
    while ( pParents.size() > qParents.size() )
    {
      pParents.pop();
    }
    while ( qParents.size() > pParents.size() )
    {
      qParents.pop();
    }
    
    // Both stacks are at the same level of the tree now, compare
    while ( !pParents.isEmpty() && !qParents.isEmpty() )
    {
      if ( pParents.peek() == qParents.peek() )
      {
        return pParents.peek();
      }
      
      pParents.pop();
      qParents.pop();
    }
    
    // if we have reached this point, that means the root is the LCA
    return root;
  }
  
  /**
   * Helper method that would return a stack containing the reverse
   * path from root to n.
   * 
   * @param root
   * @param n
   * @return Stack containing the path from root to n.  Top of stack is n, bottom of stack is root.
   */
  public Stack<TreeNode> findPath(TreeNode root, TreeNode n)
  {
    Stack<TreeNode> parents = new Stack<TreeNode>();
    TreeNode curr = root;
    boolean foundNode = false; // Check and see if the given node n is part of this tree
    while ( curr != null )
    {
      parents.add(curr);
      
      if ( curr != n )
      {
        if ( curr.val >= n.val )
        {
          curr = curr.left;
        }
        else
        {
          curr = curr.right;
        }
      }
      else
      {
        foundNode = true;
        break;
      }
    }
    
    return foundNode ? parents : null;
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
