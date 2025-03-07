/**
 * 
 */
package alg.analysis.quadratic;

/**
 * 
 */
public class TwoSumTest {

	public static void main(String[] args) {
        int[] t1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("TEST 1 count = "+TwoSum.count(t1));
        int[] t2 = { 1, 2, 3, -1, -2, -3, 4};
        System.out.println("TEST 2 count = "+TwoSum.count(t2));
    }
}
