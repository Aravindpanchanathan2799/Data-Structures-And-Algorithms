/**
 * 
 */
package search.binary;

import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import search.orderedst.BinarySearchSymbolTable;
import search.symboltable.UnsortedLinkedListSymbolTable;
import util.array.ArrayUtility;

/**
 * 
 */
public class TestSymbolTable { 
	 
private static TimeAnalysis[] putMeanTimeComparison(int numberOfExecutions, int 
numberOfAssociations, int minKey, double keyDensity) 
 
{ 
 
int maxKey = minKey + (int)(numberOfAssociations/keyDensity); 
 
Stopwatch watch = new Stopwatch(); 
 
TimeAnalysis[] ta = new TimeAnalysis[3]; 
 
ta[0] = new TimeAnalysis("Linked List", numberOfExecutions); 
 
ta[1] = new TimeAnalysis("Binary Search", numberOfExecutions); 
 
ta[2] = new TimeAnalysis("Binary Tree", numberOfExecutions); 
 
for(int trail = 0; trail<numberOfExecutions; trail++) 
 
{ 
 
int[] keys = ArrayUtility.generateIntArray(numberOfAssociations, minKey, 
maxKey); 
 
int[] values = ArrayUtility.generateIntArray(numberOfAssociations, 
Integer.MIN_VALUE, Integer.MAX_VALUE); 
 
watch.startWatch(); 
 
UnsortedLinkedListSymbolTable<Integer, Integer> st0 = new 
UnsortedLinkedListSymbolTable<>(); 
 
for(int i=0; i<numberOfExecutions; i++) 
 
{ 

 
st0.put(keys[i], values[i]); 
 
} 
 
long time = watch.elapsedTime(); 
 
ta[0].add(time); 
 
 
watch.startWatch(); 
 
BinarySearchSymbolTable<Integer, Integer> st1 = new 
BinarySearchSymbolTable<>(); 
 
for(int i=0; i<numberOfExecutions; i++) 
 
{ 
 
st1.put(keys[i], values[i]); 
 
} 
 
time = watch.elapsedTime(); 
 
ta[1].add(time); 
 
 
watch.startWatch(); 
 
BinarySearchTree<Integer, Integer> st2 = new BinarySearchTree<>(); 
 
for(int i=0; i<numberOfExecutions; i++) 
 
{ 
 
st2.put(keys[i], values[i]); 
 
} 
 
time = watch.elapsedTime(); 
 
ta[2].add(time); 
 
} 
 
return ta; 
 
} 
 
private static void putComparisonTable(String name, int numberOfExecutions, int minAssoc, 
int incrementAssoc, int maxAssoc, int minKey, double keyDensity) 
 
{ 
 
System.out.println("Mean Execution time growth comparison table for put peration."); 
 
System.out.println(" - Test name: "+ name); 

 
System.out.println(" - Number of Execution(Sample Size) for time estimation: "+ 
numberOfExecutions); 
 
System.out.println(" - Key density: " + keyDensity); 
 
System.out.println(" - Methods: LL=unsorted Linked List, BS=binary search in dynamic capacity arrays;"+"BT=binary search Tree"); 
 
System.out.println("----------- |--------|--------|------  |"); 
 
System.out.println(" N          | LL     | BS     | BT     |"); 
 
System.out.println("----------- |--------|--------|------  |"); 
 
for(int n=minAssoc; n<=maxAssoc; n+=incrementAssoc) 
 
{ 
 
TimeAnalysis[] ta = 
putMeanTimeComparison(numberOfExecutions,n,minKey,keyDensity); 
 
System.out.printf("| %9d | %6.1f | %6.1f | %6.1f |\n",n, 
ta[0].getMeanTime(),ta[1].getMeanTime(),ta[2].getMeanTime()); 
 
} 
 
System.out.println("----------- |--------|--------|------  |"); 
 
} 
 
public static void main(String[] args) 
 
{ 
 
System.out.println("PA2 Search Binary Search Trees-Task3/4-Search Comparison-Mayuri Jadhav "); 
 
Date date = new Date(); 
 
System.out.println("Executed on: "+date.toString()); 
 
//putComparisonTable("Sparse keys", 21, 10000, 1000, 20000, Integer.MIN_VALUE, 0.05); 
 
//putComparisonTable("Normal keys", 21, 10000, 1000, 20000, Integer.MIN_VALUE, 0.5); 
 
//putComparisonTable("Close to Normal keys", 21, 10000, 1000, 20000, Integer.MIN_VALUE, 2); 
 
//putComparisonTable("Denser keys", 21, 10000, 1000, 20000, Integer.MIN_VALUE, 5); 
 
//putComparisonTable("Denser keys", 21, 10000, 1000, 20000, Integer.MIN_VALUE, 10); 
 
} 
}
