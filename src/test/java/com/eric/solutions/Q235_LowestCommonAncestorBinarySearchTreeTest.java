package com.eric.solutions;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.eric.solutions.Q235_LowestCommonAncestorBinarySearchTree.TreeNode;

public class Q235_LowestCommonAncestorBinarySearchTreeTest
{
  private Q235_LowestCommonAncestorBinarySearchTree testSubject;
  
  private TreeNode root;
  
  private TreeNode root6;
  private TreeNode node2;
  private TreeNode node8;
  private TreeNode node4;
  
  @Before
  public void setup()
  {
    testSubject = new Q235_LowestCommonAncestorBinarySearchTree();
    
    // 1-node tree
    root = testSubject.new TreeNode(6);
    
    // general tree
    root6 = testSubject.new TreeNode(6);
    node2 = testSubject.new TreeNode(2);
    node8 = testSubject.new TreeNode(8);
    node4 = testSubject.new TreeNode(4);
    
    root6.left = node2;
    root6.right = node8;
    node2.left = testSubject.new TreeNode(0);
    node2.right = node4;
    node4.left = testSubject.new TreeNode(3);
    node4.right = testSubject.new TreeNode(5);
    node8.left = testSubject.new TreeNode(7);
    node8.right = testSubject.new TreeNode(9);
  }
  
  @Test
  public void testFindPath()
  {
    Stack<TreeNode> stack = testSubject.findPath(root, root);
    assertEquals(6, stack.pop().val);
    assertTrue(stack.isEmpty());
    
    Stack<TreeNode> stack2 = testSubject.findPath(root6, node4);
    assertEquals(4, stack2.pop().val);
    assertEquals(2, stack2.pop().val);
    assertEquals(6, stack2.pop().val);
    assertTrue(stack2.isEmpty());
  }
  
  @Test
  public void testLowestCommonAncestor()
  {
    assertNull(testSubject.lowestCommonAncestor(null, null, null));
    assertEquals(root, testSubject.lowestCommonAncestor(root, root, root));
    assertEquals(root6, testSubject.lowestCommonAncestor(root6, node2, node8));
    assertEquals(node2, testSubject.lowestCommonAncestor(root6, node2, node4));
    assertEquals(node2, testSubject.lowestCommonAncestor(root6, node4, node2));
  }
}
