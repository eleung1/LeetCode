package com.eric.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Question 350: Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * 
 * @author Eric Leung
 *
 */
public class Q350_IntersectionOfTwoArrays2
{
  public int[] intersect(int[] nums1, int[] nums2) 
  {
    if ( nums1 == null || nums2 == null ) return null;
    
    // Map keeping track of the number of occurrences of each int in nums1
    // key=the int element; value=its number of occurrence in num1
    Map<Integer, Integer> countNums1 = new HashMap<Integer, Integer>();
    
    // Populate the map with elements in nums1
    for ( int n : nums1 )
    {
      if ( countNums1.containsKey(n) )
      { 
        // increment the occurrence count of the existing key
        countNums1.put(n, countNums1.get(n) + 1 );
      }
      else
      {
        // brand new key
        countNums1.put(n, 1);
      }
    }
    
    List<Integer> intersection = new LinkedList<Integer>();
    for ( int n : nums2 )
    {
      Integer count = countNums1.get(n);
      if ( count != null && count > 0 )
      {
        intersection.add(n);
        countNums1.put(n, count-1);
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
  
  /**
   * Follow up:  
   * 
   * i) nums1 and nums2 sorted. We can compare nums2 against num1 from index 0.  Use a fromIndex to keep track of the non-visited portion nums1.
   * 
   * ii) If nums1's size is small compared to num2's size, then we should compare nums1 against nums2.  This way the outer loop
   * will end quicker (i.e. ends as soon as we reach the end of the smaller array).
   * 
   * iii) If elements of nums2 are stored on disk, and the memory is limited such that you cannot 
   * load all elements into the memory at once:
   * Then read chunks of nums2 from disk and search for intersection in nums1.  If we have exhausted all elements in num1, we are done.
   * 
   * iv) If both nums1 and nums2 cannot fit on disk.  If they are sorted:
   * 1.  Read the top(i.e. smallest) element from nums1 and nums2.  
   * 2.  Compare them:
   *       If they are equal, add this number to our resulting intersection list. Read the next value from nums1 and nums2.  Compare them.
   *       If they are not equal, read the next element off the list with the smaller value. Compare again.
   *       ** If we have reached the end of either list, we are done.
   *
   * v) If both nums1 and nums2 cannot fit on disk.  If they are not sorted:
   *    Perform external sort on nums1 and nums2, and then execute the steps in iv). 
   * 
   */
  public int[] intersectSorted(int[] nums1, int[] nums2)
  {
    if ( nums1 == null || nums2 == null ) return null;
    
    // Duo-Pivot Quicksort: O(n log(n))
    Arrays.sort(nums1);  
    Arrays.sort(nums2);
    
    List<Integer> intersection = new LinkedList<Integer>();
    
    // index where we start searching, it will move to the right when we have found an element so we don't double count.
    int fromIndex = 0;  
    for ( int n : nums2 )
    {
      for ( int i = fromIndex; i < nums1.length; i ++ )
      {
        if ( nums1[i] == n )
        {
          intersection.add(n);
          fromIndex = i+1;
          break;
        }
      }
    }
    
    // Create result array
    int[] result = new int[intersection.size()];
    int i = 0;
    for ( int n : intersection )
    {
      result[i++] = n;
    }
    
    return result;
  }
}
