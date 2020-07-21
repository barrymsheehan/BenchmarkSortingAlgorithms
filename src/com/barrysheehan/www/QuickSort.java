package com.barrysheehan.www;

/**
 * Sorts an int[] array using an implementation of Quick Sort, an unstable
 * efficient comparison-based sorting algorithm.
 * <p>
 * Quick Sort sorts an array by selecting a "pivot point" within the array. All
 * values smaller than the value at this pivot point are moved to its left, and
 * all values larger are moved to its right, creating two subarrays of integers.
 * <p>
 * This process is repeated recursively until there are no more values to be
 * rearranged. Finally the array is rebuilt in sorted order.
 * <p>
 * This implementation of the Quick Sort algorithm can be found on Baeldung.com
 * at the url below. I added the sort() method to allow sorting by passing only
 * one parameter, the int[] array to be sorted
 * 
 * https://www.baeldung.com/java-quicksort
 * 
 * @author Baeldung.com
 *
 */

public class QuickSort implements Sorter {
	private String name = "Quick Sort";

	public String getName() {
		return this.name;
	}

	/**
	 * Calls the <code>quickSort()</code> method passing the input array to be
	 * sorted, the first index of the array and the last index of the array.
	 * <p>
	 * This method was added to allow <code>quickSort()</code> to be called passing
	 * only one argument, the array to be sorted. The pivot point selected is the
	 * final index in the input array.
	 * 
	 * @param arr the integer array to be sorted
	 * 
	 */
	public void sort(int[] arr) { // Allows method to be called passing only the array as parameter
		quickSort(arr, 0, arr.length - 1);
	}

	/**
	 * Sorts the values in an int[] array by comparing elements in the array.
	 * <p>
	 * Creates a pivot point (partitioning index) by calling the
	 * <code>partition()</code> method on the input array and recursively calls
	 * itself on the subarrays to the left and the right of this partition index.
	 * 
	 * @param arr   the integer array to be sorted
	 * @param begin the index of the first element in this partition of the array
	 * @param end   the index of the last element in this partition of the aray
	 * 
	 */
	public void quickSort(int arr[], int begin, int end) {

		if (begin < end) { // base case, if begin index => end index, do not make further recursive calls
			int partitionIndex = partition(arr, begin, end);
			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	/**
	 * Swaps all elements in an array smaller than the pivot index to its left, and
	 * swaps all element in an array larger than the pivot index to its right.
	 * <p>
	 * i = (begin - 1) allows swapping first value of j <= pivot with 0th element
	 * 
	 * @param arr   the integer array to be sorted
	 * @param begin the index of the first element in this partition of the array
	 * @param end   the index of the last element in this partition of the aray
	 * 
	 * @return the pivot value which is in its final, sorted, position
	 */
	private int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {

			if (arr[j] <= pivot) {
				i++;

				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		/*
		 * After above operations, value at i and values before it in the array must be
		 * smaller than the pivot value
		 * 
		 * Placing the pivot value at i + 1 places it in its final, sorted, position
		 * 
		 * Finally, return index of pivot point to be used when making recursive calls
		 * to quickSort() above
		 */

		int swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}
}
