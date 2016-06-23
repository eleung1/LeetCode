package com.eric.solutions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q100_SameTree.TreeNode;

public class Q100_SameTreeTest
{
  private Q100_SameTree testSubject;
  
  // 1 node
  private TreeNode root1;
  private TreeNode root2;
  private TreeNode root3;
  
  // multi nodes
  private TreeNode root4;
  private TreeNode root5;
  private TreeNode root6;
  
  @Before
  public void setup()
  {
    testSubject = new Q100_SameTree();
    
    root1 = testSubject.new TreeNode(1);
    root2 = testSubject.new TreeNode(1);
    root3 = testSubject.new TreeNode(2);
    
    root4 = testSubject.new TreeNode(1);
    root4.left = testSubject.new TreeNode(2);
    root4.right = testSubject.new TreeNode(3);
    
    root5 = testSubject.new TreeNode(1);
    root5.left = testSubject.new TreeNode(2);
    root5.right = testSubject.new TreeNode(3);
    
    root6 = testSubject.new TreeNode(1);
    root6.left = testSubject.new TreeNode(2);
    root6.right = testSubject.new TreeNode(4);
  }
  
  @Test
  public void testIsSameTree()
  {
    assertTrue(testSubject.isSameTree(null, null));
    
    assertTrue(testSubject.isSameTree(root1, root2));
    
    assertFalse(testSubject.isSameTree(root1, root3));
    
    assertTrue(testSubject.isSameTree(root4,  root5));
    
    assertFalse(testSubject.isSameTree(root5, root6));
  }
}
