/**
 * 
 */
package search.wordfreq;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import search.symboltable.UnsortedLinkedListSymbolTable;

/**
 * 
 */
public class WordFrequencyUnsorted extends UnsortedLinkedListSymbolTable<String, Integer>{
	public WordFrequencyUnsorted() {
		super();
	}
	
	public void computeFrequency(String url) {
		try {
		Scanner scanner = new Scanner(new URL(url).openStream());
		
		while (scanner.hasNext()) {
			String key = scanner.next();
			if(!key.isBlank()) {
				if(contains(key)) {
					put(key,get(key)+1);
				}
				else {
					put(key,1);
				}
			}
		}
		scanner.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
}
	public int wordsCounted() {
		int sum = 0;
		for(String word:keys()) {
			int freq = get(word);
			sum+=freq;
		}
		return sum;
	}
	
	public int maxFrequency() {
		int max = 0;
		for(String word: keys()) {
			int freq = get(word);
			if(freq>max)
				max=freq;
		}
		return max;
	}
	
	public int minFrequency() {
		int min = Integer.MAX_VALUE;
		for(String word:keys()) {
			int freq = get(word);
			if(freq<min)
				min = freq;
		}
		return min;
	}
	
	public ArrayList<String> getWordsWithFrequency(int frequency){
		ArrayList<String> result = new ArrayList<>();
		for(String word:keys()) {
			int freq = get(word);
			if(freq == frequency)
				result.add(word);
		}
		return result;
		}
}
