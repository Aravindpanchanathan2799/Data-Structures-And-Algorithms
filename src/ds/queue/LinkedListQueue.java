/**
 * 
 */
package ds.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */
public class LinkedListQueue<Item> implements Queue<Item> {
	private class Node {
		Node nextNode;
		Item item;
	}
	
	private Node frontNode;
	
	private Node backNode;
	
	private int numberOfElements;
	
	public LinkedListQueue() {
		frontNode = null;
		backNode = null;
		numberOfElements = 0;
	}
	
	@Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node currentNode = frontNode;

            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
                Item item = currentNode.item;
                currentNode = currentNode.nextNode;
                return item;
            }

        };
	}

	@Override
    public void enqueue(Item item) {
    	Node node = new Node();
    	node.nextNode = null;
    	node.item = item;
    	
    	if (numberOfElements==0) {
    		frontNode = node;
    		backNode = node;
    	} else {
    		backNode.nextNode = node;
    		backNode = node;
    	}
       numberOfElements++;
    }

	@Override
    public Item dequeue() {
    	if (numberOfElements==0) 
    		throw new NoSuchElementException("Queue is empty");
    	Node next = frontNode;
    	if (numberOfElements==1) {
    		frontNode=null;
    		backNode=null;
    	} else {
    		frontNode=frontNode.nextNode;
    	}
    	numberOfElements--;
    	return next.item;
    }
	@Override
	  public int size() {
    	return numberOfElements;
    }

}
