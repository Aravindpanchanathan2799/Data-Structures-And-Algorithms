package ds.bag;

import java.util.Iterator;

public class DynamicCapacityBag<Item> implements Bag<Item> {

    private Item[] elements;
    private int numberOfElements;


    @SuppressWarnings("unchecked")
	public DynamicCapacityBag(int initialCapacity) {
        elements = (Item[]) new Object[initialCapacity];
        numberOfElements = 0;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
    
    public DynamicCapacityBag() {
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

    @Override
    public void add(Item item) {
        if (numberOfElements == elements.length)
            doubleCapacity();
        elements[numberOfElements++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < numberOfElements;
            }

            @Override
            public Item next() {
                if (hasNext())
                    return elements[index++];
                throw new RuntimeException("No more elements.");
            }
        };
    }

    @Override
    public String toString() {
        String result = "[";
        for (Item item : this) {
            result += item.toString() + " ";
        }
        result += "]";
        return result;
    }

    
}
