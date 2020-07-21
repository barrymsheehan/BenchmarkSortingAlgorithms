# Benchmark Sorting Algorithms
A Java command line application which benchmarks the performance of sorting algorithms when sorting integer arrays.

## About
The application takes one or more sorting algorithms, and times their execution when sorting one or more arrays of random integers of specified size(s). Results are generated by calculating the mean running time of an algorithm when sorting a given number of arrays of a specified length. Results of benchmarking are printed to the console in ms format in a neat table.

There are a number of sorting algorithms supplied with the program, but sorting algorithms can be added or removed easily by the user through editing the src files.

### Included Sorting Algorithms
1. Bubble Sort
2. Selection Sort (Implementation created by Nikunj Gandhi at Baeldung.com, found [here](https://www.baeldung.com/java-selection-sort))
3. Quick Sort (Implementation created by Baeldung.com, found [here](https://www.baeldung.com/java-quicksort))
4. Counting Sort
5. Heap Sort (Implementation created by Sandeep Jain at GeeksForGeeks.org, found [here](https://www.geeksforgeeks.org/heap-sort/))

### Compatibility
The program was written working with Java 8. (1.8.0_212). It has not been tested in any other environment.

## Usage

The program can be run by entering this command in a console from the /bin directory of the project:

```
java com.barrysheehan.www.Runner
```

Each sorting algorithm is contained within its own class. A new sorting algorithm can be added by creating a class containing the algorithm which implements the __Sorter__ interface and adding an instance of that class to the __sortingClassList__ ArrayList in the main method of the __Runner__ class.

Once a sorting class has been added in this way, it will be benchmarked alongside any other sorting class in the __sortingClassList__.

### Configuration: The Runner Class
Stores configuration information and creates the objects necessary to perform benchmarking. Contains the below class variables used to configure the program:

1. __numberOfArrays__ (String): The number of arrays to generate for **each** length of array specified in __arrayLengths__.
2. __maxIntSize__ (int): The maximum size that any integer that appears in an integer array can be
3. __arrayLengths__ (int[]): Each value in the array represents the length of a set of arrays against which a sorting class will be benchmarked
4. __sortingClassList__ (ArrayList): Stores an instance of any sorting class to be benchmarked. A user can create an instance of any sorting algorithm that implements the __Sorter__ interface and add it to this ArrayList **using the main method** in order to benchmark it.

### The Sorter Interface
The __Sorter__ interface defines two methods:

1. __getName()__: Returns the name specified in the __name__ field of a sorting class (important when printing the results table to console)
2. __sort()__: Calls the main sorting method (containing the sorting algorithm) of a class that implements the interface

The implementation of this interface is necessary for the function of the __Runner__ class which runs the application, and the __Tester__ class which benchmarks the algorithms.

## Documentation
JavaDocs are supplied for the project [here]()

## Contact
### Barry Sheehan
* Home page: [BarrySheehan.com](http://www.barrysheehan.com)
* Twitter: [@barrymsheehan](https://twitter.com/barrymsheehan)

## License
This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](LICENSE.md) file for details.