/**
 * 
 */
package alg.analysis.cubic;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import alg.analysis.quadratic.TwoSum;

/**
 * 
 */
public class ThreeSumGrowthAnalysis {

	public static String arrayToString(int[] a) {
        String result = "[";
        String separator = "";
        for (int item: a) {
            result += separator + item;
            separator = " ";
        }
        result += "]";
        return result;
    }
	
	public static int[] generateRandomArray(int numberOfElements, int startNumber, int endNumber) {
        if (endNumber-startNumber<numberOfElements) throw new RuntimeException("Too small interval");
        int[] a = new int[numberOfElements];
        for (int i=0; i<numberOfElements; i++) {
            int val;
            boolean found;
            // find a random value that is not in the array
            do {
                val = (int)(Math.random()*(1.0+endNumber-startNumber)) + startNumber;
                found = false;
                for (int j=0; !found && j<i; j++) {
                    found = (val == a[j]);
                }
            } while (found);
            a[i]=val;
        }
        return a;
    }
	
	public static TimeAnalysis testThreeSum(String name, int numberOfExecutions, int numberOfElements) {
        Stopwatch watch = new Stopwatch();
        TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
        for (int trial = 0; trial < numberOfExecutions; trial++) {
            // build the test array
            int[] a = generateRandomArray(numberOfElements, -numberOfElements, numberOfElements);
            watch.startWatch();
            // tested code - start
            ThreeSum.count(a);
            // tested code - end
            long time = watch.elapsedTime();
            ta.add(time);
        }
        return ta;
    }
	
	public static void printMeanExecutionTimeGrowthTable(int numberOfExecutions, int minValue, int increment,
            int maxValue) {
        System.out.println("Mean execution time growth table");
        System.out.println("  - Method: Two sum for a random array of size N");
        System.out.println("  - Sample size for time estimation: "+numberOfExecutions);
        System.out.println("|-----------|--------|------|------|------------------|");
        System.out.println("|         N |   Mean |  Min |  Max |         CI 99.9% |");
        System.out.println("|-----------|--------|------|------|------------------|");
        for (int n=minValue; n<=maxValue; n+=increment) {
            String name = "Add the first " + n + " integers";
            TimeAnalysis ta = testThreeSum(name, numberOfExecutions, n);
            System.out.printf("| %9d | %6.1f | %4d | %4d | (%6.1f, %6.1f) |\n", n,  ta.getMeanTime(), 
                    ta.getMinTime(), ta.getMaxTime(), ta.getMinMean999Confidence(), ta.getMaxMean999Confidence());
        }
        System.out.println("|-----------|--------|------|------|------------------|");
    }
	
	public static void main(String[] args) {
		//TimeAnalysis ta = testTwoSum("test", 41, 10000);
	    //ta.printStatistics(); 
		System.out.println("Cubic Growth Analysis-Task 9 - Adapted by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
		printMeanExecutionTimeGrowthTable(31, 200, 100, 2000);
		printMeanExecutionTimeGrowthTable(31, 4000, 100, 5000);
	    }  

}
