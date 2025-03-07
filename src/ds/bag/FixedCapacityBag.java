/**
 * Module A11 Fixed capacity bags
 * Task 1: Basic Implementation
 */
package ds.bag;

import java.util.Iterator;

/**
 * A Fixed Capacity Bag - Has fixed number of elements and cannot be changed once specificed
 * 
 * @author Mayuri Jadhav
 * @param <Item> specifies the type of object Stored in the Bag.
 */
public class FixedCapacityBag<Item> implements Bag<Item> {

	/**
	 * object elements is the array of items 
	 * variable numberOfElements specifies the number of the items in the array
	 */
	private final Item[] elements;
	private int numberOfElements;
	
	/**
	 * Constructor FixedCapacityBag helps to initialize the Bag object 
	 * "elements" and variable "numberOfElements"
	 * @param capacity get the input from user on the size of the array 
	 */
	
	@SuppressWarnings("unchecked")
	public FixedCapacityBag(int capacity)
	{
		elements = (Item[]) new Object[capacity];
		numberOfElements = 0;
	}
	
	/**
	 * checks the bag is empty or not , uses the value inside the numberOfElements
	 */
	/**
	 * checks how many items are contained inside the bag , uses the value inside the numberOfElements
	 */
	public int size()
	{
		return numberOfElements;
	}

    /**
     * Return the capacity of this bag.
     * @return the capacity of this bag as an int.
     */
    protected int getCapacity() {
        return elements.length;
    }
    
	/**
	 * checks if the bag is full, if yes throws the error that we can't add items
	 * or else adds the item to the index specified by numberOfElements under the elements.
	 */
	
	public void add(Item item)
	{
		if(numberOfElements== elements.length)
			throw new RuntimeException ("Bag is Full");
		  elements[numberOfElements]= item;
		  numberOfElements++;
	}

	/**
	 * Iterates over the number of elements step by step , used the  Iterator Interface and implements iterator method
	 * If there are no more elements its returns the error telling No more Elements.
	 */
	
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			int index = 0;
				public boolean hasNext()
				{
					return index < numberOfElements;
				}
				public Item next()
				{
					if(hasNext())
						return elements[index++];
					throw new RuntimeException("No more Elements");
				}
		};
		
	}
	
    /**
     * A bag may be printed with the format: [e1 e2 e3 ... ].
     * @return a String description of the bag.
     */
    @Override
	public String toString() {
		String result = "[";
		String separator = "";
		for (Item item : this) {
			result += separator + item.toString();
			separator = ", ";
		}
		result += "]";
		return result;
	}
}
