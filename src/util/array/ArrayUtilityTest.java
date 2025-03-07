/**
 * 
 */
package util.array;

import java.util.Date;

/**
 * 
 */
public class ArrayUtilityTest {
	/**
	 * In ArrayUtilityTest class, create a public static method toStringTest 
	 * that prints the results for the following 5 lengths of arrays, 
	 * using different types of brackets and separators for each: empty, singleton, 
	 * two elements, 5 elements and 20 elements. 
	 * Call only this class in the main method and check the results. 
	 * @param args
	 */
	public static void toStringTest() {
		// test with empty array
		int[] empty = {};
		System.out.println("Empty array: "+ArrayUtility.toString(empty, "{", " ", "}"));
		// test with singleton array
		int[] singleton = { 1 };
		System.out.println("Singleton array: "+ArrayUtility.toString(singleton, "[", " ", "]"));
		// test with two element array
		int[] twoElements = { 11, 12 };
		System.out.println("Two element array: "+ArrayUtility.toString(twoElements, "<", ", ", ">"));
		
		int[] fiveElements = { 31,24,56,75,21};
		System.out.println("Five element array: "+ArrayUtility.toString(fiveElements, "<", ", ", ">"));
		
		int[] twentyElements = { 31,24,56,75,21,56,21,32,12,45,32,12,54,31,29,87,54,41,30,11};
		System.out.println("Twenty element array: "+ArrayUtility.toString(twentyElements, "<", ", ", ">"));
		
	}
	
	public static void IsEqualsTest() {
		int[] empty = {};
		System.out.println("Two Empty arrays are: "+ArrayUtility.equals(empty,empty));
		int[] singleton = { 1 };
		int[] singleton_2 = { 1 };
		int[] singleton_3 = { 11 };
		System.out.println("An Singleton array and Empty Array are Equal: "+ArrayUtility.equals(singleton, empty));
		System.out.println("Two Singleton array with same elements are Equal: "+ArrayUtility.equals(singleton, singleton_2));
		System.out.println("Two Singleton array with different elements are Equal: "+ArrayUtility.equals(singleton, singleton_3));
		int[] twoElements = { 11, 12 };
		int[] twoElements_1 = { 11, 12 };
		System.out.println("Two arrays with same elements are Equal: "+ArrayUtility.equals(twoElements, twoElements_1));
		int[] fiveElements = { 31,24,56,75,21};
		int[] twentyElements = { 31,24,56,75,21,56,21,32,12,45,32,12,54,31,29,87,54,41,30,11};
		System.out.println("Two arrays with different elements are Equal: "+ArrayUtility.equals(fiveElements, twentyElements));
	}
	public static void IsSortedTest() {
		int[] empty = {};
        System.out.println("Empty array " + ArrayUtility.toString(empty, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(empty));
        int[] array2ElemUnsorted = {5, 3};
        System.out.println("Unsorted 2 elements array " + ArrayUtility.toString(array2ElemUnsorted, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(array2ElemUnsorted));
        int[] array2ElemSorted = {3, 5};
        System.out.println("Sorted 2 elements array " + ArrayUtility.toString(array2ElemSorted, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(array2ElemSorted));
        int[] arrayMultipleSorted = {1, 2, 3, 4, 5};
        System.out.println("Sorted multiple elements array " + ArrayUtility.toString(arrayMultipleSorted, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(arrayMultipleSorted));
        int[] arrayMultipleUnsorted = {1, 3, 2, 4, 5};
        System.out.println("Unsorted multiple elements array " + ArrayUtility.toString(arrayMultipleUnsorted, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(arrayMultipleUnsorted));
        int[] arrayAllSame = {2, 2, 2, 2, 2};
        System.out.println("All same elements array " + ArrayUtility.toString(arrayAllSame, "[", " ", "]") + " is sorted? " + ArrayUtility.isSorted(arrayAllSame));
	}
	
	public static void generateIntArrayTest(){
		int[] empty = ArrayUtility.generateIntArray(0, 0, 10);
	    System.out.println("Generated empty array: " + ArrayUtility.toString(empty, "[", " ", "]"));
	    int[] singleton = ArrayUtility.generateIntArray(1, 0, 10);
	    System.out.println("Generated singleton array with elements from 0 to 10: " + ArrayUtility.toString(singleton, "[", " ", "]"));
	    int[] array10 = ArrayUtility.generateIntArray(10, 0, 20);
	    System.out.println("Generated 10-element array with elements from 0 to 20: " + ArrayUtility.toString(array10, "[", " ", "]"));
	    int[] arrayNegative = ArrayUtility.generateIntArray(5, -10, 0);
	    System.out.println("Generated 5-element array with elements from -10 to 0: " + ArrayUtility.toString(arrayNegative, "[", " ", "]"));
	    int[] arrayLargeRange = ArrayUtility.generateIntArray(15, 100, 200);
	    System.out.println("Generated 15-element array with elements from 100 to 200: " + ArrayUtility.toString(arrayLargeRange, "[", " ", "]"));
	    int[] arraySameValue = ArrayUtility.generateIntArray(5, 7, 7);
	    System.out.println("Generated 5-element array with all values being 7: " + ArrayUtility.toString(arraySameValue, "[", " ", "]"));
	    
	    
	}
	
	public static void main(String[] args) {
		System.out.println("ArrayUtility Generate Random Int Arrays - B11 Task 1 S4 - adapted by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
        generateIntArrayTest();
		// test toString
		}

}
