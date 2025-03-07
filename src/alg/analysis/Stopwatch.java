/**
 * Simulates a stop-watch to compute the execution time.
 */
package alg.analysis;

/**
 * @author mayurijadhav
 */
public class Stopwatch {

    /**
     * Saves the time when the watch is started (or restarted)
     */
    private long startTime;
    
    /**
     * Starts or restarts the stop watch.
     */
    public void startWatch() {
        startTime = System.currentTimeMillis();
    }
    
    /**
     * Creates and starts a stop watch.
     */
    public Stopwatch() {
        startWatch();
    }
    
    /**
     * Compute and return the elapsed time from the last start or restart.
     * @return the elapsed time as a {@code long}
     */
	public long elapsedTime() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis() - startTime;
	}
    
    
	
}
