/**
 * 
 */
package search.orderedst;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value>
	implements OrderedSymbolTable<Key, Value> {

	private static final int INITIAL_CAPACITY = 2;
	
	private Key[] keys;
	
	private Value[] values;
	
	private int numberOfKeys = 0;
	
	public BinarySearchSymbolTable() {
		this(INITIAL_CAPACITY);
	}
	
@SuppressWarnings("unchecked" )
public BinarySearchSymbolTable(int capacity) {
	keys = (Key[]) new Comparable[capacity];
	values = (Value[]) new Object[capacity];

}

private void resize(int capacity) {
	if (capacity<numberOfKeys)
		throw new RuntimeException("The resized capacity is too small.");
	@SuppressWarnings("unchecked")
	Key[]  tempKeys = (Key[]) new Comparable [capacity];
	@SuppressWarnings("unchecked" )
	Value[] tempValues = (Value[]) new Object [capacity];

	for (int i = 0; i < numberOfKeys; i++) {
		tempKeys[i] = keys[i];	
		tempValues[i] = values[i];
	}
	values = tempValues;
	keys = tempKeys;
}

/*
** Return the number of key value pairs in this symbol table.
** @return the number of keynvalue pairs in this symbol table.
*/
public int size() {
 return numberOfKeys;
}


public boolean isEmpty() {
return size () == 0;
}


public boolean contains (Key key) {
if (key == null) throw new IllegalArgumentException("argument to contains() is null");
return get(key) !=null;


}


public Value get(Key key) {
if (key == null)
	throw new IllegalArgumentException("argument to get() is null");
if (isEmpty())
	return null;
int i = rank(key) ;
if (i < numberOfKeys && keys[i].compareTo(key) == 0)
return values[i];
return null;
}



public int rank(Key key) {
	if (key == null)
		throw new IllegalArgumentException("argument to rank() is null");
int low = 0, high = numberOfKeys-1;
while (low <= high) {
	int mid = low + (high - low) / 2;
	int cmp = key.compareTo (keys [mid]);
	if (cmp < 0)
		high = mid - 1;
	else if ( cmp > 0)
		low = mid + 1;
	else
		return mid;
}

return low;
}



public void put(Key key, Value val) {
	if (key == null)
		throw new IllegalArgumentException("first argument to put() is null");
	if (val == null) {
		delete (key); 	
		return;
}

	int i = rank(key);

if (i < numberOfKeys && keys[i].compareTo(key) == 0) {
values[i] = val;
return;
}




if (numberOfKeys == keys.length) resize(2*keys.length);

for (int j = numberOfKeys; j > i; j--) {
	keys[j] = keys[j-1];
	values[j] = values[j-1];
}
keys[i] = key;
values [i] = val;
numberOfKeys++;
}


public void delete(Key key) {
if (key == null)
	throw new IllegalArgumentException("argumentto delete() is null");
if (isEmpty())
	return;

// compute rank
int i = rank(key);

// key not in table
if (i == numberOfKeys || keys[i].compareTo(key) != 0) {
return;
}



for (int j = i; j < numberOfKeys-1; j++) {
	keys[j] = keys[j+1];
	values[j] = values[j+1];
}

numberOfKeys--;
keys[numberOfKeys] = null; // to avoid loitering
values [numberOfKeys] = null;

//resize if 1/4 full
if (numberOfKeys > 0 && numberOfKeys == keys.length/4)
	resize (keys.length/2);
}



public void deleteMin() {
if (isEmpty())
	throw new NoSuchElementException ("Symbol table underflow error");
	delete (min());
}



public void deleteMax() {
	if(isEmpty())
		throw new NoSuchElementException ("Symbol table underflo error");
	delete (max());
}


public Key min() {
	if (isEmpty())
		throw new NoSuchElementException("called min() with empty symbol table");
	return keys[0];
}




public Key max() {
	if (isEmpty())

throw new NoSuchElementException("called max() with empty symbol table");
return keys [numberOfKeys-1] ;
}



public Key select(int k) {
	if (k < 0 || k >= size()) {
throw new IllegalArgumentException("called select() with invalid argument: " + k);
	}
return keys[k];
}

	public Key floor(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to floor() is null");
	int i = rank(key);
	if (i < numberOfKeys && key.compareTo(keys[i]) == 0)
		return keys[i];
	if (i == 0)
		throw new NoSuchElementException ("argument to floor() is too small");
	else
		return keys[i-1];
	}
	
	
	public Key ceiling (Key key) {
	if (key == null)
		throw new IllegalArgumentException ("argument to ceiling() is null");
	int i = rank(key) ;
	if (i == numberOfKeys)
		throw new NoSuchElementException("argument to ceiling() is too large");
	else
		return keys[i];
	}

	
	
	public int size(Key low, Key high) {
	if (low == null)
		throw new IllegalArgumentException("first argument to size() is null");
	if (high == null)
		throw new IllegalArgumentException("second argument to size() is null");
	
	if (low.compareTo(high) > 0)
		return 0;
	if (contains(high))
		return rank(high) - rank (low) + 1;
	else
		return rank(high) - rank (low);
	}
	
	
	
	public Iterable<Key> keys () {
	return keys(min(), max());
	}
	
	
public Iterable<Key> keys(Key low, Key high) {
	if (low == null)
		throw new IllegalArgumentException("first argument to keys() is null");
	if (high == null)
		throw new IllegalArgumentException("second argument to keys() is null");
	ArrayList<Key> queue = new ArrayList<Key>();
	if (low.compareTo(high) > 0)
		return queue;
	for (int i = rank(low); i < rank(high); i++)
		queue.add (keys[i]);
	if (contains (high))
		queue.add(keys[rank(high)]);
	return queue;
	}


	boolean check() {
		return isSorted() && rankCheck();
	}
	
	boolean isSorted() {
	for (int i = 1; i < size(); i++)
	if (keys[i].compareTo(keys[i-1]) < 0)
		return false;
	return true;
	}
	
	boolean rankCheck() {
		for (int i = 0; i < size(); i++) 
			if (i != rank(select(i)))
				return false;
	for (int i = 0; i < size(); i++)
		if (keys[i].compareTo(select(rank(keys[i]))) != 0)
			return false;
	return true;
	}

	@Override
	public Key celling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}
	}