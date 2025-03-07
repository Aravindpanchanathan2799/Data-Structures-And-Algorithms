/**
 * 
 */
package graph.undirected;

import java.util.Iterator;

/**
 * 
 */
public interface UndirectedGraph {

	public int getNumberOfVertices();
	public void addVertex();
	public void removeVertex(int vertexIndex);
	
	public int getNumberOfEdges();
	public int getNumberOfAdjacentEdges(int vertexIndex);
	public Iterator<Integer> getAdjacentVerticesIndexesIterator(int vertexIndex);
	public void addEdge(int vertex1Index, int vertex2Index);
	public void removeEdge(int vertex1Index, int vertex2Index);
	public int[] getAdjacentVerticesIndexesArray(int vi);
	public boolean hasEdge(int vertex1Index, int vertex2Index);
	/**
	 * @param vi
	 * @return
	 */
	
	
	
}
