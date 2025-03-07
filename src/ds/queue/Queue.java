/**
 * @author mayurijadhav
 */
package ds.queue;

/**
 * A Stack works with LIFO Structure.
 * We can push, pop and iterate over the elements of the stack.
 */
public interface Queue<Item> extends Iterable<Item> {
    /**
     * Add an item at the end of the queue.
     * @param item the Item to be added
     */
    public void enqueue(Item item);
    /**
     * Remove and return the item from the beginning of the queue.
     * @return the next item in the queue (from the beginning)
     */
    public Item dequeue();
    /**
     * The number of elements in the queue is named the size of the queue.
     * @return the size of the queue.
     */
    public int size();
    /**
     * Check if a queue is empty (no elements in the queue)
     * @return true if the queue is empty.
     */
    default public boolean isEmpty() {
        return size()==0;
    }
    /**
     * Creates a string representation of the queue, starting with the start string,
     * ending with the end string and separating the items with the separator.
     * The method will display the elements starting with the beginning of the queue 
     * (first element added).
     * 
     * @param start     - included at the beginning
     * @param end       - included at the end
     * @param separator - included between elements
     * @return the generated String
     */
    default public String toString(String start, String end, String separator) {
        String result = start;
        boolean needSeparator = false;
        for (Item item : this) {
            if (needSeparator) {
                result += separator;
            } else {
                needSeparator = true;
            }
            result += item.toString();
        }
        result += end;
        return result;
    }
	

}
