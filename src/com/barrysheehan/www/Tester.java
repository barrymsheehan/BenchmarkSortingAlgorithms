package com.barrysheehan.www;

/**
 * Returns the mean time taken by a given sorting algorithm to sort a given
 * array of integer arrays.
 * <p>
 * A sorting algorithm class passed to the <code>Tester</code>'s
 * <code>test()</code> method must implement the <code>Sorter</code> interface
 * and contain its sorting algorithm in a sort(int[] arr) method.
 * 
 * @author Barry Sheehan
 * @version 0.1
 * @see Sorter
 * @since 1.8
 *
 */

public class Tester {

	/**
	 * Clones each array in the multidimensional array passed as a parameter and
	 * sorts this copy. Captures <code>System.nanoTime()</code> before and after
	 * each sort and logs the running time in milliseconds.
	 * 
	 * @param s      the sorting algorithm class implementing Sorter
	 * @param arrays an array of integer arrays to be sorted
	 * 
	 * @return the average running time of the input sorting algorithm in
	 *         milliseconds by calling <code>averageArray()</code>
	 * 
	 */

	public static double test(Sorter s, int[][] arrays) {

		// log array stores the run time of each sort performed in nanoseconds
		double[] log = new double[arrays.length];

		for (int i = 0; i < arrays.length; i++) {

			// clone array so that original, unsorted array is not changed and can be reused
			int[] testArray = arrays[i].clone();

			long startTime = System.nanoTime();
			s.sort(testArray);
			long endTime = System.nanoTime();

			long timeElapsedNanos = endTime - startTime;
			double timeElapsedMillis = timeElapsedNanos / 1000000.0;

			log[i] = timeElapsedMillis;
		}

		// Call averageArray method on the nanosecond values stored in the log
		// Return the mean running time in milliseconds as a double value
		return averageArray(log);
	}

	/**
	 * Calculates the mean of the values stored in input array
	 * <code>double[] arr</code>.
	 * <p>
	 * Values passed to the method in the array will be running times for a sorting
	 * algorithm in nanotime. The mean value is converted to milliseconds before the
	 * mean is returned.
	 * 
	 * @param arr an array of double values from which to calculate a mean
	 * 
	 * @return the mean of the input nanosecond time values in milliseconds
	 */

	private static double averageArray(double[] arr) {

		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum / arr.length;
	}

}
