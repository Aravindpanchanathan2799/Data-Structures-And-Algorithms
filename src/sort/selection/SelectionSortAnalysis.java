/**
 * 
 */
package sort.selection;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import util.array.ArrayUtility;

/**
 * 
 */
public class SelectionSortAnalysis {
	   public static TimeAnalysis meanTime(String name, int numberOfExecutions, int numberOfElements, int min, int max) {
	        Stopwatch watch = new Stopwatch();
	        TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
	        for (int trial = 0; trial < numberOfExecutions; trial++) {
	        		// generate the array
	        		int[] array = ArrayUtility.generateIntArray(numberOfElements, min, max);
	            watch.startWatch();
	            // tested code - start
	            SelectionSort.sort(array);
	            // tested code - end
	            long time = watch.elapsedTime();
	            ta.add(time);
	        }
	        return ta;
	    }
	    public static void printMeanExecutionTimeGrowthTable(int numberOfExecutions, 
	    		int minArrayLength, int arrayIncrementLength, int maxArrayLength, 
	    		int minArrayValue, int maxArrayValue) {
	        System.out.println("Mean execution time growth table");
	        System.out.println("  - Method: Selection sort of N integers");
	        System.out.println("  - Sample size for time estimation: "+numberOfExecutions);
	        System.out.println("|-----------|--------|------|------|------------------|");
	        System.out.println("|         N |   Mean |  Min |  Max |         CI 99.9% |");
	        System.out.println("|-----------|--------|------|------|------------------|");
	        for (int n=minArrayLength; n<=maxArrayLength; n+=arrayIncrementLength) {
	            String name = "Sort " + n + " integers";
	            TimeAnalysis ta = meanTime(name, numberOfExecutions, n, minArrayValue, maxArrayValue);
	            System.out.printf("| %9d | %6.1f | %4d | %4d | (%6.1f, %6.1f) |\n", n,  ta.getMeanTime(), 
	                    ta.getMinTime(), ta.getMaxTime(), ta.getMinMean999Confidence(), ta.getMaxMean999Confidence());
	        }
	        System.out.println("|-----------|--------|------|------|------------------|");
	    }
	    
	    public static void main(String[] args) {
			System.out.println("Selection Sort  - Task 4 - by Mayuri Jadhav");
	        Date date = new Date();
	        System.out.println("Executed on: "+date.toString());
	        printMeanExecutionTimeGrowthTable(90, 10000, 1000, 20000, 1000000, 2000000);
			// test toString
			}

}
