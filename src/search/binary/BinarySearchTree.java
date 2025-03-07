
package search.binary; 
import java.util.NoSuchElementException; 
import search.orderedst.OrderedSymbolTable;

public class BinarySearchTree <Key extends Comparable<Key>,Value> implements
OrderedSymbolTable<Key,Value>{ 
public class Node { 
private Key key; 
private Value value; 
private Node leftSubTree; 
private Node rightSubTree; 
private int size; 
 
public Node(Key key, Value value) { 
 
this.key = key; 
 
this.value = value; 
 
this.size = 1; 
 
this.leftSubTree = null; 
 
this.rightSubTree = null; 
 
} 
} 
private Node rootNode; 
public BinarySearchTree() 
{ 
rootNode = null; 
} 
private Node put(Node treeRoot, Key key, Value value) { 
// TODO Auto-generated method stub
if(treeRoot==null) 
 
return new Node(key,value); 
int cmp = key.compareTo(treeRoot.key); 
if(cmp < 0) 
 
{ 
 
treeRoot.leftSubTree = put(treeRoot.leftSubTree,key,value); 
 
} 
else if(cmp>0) 
 
{ 
 
treeRoot.rightSubTree = put(treeRoot.rightSubTree,key,value); 
 
} 

else
 
{ 
 
treeRoot.value = value; 
 
} 
treeRoot.size = 1 + size(treeRoot.leftSubTree)+size(treeRoot.rightSubTree); 
return treeRoot; 
} 
public void put(Key key, Value value) 
{ 
if(key==null) 
 
throw new IllegalArgumentException("Keys are not allowed to be null"); 
if(value==null) 
 
{ 
 
delete(key); 
 
return; 
 
} 
rootNode = put(rootNode,key,value); 
} 
public Value get(Node subtreeRoot, Key key) { 
// TODO Auto-generated method stub
if(subtreeRoot == null) 
 
return null; 
int cmp = key.compareTo(subtreeRoot.key); 
if(cmp < 0) 
 
{ 
 
return get(subtreeRoot.leftSubTree,key); 
 
} 
else if(cmp>0) 
 
{ 
 
return get(subtreeRoot.rightSubTree,key); 
 
} 
else
 
{ 
 
return subtreeRoot.value; 
 
} 
 
} 
public Value get(Key key) 
{ 
if(key==null) 
 
throw new IllegalArgumentException("Keys are not allowed to be null."); 
return get(rootNode,key); 
} 
public boolean contains(Key key) { 
// TODO Auto-generated method stub
if(key==null) 
 
throw new IllegalArgumentException("Keys are not allowed to be null."); 
return get(key) != null; 
} 
@Override
public boolean isEmpty() { 
// TODO Auto-generated method stub
return size()==0; 
} 
public int size(Node subtree) { 
// TODO Auto-generated method stub
if(subtree==null) {return 0;} 
return subtree.size; 
} 
private Node min(Node subtreeRoot) 
{ 
if(subtreeRoot.leftSubTree==null) 
 
return subtreeRoot; 
else
 
return min(subtreeRoot.leftSubTree); 
} 
@Override
public Key min() { 
// TODO Auto-generated method stub

if(isEmpty()) 
 
throw new NoSuchElementException("An empty symbol table has no minimum"); 
return min(rootNode).key; 
} 
private Node max(Node subtreeRoot) 
{ 
if(subtreeRoot.rightSubTree==null) 
 
return subtreeRoot; 
else
 
return max(subtreeRoot.rightSubTree); 
} 
@Override
public Key max() { 
// TODO Auto-generated method stub
if(isEmpty()) 
 
throw new NoSuchElementException("An empty symbol table has no maxiumum"); 
return max(rootNode).key; 
} 
@Override
public Key floor(Key key) { 
// TODO Auto-generated method stub
return null; 
} 
public Key ceiling(Key key) { 
// TODO Auto-generated method stub
return null; 
} 
@Override
public int rank(Key key) { 
// TODO Auto-generated method stub
return 0; 
} 
@Override
public Key select(int rank) { 
// TODO Auto-generated method stub
return null; 
} 
private Node deleteMin(Node rootNode) 
{ 
if(rootNode.leftSubTree==null) 
 
return rootNode.rightSubTree; 
rootNode.leftSubTree=deleteMin(rootNode.leftSubTree); 
rootNode.size--; 
return rootNode; 
 
} 
@Override
public void deleteMin() { 
// TODO Auto-generated method stub
if(isEmpty()) 
 
throw new NoSuchElementException("Symbol Table is Empty-No Minimum Element"); 
rootNode=deleteMin(rootNode); 
 
} 
private Node deleteMax(Node rootNode) 
{ 
if(rootNode.rightSubTree==null) 
 
return rootNode.leftSubTree; 
rootNode.rightSubTree=deleteMax(rootNode.rightSubTree); 
rootNode.size--; 
return rootNode; 
 
} 
@Override
public void deleteMax() { 
// TODO Auto-generated method stub
if(isEmpty()) 
 
throw new NoSuchElementException("Symbol Table is Empty-No Maximum Element"); 

rootNode=deleteMax(rootNode); 
 
} 
private Node delete(Node rootNode,Key key) 
{ 
if(rootNode == null) 
 
{ 
 
return null; 
 
} 
int cmp = key.compareTo(rootNode.key); 
if(cmp < 0) 
 
{ 
 
rootNode.leftSubTree = delete(rootNode.leftSubTree,key); 
 
} 
else if(cmp>0) 
 
{ 
 
rootNode.rightSubTree = delete(rootNode.rightSubTree,key); 
 
} 
else
 
{ 
 
if(rootNode.rightSubTree == null) 
 
return rootNode.leftSubTree; 
 
else if(rootNode.leftSubTree==null) 
 
return rootNode.rightSubTree; 
 
Node temp = rootNode; 
 
rootNode = min(temp.rightSubTree); 
 
rootNode.rightSubTree = deleteMin(temp.rightSubTree); 
 
rootNode.leftSubTree = temp.leftSubTree; 
 
} 
rootNode.size = 1 + size(rootNode.leftSubTree)+size(rootNode.rightSubTree); 
return rootNode; 
} 
public void delete(Key key) { 
if(isEmpty()) 
 
throw new NoSuchElementException("Symbol Table is Empty-No Maximum Element"); 
 
rootNode = delete(rootNode, key); 
} 
@Override
public int size() { 
// TODO Auto-generated method stub
return size(rootNode); 
} 
@Override
public Iterable<Key> keys(Key low, Key high) { 
// TODO Auto-generated method stub
return null; 
} 
@Override
public Iterable<Key> keys() { 
// TODO Auto-generated method stub
return null; 
} 
@Override
public int size(Key low, Key high) { 
// TODO Auto-generated method stub
return 0; 
} 
public String toString() { 
 
StringBuilder result = new StringBuilder(); 
 
result.append("["); 
 
// Start with the root node
 
buildString(rootNode, result); 
 
result.append("]"); 
 
return result.toString(); 
} 
private void buildString(Node node, StringBuilder result) { 

 
if (node == null) { 
 
return; 
 
} 
 
// In-order traversal: left, current, right
 
buildString(node.leftSubTree, result); 
 
// Append the key-value pair
 
result.append("("); 
 
result.append(node.key); 
 
result.append(":"); 
 
result.append(node.value); 
 
result.append(")"); 
 
// Add a separator if there are more nodes to process
 
if (node.rightSubTree != null) { 
 
result.append(", "); 
 
} 
 
buildString(node.rightSubTree, result); 
}
@Override
public Key celling(Key key) {
	// TODO Auto-generated method stub
	return null;
} 
}
