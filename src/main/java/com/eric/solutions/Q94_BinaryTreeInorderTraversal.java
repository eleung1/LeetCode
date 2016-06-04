package com.eric.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
  /**
   * Recursive solution.
   * 
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) 
  {
    if ( root == null ) return new LinkedList<Integer>();
    
    List<Integer> result = inorderTraversal(root.left);
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));
    
    return result;
  }
  
  /**
   * Iterative solution.
   * 
   * Idea:
   * 1.  Traverse to the left most child of this tree.  This will be our first/curr node.
   * 2.  Find currNode's in-order successor.
   *     - if currNode has no children
   *          if currNode is leftChild of parent
   *             successor is parent
   *          else if currNode is rightChild of parent
   *             find first parent who is the left child of its ancestor, that ancestor is the succesor.
   *     - else if currNode has right child
   *          successor is left most child of the right child, or the rightChild if the right child has no children.  
   *     
   * 
   * @param root
   * @return
   */
  public List<Integer> inorderTraversalIterative(TreeNode root)
  {
    if ( root == null ) return new LinkedList<Integer>();
    
    List<Integer> result = new LinkedList<Integer>();
    
    // key=child; value=parent
    Map<TreeNode, TreeNode> parentMap = constructParentMap(root);
    
    TreeNode leftMostNode = root;
    while(leftMostNode.left != null) 
    {
      leftMostNode = leftMostNode.left;
    }
    
    result.add(leftMostNode.val);
    
    TreeNode successor = getInorderSuccessor(leftMostNode, parentMap);
    
    while ( successor != null )
    {
      result.add(successor.val);
      successor = getInorderSuccessor(successor, parentMap);
    }
    
    return result;
  }
  
  /**
   * The given TreeNode class does not have a reference to its parent.
   * Explore all nodes(Breadth first traversal) from top to bottom and construct a parent map.
   * 
   * @param root Root of this binary tree.
   * @return A map containing key value pairs of node to parentNode.
   */
  public Map<TreeNode, TreeNode> constructParentMap(TreeNode root)
  {
    if ( root == null ) return null;
    
    Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
    Queue<TreeNode> toExplore = new LinkedList<TreeNode>();
    toExplore.add(root);
    
    while ( !toExplore.isEmpty() )
    {
      TreeNode currNode = toExplore.poll();
      if ( currNode.left != null )
      {
        parentMap.put(currNode.left, currNode);
        toExplore.add(currNode.left);
      }
      
      if ( currNode.right != null )
      {
        parentMap.put(currNode.right, currNode);
        toExplore.add(currNode.right);
      }
    }
    
    return parentMap;
  }
  
  /**
   * Helper method to find the in-order successor of a given node.
   * 
   * @param node
   * @return
   */
  public TreeNode getInorderSuccessor(TreeNode node, Map<TreeNode, TreeNode> parentMap)
  {
    if ( node == null ) return null;
    
    TreeNode parent = parentMap.get(node);
    
    if ( node.right == null)
    {
      // does not have right child and currNode is the leftChild of parent
      if ( parent != null && parent.left == node ) return parent;
      
      if ( parent != null && parent.right == node )
      {
        // in this case we have already visited parent
        // return first parent who is a left child of its parent
        TreeNode successor = parentMap.get(parent);
        while ( successor != null )
        {
          if ( successor.left == parent )
          {
            return successor;
          }
          parent = successor;
          successor = parentMap.get(successor);
        }
        return null; // cannot find a successor, we are at the right most node of the tree, i.e. done.
      }
    }
    else
    {
      // return left most child of node.right
      return findLeftMostChild(node.right);
    }
    
    return null;
    
  }
  
  /**
   * Helper method to find the left most child of the tree rooted at the given node.
   * 
   * @param node
   * @return
   */
  public TreeNode findLeftMostChild(TreeNode node)
  {
    if ( node == null ) return null;
    
    TreeNode leftMostChild = node;
    while ( leftMostChild.left != null )
    {
      leftMostChild = leftMostChild.left;
    }
    
    return leftMostChild;
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
