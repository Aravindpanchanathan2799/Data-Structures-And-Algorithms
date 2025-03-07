/**
 * 
 */
package graph.undirected;

import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */
public class UndirectedGraphAdjList implements UndirectedGraph {
	
	private static final double HALF_CAPACITY_TRIGGER = 0.2; 
	private static final int INITIAL_ADJACENCY_CAPACITY = 10; 
	private static final int[] EMPTY_ARRAY = new int[0]; 
	private int numberOfVertices; 
	private int minimumCapacity; 
	private int numberOfEdges; 
	private int[] verticesDegrees;  
	private int[][] adjacencyLists; 
	
	public UndirectedGraphAdjList(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		this.minimumCapacity = numberOfVertices;
		this.verticesDegrees = new int[numberOfVertices];
		this.adjacencyLists = new int[numberOfVertices][];
		for(int i=0; i<numberOfVertices; i++)
		{
			verticesDegrees[i] = 0;
			adjacencyLists[i] = EMPTY_ARRAY;
		}
		
	}

	@Override
	public int getNumberOfVertices() {
		return this.numberOfVertices;
	}

	@Override

	public void addVertex() { 
		if(numberOfVertices==verticesDegrees.length) 
		{ 
			doubleVertexCapacity(); 
 
		} 
		adjacencyLists[numberOfVertices]=EMPTY_ARRAY; 
		verticesDegrees[numberOfVertices]=0; 
		numberOfVertices++; 
	} 
	
	

	@Override

	public void removeVertex(int vertexIndex) { 
		if(vertexIndex<0 || vertexIndex>=numberOfVertices) 
		{ 
			throw new RuntimeException("Invalid index for a vertex: "+vertexIndex); 
		} 
 
		for(int adj:getAdjacentVerticesIndexesArray(vertexIndex)) 
		{ 
			removeEdge(vertexIndex,adj); 
 
		} 
		
		verticesDegrees[vertexIndex] = verticesDegrees[numberOfVertices-1];  
		adjacencyLists[vertexIndex] = adjacencyLists[numberOfVertices-1]; 
		numberOfVertices--; 
		if(verticesDegrees.length >=2 * minimumCapacity && HALF_CAPACITY_TRIGGER * verticesDegrees.length>numberOfVertices) 	
		{ 
			halfVertexCapacity(); 
		} 
		for(int i=0; i<numberOfVertices; i++) 
		{ 
		for(int j=0; j<verticesDegrees[i]; j++) { 
			if(adjacencyLists[i][j]==numberOfVertices) 
				adjacencyLists[i][j]=vertexIndex; 
		}
		} 
	} 

	private void doubleVertexCapacity() 
	{ 
		changeVertexCapacity(verticesDegrees.length * 2); 
 
	}
	
	private void halfVertexCapacity() 
	{ 
	changeVertexCapacity(verticesDegrees.length / 2); 
	}
	 
 
	private void changeVertexCapacity(int newCapacity) { 
	int[] newVerticesDegrees = new int[newCapacity]; 
	for(int i=0; i<numberOfVertices; i++)  
	{ 
	newVerticesDegrees[i]=verticesDegrees[i]; 
	} 
	verticesDegrees = newVerticesDegrees; 
	int[][] newAdjacencies = new int[newCapacity][]; 
	for(int i=0; i<numberOfVertices; i++) 
	{ 
	newAdjacencies[i]=adjacencyLists[i]; 
	} 
	adjacencyLists = newAdjacencies; 
	} 
 
	public int getNumberOfEdges() { 
	return numberOfEdges; 
	} 
 
	public int getNumberOfAdjacentEdges(int vertexIndex) { 
	return verticesDegrees[vertexIndex]; 
	} 
 
	public Iterator<Integer> getAdjacentVerticesIndexesIterator(int vertexIndex) { 
	return new Iterator<Integer>() { 
		int index =0; 
		public boolean hasNext() { 
			return index < verticesDegrees[vertexIndex]; 
		} 
		public Integer next() { 
		if(hasNext()) 
		return adjacencyLists[vertexIndex][index++]; 
		throw new RuntimeException("No more elements"); 
		} 
	}; 
	} 
	 
	public int[] getAdjacentVerticesIndexesArray(int vertexIndex) { 
	if(vertexIndex<0 || vertexIndex>=numberOfVertices) { 
	throw new RuntimeException("Invalid index for a vertex: "+vertexIndex); 
	} 
	int[] result = new int[verticesDegrees[vertexIndex]]; 
	for(int i=0; i<verticesDegrees[vertexIndex]; i++) 
	{ 
	result[i]=adjacencyLists[vertexIndex][i]; 
	} 
	return result; 
	} 
 
	public void addEdge(int vertex1Index, int vertex2Index) { 
		if(vertex1Index<0 || vertex1Index>=numberOfVertices) 
		{ 
		throw new RuntimeException("Invalid index for the first vertex"); 
		} 
		if(vertex2Index<0 || vertex2Index>=numberOfVertices) 
		{ 
		throw new RuntimeException("Invalid index for the second vertex"); 
		} 
		addDirectedEdge(vertex1Index,vertex2Index); 
		addDirectedEdge(vertex2Index,vertex1Index); 
		numberOfEdges++; 
	} 
 
	private void addDirectedEdge(int vertex1Index, int vertex2Index ) 
	{ 
		if(verticesDegrees[vertex1Index]==adjacencyLists[vertex1Index].length)  
		{ 
			doubleAdjacencyCapacity(vertex1Index); 
		} 
		adjacencyLists[vertex1Index][verticesDegrees[vertex1Index]++]=vertex2Index; 
		} 
		public void removeEdge(int vertex1Index, int vertex2Index) { 
		if(vertex1Index<0 || vertex1Index>=numberOfVertices) 
		{ 
		throw new RuntimeException("Invalid index for the first vertex"); 
		} 
		if(vertex2Index<0 || vertex2Index>=numberOfVertices) 
		{ 
		throw new RuntimeException("Invalid index for the second vertex"); 
		} 
		removeDirectedEdge(vertex1Index,vertex2Index); 
		removeDirectedEdge(vertex2Index,vertex1Index); 
		numberOfEdges--; 
	 
	} 
 
	private void removeDirectedEdge(int vertex1Index, int vertex2Index) 
	{ 
	for(int i=0; i<verticesDegrees[vertex1Index]; i++) { 
	if(adjacencyLists[vertex1Index][i]==numberOfVertices) 
	adjacencyLists[vertex1Index][i]=adjacencyLists[vertex1Index][verticesDegrees[vertex1Index]]; 
	} 
	 
	verticesDegrees[vertex1Index]--;  
	if(verticesDegrees[vertex1Index]>=2 * INITIAL_ADJACENCY_CAPACITY && 
	HALF_CAPACITY_TRIGGER * adjacencyLists[vertex1Index].length > verticesDegrees[vertex1Index]) 
	halfAdjacencyCapacity(vertex1Index); 
	} 
 
	private void doubleAdjacencyCapacity(int vertexIndex) 
	{ 
		int capacity = INITIAL_ADJACENCY_CAPACITY; 
		if(adjacencyLists[vertexIndex]!=EMPTY_ARRAY) 
		{ 
		capacity = adjacencyLists[vertexIndex].length * 2; 
		} 
		changeAdjacencyCapacity(vertexIndex,capacity); 
	} 
	 
	private void halfAdjacencyCapacity(int vertexIndex) 
	{ 
	changeAdjacencyCapacity(vertexIndex,adjacencyLists[vertexIndex].length/2); 
	} 
	
	private void changeAdjacencyCapacity(int vertexIndex, int newCapacity) 
	{ 
	int[] newAdjacencyList = new int[newCapacity]; 
	for(int i=0; i<verticesDegrees[vertexIndex]; i++) 
	{ 
	newAdjacencyList[i] = adjacencyLists[vertexIndex][i]; 
	} 
	adjacencyLists[vertexIndex]=newAdjacencyList; 
	} 
	 
 
	public static UndirectedGraphAdjList readNumberedGraph(File file)  
	{ 
	Scanner scanner; 
	try { 
	scanner = new Scanner(file); 
	} 
	
	catch(FileNotFoundException e) 
	{ 
	throw new RuntimeException("Invalid File"); 
	} 
	 
	int numberOfVertices = scanner.nextInt();  
	int numberOfEdges = scanner.nextInt(); 
	UndirectedGraphAdjList graph = new UndirectedGraphAdjList(numberOfVertices); 
	for(int i=0; i<numberOfEdges; i++) 
	{  
	int v1 = scanner.nextInt(); 
	int v2 = scanner.nextInt(); 
	graph.addEdge(v1,v2); 
	} 
	scanner.close(); 
	return graph; 
	} 
	 
	public String verticesSetToString() 
	{ 
	String result = "{1.."+numberOfVertices+"}";  
	return result;  
	} 
		 
	public String edgesSetToString() 
	{ 
	 String result = "{"; 
	 String seperator = ""; 
	for(int vi=0; vi<numberOfVertices; vi++)  
	{ 
		for(int ei=0; ei<verticesDegrees[vi]; ei++) {  
			int ai=adjacencyLists[vi][ei]; 
		if(vi<=ai) 
		{ 
			result += seperator + "(" + vi + "," + ai +")"; 
		}  
	} 
	} 
	result+="}"; 
	return result; 
	} 
	
	
	public String toString()  
	{ 
	String result = "G(" + verticesSetToString() + "," + edgesSetToString() +")"; 
	return result;  
	}

	/**
	 * @param numberOfVertices2
	 * @param numberOfEdges2
	 * @return
	 */
	public static UndirectedGraphAdjList createRandomGraph(int numberOfVertices, int numberOfEdges) {
		// TODO Auto-generated method stub
		if(numberOfEdges > (numberOfVertices-1)*numberOfVertices/2) {
			numberOfEdges = (numberOfVertices-1)*numberOfVertices/2;
		}
		UndirectedGraphAdjList graph = new UndirectedGraphAdjList(numberOfVertices);
		for(int ei=0; ei<numberOfEdges; ei++) {
			boolean created = false;
			while(!created){
				int v1 = (int)(Math.random()*numberOfVertices);
				int v2 = (int)(Math.random()*numberOfVertices);
				if(v1!=v2 && graph.hasEdge(v1,v2)) {
					graph.addEdge(v1,v2);
					created=true;
				}
			}
		}
		return graph;
	}

	@Override
	public boolean hasEdge(int vertex1Index, int vertex2Index) {
		
		for(int ae=0; ae< verticesDegrees[vertex1Index]; ae++)
		{
			if(vertex2Index==adjacencyLists[vertex1Index][ae]) {
				return true;
			}
			
		}
		return false;
		
	} 
	
	
}
    

