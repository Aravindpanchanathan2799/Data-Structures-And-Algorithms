/**
 * 
 */
package sort.merge.topdown;

/**
 * 
 */
public class TopDownMergeSort {

	/**
	 * @param args
	 */
	private static void sort(int[] a, int[] aux, int startIndex, int endIndex) {
		if (endIndex<=startIndex) return;
		int midIndex = startIndex + (endIndex - startIndex) / 2;
		sort(a, aux, startIndex, midIndex);
		sort(a, aux, midIndex + 1, endIndex);
		MergeArray.mergeAux(a, aux, startIndex, midIndex, endIndex);
		
	}
	 /** 
	  * Sorts an array of integers by using the top down merge sort
	  * @ a array to be sorted
	  */
	public static void  sort(int [] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length-1);
	}
}