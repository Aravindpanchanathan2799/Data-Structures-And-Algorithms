/**
 * 
 */
package sort.merge.optimtopdown;
import sort.merge.topdown.*;
import sort.insert.InsertionSort;

/**
 * 
 */
public class OptimizedTopDownMergeSort {
	
	private static void sort(int[]a, int[] aux, int lo, int hi, int insertionSortSize ) {
		if(hi<=lo)
			return;
		if(hi< lo+insertionSortSize) {
			for(int i= lo+1; i<=hi; i++) {
				int temp = a[i];
				int j;
				for(j=i; j>lo && temp<a[j-1]; j--) {
					a[j] = a[j-1];
				}
				a[j]=temp;
			}
			return;
		}
		int mid = lo + (hi-lo)/2;
		sort(a,aux,lo, mid, insertionSortSize);
		sort(a,aux,mid+1, hi, insertionSortSize);
		
		MergeArray.mergeAux(a, aux, lo, mid, hi);
		
	}
	public static void sort(int[] a, int insertionSortSize) {
		if(a.length <= insertionSortSize){
			InsertionSort.sort(a);
			return;
		}
		int[] aux = new int[a.length];
		sort(a,aux,0, a.length-1, insertionSortSize);
	}

}
