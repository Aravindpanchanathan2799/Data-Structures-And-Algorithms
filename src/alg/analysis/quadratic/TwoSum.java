/**
 * 
 */
package alg.analysis.quadratic;

/**
 * 
 */
public class TwoSum {

	public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    } 
	
	
}
