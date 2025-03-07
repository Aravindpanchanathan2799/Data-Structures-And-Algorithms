
package graph.undirected; 
import java.io.File; 
import java.util.Date; 
import util.array.ArrayUtility; 
public class ConnectedComponentDFSTest { 
public static void test(String fileName) { 

 
 
File tinyFile = new File(fileName); 
 
UndirectedGraphAdjList graph = UndirectedGraphAdjList.readNumberedGraph(tinyFile); 
 
System.out.println("GRAPH: "); 
 
System.out.println(graph.toString()); 
 
for(int vi=0; vi<graph.getNumberOfVertices();vi++) 
 
{ 
 
ConnectedComponentDFS cc = new ConnectedComponentDFS(graph,vi); 
 
System.out.println(vi+":"+ArrayUtility.toString(cc.getConnectedComponent(), 
"{", ",", "}")); 
 
} 
 
} 
public static void main(String[] args) { 
 
System.out.println("D12-PA Depth First Search for Undirected Graphs - Programming Assignment\r\n" + " - Programming Assignment - Task 3 - by Mayuri Jadhav");  
Date date = new Date(); 
System.out.println("Executed on: "+date.toString()); 
//test("/Users/mayurijadhav/Desktop/graph/data/tinyG.txt");
test("/Users/mayurijadhav/Desktop/graph/data/mediumG.txt"); 
//test("/Users/mayurijadhav/Desktop/graph/data/largeG.txt"); 
} 
} 
