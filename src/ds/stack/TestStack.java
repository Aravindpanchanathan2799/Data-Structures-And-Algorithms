/**
 * 
 */
package ds.stack;

import java.util.Date;

/** 
 * Module A21 Fixed Capacity Bags
 * @author Mayuri Jadhav
 */
public class TestStack {
	
	   private static <Item> void testPushItem(Stack<Item> stack, Item item) {
	    	System.out.println();
	        System.out.println("Push item: "+item.toString());
	        try {
	            stack.push(item);
	        } catch (Exception e) {
	            System.out.println("Error pushing an item in the stack: "+e.getMessage());
	        }
	        System.out.println("Updated stack: "+stack.toString("<", "]", ", "));
	    }
	   private static <Item> void testPopItem(Stack<Item> stack) {
	    	System.out.println();
	    	System.out.println("Pop Item from Stack: ");
	        try {
	            Item item = stack.pop();
	            System.out.println("Item Popped: "+item.toString());
	        } catch (Exception e) {
	            System.out.println("Error popping an item in the stack: "+e.getMessage());
	        }
	        System.out.println("Updated stack: "+stack.toString("<", "]", ", "));
	    }
	   
	   private static void testStringStack(Stack<String> s) {
	        System.out.println("Empty stack: "+s.toString("<", "]", ", "));
	        testPushItem(s, "Nissan Versa");
	        testPushItem(s, "Diamond Necklace");
	        testPushItem(s, "Ravichandran Ashwin");
	        testPushItem(s, "Usian Bolt");
	        testPopItem(s);
	        testPopItem(s);
	        testPopItem(s);
	        testPopItem(s);
	    }
	   private static <Item> void testStack(Stack<Item> stack, Item[] items, int n)
	   {
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.println("Empty stack: "+stack.toString("<", "]", ", "));
		   for(Item item: items) {
			   testPushItem(stack, item);
		   }
		   for ( int i=1; i<=n; i++)
		   {
			   testPopItem(stack);
		   }
	   }
	   public static void main(String[] args) {
			System.out.println("Linked List Stack - Task 1 - by Mayuri Jadhav");
			Date date = new Date();
			System.out.println("Executed on: "+date.toString());    	
			//FixedCapacityStack<String> fcs = new FixedCapacityStack<>(4);
			//testStringStack(fcs);
			//DynamicCapacityStack<String> dcs = new DynamicCapacityStack<>(2);
			//testStringStack(dcs);
			LinkedListStack<String> lls = new LinkedListStack<>();
			testStringStack(lls);
			LinkedListStack<Integer> llsi = new LinkedListStack<>();
			testStack(llsi, new Integer[] {92,76,43,2,1,654,91,46,35,21}, 10);
			//testStack(dcsi, new Integer[] {92,76,43,2,1,654,91,46,35,21}, 10)
			//testStack(dcs, new String[] {"Nissan Versa","Diamond Necklace","MS Dhoni", "Noah Lyles"}, 4);
			//DynamicCapacityStack<Integer> dcsi = new DynamicCapacityStack<>(2);
			//testStack(dcsi, new Integer[] {92,76,43,2,1,654,91,46,35,21}, 10);
	    }

}

