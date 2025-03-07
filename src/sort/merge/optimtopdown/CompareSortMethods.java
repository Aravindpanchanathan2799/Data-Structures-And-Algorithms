/**
 * 
 */
package sort.merge.optimtopdown;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import sort.insert.InsertionSort;
import sort.merge.topdown.TopDownMergeSort;
import sort.selection.SelectionSort;
import sort.shell.ShellSort;
import util.array.ArrayUtility;

/**
 * 
 */
public class CompareSortMethods {
	
	public static TimeAnalysis[] meanTimeComparison1(int numberOfExecutions, int length) {
		Stopwatch watch = new Stopwatch();
		TimeAnalysis[] ta = new TimeAnalysis[4];
		ta[0] = new TimeAnalysis("Selection", numberOfExecutions);
		ta[1] = new TimeAnalysis("Insertion", numberOfExecutions);
		ta[2] = new TimeAnalysis("Shell", numberOfExecutions);
		ta[3] = new TimeAnalysis("Top-Down Merge", numberOfExecutions);
		for(int trial =0; trial < numberOfExecutions; trial++) {
			int[] a0 = ArrayUtility.generateIntArray(length, Integer.MIN_VALUE, Integer.MAX_VALUE);
			int[] a1 = ArrayUtility.copy(a0);
			int[] a2 = ArrayUtility.copy(a0);
			int[] a3 = ArrayUtility.copy(a0);
			
            watch.startWatch();
            SelectionSort.sort(a0);
            long time = watch.elapsedTime();
            ta[0].add(time);
            
            watch.startWatch();
            InsertionSort.sort(a1);
            time = watch.elapsedTime();
            ta[1].add(time);
            
            watch.startWatch();
            ShellSort.sort(a2);
            time = watch.elapsedTime();
            ta[2].add(time);
            
            watch.startWatch();
            TopDownMergeSort.sort(a3);
            time = watch.elapsedTime();
            ta[3].add(time);
            
		}
		return ta;
	}
	
	public static TimeAnalysis[] meanTimeComparison2(int numberOfExecutions, int length, int repeatFactor) {
		Stopwatch watch = new Stopwatch();
		TimeAnalysis[] ta = new TimeAnalysis[4];
		ta[0] = new TimeAnalysis("Selection", numberOfExecutions);
		ta[1] = new TimeAnalysis("Insertion", numberOfExecutions);
		ta[2] = new TimeAnalysis("Shell", numberOfExecutions);
		ta[3] = new TimeAnalysis("Top-Down Merge", numberOfExecutions);
		for(int trial =0; trial < numberOfExecutions; trial++) {
			int[] a0 = ArrayUtility.generateIntArray(length, Integer.MIN_VALUE, Integer.MAX_VALUE);
			int[] a1 = ArrayUtility.copy(a0);
			int[] a2 = ArrayUtility.copy(a0);
			int[] a3 = ArrayUtility.copy(a0);
			
            watch.startWatch();
            for(int i=0; i<=repeatFactor; i++)
            	SelectionSort.sort(a0);
            long time = watch.elapsedTime();
            ta[0].add(time);
            
            watch.startWatch();
            for(int i=0; i<=repeatFactor; i++)
            	InsertionSort.sort(a1);
            time = watch.elapsedTime();
            ta[1].add(time);
            
            watch.startWatch();
            for(int i=0; i<=repeatFactor; i++)
            	ShellSort.sort(a2);
            time = watch.elapsedTime();
            ta[2].add(time);
            
            watch.startWatch();
            for(int i=0; i<=repeatFactor; i++)
            	TopDownMergeSort.sort(a3);
            time = watch.elapsedTime();
            ta[3].add(time);
            
		}
		return ta;
	}
	
	public static void printMeanExecutionTimeGrowthTable(int numberOfExecutions,
			int min, int increment, int max) {
		System.out.println("Mean execution time growth comparsion table");
		System.out.println("  - Method: SELction, INSertion, SHEll, TopDownMerge ");
		System.out.println("  - Number of executions (sample size) for time estimation: "+numberOfExecutions);
		System.out.println("|------------|--------|--------|---------|--------|");
		System.out.println("|           N|   SEL  |  INS   |  SHE    |   TDM  |");
		System.out.println("|------------|--------|--------|---------|--------|");
		for (int n=min; n<=max; n+=increment) {
			TimeAnalysis[] ta = meanTimeComparison1(numberOfExecutions, n);
			System.out.printf("|  %9d | %6.1f | %6.1f |  %6.1f | %6.1f |\n", n,  ta[0].getMeanTime(),
					ta[1].getMeanTime(), ta[2].getMeanTime(), ta[3].getMeanTime());
		}
		System.out.println("|------------|--------|--------|---------|--------|");	
		}
	
	public static void printMeanExecutionTimeGrowthTable2(int numberOfExecutions,
			int min, int increment, int max, int repeatFactor) {
		System.out.println("Mean execution time growth comparsion table");
		System.out.println("  - Method: SELction, INSertion, SHEll, TopDownMerge ");
		System.out.println("  - Number of executions (sample size) for time estimation: "+numberOfExecutions);
		System.out.println("  - Repeat Factor: "+ repeatFactor);
		System.out.println("|------------|--------|--------|---------|--------|");
		System.out.println("|           N|   SEL  |  INS   |  SHE    |   TDM  |");
		System.out.println("|------------|--------|--------|---------|--------|");
		for (int n=min; n<=max; n+=increment) {
			TimeAnalysis[] ta = meanTimeComparison2(numberOfExecutions, n,repeatFactor);
			System.out.printf("|  %9d | %6.1f | %6.1f |  %6.1f | %6.1f |\n", n,  ta[0].getMeanTime(),
					ta[1].getMeanTime(), ta[2].getMeanTime(), ta[3].getMeanTime());
		}
		System.out.println("|------------|--------|--------|---------|--------|");	
		}

	public static void main(String[] args) {
		System.out.println(" B22 OptimizedTopDown- Task 2- by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		//printMeanExecutionTimeGrowthTable(21, 5, 5, 100);
		 for(int rf = 1000; rf<=100000; rf*=10)
			 printMeanExecutionTimeGrowthTable2(21,5,5,100,rf);
	}

}
