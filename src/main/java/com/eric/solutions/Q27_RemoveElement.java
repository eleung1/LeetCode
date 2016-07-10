package com.eric.solutions;

/**
 * Question 27: Remove element
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * Hint:
 * 
 * Try two pointers. Did you use the property of
 * "the order of elements can be changed"? What happens when the elements to
 * remove are rare?
 * 
 * @author Eric Leung
 *
 */
public class Q27_RemoveElement
{
  public int removeElement(int[] nums, int val) 
  {
    if (nums == null || nums.length == 0) return 0;
    if ( nums.length == 1 ) return nums[0] == val ? 0 : 1;
    
    int count = 0;
    
    // rightmost element that is not equal to val.
    // elements to its right are val
    int pivot = nums.length - 1;  
    
    // move pivot to the left until nums[pivot] is not the value to be removed
    while ( pivot >= 0 && nums[pivot] == val)
    {
      pivot--;
      count++;
    }
    
    // All elements are to be removed
    if ( count == nums.length) return 0;
    
    for ( int i = 0; i <= pivot; i ++ )
    {
      if ( nums[i] == val )
      {
        nums[i] = nums[pivot];
        nums[pivot] = val;
        
        // move pivot to the left until nums[pivot] is not the value to be removed
        while ( pivot >= 0 && nums[pivot] == val)
        {
          pivot--;
          count++;
        }
      }
    }
    
    return nums.length - count;
  }
}
