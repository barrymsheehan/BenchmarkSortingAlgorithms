package com.barrysheehan.www;

import java.util.Random;

/**
 * Creates an array of sub-arrays, with each sub-array containing a number of
 * randomly generated integers, or creates a single array of random integers.
 * <p>
 * The number of arrays created, the length of the arrays, and the maximum value
 * allowed for any integer contained in the arrays are specified by the user
 * before arrays are created.
 * 
 * @author Barry Sheehan
 * @version 0.1
 * @since 1.8
 *
 */

public class RandomArrays {

	/**
	 * Creates multidimensional array of random integers. Each array is created
	 * using the <code>createRandomArray()</code> method
	 * 
	 * @param numberOfArrays the number of sub-arrays of random integers contained
	 *                       within the outer array
	 * @param maxElementSize the maximum value of an integer that can appear in the
	 *                       array
	 * @param arrayLength    the length of the integer array
	 * 
	 * @return array the multidimensional array containing arrays of random integers
	 * 
	 */
	public static int[][] createRandomArrays(int numberOfArrays, int maxElementSize, int arrayLength) {

		int[][] array = new int[numberOfArrays][arrayLength];

		for (int i = 0; i < numberOfArrays; i++) {
			array[i] = createRandomArray(maxElementSize, arrayLength);
		}

		return array;
	}

	/**
	 * Creates an array of random integers with a maximum integer value specified as
	 * <code>maxElementSize</code> and of length specified as
	 * <code>arrayLength</code>
	 * <p>
	 * Integers randomly generated using the <code>java.util.Random</code> class
	 * 
	 * @param maxElementSize the maximum value of an integer that can appear in the
	 *                       array
	 * @param arrayLength    the length of the integer array
	 * 
	 * @return array the array populated with random integers
	 * 
	 * @see java.util.Random
	 */
	private static int[] createRandomArray(int maxElementSize, int arrayLength) {

		int[] array = new int[arrayLength];
		Random rand = new Random(); // Create Random() object

		for (int i = 0; i < arrayLength; i++) {
			array[i] = rand.nextInt(maxElementSize); // Create random int of specified max size
		}

		return array;
	}
}
