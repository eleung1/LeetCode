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
  }
  
  @Test
  public void test()
  {
    assertNull(testSubject.levelOrderBottom(null));
    
    List<List<Integer>> levelOrder = testSubject.levelOrderBottom(root);
    
    assertEquals(1, levelOrder.get(0).get(0).intValue());
    
    System.out.println(levelOrder);
  }
 
}
