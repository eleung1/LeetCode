package com.eric.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 217: Contains duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author Eric Leung
 * 
 */
public class Q217_ContainsDuplicate
{
  public boolean containsDuplicate(int[] nums) 
  {
    Set<Integer> visited = new HashSet<Integer>();
    for ( int i : nums )
    {
      if ( visited.contains(i) ) return true;
      
      visited.add(i);
    }
    
    return false;
  }
}
