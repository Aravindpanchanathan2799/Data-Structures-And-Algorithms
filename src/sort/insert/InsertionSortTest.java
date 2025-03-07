/**
 * 
 */
package sort.insert;

import java.util.Date;

import util.array.ArrayUtility;

/**
 * 
 */
public class InsertionSortTest {
	
	public static void testInsertionSort(int length , int min , int max) {
		int[] a10 = ArrayUtility.generateIntArray(length, min, max);
		System.out.printf("Random array with 10 elements, from 1 to 20: \n%s\n",
				ArrayUtility.toString(a10, "{", ", ", "}"));
		InsertionSort.sort(a10);
		System.out.printf("Sorted array : \n%s\n",
				ArrayUtility.toString(a10, "{", ", ", "}"));
	}
	public static void main(String[] args) {
		System.out.println("Insertion Sort  - Task 1 - by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
        testInsertionSort(10, 1, 20);
		}

}
