package com.eric.solutions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q107_BinaryTreeLevelOrderTraversal2.TreeNode;

public class Q107_BinaryTreeLevelOrderTraversal2Test
{
  private Q107_BinaryTreeLevelOrderTraversal2 testSubject;
  private TreeNode root;
  
  @Before
  public void setup()
  {
    testSubject = new Q107_BinaryTreeLevelOrderTraversal2();
    
    root = testSubject.new TreeNode(1);
    root.left = testSubject.new TreeNode(2);
    root.right = testSubject.new TreeNode(3);
    root.left.left = testSubject.new TreeNode(4);
    root.left.right = testSubject.new TreeNode(5);
    root.right.left = testSubject.new TreeNode(6);
    root.right.right = testSubject.new TreeNode(7);
  }
  
  @Test
  public void test()
  {
    assertTrue(testSubject.levelOrderBottom(null).isEmpty());
    
    List<List<Integer>> levelOrder = testSubject.levelOrderBottom(root);
    
    List<Integer> level0 = levelOrder.get(0);
    List<Integer> level1 = levelOrder.get(1);
    List<Integer> level2 = levelOrder.get(2);
    assertArrayEquals(level0.toArray(new Integer[0]), new Integer[]{4,5,6,7});
    assertArrayEquals(level1.toArray(new Integer[0]), new Integer[]{2,3});
    assertArrayEquals(level2.toArray(new Integer[0]), new Integer[]{1});
    System.out.println(levelOrder);
  }
 
}
