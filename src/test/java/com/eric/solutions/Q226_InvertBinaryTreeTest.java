package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q226_InvertBinaryTree.TreeNode;

public class Q226_InvertBinaryTreeTest
{
  private Q226_InvertBinaryTree testSubject;
  private TreeNode root1;
  private TreeNode root2;
  private TreeNode root3;
  
  @Before
  public void setup()
  {
    testSubject = new Q226_InvertBinaryTree();
    
    // Height 1
    root1 = testSubject.new TreeNode(1);
    
    // Height 2
    root2 = testSubject.new TreeNode(1);
    root2.left = testSubject.new TreeNode(2);
    root2.right = testSubject.new TreeNode(3);
    
    // Height 3
    root3 = testSubject.new TreeNode(4);
    root3.left = testSubject.new TreeNode(2);
    root3.right = testSubject.new TreeNode(7);
    root3.left.left = testSubject.new TreeNode(1);
    root3.left.right = testSubject.new TreeNode(3);
    root3.right.left = testSubject.new TreeNode(6);
    root3.right.right = testSubject.new TreeNode(9);
  }
  
  @Test
  public void testInvertTree_givenNull_returnNull()
  {
    assertNull(testSubject.invertTree(null));
  }
  
  @Test
  public void testInvertTree_given1Node_returnSameNode()
  {
    assertEquals(1, testSubject.invertTree(root1).val);
  }
  
  @Test
  public void testInvertTree_givenHeight2_returnInvertedTree()
  {
    TreeNode result = testSubject.invertTree(root2);
    assertEquals(1, result.val);
    assertEquals(3, result.left.val);
    assertEquals(2, result.right.val);
  }
  
  @Test
  public void testInvertTree_givenHeight3_returnInvertedTree()
  {
    TreeNode result = testSubject.invertTree(root3);
    assertEquals(4, result.val);
    assertEquals(7, result.left.val);
    assertEquals(2, result.right.val);
    assertEquals(9, result.left.left.val);
    assertEquals(6, result.left.right.val);
    assertEquals(3, result.right.left.val);
    assertEquals(1, result.right.right.val);
  }
}
