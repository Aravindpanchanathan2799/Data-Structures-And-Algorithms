package alg.analysis.linear;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;

public class SumGrowthAnalysis {
	
    public static TimeAnalysis testAddition(String name, int numberOfExecutions, int lastValueAdded) {
        Stopwatch watch = new Stopwatch();
        TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
        for (int trial = 0; trial < numberOfExecutions; trial++) {
            watch.startWatch();
            // tested code - start
            @SuppressWarnings("unused")
            double sum = 0;
            for (int i = 1; i <= lastValueAdded; i++) {
                sum += i;
            }
            // tested code - end
            long time = watch.elapsedTime();
            ta.add(time);
        }
        return ta;
    }
    
    public static void printMeanExecutionTimeGrowthTable(int numberOfExecutions, int minValueAdded, int increment, int maxValueAdded) {
    	System.out.println("Mean execution time growth table");
    	System.out.println(" - Method: Sum of first N integers");
    	System.out.println(" - Sample size for time estimation: "+numberOfExecutions);
    	System.out.println("|-----------|--------|------|------|------------------|");
    	System.out.println("|         N |   Mean |  Min |  Max |       CI 99.9%   |");
    	System.out.println("|-----------|--------|------|------|------------------|");
    	for (int n=minValueAdded; n<=maxValueAdded; n+=increment) {
    		String name = "Add the first "+n+" integers";
    		TimeAnalysis ta = testAddition(name, numberOfExecutions, n);
    		System.out.printf("| %9d | %6.1f | %4d | %4d | (%6.1f, %6.1f) |\n" ,
    				n, ta.getMeanTime(), ta.getMinTime(), ta.getMaxTime(), 
    				ta.getMinMean999Confidence(), ta.getMaxMean999Confidence());
    	}
    	System.out.println("|-----------|--------|------|-----|------------------|");
    } 
    
    public static void main(String[] args) {
        System.out.println("Growth table 10M to 100M in 10M increment - A32 Task 3 - adapted by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
        printMeanExecutionTimeGrowthTable(41, 100000000, 100000000, 1000000000);
	}

}

