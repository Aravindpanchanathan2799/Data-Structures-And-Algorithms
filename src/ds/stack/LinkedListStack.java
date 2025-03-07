/**
 * 
 */
package ds.stack;

import java.util.Iterator;

/**
 * 
 */
public class LinkedListStack<Item> implements Stack<Item> {

	private Node topNode;
    private int numberOfElements;

    public LinkedListStack() {
        topNode = null;
        numberOfElements = 0;
    }
	private class Node{
	Node belowNode;
	Item item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

            private Node currentNode = topNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
                Item item = currentNode.item;
                currentNode = currentNode.belowNode;
                return item;
            }
        };
	}

	@Override
	public void push(Item item) {
		 Node itemNode = new Node();
	        itemNode.belowNode = null;
	        itemNode.item = item;
	        numberOfElements++;
	        if (topNode == null) {
	        	topNode = itemNode;
	        } else {
	            itemNode.belowNode = topNode;
	            topNode = itemNode;
	        }
	}

	@Override
	public Item pop() {
		// TODO Auto-generated method stub
		if(topNode==null) {
			throw new RuntimeException("Stack is empty");
		}
		Item top = topNode.item;
		topNode = topNode.belowNode;
		return top;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}

}
