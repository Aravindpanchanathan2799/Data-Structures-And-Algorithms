/**
 * 
 */
package sort.quicksort.optim;

/**
 * 
 */
public class OptimizedQuickSort {
/**
 * The maximum default size of a sub-array for which we apply insertion sort.
 */
 private static int MAX_INSERTION_SIZE = 20;
 private static int median3(int a, int b, int c) {
	 if (a<b) {
		 if (b<c) return b;
		 if (a<c) return c;
		 return a;
	 } else {
		 if (a<c) return a; 
		 if (b<c) return c;
		 return b;
	 }
   }
	 
    /**
	 * Compute the median of the values placed at start index, end index
	 * and in the middle of start index and end index. Exchange the median
	 * with the value on the start index.
	 * @param a The array in which the median is computed
	 * @param startIndex the first value to compare
	 * @param end index the second value to compare$
	 */
	 private static void median3(int[] array, int startIndex, int endIndex) {
	 // put the median value in the startIndex position
	 int midIndex = (startIndex+endIndex)/2;
	 int a = array[startIndex];
	 int b = array[midIndex];
	 int c = array[endIndex];
	 if (a<b) {
		 if (b<c) {
			 //a,b,c
			 int temp = array[startIndex];
			 array[startIndex] = array[midIndex];
			 array[midIndex] = temp;
	 } else if (a<c){
	 //a,c,b
	   int temp = array[startIndex];
	   array[startIndex] = array[endIndex];
	   array[endIndex] = temp;
	 //c, a, b
	 }
	}
	 else { //b <=a
		 if (a<c) {
			 	//b, a, c
		 }else if (b<c) {
			 //b, c, a
			 int temp = array[startIndex];
			 array[startIndex] = array[endIndex] ;
			 array[endIndex] = temp;
		 } else {
			 int temp = array[startIndex];
			 array[startIndex] = array[midIndex];
			 array[midIndex] = temp;
		 }
	  }
   }
		 
		 
  static int partition(int[] a, int startIndex, int endIndex) {
			
			median3(a, startIndex, endIndex);
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
		 * Recursive quick sort method that is sorting a sub-array from a between startIndex and endIndex
		 * @param a the array to be sorted
		 * @param startindex  the start index of the sub-array (inclusive)
		 * @param endIndex the end index of the sub-array (inclusive)
		 */
	private static void sort(int[] a, int startIndex, int endIndex, int maxInsert) {
			
		// empty sub-arrays and singletons are already sorted
		if (endIndex <= startIndex) return;
		
		// perform insertion sort for small sub-arrays
		if (endIndex < startIndex + maxInsert) {
			for (int i = startIndex+1; i <= endIndex; i++) {
				int temp = a[i];
				int j;
				for (j = i; j > startIndex && temp<a [j-1]; j--) {	
					a[j] = a[j-1];	
				}
				a[j]=temp;
			}
			return;
		}
		
		// for arrays with at least maxInsert+1 elements
		
		// partition and determine the position of the pivot
		int pivotIndex = partition(a, startIndex, endIndex);
		// after the partition we have;
		// [startIndex ... pivotIndex - 1] <= a[pivotIndex] <= a[pivotIndex+1 ... endIndex]
		
		// sort the sub-array to the left
		sort(a, startIndex, pivotIndex-1, maxInsert);
		
		// sort the sub-array to the right
		sort(a, pivotIndex+1, endIndex, maxInsert);
		// at the end the entire sub-array must be sorted
	}
		
	/**
	 * Sort an array of integers a in the increasing order using a recursive quick sort method.
	 * @param a - the array to be sorted 
	 */
		public static void sort(int[] a, int maxInsert) {
		// call the sorting of a sub-array for the entire array
		sort(a, 0, a.length - 1, maxInsert);
		}
		
	/**
	 * Sort an array of integers a in the increasing order using a recursive quick sort method.
	 * @param a - the array to be sorted
	 */
		public static void sort (int [] a) {
		// call the sorting of a sub-array for the entire array
		sort(a, 0, a.length - 1, MAX_INSERTION_SIZE);
		}
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		 