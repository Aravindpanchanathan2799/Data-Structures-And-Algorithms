/**
 * 
 */
package sort.selection;

import java.util.Date;

import util.array.ArrayUtility;

/**
 * 
 */
public class SelectionSortTest {
	public static void testSelectionSort(int length , int min , int max) {
		int[] a10 = ArrayUtility.generateIntArray(length, min, max);
		System.out.printf("Random array with 10 elements, from 1 to 20: \n%s\n",
				ArrayUtility.toString(a10, "{", ", ", "}"));
		SelectionSort.sort(a10);
		System.out.printf("Sorted array : \n%s\n",
				ArrayUtility.toString(a10, "{", ", ", "}"));
	}
	public static void main(String[] args) {
		System.out.println("Selection Sort  - Task 2 - by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
        testSelectionSort(10, 1, 20);
		// test toString
		}

}
