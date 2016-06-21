package com.eric.solutions;

/**
 * Question 292: Nim Game
 * 
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 
 * Hint: If there are 5 stones in the heap, could you figure out a way to remove
 * the stones such that you will always be the winner?
 * 
 * @author Eric Leung
 * 
 */
public class Q292_NimGame
{
  public boolean canWinNim(int n) 
  {
    if ( n < 1 ) return false;  // no stone, no game
    
    // I lose if the number of stones are divisible by 4 because:
    // For each sets of 4 stones:
    //   If I take 1, opponent will take 3
    //   If I take 2, opponent will take 2
    //   If I take 3, opponent will take 1
    //   This will continue for each subset of 4 stones until we run out of stones.
    if ( n % 4 == 0 ) return false;      
    
    return true;
  }
}
