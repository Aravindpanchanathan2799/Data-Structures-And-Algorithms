	/**
 * 
 */
	package sort.quicksort.insertion;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import sort.quicksort.optim.OptimizedQuickSort;
import util.array.ArrayUtility;

public class CompareInsertionSize {


	
	/**
	 * compare the mean time execution of quick sort for various insertion sizes.
	 * They all will use the same randomly generated arrays for time measuring.
	 *The sizes are generated starting with the provided startSize with the incrementSize
	 *for the given number of times.
	 *@param numberOfExecutions The number of executions to compute the mean
	 * @param length            The length of the generated random arrays.
	 * @return  the array of time analysis elements (with length number of sizes +1)
	 */
	public static TimeAnalysis[] meanTimeComparison(int numberOfExecutions, int length, int startSize, int incrementSize, int numberSizes) {
	Stopwatch watch = new Stopwatch();
	TimeAnalysis[] ta = new TimeAnalysis[numberSizes+1];
	for (int i=0; i<=numberSizes; i++) {
		int size = startSize + i*incrementSize;
		ta[i]= new TimeAnalysis("insertion size "+size, numberOfExecutions);
	}
	for (int trial = 0; trial < numberOfExecutions; trial++) {
	int[] a0 = ArrayUtility.generateIntArray(length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	
	for (int i=0; i<=numberSizes; i++) {
		int[] a = ArrayUtility.copy(a0);
		int size = startSize + i*incrementSize;
		watch.startWatch();
		OptimizedQuickSort.sort(a, size);
		long time = watch.elapsedTime();
		ta[i].add(time);
		}
	}
	return ta;
}

	public static void printComparisonTable(int numberOfExecutions, int min, int increment, int max, int startSize, int incrementSize, int numberSizes) {
	System.out.println ("Mean execution time growth Comparison table");
	System.out.println("- Number of execution (sample size) for time estimation: "+numberOfExecutions) ;

	System.out.print("|---------------");
	for (int i=0; i<=numberSizes; i++)
		System.out.print("--------|");
	System.out.println();
	
	System.out.print("|      N\\SIZE  |");
	for (int i=0; i<=numberSizes; i++) {
	   int size = startSize + i*incrementSize;	
	   System.out.printf(" %6s |", size);
	}
	System.out.println();
	
	System.out.print("|--------------|");
	for (int i=0; i<=numberSizes; i++)
		System.out.print("--------|");
	System.out.println();
		
	for (int n=min; n<=max; n+=increment) {
	    TimeAnalysis[] ta = meanTimeComparison(numberOfExecutions, n, startSize, incrementSize, numberSizes);
	    System.out.printf("| %9d    |", n);
	    for (int i=0; i<=numberSizes; i++) {	
	    	System.out.printf(" %6.1f |", ta[i].getMeanTime()) ;	
	    }	
	    System.out.println();
	}
	System.out.print("|--------------|");
	for (int i=0; i<=numberSizes; i++)
		System.out.print("--------|");
	System.out.println();
}

	public static void main(String[] args) {
		System.out.println("B33 ComparisonSort- Task 3 - by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		printComparisonTable(21, 1000000, 1000000, 10000000, 0, 25, 10);
	}
	}





	
	
	
	
	
	
	
	