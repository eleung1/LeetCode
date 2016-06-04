package com.eric.solutions;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.eric.solutions.Q94_BinaryTreeInorderTraversal.TreeNode;

public class Q94_BinaryTreeInorderTraversalTest
{
  private Q94_BinaryTreeInorderTraversal testSubject;
  
  private TreeNode root1;
  
  private TreeNode root2;
  
  private TreeNode root3;
  
  private TreeNode root4;
  
  @Before
  public void setup()
  {
    testSubject = new Q94_BinaryTreeInorderTraversal();
    root1 = testSubject.new TreeNode(1);
    root1.right = testSubject.new TreeNode(2);
    root1.right.left = testSubject.new TreeNode(3);
    
    root2 = testSubject.new TreeNode(1);
    root2.left = testSubject.new TreeNode(2);
    root2.left.left = testSubject.new TreeNode(3);
    root2.right = testSubject.new TreeNode(4);
    root2.right.left = testSubject.new TreeNode(5);
    
    root3 = testSubject.new TreeNode(2);
    root3.right = testSubject.new TreeNode(3);
    root3.right.right = testSubject.new TreeNode(1);
    
    root4 = testSubject.new TreeNode(3);
    root4.left = testSubject.new TreeNode(4);
    root4.left.right = testSubject.new TreeNode(2);
    root4.left.right.right = testSubject.new TreeNode(1);
  }
  
  @Test
  public void testInorderTraversal()
  {
    List<Integer> rc = testSubject.inorderTraversal(root1);
    
    assertArrayEquals(new Integer[]{1,3,2}, rc.toArray(new Integer[0]));
  }
  
  @Test
  public void testInorderTraversalIterative()
  {
    List<Integer> rc = testSubject.inorderTraversalIterative(root2);
    
    assertArrayEquals(new Integer[]{3,2,1,5,4}, rc.toArray(new Integer[0]));
  }
  
  @Test
  public void testInorderTraversalIterative_rightBranchOnly()
  {
    List<Integer> rc = testSubject.inorderTraversalIterative(root3);
    
    assertArrayEquals(new Integer[]{2,3,1}, rc.toArray(new Integer[0]));
  }
  
  @Test
  public void testInorderTraversalIterative_leftBranchOnly()
  {
    List<Integer> rc = testSubject.inorderTraversalIterative(root4);
    
    assertArrayEquals(new Integer[]{4,2,1,3}, rc.toArray(new Integer[0]));
  }
}
