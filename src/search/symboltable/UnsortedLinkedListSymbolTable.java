/**
 * 
 */
package search.symboltable;

import java.util.Iterator;

/**
 * 
 */
public class UnsortedLinkedListSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
	
	private class Association{
		private Key key;
		private Value value;
		private Association nextAssociation;
		
		public Association(Key key, Value value, Association nextAssociation) {
			this.key = key;
			this.value = value;
			this.nextAssociation = nextAssociation;
			}
	}
	
	private int numberOfAssociations;
	private Association firstAssociation;
	
	public UnsortedLinkedListSymbolTable() {
		this.numberOfAssociations = 0;
		this.firstAssociation = null;
	}
	

	private Association getAssociation(Key key) {
		Association node = firstAssociation;
			while(node!=null)
			{
				if(node.key.equals(key))
					return node;
				node = node.nextAssociation;
			}
		return null;
	}
	@Override
	public void put(Key key, Value value) {
		if(key == null) {
				throw new NullPointerException();
		}
		if(value!=null) {
			Association a = getAssociation(key);
				if(a!=null) {
					a.value = value;
				}else {
					a = new Association(key,value, firstAssociation);
					firstAssociation = a; numberOfAssociations++;
				}
		}else {
			delete(key);
		}
		
	}

	@Override
	public Value get(Key key) {
		Association a = getAssociation(key);
		if(a==null)
			return null;
		return a.value;
		
	}

	@Override
	public void delete(Key key) {
		if(firstAssociation == null)
			return;
		if(firstAssociation.key.equals(key)) {
			firstAssociation = firstAssociation.nextAssociation;
			numberOfAssociations--;
			return;
		}
	
	Association prevAssoc = firstAssociation;
	Association assoc = firstAssociation.nextAssociation;
	while(assoc!=null) {
		if(assoc.key.equals(key)) {
			prevAssoc.nextAssociation = assoc.nextAssociation;
			numberOfAssociations--;
			return;
		}
		prevAssoc = assoc;
		assoc = assoc.nextAssociation;
	}
	
	}
	
	public boolean contains(Key key) {
		return getAssociation(key)!=null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfAssociations==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfAssociations;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return new Iterable<Key>() {
			
			public Iterator<Key> iterator(){
				return new Iterator<Key>() {
					Association next = firstAssociation;
					
					public boolean hasNext() {
						return next!=null;
				}
					
				public Key next() {
					Association result = next;
					next = next.nextAssociation;
					return result.key;
				}
				 
				
			};
		}
	};
	}
	
	public String toString() {
		String result = "{";
		Association next = firstAssociation;
		String seperator="";
		while(next!=null) {
			result+=seperator+next.key+"{"+next.value+"}";
			seperator = ", ";
			next = next.nextAssociation;
			
		}
		result+= "}";
		return result;
	}

}
