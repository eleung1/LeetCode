package com.eric.solutions;

import java.util.Arrays;

/**
 * Question 169: Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [n/2] times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * 
 * @author Eric Leung
 * 
 */
public class Q169_MajorityElement
{
  /**
   * Idea: sort the array, the "majority" element will either be on the 
   * lower half or upper half.
   * 
   * Examples:
   * If we have even number of elements: 
   * 1 1 1 1 2 2
   * 1 1 2 2 2 2
   * arr[n/2] == arr[n/2 +1]
   * 
   * If we have odd number of elements:
   * 1 1 1 2 2 >> arr[n/2] == arr[n/2 +1], return arr[n/2] 
   * 1 1 2 2 2 >> arr[n/2] != arr[n/2 +1], return arr[n/2 +1]
   * 
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) 
  {
    Arrays.sort(nums);
    int size = nums.length;
    int mid = nums[size/2]-1;
    if ( mid == nums[size/2] ) 
    {
      return mid;
    }
    else
    {
      return nums[size/2];
    }
  }
}
