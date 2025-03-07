/**
 *  Module  A3: Analysis of Algorithms
 * Section A31  : Measure Execution Time
 * Task 1: Basic implementation of Stopwatch
 */
package alg.analysis;

import java.util.Date;

/**
 * @author mayurijadhav
 */
public class TestStopwatch {

	 public static void main(String[] args) {
	        System.out.println("Stopwatch2B - Task 1 - by Mayuri Jadhav");
	        Date date = new Date();
	        System.out.println("Executed on: "+date.toString());
	        Stopwatch w = new Stopwatch();
	        double sum = 0;
	        for (int i=1; i<=2000000000; i++) {
	            sum += i;
	        }
	        long t = w.elapsedTime();
	        System.out.println("Computes the sum of the first two billion integers as a double.");
	        System.out.println("Sum  (double) = "+sum);
	        System.out.println("Time (mili-s) = "+t);
	    }
}
