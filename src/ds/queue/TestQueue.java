/**
 * 
 */
package ds.queue;

import java.util.Date;

/**
 * 
 */
public class TestQueue {
    /**
     * Print a detailed description of the queue.
     */
    private static <Item> void printQueue(Queue<Item> queue, String name) {
        System.out.println("Queue: "+name);
        System.out.println("  - elements = "+queue.toString("<< ", " <<", ", "));
        System.out.println("  - size = "+queue.size());
        System.out.println("  - isEmpty = "+queue.isEmpty());
    }
    private static <Item> void testEnqueueItem(Queue<Item> queue, String name, Item item) {
    	System.out.println();
    	System.out.println("-------------------------------------------------------------------------");
        System.out.println("Enqueue (add) an item to a queue");
        System.out.println("  - queue = "+name);
        System.out.println("  - item = "+item);
        System.out.println("-------------------------------------------------------------------------");
        try {
            queue.enqueue(item);
            System.out.println("  - add successfull");
        } catch (Exception e) {
            System.out.println("  - runtime exception: "+e.getMessage());
        }
        printQueue(queue, name);
        System.out.println("-------------------------------------------------------------------------");
    }
    private static <Item> void testDequeueItem(Queue<Item> queue, String name) {
    	System.out.println();
    	System.out.println("-------------------------------------------------------------------------");
        System.out.println("Dequeue (remove and return) the next item from a queue");
        System.out.println("  - queue = "+name);
        System.out.println("-------------------------------------------------------------------------");
        try {
            Item item = queue.dequeue();
            System.out.println("  - dequeue successfull");
            System.out.println("  - item = "+item.toString());
        } catch (Exception e) {
            System.out.println("  - runtime exception: "+e.getMessage());
        }
        printQueue(queue, name);
        System.out.println("-------------------------------------------------------------------------");
    }
    @SuppressWarnings("unused")
	private static void testWithStrings() {
        Queue<String> fcq3 = new FixedCapacityQueue<>(3);
        String fcq3Name = "fixed capacity queue of 3 elements";
        printQueue(fcq3, fcq3Name);
        testEnqueueItem(fcq3, fcq3Name, "Nissan Versa");
        testEnqueueItem(fcq3, fcq3Name, "Skoda");
        testEnqueueItem(fcq3, fcq3Name, "BMW");
        testEnqueueItem(fcq3, fcq3Name, "Audi");
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testEnqueueItem(fcq3, fcq3Name, "Audi");
        testEnqueueItem(fcq3, fcq3Name, "Mercedes");
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
    }
    @SuppressWarnings("unused")
	private static void testWithIntegers() {
        Queue<Integer> fcq3 = new FixedCapacityQueue<>(3);
        String fcq3Name = "fixed capacity queue of 3 integers";
        printQueue(fcq3, fcq3Name);
        testEnqueueItem(fcq3, fcq3Name, 21);
        testEnqueueItem(fcq3, fcq3Name, 93);
        testEnqueueItem(fcq3, fcq3Name, 56);
        testEnqueueItem(fcq3, fcq3Name, 41);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testEnqueueItem(fcq3, fcq3Name, 41);
        testEnqueueItem(fcq3, fcq3Name, 56);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
        testDequeueItem(fcq3, fcq3Name);
    }
    private static <Item> void testQueue(Queue<Item> queue, String name, 
    		Item[] items1, int dequeue1, Item[] items2, int dequeue2) {
    	System.out.println("----------------------------------------");
    	System.out.println("Queue = "+name);
    	printQueue(queue, name);
        for (Item item: items1) {
        	testEnqueueItem(queue, name, item);
        }
        for (int i=1; i<=dequeue1; i++) {
        	testDequeueItem(queue, name);
        }
        for (Item item: items2) {
        	testEnqueueItem(queue, name, item);
        }
        for (int i=1; i<=dequeue2; i++) {
        	testDequeueItem(queue, name);
        }
    }
    public static void main(String[] args) {
    	System.out.println("Linked List Queue - Task 1 - by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		LinkedListQueue<String> llqs = new LinkedListQueue<>();
    	testQueue(llqs, "linkedlist queue of strings with initial capacity 3",
        		new String[] {"Nissan Versa", "Skoda",  "BMW", "Audi"}, 2,
        		new String[] {"Audi", "BWM"}, 5
        		);
    	LinkedListQueue<Integer> llqi = new LinkedListQueue<>();
        testQueue(llqi, "linkedlist queue of integers with initial capacity 3",
        		new Integer[] {14,49,72,98,26,42,34,55}, 9,
        		new Integer[] {97,23,41,32,51}, 3);
    }

}
