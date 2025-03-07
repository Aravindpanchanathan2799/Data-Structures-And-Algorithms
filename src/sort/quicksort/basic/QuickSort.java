/**
 * 
 */
package sort.quicksort.basic;

/**
 * 
 */

public class QuickSort {

	static int partition(int[] a, int startIndex, int endIndex) {
		
	
		// take the first element as the pivot
		int pivot = a[startIndex];
	
		// arrange the elements from startIndex+1 to endIndex
		
		// lowerIndex will search for the first element that is out of place in the lower part
		int lowerIndex = startIndex;
		// higherIndex will search for the first element that is out of place in the higher part
		int higherIndex = endIndex+1;
		
		// while we can have elements out of place
		while (true) {
			
		
			//find a big value (›pivot) on lower part to swap - out of place in the lower part 
			while (a[++lowerIndex]<= pivot && lowerIndex<endIndex);
			
			
			// find a small value(‹pivot) on upper part to swap - out of place in the higher part
			while (a[--higherIndex] >= pivot && higherIndex>startIndex);
							
			//check if pointers cross - the lower and higher areas met 
			if (lowerIndex >= higherIndex) break;
			
			// exchange the out of place elements
			int temp= a[lowerIndex];
			a[lowerIndex] = a[higherIndex];
			a[higherIndex] = temp;
		}
			
			// put the pivot in the middle place
				int temp = a[startIndex];
				a[startIndex]= a[higherIndex];
				a[higherIndex] = temp;
				
				// return the index of the pivot
				return higherIndex;
}
	
	
	/**
	 * Recursive quick sort method that is sorting a sub-array from a between startIndex and endIndex.
	 * @param a the array to be sorted
	 * @param startIndex the start index of the sub-array (inclusive)
	 * @param endIndex the end index of the sub-array (inclusive)
	 * 
	 * */

	private static void sort(int[] a, int startIndex, int endIndex) {
		// empty sub-arrays and singletons are already sorted 
		if (endIndex <= startIndex) return;
		
		// for arrays with at least 2 elements
		
		// partition and determine the position of the pivot
		int pivotIndex = partition(a, startIndex, endIndex);
		
		// after the partition we have;	
		// a[startIndex ... pivotIndex - 1] <= a [pivotIndex] < alpivotIndex+1 ... endIndex]	
		
		// sort the sub-array to the left
		sort(a, startIndex, pivotIndex-1);
		
		// sort the sub-array to the right
		sort(a, pivotIndex+1, endIndex);
		
	// at the end the entire sub-array must be sorted
		
	}

	/**
	 * Sort an array of integers a in the increasing order using a recursive quick sort method.
	 * @param a - the array to be sorted
	 */
	public static void sort (int[]a) {
		//call the sorting of a sub-array for the entire array
		sort(a, 0, a. length - 1);
	}

}








