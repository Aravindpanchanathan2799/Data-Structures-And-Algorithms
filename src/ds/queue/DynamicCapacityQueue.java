/**
 * 
 */
package ds.queue;

import java.util.Iterator;

/**
 * 
 */
public class DynamicCapacityQueue<Item> implements Queue<Item> {
    /**
     * The array of elements stored in the queue. If the end of the array is
     * reached, and there is space at the beginning, the elements will be stored
     * from the beginning. The array is circular, after the last element we continue
     * with the first element. When full the capacity is doubled.
     */
    private Item[] elements;

    /**
     * The current number of elements stored in the queue. The size of the stack.
     */
    private int numberOfElements;

    /**
     * The index of the first element in the queue. -1 if empty. When reaches the
     * end of the array, resets to the beginning.
     */
    private int startIndex;

    /**
     * The index of the last element in the queue. -1 if empty. When reaches the end
     * of the array, resets to the beginning.
     */
    private int endIndex; 
    
    @SuppressWarnings("unchecked")
    public DynamicCapacityQueue(int capacity) {
        elements = (Item[]) new Object[capacity];
        numberOfElements = 0;
        startIndex = -1;
        endIndex = -1;
    }
    
    /**
     * Creates a queue with a default initial capacity (e.g. 10).
     */
    public DynamicCapacityQueue() {
        this(10);
    }  
    private void doubleCapacity() {
        // Needed because Item is a generic type and the compiler cannot 
        // check if it is correct
        @SuppressWarnings("unchecked")
        // Create a new array of Items with a double capacity
        Item[] newElements = (Item[]) new Object[elements.length * 2];
        // Declare and initialize the index to get the old elements, 
        // starting with the first element at startIndex
        int oldIndex = startIndex;
        // Declare and initialize the index where we put the elements 
        // in the new array, starting from the beginning of the new array
        // at index 0
        int newIndex = 0;
        // Copy all the elements from first to last, counting the number of
        // elements copied with i, in total numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            // Copy the current item from the old array in the new array
            // and increment both indexes
            newElements[newIndex++] = elements[oldIndex++];
            // The old index will go circular over the end of the array 
            // If the old index reaches the end of the array
            if (oldIndex==elements.length)
                // Reset the old index to the beginning of the array
                oldIndex=0;
        }
        // Update the elements to the newly created array
        elements = newElements;
        // The elements in the new array started at the index 0
        startIndex = 0;
        // The last element in the new array will be at the index numberOfElements-1
        endIndex = numberOfElements-1;
    }
    private void halfCapacity() {
        if (numberOfElements >= elements.length/2) {
            throw new RuntimeException("Queue is half or more full");
        }
        @SuppressWarnings("unchecked")
        Item[] newElements = (Item[]) new Object[elements.length / 2];
        // Declare and initialize the index to get the old elements, 
        // starting with the first element at startIndex
        int oldIndex = startIndex;
        // Declare and initialize the index where we put the elements 
        // in the new array, starting from the beginning of the new array
        // at index 0
        int newIndex = 0;
        // Copy all the elements from first to last, counting the number of
        // elements copied with i, in total numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            // Copy the current item from the old array in the new array
            // and increment both indexes
            newElements[newIndex++] = elements[oldIndex++];
            // The old index will go circular over the end of the array 
            // If the old index reaches the end of the array
            if (oldIndex==elements.length)
                // Reset the old index to the beginning of the array
                oldIndex=0;
        }
        // Update the elements to the newly created array
        elements = newElements;
        // The elements in the new array started at the index 0
        startIndex = 0;
        // The last element in the new array will be at the index numberOfElements-1
        endIndex = numberOfElements-1;
    }
	@Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            int nextItem = startIndex;

            @Override
            public boolean hasNext() {
                return nextItem != -1;
            }

            @Override
            public Item next() {
                if (nextItem == -1)
                    throw new RuntimeException("No more elements");
                Item item = elements[nextItem];
                if (nextItem == endIndex)
                    nextItem = -1;
                else {
                    nextItem++;
                    if (nextItem == elements.length)
                        nextItem = 0;
                }
                return item;
            }
        };
    }

	@Override
    public void enqueue(Item item) {
        if (numberOfElements == elements.length)
            doubleCapacity();
        numberOfElements++;
        endIndex++; 
        if (endIndex>=elements.length) {
        	endIndex = 0;
        }
        if (startIndex==-1) {
        	startIndex=0;
        }
        elements[endIndex] = item;
    }

	@Override
    public Item dequeue() {
        if (numberOfElements == 0) {
            throw new RuntimeException("Queue is empty");
        }
        Item item = elements[startIndex];
        elements[startIndex]=null;
        numberOfElements--;
        if (numberOfElements == 0) {
            startIndex = -1;
            endIndex = -1;
        } else {
            startIndex++;
            if (startIndex == elements.length)
                startIndex = 0;
        }
        if (numberOfElements>10&&numberOfElements<elements.length/4) {
        	halfCapacity();
        }
        return item;
    }
	@Override
	  public int size() {
    	return numberOfElements;
    }

}
