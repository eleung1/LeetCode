package com.eric.solutions;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q94_BinaryTreeInorderTraversal.TreeNode;

public class Q94_BinaryTreeInorderTraversalTest
{
  private Q94_BinaryTreeInorderTraversal testSubject;
  
  private TreeNode root1;
  
  @Before
  public void setup()
  {
    testSubject = new Q94_BinaryTreeInorderTraversal();
    root1 = testSubject.new TreeNode(1);
    root1.right = testSubject.new TreeNode(2);
    root1.right.left = testSubject.new TreeNode(3);
  }
  
  @Test
  public void testInorderTraversal()
  {
    List<Integer> rc = testSubject.inorderTraversal(root1);
    
    for ( int i: rc )
    {
      System.out.println(i);
    }
  }
}
