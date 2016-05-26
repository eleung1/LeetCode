package com.eric.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 349: Intersection of Two Arrays
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author Eric Leung
 * 
 */
public class Q349_IntersectionOfTwoArrays
{
  public int[] intersection(int[] nums1, int[] nums2)
  {
    if ( nums1 == null || nums2 == null ) return null;
    
    Set<Integer> intersection = new HashSet<Integer>();
    
    // Put elements of num1 into a set
    Set<Integer> nums1Set = new HashSet<Integer>();
    for ( int n : nums1 )
    {
      nums1Set.add(n);
    }
    
    // Examine elements in num2 against num1's set
    for ( int n: nums2 )
    {
      if ( nums1Set.contains(n) )
      {
        // if num1Set contains the current element, we have found an intersection
        intersection.add(n);
      }
    }
    
    // Create the result array
    int[] result = new int[intersection.size()];
    int i = 0;
    for ( int n: intersection )
    {
      result[i++] = n;
    }
    
    return result;
  }
}
