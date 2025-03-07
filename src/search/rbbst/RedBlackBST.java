/**
 * 
 */
package search.rbbst;

/**
 * 
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
private enum COLOR{ RED, BLACK}; 
	private class Node
	{
	private Key key;
	private Value value;
	private Node leftSubtreeRoot; 
	private Node rightSubtreeRoot; 
	private COLOR color;
	private int size;
	
	Node(Key key, Value value, COLOR color) {
		 this.key = key;
		 this.value = value;
		 this.leftSubtreeRoot = null;
		 this.rightSubtreeRoot = null;
		 this.color = color;
		 this.size = 1;
		 } 
	}
	
	private int size(Node node)
	 {
	 if(node==null) return 0;
	 return node.size;
	 } 
	
	private Node rotateLeft(Node previousRoot)
	 {
	 Node newRoot = previousRoot.rightSubtreeRoot;
	 previousRoot.rightSubtreeRoot = newRoot.leftSubtreeRoot;
	 newRoot.leftSubtreeRoot = previousRoot; 
	 newRoot.color = previousRoot.color;
	 previousRoot.color = COLOR.RED;
	 newRoot.size = previousRoot.size;
	 previousRoot.size = size(previousRoot.leftSubtreeRoot) +
	size(previousRoot.rightSubtreeRoot) + 1;
	 return newRoot;
	 }
	
	private Node rotateRight(Node previousRoot)
	 {
	 Node newRoot = previousRoot.leftSubtreeRoot;
	 previousRoot.leftSubtreeRoot = newRoot.rightSubtreeRoot;
	 newRoot.rightSubtreeRoot = previousRoot;
	 newRoot.color = previousRoot.color;
	 previousRoot.color = COLOR.RED;
	 newRoot.size = previousRoot.size;
	 previousRoot.size = size(previousRoot.leftSubtreeRoot) +
	size(previousRoot.rightSubtreeRoot) + 1;
	 return newRoot;
	 }
	
	private void flipColors(Node middleNode)
	 {
	 middleNode.color = COLOR.RED;
	 middleNode.leftSubtreeRoot.color = COLOR.BLACK;
	 middleNode.rightSubtreeRoot.color = COLOR.BLACK;
	 }
	
	public void put(Key key, Value value)
	 {
	 if(key==null) throw new NullPointerException("Key must not be null.");
	 //if(value==null) delete(key,value);
	 if(root==null)
	 {
	 root=new Node(key,value,COLOR.BLACK); 
	 }
	 else
	 {
	 root = put(root,key,value);
	 root.color = COLOR.BLACK;
	 }
	 } 
	
	public Node put(Node subtreeBlackRoot, Key key, Value value)
	 {
	 if (subtreeBlackRoot==null) {
	 return new Node(key, value, COLOR.RED);
	 }
	 Node result;
	 int compareBlack = key.compareTo(subtreeBlackRoot.key);
	 if(compareBlack==0)
	 {
	 subtreeBlackRoot.value = value;
	 return subtreeBlackRoot;
	 }

	 if(subtreeBlackRoot.leftSubtreeRoot==null)
	 {
	 if(compareBlack<0)
	 {
	 subtreeBlackRoot.leftSubtreeRoot = new Node(key,value,COLOR.RED);
	 return subtreeBlackRoot;
	 }
	 else
	 {
	 subtreeBlackRoot.rightSubtreeRoot = new Node(key,value,COLOR.RED);
	 result = rotateLeft(subtreeBlackRoot); 
	 return result;
	 }
	 }
	 if(subtreeBlackRoot.leftSubtreeRoot.color == COLOR.BLACK)
	 {
	 if(compareBlack<0)
	 {
	 subtreeBlackRoot.leftSubtreeRoot =
	put(subtreeBlackRoot.leftSubtreeRoot,key,value);
	 return subtreeBlackRoot;
	 }
	 else
	 {
	 subtreeBlackRoot.rightSubtreeRoot =
	put(subtreeBlackRoot.rightSubtreeRoot,key,value);
	 result = rotateLeft(subtreeBlackRoot);
	 return result;
	 }
	 }
	 if(compareBlack>0)
	 {
	 subtreeBlackRoot.rightSubtreeRoot =
	put(subtreeBlackRoot.rightSubtreeRoot,key,value);
	 if(subtreeBlackRoot.rightSubtreeRoot.color == COLOR.RED)
	 {
	 flipColors(subtreeBlackRoot);
	 }
	 return subtreeBlackRoot;
	 }
	 Node redNode = subtreeBlackRoot.leftSubtreeRoot;
	 int compareRed = key.compareTo(redNode.key);
	 if(compareRed==0) 
	 {
	 redNode.value = value;
	 return subtreeBlackRoot;
	 }
	 if(compareRed<0)
	 {
	 if(redNode.leftSubtreeRoot==null)
	 {
	 redNode.leftSubtreeRoot = new Node(key,value,COLOR.RED);
	 }
	 else
	 {
	 redNode.leftSubtreeRoot = put(redNode.leftSubtreeRoot,key,value);
	 }
	 if(redNode.leftSubtreeRoot.color==COLOR.RED)
	 {
	 Node middleNode = rotateRight(subtreeBlackRoot);
	 flipColors(middleNode);
	 return middleNode;
	 }
	 return subtreeBlackRoot;
	 }
	 else
	 {
	 if(redNode.rightSubtreeRoot==null)
	 {
	 redNode.rightSubtreeRoot = new Node(key,value,COLOR.RED);

	 }
	 else
	 { 
	 redNode.rightSubtreeRoot = put(redNode.rightSubtreeRoot,key,value);
	 }
	 if(redNode.rightSubtreeRoot.color==COLOR.RED)
	 {
	 subtreeBlackRoot.leftSubtreeRoot= rotateLeft(redNode);
	 Node middleNode = rotateRight(subtreeBlackRoot);
	 flipColors(middleNode);
	 return middleNode;
	 }
	 return subtreeBlackRoot;
	 }

	 }
	
	public String keysToTreeString()
	 {
	 return keysToString(root,"");
	 }
	 public String keysToString(Node subtreeRoot, String prefix)
	 {
	 if(subtreeRoot==null)return "";
	 return keysToString(subtreeRoot.rightSubtreeRoot,prefix+" ") + prefix +
	subtreeRoot.key.toString() + "(" + subtreeRoot.value.toString()+") "

	 +((subtreeRoot.color==COLOR.RED?"R":"B")+"\n"+keysToString(subtreeRoot.leftSubtreeRoot,prefix+" "));
	 } 
	 
	private Node root;
	
	
}
