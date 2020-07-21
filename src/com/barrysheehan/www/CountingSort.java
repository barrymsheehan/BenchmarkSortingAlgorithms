package com.barrysheehan.www;

/**
 * Sorts an int[] array using an implementation of Counting Sort, a stable
 * non-comparison sorting algorithm.
 * <p>
 * Counting Sort counts the frequency at which each distinct integer appears in
 * an array and stores this values in a separate count array. The values in the
 * count array are then used to populate a new array with the correct number of
 * each value in sorted order.
 * 
 * @author Barry Sheehan
 * @version 0.1
 * @since 1.8
 */

public class CountingSort implements Sorter {
	private String name = "Counting Sort"; // Name of sorting algorithm

	public String getName() {
		return this.name;
	}

	/**
	 * Sorts an array of integers into ascending order by counting the frequency at
	 * which each distinct integer appears in the array.
	 * <p>
	 * A secondary count array is created to store the frequency at which each
	 * distinct integer appears in the input array. The value at each index in the
	 * count array is incremented when an integer with a value equal to that index
	 * is encountered in the input array.
	 * <p>
	 * Once the input array has been iterated over, any value stored in the count
	 * array will refer to the number of times that that index number appears in the
	 * original input array.
	 * <p>
	 * Finally, the value at each index of the count array is added to the value at
	 * the index that comes before it. The count array thus stores the position of
	 * the last appearance of its own index number in the final sorted array. The
	 * count array is then used to populate the final sorted array with the correct
	 * number of duplicates of each distinct integer from the input array.
	 * 
	 * @param arr the integer array to be sorted
	 */

	public void sort(int[] arr) {

		int n = arr.length; // Length of unsorted input array
		int output[] = new int[n]; // Array of same length to store sorted array

		/*
		 * count array initialised to length 1000 in this implementation, but can be
		 * made longer or shorter if required
		 */

		int count[] = new int[1000]; // Will store number of times each distinct value appears in input array
		for (int i = 0; i < 1000; ++i)
			count[i] = 0; // Initialise each value to 0, to be incremented during counting

		/*
		 * Take each value stored in the input array to be an index of the count array.
		 * Each time this value is encountered in the input array, increment the value
		 * at this index in the count array by 1
		 */

		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		/*
		 * Add the value at each index in the count array to the value at the index
		 * before it.
		 * 
		 * Each value stored in the count array thus represents the position of the last
		 * appearance of its index number in the final sorted array.
		 */

		for (int i = 1; i <= 999; ++i)
			count[i] += count[i - 1];

		/*
		 * In reverse order, populate the output array with the correct number of
		 * duplicates of each number from the unsorted input array as specified by the
		 * count array.
		 */

		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		/*
		 * Copy all of the values stored in the output array to the unsorted input
		 * array, arr.
		 * 
		 * The input array thus contains the same elements but in sorted order.
		 */

		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}
}