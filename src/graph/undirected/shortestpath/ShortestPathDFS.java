
package graph.undirected.shortestpath; 
import graph.undirected.UndirectedGraph; 
public class ShortestPathDFS implements ShortestPath { 
private UndirectedGraph graph; 
private int sourceIndex; 
 
private int[] shortestPathThrough; 
private int[] shortestPathSize; 
private boolean[] marked; 
 
public ShortestPathDFS(UndirectedGraph graph, int sourceIndex) 

 
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
 
dfs(sourceIndex); 
 
} 
private void dfs(int vi) 
 
{ 
 
marked[vi]=true; 
 
for(int ai:graph.getAdjacentVerticesIndexesArray(vi)) { 
 
if(!marked[ai] || shortestPathSize[ai]>shortestPathSize[vi]+1){ 
 
shortestPathSize[ai]=shortestPathSize[vi]+1; 
 
shortestPathThrough[ai]=vi; 
 
dfs(ai); 
 
} 
 
} 
 
} 
public UndirectedGraph getGraph() { 
 
// TODO Auto-generated method stub
 
return graph; 
 
} 
 
public int getSourceVertex() { 
 
// TODO Auto-generated method stub
 
return sourceIndex; 
 
} 
public boolean hasPathTo(int vertex) { 
 
// TODO Auto-generated method stub
 
return shortestPathSize[vertex]>0; 
 
} 
public int[] getPath(int vertex) { 
 
// TODO Auto-generated method stub
 
int[] result = new int[shortestPathSize[vertex]+1]; 
 
for(int i=shortestPathSize[vertex], v=vertex; i>=0; i--) { 
 
result[i]=v; 
 
v = shortestPathThrough[v]; 
 
} 
 
return result; 
 
} 
}
