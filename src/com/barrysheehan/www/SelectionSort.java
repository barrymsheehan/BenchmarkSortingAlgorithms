package com.barrysheehan.www;

/**
 * Sorts an int[] array using an implementation of Selection Sort, an unstable
 * comparison-based sorting algorithm.
 * <p>
 * Selection sort loops over an array moving the smallest value therein to the
 * beginning of the array. This value is excluded from subsequent loops, so that
 * the array is eventually sorted into ascending order.
 * <p>
 * This implementation of Selection Sort was written by Nikunj Gandi and can be
 * found on Baeldung.com at the url below
 * 
 * https://www.baeldung.com/java-selection-sort
 * 
 * @author Nikunj Gandhi, Baeldung.com
 */

public class SelectionSort implements Sorter {
	private String name = "Selection Sort";

	public String getName() {
		return this.name;
	}

	/**
	 * Variable minElmentIndex is created to store the index of the smallest value
	 * stored in the array. It is initialised to i (0 in the first iteration).
	 * <p>
	 * A second inner loop iterates through each subsequent index in the array [j]
	 * and compares the value stored at that index with the value stored at
	 * minElementIndex. If the value at [j] is smaller than the value stored ad
	 * [minElementIndex], j is stored in minElement index and iteration continues.
	 * <p>
	 * When the inner loop iterates over the entire array, the value stored at
	 * [minElementIndex] is compared to the value stored at [i] in the outer loop.
	 * If the value at [minElementIndex] is smaller, the two values are swapped.
	 * <p>
	 * The value at [i] is now the smallest value considered in this iteration of
	 * the outer loop, and is in its final position at the lowest possible index for
	 * that loop.
	 * 
	 * @param arr the integer array to be sorted
	 */
	public void sort(int[] arr) {

		/*
		 * Initialise minElementIndex to i. If element at [minElementIndex] is larger
		 * than element at [j], update variable minElementIndex to store index [j]
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			int minElementIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minElementIndex] > arr[j]) { //
					minElementIndex = j;
				}
			}

			/*
			 * If minElementIndex does not contain the same value as i swap the two values
			 */
			if (minElementIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minElementIndex];
				arr[minElementIndex] = temp;
			}
		}
	}
}
