/**
 * 
 */
package search.orderedst;

import search.symboltable.SymbolTable;

/**
 * 
 */
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
	
	public Key min();
	
	public Key max();
	
	public Key floor(Key key);
	
	public Key celling(Key key);
	
	public int rank (Key key);
	
	public Key select(int rank);
	
	public void deleteMin();
	
	public void deleteMax();
	
	public int size(Key low, Key high);
	
	public Iterable<Key> keys(Key low, Key high);
	
	@Override
	
	public Iterable<Key> keys();
	
}
