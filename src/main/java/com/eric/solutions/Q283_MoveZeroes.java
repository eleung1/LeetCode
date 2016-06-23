package com.eric.solutions;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: 
 * You must do this in-place without making a copy of the array. 
 * Minimize the total number of operations.
 * 
 * 
 * @author Eric Leung
 * 
 */
public class Q283_MoveZeroes
{
  /**
   * Idea: pivot
   * Start pivot as the last element 
   * Examine first/curr element, if it is zero, shift everything to left, move zero to end, pivot--
   * If the new current element is still zero, do the shift again.  Otherwise, advance curr to the right.
   * Stop when curr has reached the pivot.
   * 
   * 0 0 (1)
   * 0 (1) 0
   * (1) 0 0
   * ------
   * 0 0 1 0 3 (12) 
   * 0 1 0 3 (12) 0
   * 1 0 3 (12) 0 0
   * 
   * @param nums
   */
  public void moveZeroes(int[] nums) 
  {
    if ( nums == null || nums.length < 2 ) return;
    
    int pivot = nums.length - 1;
    int curr = 0;
    while ( curr < pivot )
    {
      if ( nums[curr] == 0 )
      {
        shiftLeft(nums, curr);
        pivot--;
      }
      else
      {
        curr++;
      }
    }
  }
  
  /**
   * Helper method that shift array one index to the left.
   * zeroIndex is where we originally found the zero, after the shift
   * it will contain the element in zeroIndex+1.  zeroIndex+1 will 
   * contain the element in zeroIndex+2, and so on.
   * 
   * @param nums
   * @param zeroIndex
   */
  public void shiftLeft(int[] nums, int zeroIndex)
  {
    // shift everything 1 to the left
    for ( int i = zeroIndex; i < nums.length - 1; i++)
    {
      nums[i] = nums[i+1];
    }
    
    // put zero at last
    nums[nums.length-1] = 0;
  }
}
