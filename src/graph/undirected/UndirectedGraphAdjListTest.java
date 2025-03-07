package graph.undirected; 
import java.io.File; 
import java.util.Date; 
public class UndirectedGraphAdjListTest { 
 
public static void main(String[] args) { 
 
System.out.println("D11-PA Undirected Graphs Representation - Programming Assignment - Task 2 - by Mayuri Jadhav"); 
Date date = new Date(); 
System.out.println("Executed on: "+date.toString()); 
 
File tinyFile = new File("/Users/mayurijadhav/Desktop/graph/data/tinyG.txt"); 
UndirectedGraphAdjList tinyGraph = UndirectedGraphAdjList.readNumberedGraph(tinyFile); 
System.out.println("TINY GRAPH");  
System.out.println(tinyGraph.toString()); 
 
 
File mediumFile = new File("/Users/mayurijadhav/Desktop/graph/data/mediumG.txt"); 
UndirectedGraphAdjList mediumGraph = 
UndirectedGraphAdjList.readNumberedGraph(mediumFile); 
 
System.out.println("MEDIUM GRAPH"); 
System.out.print(mediumGraph.toString()); 
 
} 
}
