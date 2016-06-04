package com.eric.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 15: 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 * 
 * @author Eric Leung
 *
 */
public class Q15_ThreeSum
{
  public List<List<Integer>> threeSum(int[] nums) 
  {
    if ( nums == null || nums.length < 3) return new LinkedList<List<Integer>>();
    
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    
    // Sort the array of ints in non-descending order
    Arrays.sort(nums);
    
    for ( int i = 0; i < nums.length - 2; i ++ )
    {
      if ( nums[i] > 0 ) break; // sum of positive integers will not be zero.
      
      // we have seen this number before, which means we have already considered a triplet with nums[i]
      if ( i >= 1 && nums[i] == nums[i-1] ) continue;
      
      for ( int j = i+1; j < nums.length - 1; j ++ )
      {
        // we have seen this number before, which means we have already considered a triplet with nums[i] && nums[j]
        if ( j > i+1 && (nums[j]==nums[j-1])) continue;
        
        // if the sum of the first 2 ints are >= zero, then adding a third positive int will not yield zero.
        if ( (nums[i] != 0 || nums[j] != 0) && nums[i] + nums[j] >= 0 ) break;
        
        int k = Arrays.binarySearch(nums, j+1, nums.length, 0 - nums[i] - nums[j] );
        
        if ( k >= 0 )
        {          
          List<Integer> triplet = new LinkedList<Integer>(); 
          triplet.add(nums[i]);
          triplet.add(nums[j]);
          triplet.add(nums[k]);
          result.add(triplet);
        }
        
      }
    }
    
    return result;
  }
}
