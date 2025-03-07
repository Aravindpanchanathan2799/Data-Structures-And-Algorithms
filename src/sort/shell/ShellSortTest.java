/**
 * 
 */
package sort.shell;
import java.util.Date;
import util.array.ArrayUtility;
	/**
	 * 
	 */
	public class ShellSortTest {
		
		public static void testShellSort(int length , int min , int max) {
			int[] a10 = ArrayUtility.generateIntArray(length, min, max);
			System.out.printf("Random array with %d elements, from %d to %d: \n%s\n",
				    length, min, max, ArrayUtility.toString(a10, "{", ", ", "}"));
					ShellSort.sort(a10);
			System.out.printf("Sorted array : \n%s\n",
					ArrayUtility.toString(a10, "{", ", ", "}"));
		}
		public static void main(String[] args) {
			System.out.println("Shell Sort  - Task 1 - by Mayuri Jadhav");
	        Date date = new Date();
	        System.out.println("Executed on: "+date.toString());
	        //testShellSort(0,1,20);
	        //testShellSort(1, 1, 20);
	        //testShellSort(2,1,20);
	        //testShellSort(5,1,20);
	        testShellSort(10,1,20);         
			}

	}
