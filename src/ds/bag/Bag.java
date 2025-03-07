/**
 * Module A11 Fixed Capacity Bags
 * Task 1: Basic implementation of fixed capacity bags
 */
package ds.bag;

/**
 * A bag is a collection of objects. It allows us to add objects & Iterate over them.
 * A bag doesn't allow to remove Items from the objects.
 *
 * @author Mayuri Jadhav
 * @param <Item> - specifies the type of objects stored in the bag, can be Integers/ Objects of another class
 */
public interface Bag<Item> extends Iterable<Item> {

    public void add(Item item);
    public int size();

    public default boolean isEmpty() {
        return size() == 0;
    }

    public default boolean isSingleton() {
        return size() == 1;
    }

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
	default public int maxFreq() {
		int max =0;
		for (Item countedItem: this) {
			int count = 0;
			for (Item item: this) {
				if (countedItem.equals(item)) {
					count++;
				}
			}
			if (count>max) {
				max = count;
			}
		}
		return max;
	}
}
