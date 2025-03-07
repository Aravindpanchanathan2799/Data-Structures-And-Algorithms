/**
 * 
 */
package ds.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */
public class DynamicCapacityStack <Item> implements Stack<Item> {
	 /**
     * The array of elements stored in the stack.
     */
    private Item[] elements;
    
    /**
     * The current number of elements stored in the stack.
     * The size of the stack.
     */
    private int numberOfElements;
    /**
     * Creates an empty stack with the given capacity
     * 
     * @param capacity - the maximum capacity of the stack
     */
    @SuppressWarnings("unchecked")
    public DynamicCapacityStack(int capacity) {
        elements = (Item[]) new Object[capacity];
        numberOfElements = 0;
    }
    
    public DynamicCapacityStack() {
    	this(10);
    }
    
    private void doubleCapacity() {
        @SuppressWarnings("unchecked")
        Item[] newElements = (Item[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    
	private void halfCapacity() {
    	if(numberOfElements >= elements.length/2){
    		throw new RuntimeException("Stack is more than half full");	
    	}
    	@SuppressWarnings("unchecked")
		Item[] newElements = (Item[]) new Object[elements.length / 2];
    	for (int i = 0; i < numberOfElements; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    
	@Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int index= numberOfElements-1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Item next() {
                if (hasNext())
                    return elements[index--];
                throw new NoSuchElementException("No more elements in the stack.");
            }
        };
    }

	@Override
	public void push(Item item) {
		if(numberOfElements==elements.length)
			doubleCapacity();
		elements[numberOfElements]=item;
		numberOfElements++;

	}

	@Override
	public Item pop() {
		if(numberOfElements==0)
			throw new RuntimeException("Stack is Empty");
		numberOfElements--;
		Item top = elements[numberOfElements];
		elements[numberOfElements] = null;
		if(numberOfElements<=elements.length/4 && elements.length>10)
			halfCapacity();
		return top;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

}
