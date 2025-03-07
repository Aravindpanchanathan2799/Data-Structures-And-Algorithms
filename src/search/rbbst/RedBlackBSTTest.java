package search.rbbst;
import java.util.Date;
public class RedBlackBSTTest {
private static String[] test1 = {"N","U","M","B","E","R" };
private static String[] test2 = {"B","A","N","U","D","E","P","R","D","Y"};


public static void main(String[] args) 
 {
 System.out.println("----------------------------------------------------------------------------");
 System.out.println("Task 3: RedBlackBST - by Mayuri Jadhav");
 Date date = new Date();
 System.out.println("Executed on: "+date.toString());
 System.out.println("----------------------------------------------------------------------------");
 RedBlackBST<String,Integer> rb = new RedBlackBST<>();
 int index = 1;
 for(String key:test1) {
 rb.put(key, index++);
 System.out.println(rb.keysToTreeString());
 }
 System.out.println("----------------------------------------------------------------------------");
 for(String key:test2) {
	 rb.put(key, index++);
	 System.out.println(rb.keysToTreeString());
	 }
 }
}