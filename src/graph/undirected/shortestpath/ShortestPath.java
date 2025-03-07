/**
 * 
 */
package graph.undirected.shortestpath;
import graph.undirected.UndirectedGraph;

/**
 * 
 */
public interface ShortestPath {
	
	public UndirectedGraph getGraph();
	public int getSourceVertex();
	public boolean hasPathTo(int vertex);
	public int[] getPath(int vertex);

}
