package com.barrysheehan.www;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains a main method which runs the BenchmarkSortingAlgorithms application.
 * <p>
 * Stores configuration information in class variables and uses them along with
 * the <code>RandomArrays</code> and <code>Tester</code> classes to benchmark
 * the sorting algorithms stored in classes which implement <code>Sorter</code>.
 * 
 * @author Barry
 * @version 0.1
 * @see Sorter
 * @see RandomArrays
 * @see Tester
 * @since 1.8
 *
 */

public class Runner {
	private static int numberOfArrays = 10; // No. of random int[] arrays of a given length to be used in testing
	private static int maxIntSize = 1000; // Max size of an int contained in any random int[] array

	// The length of each array to be used in testing
	private static int[] arrayLengths = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };

	// HashMap stores name of sorting class and its benchmarking results
	private static Map<String, double[]> benchmarkResultsMap = new LinkedHashMap<String, double[]>();

	// ArrayList stores each sorting class to be tested
	public static List<Sorter> sortingClassList = new ArrayList<Sorter>();

	/**
	 * Creates arrays to be used in testing using the static method
	 * <code>RandomArrays.createRandomArrays()</code>.
	 * <p>
	 * Calls the static method <code>Tester.test()</code> on each sorting algorithm
	 * class, passing a multidimensional array of integers against which to test it.
	 * Then adds the name of the sorting algorithm and its results to
	 * <code>benchMarkResultsMap</code>.
	 */
	private static void benchmark() {
		for (int i = 0; i < arrayLengths.length; i++) {

			// Create int[][] array based on class variables above to be used to benchmark
			int[][] arrays = RandomArrays.createRandomArrays(numberOfArrays, maxIntSize, arrayLengths[i]);

			// Perform benchmarking tests and store results in benchmarkResultsMap
			for (int j = 0; j < sortingClassList.size(); j++) {
				double thisResult = Tester.test(sortingClassList.get(j), arrays);

				String name = sortingClassList.get(j).getName(); // name field used as key in benchmarkResultsMap

				/*
				 * If no entry exists for this key in benchmarkResultsMap, create one and add
				 * it. Else, add the current result to the results double[] at this key value
				 */
				if (benchmarkResultsMap.get(name) == null) {
					double[] results = new double[arrayLengths.length];
					results[i] = thisResult;
					benchmarkResultsMap.put(name, results);
				} else {
					double[] results = benchmarkResultsMap.get(name);
					results[i] = thisResult;
				}
			}
		}
	}

	/**
	 * Creates an instance of each class containing a sorting algorithm to be
	 * benchmarked, creates the the correct number of arrays of random integers and
	 * benchmarks each sorting algorithm using the <code>test()</code> method of the
	 * <code>Tester</code> class.
	 * 
	 * Creates an instance of each class containing a sorting algorithm to be
	 * benchmarked and adds it to <code>ArrayList</code>
	 * <code>sortingClassList</code>
	 * <p>
	 * Calls the <code>benchmark()</code> method to benchmark each algorithm in
	 * <code>sortingClassList</code> and calls
	 * <code>PrintResultsTable.print()</code> to print the results to console.
	 * 
	 * @see PrintResultsTable
	 * 
	 */
	public static void main(String[] args) {

		// Create instance of each class containing a sorting method to be tested
		sortingClassList.add(new BubbleSort());
		sortingClassList.add(new SelectionSort());
		sortingClassList.add(new QuickSort());
		sortingClassList.add(new CountingSort());
		sortingClassList.add(new HeapSort());

		benchmark();

		PrintResultsTable.print(arrayLengths, benchmarkResultsMap);
	}
}
