package com.eric.solutions;

/**
 * Question 189: Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array 
 * [1,2,3,4,5,6,7] is rotated to
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
  /**
   * Cloning the array, then simply update the array elements
   * base on their shifted index.
   * 
   * Time O(n)
   * Space O(n)
   *
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) 
  {
    int[] numsClone = nums.clone();
    
    for ( int i = 0; i < numsClone.length; i ++ )
    {
      nums[(i+k)%nums.length] = numsClone[i];
    }
    
  }
  
  /**
   * Bubble up the last element to index 0, which has 
   * the same effect has rotating the array 1 step to the right.
   * 
   * Do this k times, and we have rotated the array k-steps to the right.
   * 
   * Time: O(n*k)
   * Space: O(1)
   * 
   * @param nums
   * @param k
   */
  public void rotateBubbleUp(int[] nums, int k)
  {
    while ( k > 0 )
    {
      for ( int i = nums.length - 1; i > 0; i -- )
      {
        int temp = nums[i-1];
        nums[i-1] = nums[i];
        nums[i] = temp;
      }
      k--;
    }
  }
  
  /**
   * Split the array into 2 parts
   * 
   * [0 to length-k-1] | [length-k to length-1]
   * 
   * Example:
   * Given:    [1 2 3 4 5]   k=2
   * Expected: [4 5 1 2 3]
   * 
   * 1.  Split array into:
   * [1 2 3] [4 5]
   * 
   * 2.  Reverse both sections:
   * [3 2 1] [5 4]
   * 
   * 3.  Reverse whole array(done):
   * [4 5 1 2 3]
   * 
   * Time: O(n)
   * Space: O(1)
   * 
   * @param nums
   * @param k
   */
  public void rotateWithReverse(int[] nums, int k)
  {
    if ( k > nums.length ) k = k%nums.length;
    
    // reverse 0 to length-k-1
    reverseHelper(nums, 0, nums.length-k);
    
    // reverse length-k to length
    reverseHelper(nums, nums.length-k, nums.length);
    
    // reverse whole array
    reverseHelper(nums, 0, nums.length);
  }
  
  /**
   * Helper method that reverse a portion of the array between
   * index start and index end.
   * 
   * @param nums The array
   * @param start The start index (inclusive)
   * @param end The end index (exclusive)
   */
  public void reverseHelper(int[] nums, int start, int end)
  {
    for ( int i = start; i < (start+end) / 2; i++ )
    {
      int temp = nums[i];
      nums[i] = nums[end-i+start-1];
      nums[end-i+start-1] = temp;
    }
  }
  
  
}
