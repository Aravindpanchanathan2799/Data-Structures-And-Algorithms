/**
 * 
 */
package sort.merge.topdown;
import util.array.*;

import java.util.Date;

import alg.analysis.Stopwatch.*;
/**
 * @author mayurijadhav
 */
public class MergeArrayTest {
	
	private static boolean mergeAuxTest(String name, int[] original, int start1, int end1, int end2, int[] expected) {
		System.out.println("Test "+ name + ":");
		System.out.println(" + Input");
		System.out.println("    - array:      "+ ArrayUtility.toString(original, "[", ",", "]"));
		System.out.println("    - start first: " + start1);
		System.out.println("    - end first: " + end1);
		System.out.println("    - end second: " + end2);
		int[] aux = new int[original.length];
		MergeArray.mergeAux(original, aux, start1, end1, end2);
		boolean testResult = ArrayUtility.equals(original, expected);
		System.out.println("    - Result");
		System.out.println("    - array:      "+ ArrayUtility.toString(original, "[", ",", "]"));
		System.out.println("    - expected:      "+ ArrayUtility.toString(expected, "[", ",", "]"));
		System.out.println("    - "+(testResult?"SUCCESS":"FAILURE !!!!!!!!!!!!!!!!!!!!!!!!"));
		return testResult;
	}
	
   private static void mergeAuxAllTests() {
	   boolean result = true;
	   result = result & mergeAuxTest("both length 1", new int[] {11,22,2,1,33,44}, 2, 2, 3, new int[] {11,22,1,2,33,44});
	   result = result & mergeAuxTest("both length 2", new int[] {41,32,52,111,444,333,555}, 3, 4, 6, new int[] {41,32,52,111,333,444,555});
	   result = result & mergeAuxTest("both length 3", new int[] {11,33,44,22,55,77,1111}, 0, 2, 5, new int[] {11,22,33,44,55,77,1111});
	   result = result & mergeAuxTest("both length 5", new int[] {-5,-3,0,1,5,-9,-7,2,4,6}, 0, 4, 9, new int[] {-9,-7,-5,-3,0,1,2,4,5,6});
	   result = result & mergeAuxTest("both length 5", new int[] {1111,3333,6666,7777,8888,9999,1112,2223,3334,4445,5556,6667,7778}, 0, 5, 12, new int[] {1111,1112,2223,3333,3334,4445,5556,6666,6667,7777,7778,8888,9999});
	   System.out.print("All mergeAux tests are successful? "+result);
   }
   
   public static void main(String[] args) {
   		System.out.println("B21-Merge Sort- Task 1 - by Mayuri Jadhav");
   		Date date = new Date();
   		System.out.println("Executed on: "+date.toString());
   		mergeAuxAllTests();
   }
}
