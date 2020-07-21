package com.barrysheehan.www;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * Prints table to console displaying all benchmarking results
 * <p>
 * The top row contains the text "Array Lengths", followed by a column
 * describing the length of the array used to generate the results in each row
 * below
 * <p>
 * A row is created for each sorting algorithm, with each benchmarking result
 * printed in the appropriate column
 * 
 * @see DecimalFormat
 * @see Map
 */

public class PrintResultsTable {
	private static DecimalFormat fmt; // Used to format double values before printing to console

	public static void print(int[] arrayLengths, Map<String, double[]> resultsMap) {

		fmt = new DecimalFormat("0.000"); // Format doubles to 3 fractional places
		fmt.setDecimalSeparatorAlwaysShown(true); // Ensure trailing zeroes are included

		// Welcome, inform user that results are shown in ms
		System.out.println("\nBenchmark Sorting Algorithms v0.1");
		System.out.println("Results printed below are in ms, precise to three fractional places.\n");

		// Length row
		System.out.print("Array Length:\t");
		for (int i = 0; i < arrayLengths.length; i++) {
			System.out.print(arrayLengths[i] + "\t");
		}

		System.out.println("\n"); // Spacing

		// Results rows
		for (Map.Entry<String, double[]> entry : resultsMap.entrySet()) {
			System.out.print(entry.getKey() + ":\t");

			for (int i = 0; i < entry.getValue().length; i++) {
				System.out.print(fmt.format(entry.getValue()[i]) + "\t");
			}
			System.out.println(); // Ensure each row starts on a new line
		}
	}
}
