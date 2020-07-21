package com.barrysheehan.www;

/**
 * Sorts an int[] array using an implementation of Heap Sort, an unstable
 * efficient comparison-based sorting algorithm.
 * <p>
 * Heap Sort creates a "heap" or tree structure, pushing the element with the
 * largest value to the "root". It then places this largest value at the end of
 * the sorted array. This process is repeated recursively until the array has
 * been sorted.
 * <p>
 * This implementation of the Heap Sort algorithm was written by Sandeep Jain
 * and can be found on GeeksForGeeks.org at the url below.
 * 
 * https://www.geeksforgeeks.org/heap-sort/
 * 
 * @author Sandeep Jain, GeeksForGeeks.org
 *
 */

public class HeapSort implements Sorter {
	private String name = "Heap Sort"; // Name of sorting algorithm

	public String getName() {
		return this.name;
	}

	/**
	 * Sorts an array of integers into ascending order using comparisons between
	 * elements in the array.
	 * <p>
	 * Considering the input array as a tree structure, iterate over each element
	 * which has a child node / is not a leaf node and call the
	 * <code>heapify()</code> method on that element.
	 * <p>
	 * Beginning iteration at n / 2 - 1 and count down to 0, considering any element
	 * after this index to be a child / leaf node.
	 * <p>
	 * The result of calling the <code>heapify()</code> method on all elements with
	 * at least one child will be a "max heap", an array in which the first element
	 * is the largest.
	 * 
	 * @param arr the integer array to be sorted
	 */
	public void sort(int[] arr) {
		int n = arr.length;

		// Call heapify() on all elements with at least one child node
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		/*
		 * Loop through the heapified array in reverse, moving the root (the largest
		 * element) to the end of the array.
		 * 
		 * Recursively call heapify() on the same array, without including the already
		 * sorted element at the last index.
		 */
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Recursive call to heapify
			heapify(arr, i, 0);
		}
	}

	/**
	 * Compares the values of a given root node and its two leaf nodes and swaps the
	 * values until the largest value is the root node.
	 * <p>
	 * Take an element from the array ([i]), its left child, l ([2 * i + 1]) and its
	 * right child, r ([2 * i + 2]). These represent the root of a tree structure
	 * [i] its two children / leaves, l and r.
	 * <p>
	 * Set value of largest to i, then compare the value of largest to the value of
	 * l and, if the value of l is larger, swap the values. Repeat this process
	 * using the value of r.
	 * 
	 * @param arr the integer array to be sorted
	 * @param n   the length of the array to be sorted
	 * @param i   the index of the current node defined by the <code>sort()</code>
	 *            method
	 * 
	 */
	void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		// Compare left child to root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// Compare right child to root
		if (r < n && arr[r] > arr[largest])
			largest = r;

		/*
		 * If the value stored in largest is not the value of i, swap the value of i
		 * with the value of largest.
		 * 
		 * Recursively call the heapify() method passing the value of largest as the
		 * "root".
		 * 
		 * The result is that the largest value will be the "root" node of the three
		 * elements in question when the process has finished.
		 */

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest); // Recursive call to heapify()
		}
	}
}