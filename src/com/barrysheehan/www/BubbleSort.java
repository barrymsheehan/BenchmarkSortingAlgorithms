package com.barrysheehan.www;

/**
 * Sorts an int[] array using an implementation of Bubble Sort, a stable
 * comparison-based sorting algorithm.
 * 
 * @author Barry Sheehan
 * @version 0.1
 * @since 1.8
 */

public class BubbleSort implements Sorter {
	private String name = "Bubble Sort"; // Name of sorting algorithm

	public String getName() {
		return this.name;
	}

	/**
	 * Sorts an integer array into ascending order using comparisons between
	 * elements in the array.
	 * <p>
	 * [outer] begins at the end of the array and counts down to 0. [inner] begins
	 * at 0. The value at [inner] is compared to the value at [inner + 1]. If the
	 * value at [inner] is larger, the two values are swapped.
	 * <p>
	 * After each iteration of the outer loop, the right-most value included in this
	 * iteration is sorted. [outer] is decremented so that the right-most value is
	 * excluded from the next round of sorting.
	 * <p>
	 * With the largest number pushed to the right in each iteration of the outer
	 * loop, the list becomes fully sorted after its last iteration
	 * 
	 * @param arr the integer array to be sorted
	 */
	public void sort(int[] arr) {

		int outer, inner; // outer and inner iterators

		for (outer = arr.length - 1; outer > 0; outer--) {
			for (inner = 0; inner < outer; inner++) {
				if (arr[inner] > arr[inner + 1]) { // Compare values

					// Swap values
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}
	}
}
