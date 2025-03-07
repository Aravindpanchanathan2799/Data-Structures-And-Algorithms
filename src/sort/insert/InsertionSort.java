/**
 * 
 */
package sort.insert;

/**
 * 
 */
public class InsertionSort {
	
    /**
     * Rearranges the elements of an array of int values in ascending order. <br>
     * Uses the insertion sort algorithm: <br>
     * - for each position in the initial array<br>
     * - moves the value to the left until the left array is sorted<br>
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;           
            for (; j > 0 && temp<a[j-1]; j--) {
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }

}
