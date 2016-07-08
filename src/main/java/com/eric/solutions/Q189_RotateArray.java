package com.eric.solutions;

/**
 * Question 189: Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * Hint: Could you do it in-place with O(1) extra space?
 * 
 * @author Eric Leung
 * 
 */
public class Q189_RotateArray
{
  public void rotate(int[] nums, int k) 
  {
    int[] numsClone = nums.clone();
    
    for ( int i = 0; i < numsClone.length; i ++ )
    {
      nums[(i+k)%nums.length] = numsClone[i];
    }
    
  }
}
