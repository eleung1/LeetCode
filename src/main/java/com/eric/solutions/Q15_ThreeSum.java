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
  class Pair
  {
    int num1;
    int num2;
    
    Pair(int i, int j)
    {
      num1 = i;
      num2 = j;
    }
    
    public boolean equals(Object o)
    {
      Pair pair = (Pair) o;
      return num1 == pair.num1 && num2 == pair.num2;
    }
    
    public int hashCode()
    {
      return num1 + num2;
    }
  }
  
  public List<List<Integer>> threeSum(int[] nums) 
  {
    if ( nums == null || nums.length < 3) return new LinkedList<List<Integer>>();
    
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    HashSet<Pair> visitedPairs = new HashSet<Pair>();
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    Arrays.sort(nums);
    
    for ( int i = 0; i < nums.length - 2; i ++ )
    {
      for ( int j = i+1; j < nums.length - 1; j ++ )
      {
        Pair currPair = new Pair(nums[i], nums[j]);
        if (!visitedPairs.contains(currPair))
        {
          if (memo.containsKey(nums[i] + nums[j] ))
          {
            List<Integer> triplet = new LinkedList<Integer>(); 
            triplet.add(nums[i]);
            triplet.add(nums[j]);
            triplet.add(memo.get(nums[i] + nums[j]));
            result.add(triplet);
            visitedPairs.add(currPair);
            continue;
          }
          
          int k = Arrays.binarySearch(nums, j+1, nums.length, 0 - nums[i] - nums[j] );
          
          if ( k >= 0 )
          {
            //if ( !visitedNums.contains(nums[i]) || !visitedNums.contains(nums[j]) || !visitedNums.contains(nums[k]) )
            
              // We have not seen these triplets before
              List<Integer> triplet = new LinkedList<Integer>(); 
              triplet.add(nums[i]);
              triplet.add(nums[j]);
              triplet.add(nums[k]);
              result.add(triplet);
              
              /*
              visitedNums.add(nums[i]);
              visitedNums.add(nums[j]);
              visitedNums.add(nums[k]);
              */
              visitedPairs.add(currPair);
              memo.put(nums[i]+nums[j], nums[k]);
          }
         
        }
      }
    }
    
    return result;
  }
}
