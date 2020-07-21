package com.barrysheehan.www;

/**
 * Defines a <code>sort()</code> method used to sort an array of integers.
 * <p>
 * For a sorting algorithm to be benchmarked, it should be contained in
 * its own class, with its algorithm contained in the
 * <code>sort(int[] arr)</code> method.
 * <p>
 * Implementation of this interface is required in order for a sorting
 * algorithm class to be passed to the <code>test()</code> method of the
 * <code>Tester</code> class.
 * 
 * @author Barry Sheehan
 * @version 0.1
 * @see Tester
 * @since 1.8
 *
 */

public interface Sorter {
	
	public String getName(); // Return the name of this sorter
	
	/**
	 * Execute the sorting method of the implementing class
	 * 
	 * @param arr the integer array to be sorted
	 */
	public void sort(int[] arr);
}
