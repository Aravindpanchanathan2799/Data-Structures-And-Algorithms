/**
 * 
 */
package graph.digraph;
import java.util.Iterator;
/**
 * 
 */
public interface Digraph {

	public int getNumberOfVertices();
	public void addVertex();
	public void removeVertex(int vertexIndex);
	public int getNumberOfEdges();
	
	public void addEdge(int vertex1Index, int vertex2Index);
	public void removeEdge(int vertex1Index, int vertex2Index);
	public boolean hasEdge(int vertex1Index, int vertex2Index);
	
	public int getNumberOfAdjacentOutEdges(int vertexIndex);
	public int getNumberOfAdjacentInEdges(int vertexIndex);
	public Iterator<Integer> getAdjacentOutVerticesIndexesIterator(int vertexIndex);
	public int[] getAdjacentOutVerticesIndexesArray(int vertexIndex);
	
	public Iterator<Integer> getAdjacentInVerticesIndexesIterator(int vertexIndex);
	public int[] getAdjacentInVerticesIndexesArray(int vertexIndex);
}
