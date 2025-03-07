/**
 * 
 */
package sort.merge.topdown;

/**
 * @author mayurijadhav
 */
public class MergeArray {
	public static void mergeAux(int[] a, int[] aux, int start1 , int end1 , int end2) {
		for (int i= start1; i<=end2; i++) {
			aux[i]=a[i];
		}
		int i = start1;
		int j = end1+1;
		
		for(int k = start1; k<=end2; k++) {
			if(i > end1) {
				a[k] = aux[j++];
			}
			else if(j> end2) {
				a[k] = aux[i++];
			}
			else if (aux[j]< aux[i]) {
				a[k] = aux[j++];
			}
			else {
				a[k] = aux[i++];
			}
		}
		
	}
}
