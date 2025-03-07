
package graph.undirected.analysis;

import java.io.File;
import java.util.Date;

import alg.analysis.Stopwatch;
import alg.analysis.TimeAnalysis;
import graph.undirected.UndirectedGraphAdjList;

import graph.undirected.shortestpath.ShortestPath; 
import graph.undirected.shortestpath.ShortestPathBFS; 
import graph.undirected.shortestpath.ShortestPathDFS;

public class ShortestPathAnalysis { 
public static void testGraphAnalysis(String filename, int numberOfExecutions) { 
 
Stopwatch watch = new Stopwatch(); 
 
UndirectedGraphAdjList graph = null; 

 
TimeAnalysis taToCreateGraph = new TimeAnalysis("create",numberOfExecutions); 
 
TimeAnalysis taForShortestPathDFS = new TimeAnalysis("dfs",numberOfExecutions); 
 
TimeAnalysis taForShortestPathBFS = new TimeAnalysis("bfs",numberOfExecutions); 
 
for(int trial=0; trial<numberOfExecutions; trial++) { 
 
watch.startWatch(); 
 
File file = new File(filename); 
 
graph = UndirectedGraphAdjList.readNumberedGraph(file); 
 
long timeToCreateGraph = watch.elapsedTime(); 
 
taToCreateGraph.add(timeToCreateGraph); 
 
 
watch.startWatch(); 
 
for(int si=0; si<graph.getNumberOfVertices(); si++) { 
 
@SuppressWarnings("unused") 
 
ShortestPath spDFS = new ShortestPathDFS(graph,si); 
 
} 
 
long timeForShortestPathDFS = watch.elapsedTime(); 
 
taForShortestPathDFS.add(timeForShortestPathDFS); 
 
 
watch.startWatch(); 
 
for(int si=0; si<graph.getNumberOfVertices(); si++) { 
 
@SuppressWarnings("unused") 
 
ShortestPath spBFS = new ShortestPathBFS(graph,si); 
 
} 
 
long timeForShortestPathBFS = watch.elapsedTime(); 
 
taForShortestPathBFS.add(timeForShortestPathBFS); 
 
} 
 
System.out.println("Graph with "+ graph.getNumberOfVertices() + " vertices and " + 
graph.getNumberOfEdges() + " edges."); 
 
System.out.println("Create graph: "+ taToCreateGraph); 
 
System.out.println("Shortest Path for all vertices using DFS: "+taForShortestPathDFS); 
 
System.out.println("Shortest Path for all vertices using BFS: "+taForShortestPathBFS); 
 
} 
public static void randomAnalysis(int minVertices, int maxVertices, int increment, int
edgesPerVertex, int numberOfExecutions ) 
 
{ 
 
for(int numberOfVertices=minVertices;numberOfVertices<=maxVertices; 
numberOfVertices+=increment) 
 
{ 
 
randomTest(numberOfVertices,(numberOfVertices*edgesPerVertex)/2, 
numberOfExecutions); 
 
} 
 
} 
public static void randomTest(int numberOfVertices, int numberOfEdges, int numberOfExecutions) 
 
{ 
 
Stopwatch watch = new Stopwatch(); 
 
UndirectedGraphAdjList graph; 
 
TimeAnalysis taToCreateGraph = new TimeAnalysis("create",numberOfExecutions); 
 
TimeAnalysis taForShortestPathDFS = new TimeAnalysis("dfs",numberOfExecutions); 
 
TimeAnalysis taForShortestPathBFS = new TimeAnalysis("bfs",numberOfExecutions); 
 
for(int trial=0; trial<numberOfExecutions; trial++) { 
 
watch.startWatch(); 
 
graph = UndirectedGraphAdjList.createRandomGraph(numberOfVertices, numberOfEdges); 
 
long timeToCreateGraph = watch.elapsedTime(); 
 
taToCreateGraph.add(timeToCreateGraph); 
 
 
watch.startWatch(); 
 
for(int si=0; si<graph.getNumberOfVertices(); si++) { 
 
@SuppressWarnings("unused") 
 
ShortestPath spDFS = new ShortestPathDFS(graph,si); 
 
} 
 
long timeForShortestPathDFS = watch.elapsedTime(); 
 
taForShortestPathDFS.add(timeForShortestPathDFS); 
 
 
watch.startWatch(); 
 
for(int si=0; si<graph.getNumberOfVertices(); si++) { 
 
@SuppressWarnings("unused") 
 
ShortestPath spBFS = new ShortestPathBFS(graph,si); 
 
} 
 
long timeForShortestPathBFS = watch.elapsedTime(); 
 
taForShortestPathBFS.add(timeForShortestPathBFS); 
 
System.out.printf("%3d %5d %5.0f %5.0f %5.0f \n",graph.getNumberOfVertices(),graph.getNumberOfEdges(), taToCreateGraph.getMeanTime(), 
 
taForShortestPathDFS.getMeanTime(),taForShortestPathBFS.getMeanTime()); 
 
} 

 
 
} 
 
public static void main(String[] args) { 
 
System.out.println("D13-PA DFS/BFS Analysis for Undirected Graphs - Programming Assignment - Task 2 - by MayuriJadhav"); 
 
Date date = new Date(); 
 
System.out.println("Executed on: "+date.toString()); 
 
randomAnalysis(50,500,50,10,31); 
 
 
} 
}
