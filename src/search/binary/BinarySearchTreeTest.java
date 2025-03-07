package search.binary; 
import java.util.Date; 
public class BinarySearchTreeTest { 
public static void main(String[] args) { 
 
// Create a BinarySearchTree
 
System.out.println("PA3-PA Delete in Binary Search Trees-Mayuri Jadhav "); 
 
Date date = new Date(); 
 
System.out.println("Executed on: "+date.toString()); 
 
BinarySearchTree<Integer, String> bst = new BinarySearchTree<>(); 
 
// Insert key-value pairs
 
System.out.println("Inserting key-value pairs:"); 
 
bst.put(5, "Five"); 
 
bst.put(3, "Three"); 
 
bst.put(7, "Seven"); 
 
bst.put(2, "Two"); 
 
bst.put(4, "Four"); 
 
bst.put(6, "Six"); 
 
bst.put(8, "Eight"); 
 
System.out.println("Inserted key-value pairs."); 
 
// Print the entire tree
 
System.out.println("Binary Search Tree:"); 
 
String treeString = bst.toString(); 
 
System.out.println(treeString); 
 
System.out.println(); 
 
// Test the get method
 
System.out.println("Getting values for keys:"); 
 
System.out.println("Value for key 3: " + bst.get(3)); // Should print "Three"
 
System.out.println("Value for key 9: " + bst.get(9)); // Should print null
 
System.out.println(); 
 
// Test the min and max methods
 
System.out.println("Minimum key: " + bst.min()); // Should print 2
 
System.out.println("Maximum key: " + bst.max()); // Should print 8
 
System.out.println(); 
 
// Test the delete method
 
System.out.println("Deleting keys:"); 
 
bst.delete(5); // Delete key 5
 
System.out.println("Deleted key 5."); 
 
bst.delete(2); // Delete key 2
 
System.out.println("Deleted key 2."); 
 
System.out.println(); 
 
// Print the entire tree after deletion

 
System.out.println("Binary Search Tree after deletions:"); 
 
treeString = bst.toString(); 
 
System.out.println(treeString); 
} 
}
