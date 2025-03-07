/** 
 * Module A21 Fixed Capacity Bags
 * @author Mayuri Jadhav
 */
package ds.stack;

/**
 * A Stack works with LIFO Structure.
 * We can push, pop and iterate over the elements of the stack.
 */
public interface Stack<Item> extends Iterable<Item> {
	/**
	 * Method push , helps to add an item onto the stack.
	 * @param item
	 */
	public void push(Item item);
	/**
	 * Method pop, helps to remove an item out of the stack
	 * @return returns the item being deleted from the stack.
	 */
	public Item pop();
	/**
	 * Method size returns the size of the stack as as integer.
	 * @return
	 */
	public int size();
	/**
	 * Checks if the stack is empty, returns true if empty else false.
	 * @return
	 */
	default public boolean isEmpty() {
        return size()==0;
    }
	/**
	 * Helps to format the contents in a way we wish to.
	 * @param start
	 * @param end
	 * @param separator
	 * @return
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
