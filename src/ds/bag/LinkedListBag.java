package ds.bag;

import java.util.Iterator;

public class LinkedListBag<Item> implements Bag<Item> {

    private Node startNode;
    private Node endNode;
    private int numberOfElements;

    public LinkedListBag() {
        startNode = null;
        endNode = null;
    }

    @Override
    public void add(Item item) {
        Node itemNode = new Node();
        itemNode.nextNode = null;
        itemNode.item = item;
        numberOfElements++;
        if (startNode == null) {
            startNode = itemNode;
            endNode = itemNode;
        } else {
            endNode.nextNode = itemNode;
            endNode = itemNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return startNode == null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node currentNode = startNode;

            @Override
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

    private class Node {
        Node nextNode;
        Item item;
    }

    @Override
    public String toString() {
       return toString("[", "]", " ");
    }

}

