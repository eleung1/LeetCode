package com.eric.solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note: 
 * You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * @author Eric Leung
 *
 */
public class Q347_TopKFrequentElements
{
  public List<Integer> topKFrequent(int[] nums, int k) 
  {
    if ( nums == null ) return null;
    
    Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    
    for ( int n : nums )  // O(n)
    {
      if ( countMap.containsKey(n) ) 
      {
        countMap.put(n, countMap.get(n) + 1);  // O(1)
      }
      else
      {
        countMap.put(n, 1);  // O(1)
      }
   
    }
    
    // Using a PriorityQueue to order elements by frequency
    PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<Entry<Integer, Integer>>(countMap.size(), new Comparator<Entry<Integer, Integer>>(){

      public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
      {
        return o2.getValue().compareTo(o1.getValue());
      }
      
    });
    
    // Add entries in our countMap to the priority queue
    for ( Entry<Integer, Integer> e: countMap.entrySet() )  // O(n)
    {
      pq.add(e);  // O(log(n))
    }
    
    List<Integer> topKFrequent = new LinkedList<Integer>();
    int count = 0;
    while ( !pq.isEmpty() )  // O(n)
    {
      topKFrequent.add(pq.poll().getKey());  // O(log(n)
      count++;
      
      if ( count == k ) break;
    }
    
    return topKFrequent;
  }
}
