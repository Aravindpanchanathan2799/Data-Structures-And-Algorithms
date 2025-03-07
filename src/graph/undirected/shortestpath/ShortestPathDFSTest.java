
package graph.undirected.shortestpath;

import java.io.File;
import java.util.Date;

import graph.undirected.UndirectedGraphAdjList;
import util.array.ArrayUtility;


public class ShortestPathDFSTest { 
public static void test(String fileName) { 
 
 
File file = new File(fileName); 
 
UndirectedGraphAdjList graph = UndirectedGraphAdjList.readNumberedGraph(file); 
 
System.out.println("GRAPH: "); 
 
System.out.println(graph.toString()); 
 
for(int vi=0; vi<graph.getNumberOfVertices(); vi++) { 
 
ShortestPath sp = new ShortestPathDFS(graph,vi); 
 
for(int di=0; di<graph.getNumberOfVertices(); di++) { 
 
if(sp.hasPathTo(di)) 

 
System.out.println("Path" + vi + "to" + di + ": " + 
ArrayUtility.toString(sp.getPath(di), "{", ",", "}")); 
 
} 
 
} 
 
} 
public static void main(String[] args) { 
 
System.out.println("D13-PA Depth First Search for Undirected Graphs - Programming Assignment\r\n"+ "- Task 3 - by MayuriJadhav"); 
 
Date date = new Date(); 
 
System.out.println("Executed on: "+date.toString()); 

//test("/Users/mayurijadhav/Desktop/graph/data/tinyG.txt");
test("/Users/mayurijadhav/Desktop/graph/data/mediumG.txt"); 
//test("/Users/mayurijadhav/Desktop/graph/data/largeG.txt");
} 
}
