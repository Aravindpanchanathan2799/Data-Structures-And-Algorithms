package search.bst23;
/**
* @author Mayuri Jadhav */

public class Balanced23Tree<Key extends Comparable<Key>, Value> 
{ private abstract class Node{

}

private class Node2 extends Node{
private Node leftSubtree; 
private Key rootKey; 
private Value rootValue; 
private Node rightSubtree;

Node2(Key key, Value value){ 
	leftSubtree=null;
	rootKey = key; 
	rootValue=value; 
	rightSubtree=null;

}

Node2(Node left, Key key, Value value, Node right){
	leftSubtree=left; 
	rootKey = key; 
	rootValue=value;
	rightSubtree=right;
 }
}

private class Node3 extends Node{
	
	private Node leftSubtree;
	
	private Key root1Key;
	
	private Value root1Value;
	
	private Node middleSubtree;
	
	private Key root2Key;
	
	private Value root2Value;
	
	private Node rightSubtree;
	
	Node3(Key key1, Value value1,Key key2, Value value2){
		
		leftSubtree=null;
		
		root1Key = key1;
		
		root1Value=value1;
		
		middleSubtree = null;
		
		root2Key = key2;
		
		root2Value=value2;
		
		rightSubtree=null;
		
	}
	
	
	
	Node3(Node left, Key key1, Value value1, Node middle, Key key2, Value value2,
			Node right){
		
		leftSubtree=left;
		root1Key = key1;
		root1Value=value1;
		rightSubtree=right;
		root2Key = key2;
		root2Value=value2;
		middleSubtree=middle;
		
	}
}
	private class Node4 extends Node{
		private Node leftSubtree; 
		private Key root1Key;
		private Value root1Value; 
		private Node middleLeftSubtree; 
		private Key root2Key;
		private Value root2Value;
		private Node middleRightSubtree; 
		private Key root3Key;
		private Value root3Value;
		private Node rightSubtree;
	

		Node4(Key key1, Value value1,Key key2, Value value2,Key key3, Value value3){ 
		leftSubtree=null;
		root1Key = key1; 
		root1Value=value1; 
		middleLeftSubtree = null; 
		root2Key = key2; 
		root2Value=value2; 
		middleRightSubtree = null; 
		root3Key = key3; 
		root3Value = value3; 
		rightSubtree=null;
		}
	
	
	 Node4(Node left, Key key1, Value value1, Node middleleft, Key key2, Value value2, Node middleright, Key key3, Value value3, Node right){
		
		
		leftSubtree=left;
		root1Key = key1; 
		root1Value=value1; 
		middleLeftSubtree = middleleft;
		
		root2Key = key2; 
		root2Value=value2; 
		middleRightSubtree = middleright; 
		root3Key = key3;
		root3Value = value3; 
		rightSubtree=right;
		}
		
}
	
	private Node rootNode; 
	public Balanced23Tree() {
		rootNode=null; 
		}
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	