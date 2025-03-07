/**
 * 
 */
package graph.undirected.shortestpath;
import ds.queue.DynamicCapacityQueue;
import ds.queue.Queue;
import graph.undirected.UndirectedGraph;

/**
 * 
 */
public class ShortestPathBFS implements ShortestPath {

	private UndirectedGraph graph; 
	private int sourceIndex; 
	 
	private int[] shortestPathThrough; 
	private int[] shortestPathSize; 
	private boolean[] marked;
	

public ShortestPathBFS(UndirectedGraph graph, int sourceIndex) 
{ 
	this.graph = graph; 
	this.sourceIndex = sourceIndex; 
	if(sourceIndex<0 || sourceIndex>=graph.getNumberOfVertices()) { 
	throw new RuntimeException("Invalid vertex index."); 
	} 
 
	marked = new boolean[graph.getNumberOfVertices()]; 
	shortestPathThrough = new int[graph.getNumberOfVertices()]; 
	shortestPathSize = new int[graph.getNumberOfVertices()]; 
	for(int i=0; i<graph.getNumberOfVertices(); i++) { 
	marked[i]=false; 
	shortestPathThrough[i]=-1; 
	shortestPathSize[i]=0; 
	} 
	bfs(sourceIndex); 
}


private void bfs(int sourceIndex) { 
Queue<Integer> unprocessed = new DynamicCapacityQueue<>(); 
unprocessed.enqueue(sourceIndex); 
marked[sourceIndex]=true; 
	while(!unprocessed.isEmpty()) { 
	int vi = unprocessed.dequeue(); 
		for(int ai:graph.getAdjacentVerticesIndexesArray(vi)) { 
			if(!marked[ai]) 
			{ 
			marked[ai]=true; 
			shortestPathSize[ai]=shortestPathSize[vi]+1;  
			shortestPathThrough[ai]=vi; 
			unprocessed.enqueue(ai); } 
		} 
	} 
}

	@Override
	public UndirectedGraph getGraph(){
		return graph; 
	}

	@Override
	public int getSourceVertex(){
		return sourceIndex;
	}

	@Override
	public boolean hasPathTo(int vertex){
		// TODO Auto-generated method stub
		return shortestPathSize[vertex]>0;
	}

	@Override
	public int[] getPath(int vertex){
		// TODO Auto-generated method stub
		int[] result = new int[shortestPathSize[vertex]+1]; 
		 
		for(int i=shortestPathSize[vertex], v=vertex; i>=0; i--) { 
		 
		result[i]=v; 
		 
		v = shortestPathThrough[v]; 
		 
		} 
		 
		return result;
	}

}
