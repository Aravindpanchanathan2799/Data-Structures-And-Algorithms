/**
 * Test the {@link TimeAnalysis} class with a linear algorithm.
 */
package alg.analysis;

import java.util.Date;

/**
 * 
 */
public class TestTimeAnalysis {
	
	public static TimeAnalysis testAddition(int numberOfExecutions, int maxValueAdded) {
        Stopwatch watch = new Stopwatch();
        String name = "Add the first " + maxValueAdded + " integers";
        TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
        for (int trial = 0; trial < numberOfExecutions; trial++) {
            watch.startWatch();
            // tested code - start
            @SuppressWarnings("unused")
            double sum = 0;
            for (int i = 1; i <= maxValueAdded; i++) {
                sum += i;
            }
            // tested code - end
            long time = watch.elapsedTime();
            ta.add(time);
        }
        return ta;
    }
    public static TimeAnalysis testAddition(String name, int numberOfExecutions, int maxValueAdded){
    	Stopwatch watch = new Stopwatch();
    	TimeAnalysis ta = new TimeAnalysis(name, numberOfExecutions);
    	for(int trial =0; trial < numberOfExecutions; trial++)
    	{
    		watch.startWatch();
    		@SuppressWarnings("unused")
			double sum = 0;
    		for(int i= 1; i <= maxValueAdded; i++) {
    			sum+=i;
    		}
    		long time = watch.elapsedTime();
    		ta.add(time);	
    	}
    	return ta;
    }
    public static void printMeanExecutionTimeTable(int[] executions, int maxValueAdded) {
    	String name = "Add the first" + maxValueAdded + "integers";
    	System.out.println("|------|------|------|------|--------------|");
    	System.out.println("| Exec |  Min |  Max | Mean |       CI     |");
    	System.out.println("|------|------|------|------|--------------|");
    	for(int i=0; i<executions.length; i++)
    	{
    		TimeAnalysis ta = testAddition(name , executions[i], maxValueAdded);
    		System.out.printf("| %4d | %4d | %4d | %4.1f | (%4.1f, 4.1f) |\n",
    				(long)ta.size(), ta.getMinTime(), ta.getMaxTime(), ta.getMeanTime(), 
    				ta.getMinMean999Confidence(), ta.getMaxMean999Confidence());
    	}
    	System.out.println("|------|------|------|------|--------------|");	
    }
    
    
    public static void main(String[] args) {
    	System.out.println("Analysis Table 1B - Task 7 - Adapted by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
        /**TimeAnalysis ta11 = testAddition(11, 10000000);
		ta11.printStatistics();
		TimeAnalysis ta101 = testAddition(101, 10000000);
		ta101.printStatistics();
		TimeAnalysis ta1001 = testAddition(1001, 10000000);
		ta1001.printStatistics();**/	
		/**TimeAnalysis ta11 = testAddition(11, 100000000);
		ta11.printStatistics();
		TimeAnalysis ta101 = testAddition(101, 100000000);
		ta101.printStatistics();
		TimeAnalysis ta1001 = testAddition(1001, 100000000);
		ta1001.printStatistics();**/
        //printMeanExecutionTimeTable(new int[] {11, 21, 41, 81, 101, 1001} ,10000000);
        printMeanExecutionTimeTable(new int[] {11, 21, 31, 41, 51, 61, 71, 81, 91, 101} ,1000000000);
        //printMeanExecutionTimeTable(new int[] {11, 21, 41, 81, 101, 1001} , 1000000000);
        /**TimeAnalysis ta1001 = testAddition(11, 1000000000);
		ta1001.printStatistics();
		TimeAnalysis ta10011 = testAddition(101, 1000000000);
		ta10011.printStatistics();
		TimeAnalysis ta10012 = testAddition(1001, 1000000000);
		ta10012.printStatistics();**/
    }

}
