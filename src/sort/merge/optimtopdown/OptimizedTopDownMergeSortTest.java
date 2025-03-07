/**
 * 
 */
package sort.merge.optimtopdown;

import java.util.Date;

import sort.merge.topdown.TopDownMergeSort;
import util.array.ArrayUtility;

/**
 * 
 */
public class OptimizedTopDownMergeSortTest {
	public static boolean sortTest(String name, int[] original, int[] expected) {
		System.out.println("Test "+name+":");
		System.out.println(" -original : "+ArrayUtility.toString(original, "[", ", ", "]"));
		OptimizedTopDownMergeSort.sort(original,10);
		System.out.println(" -sorted   : "+ArrayUtility.toString(original, "[", ", ", "]"));
		System.out.println(" -expected : "+ArrayUtility.toString(expected, "[", ", ", "]"));
		boolean result = ArrayUtility.equals(original, expected);
		System.out.println(" RESULT: "+(result?"success":"failure !!!!!!!!!!!!!!!!!!!!!!!!!!!!"));
		return result;
	}


	/**
	 *  Calls  all the basic tests for the top down merge sort.
	 */
	public static void sortAllTests() {
		boolean result=true;
		result = result && sortTest("empty array", new int[] {}, new int[] {});
		result = result && sortTest("singleton array", new int[] {9}, new int[] {9});
		result = result && sortTest("pair sorted array", new int[] {3, 9}, new int[] {3, 9});	
		result = result && sortTest("pair unsorted  array", new int[] {9, 3}, new int[] {3, 9});	
		result = result && sortTest("3-elem sorted array", new int[] {3, 6, 9}, new int[] {3, 6, 9});	
		result = result && sortTest("3-elem inverse array", new int[] {9, 6, 3}, new int[] {3, 6, 9});	
		result = result && sortTest("7-elem array", new int[] {4, 5, 9, 3, 6, 1, 2},	
			new int[] {1, 2, 3, 4, 5, 6, 9});
		System.out.println("All sort tests successful? "+result);
	}
	/**
	 *  Main testing method, calling one of the test
	 *  @param args
	 */
	public static void main(String[] args) {
		System.out.println(" B22 OptimizedTopDownMergeSort- Task 4 - by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		sortAllTests();
	}

}
