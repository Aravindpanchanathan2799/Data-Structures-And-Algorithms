/**
 * 
 */
package sort.quicksort.optim;

import java.util.Date;

import util.array.ArrayUtility;

/**
 * 
 */
public class OptimizedQuickSortTest {

public static boolean sortTest(String name, int[] original, int[] expected) {
		
	    System.out.println("Test " + name + ":");
	    System.out.println("- original: " + ArrayUtility.toString(original, "[", ", ", "]"));
	    
	    // Sorting the original array
	    OptimizedQuickSort.sort(original);
	   
	    System.out.println(" - sorted  : " + ArrayUtility.toString(original, "[", ", ", "]"));
	    System.out.println(" - expected: " + ArrayUtility.toString(expected, "[", ", ", "]")); // corrected to use expected
	    
	    // Checking equality between the sorted original and expected arrays
	    boolean result = ArrayUtility.equals(original, expected);
	    System.out.println("  RESULT: "+ (result ? "success" : "failure !!!!!!!!!!!!!!!!!!!!!!!!"));
	    return result;
	}
	
	
	public static void sortAllTests() {
		boolean result=true;
		result = result && sortTest("empty array",new int[] {},new int[] {});
		result = result && sortTest("singleton array",new int[] {9},new int[] {9});
		result = result && sortTest("pair sorted array",new int[] {2,3},new int[] {2,3});
		result = result && sortTest("pair unsorted array", new int[] {3, 2},new int[] {2, 3});
		result = result && sortTest("3-elem sorted array",new int[] {3, 4, 5},new int[] {3, 4, 5});
		result = result && sortTest("3-elem inverse array",new int[] {5, 4, 3},new int[] {3,4,5});
		result = result && sortTest("7-elem array",new int[] {5, 4, 3, 6, 4, 9, 7},
				new int[] {3,4,4,5,6,7,9});
		result = result && sortTest("10-elem array",
		new int [] {67, 85, 21, 98, 79, 78, 61, 45, 62, 10}, 
		new int [] {10,21, 45, 61, 62, 67, 78, 79, 85, 98});
		System.out.println("All sort tests successful? "+result);
	}
	
	public static void main (String[] args) {
		System.out.println("B32 OptimizedQuickSort- Task 2 - by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		sortAllTests();
		
		}
}
