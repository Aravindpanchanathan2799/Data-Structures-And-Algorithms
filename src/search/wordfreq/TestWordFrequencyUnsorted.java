/**
 * 
 */
package search.wordfreq;

import java.util.Date;

/**
 * 
 */
public class TestWordFrequencyUnsorted {
		
private static void test(String url) {
	System.out.println("*****");
	System.out.println("URL: "+url);
	WordFrequencyUnsorted counter = new WordFrequencyUnsorted();
	counter.computeFrequency(url);
	if (counter.size()<=100) {
		System.out.println("The symbol table is: "+counter.toString());
	} else {
			System.out.println("The symbol table is too big to pring.");
	}
	System.out.println("The number of words in the text is: "+ counter.wordsCounted());
	System.out.println("The number of distinct words is: "+ counter.size());
	int max = counter.maxFrequency();
	System.out.println("The maximum frequency is: "+max);
	System.out.println("The following words are having the maximum frequency: "
			+counter.getWordsWithFrequency(max));
	int min = counter.minFrequency();
	System.out.println("The minimum frequency is: "+min);
	System.out.println("The following words are having the minimum frequency: "
			+counter.getWordsWithFrequency(min));	
	}
	
	public static void main(String[] args) {
		System.out.println("C12- WordFrequencyUnsorted - by Mayuri Jadhav");
        Date date = new Date();
        System.out.println("Executed on: "+date.toString());
		//test("https://algs4.cs.princeton.edu/31elementary/tinyTale.txt");	
		//test("https://algs4.cs.princeton.edu/31elementary/tale.txt");
		test("https://algs4.cs.princeton.edu/31elementary/leipzig100K.txt");
	}
}
