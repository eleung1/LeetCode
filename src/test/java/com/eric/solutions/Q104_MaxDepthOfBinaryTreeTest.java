package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q104_MaxDepthOfBinaryTree.TreeNode;

public class Q104_MaxDepthOfBinaryTreeTest
{
  private Q104_MaxDepthOfBinaryTree testSubject;
  private TreeNode root1;
  private TreeNode root2;
  private TreeNode root3;
  
  @Before
  public void setup()
  {
    testSubject = new Q104_MaxDepthOfBinaryTree();
    
    // Height 1
    root1 = testSubject.new TreeNode(1);
    
    // Height 2
    root2 = testSubject.new TreeNode(1);
    root2.left = testSubject.new TreeNode(2);
    root2.right = testSubject.new TreeNode(3);
    
    // Height 3
    root3 = testSubject.new TreeNode(1);
    root3.left = testSubject.new TreeNode(2);
    root3.left.left = testSubject.new TreeNode(3);
  }
  
  @Test
  public void testMaxDepth_givenNull_return0()
  {
    assertEquals(0, testSubject.maxDepth(null));
  }
  
  @Test
  public void testMaxDepth_givenHeight1_return1()
  {
    assertEquals(1, testSubject.maxDepth(root1));
  }
  
  @Test
  public void testMaxDepth_givenHeight2_return2()
  {
    assertEquals(2, testSubject.maxDepth(root2));
  }
  
  @Test
  public void testMaxDepth_givenHeight3_return3()
  {
    assertEquals(3, testSubject.maxDepth(root3));
  }
}
