/**
 * 
 */
package sort.quicksort.optim;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import util.array.ArrayUtility;

/**
 * 
 */
public class OptimizedQuickSortAnalysis {
	
	public static TimeAnalysis meanTime(String name, int numberOfExecutions, int length, int i) {	
		Stopwatch watch = new Stopwatch();
		TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
		for (int trial = 0; trial < numberOfExecutions; trial++) {
				int[] a = ArrayUtility.generateIntArray(length, Integer.MIN_VALUE, Integer.MAX_VALUE);
				watch.startWatch();
				//tested code-start	
				 OptimizedQuickSort.sort(a,i);
				// tested code-end
				long time = watch.elapsedTime();
				ta.add(time);
		}
		return ta;
		}
	public static void printMeanExecutionTimeGrowthTable(int numberOfExecutions,
				int min, int increment, int max, int i) {
			System.out.println("Mean execution time growth table");
			System.out.println("  - Method: Quick sort of an array of length N");
			System.out.println("  - Insertion Size of Sort : " + i);
			System.out.println("  - Number of executions (sample size) for time estimation: "+numberOfExecutions);
			System.out.println("|------------|--------|-------|--------|-------------------|");
			System.out.println("|           N|   Mean |  Min  |  Max   |      CI 99.9%     |");
			System.out.println("|------------|--------|-------|--------|-------------------|");
			for (int n=min; n<=max; n+=increment) {
				String name = "Sort a random array of integers with length " + n + ".";
				TimeAnalysis ta = meanTime(name, numberOfExecutions, n,i);
				System.out.printf("|  %9d | %6.1f | %4d  |  %4d  |  (%6.1f, %6.1f) |\n", n,  ta.getMeanTime(),
						ta.getMinTime(), ta.getMaxTime(), ta.getMinMean999Confidence(), ta.getMaxMean999Confidence());
			}
			System.out.println("|------------|--------|------|---------|------------------|");	
			}
			
	public static void main(String[] args) {
		System.out.println(" B32-OptimizedQuickSort-Task3- by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		for(int i=10; i<=50; i+=10)
		printMeanExecutionTimeGrowthTable(21, 1000000, 1000000, 10000000,i);	
			
	}

}
