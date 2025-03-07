/**
 * 
 */
package util.array;

/**
 * 
 */
public class ArrayUtility {

	/**
	 * In ArrayUtility class, create a public static method toString 
	 * that receives an array of int's, a start string, a separator string 
	 * and an end string. 
	 * It returns a String starting with the start string, 
	 * followed by the array elements separated by the separator 
	 * and ending with the end string.
	 * @param array - the array to be output
	 * @param start - the start of the output
	 * @param separator - the separator between elements
	 * @param end - the end of the string
	 */
	public static String toString(int[] array, String start, String separator, String end) {
		// initialize the result with the start of the output
		String result = start;
		// add all the elements separated by the separator
		boolean needSeparator = false;
		for (int elem: array) {
			if (needSeparator) result += separator;
			result += elem;
			needSeparator = true;
		}
		// end  with the end of the output
		result += end;
		// return the results
		return result;
	}
	
	public static boolean equals(int[] a1, int[] a2) {
		if (a1.length!=a2.length) return false;
		for (int i=0; i<a1.length; i++) {
			if (a1[i]!=a2[i]) return false;
		}
		return true;
	}
	
	public static boolean isSorted(int[] a) {
		for (int i=0; i<a.length-1; i++) {
			if (a[i]>a[i+1]) return false;
		}
		return true;	
	}
	
	public static int[] generateIntArray(int length, int min, int max) {
		int[] array = new int[length];
		for (int i=0; i<length; i++) {
			array[i]=(int) (min+Math.random()*(1.0+max-min));
		}
		return array;
	}
	
	public static int[] copy(int[] a) {
		
		int[] c = new int[a.length];
		for(int i=0; i<a.length; i++) {
			c[i]=a[i];
		}
		return c;
	}
}
