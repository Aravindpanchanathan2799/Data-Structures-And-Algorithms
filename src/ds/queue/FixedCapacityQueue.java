/**
 * 
 */
package ds.queue;

import java.util.Iterator;

/**
 * 
 */
public class FixedCapacityQueue<Item> implements Queue<Item> {
	private final Item[] elements;
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
	public FixedCapacityQueue(int capacity) {
        elements = (Item[]) new Object[capacity];
        numberOfElements = 0;
        startIndex = -1;
        endIndex = -1;
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
        if (numberOfElements == elements.length) {
            throw new RuntimeException("Queue is full");
        }
        if (numberOfElements == 0) {
            startIndex = 0;
            endIndex = 0;
        } else {
            endIndex++;
            if (endIndex == elements.length)
                endIndex = 0;
        }
        elements[endIndex] = item;
        numberOfElements++;
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
        return item;
    }

	@Override
	public int size() {
        return numberOfElements;
    }

}
