package graph.digraph;

import java.io.File;
import java.util.Date;

public class DigraphAdjListTest {

	public static void main(String[] args) {
		
		System.out.println("D21-PA Directed Graphs Representation - Programming Assignment - Task 2 - by Mayuri Jadhav"); 
		Date date = new Date(); 
		System.out.println("Executed on: "+date.toString()); 
		
		File tiny1File= new File("/Users/mayurijadhav/Desktop/graph/data/tinyDAG.txt");
		Digraph tiny1Graph = DigraphAdjList.readNumberedGraph(tiny1File);
		System.out.println("TINY GRAPH 1");
		System.out.println(tiny1Graph.toString());
		
		File tiny2File= new File("/Users/mayurijadhav/Desktop/graph/data/tinyDG.txt");
		Digraph tiny2Graph = DigraphAdjList.readNumberedGraph(tiny2File);
		System.out.println("TINY GRAPH 2");
		System.out.println(tiny2Graph.toString());

		File mediumFile= new File("/Users/mayurijadhav/Desktop/graph/data/mediumDG.txt");
		Digraph mediumGraph = DigraphAdjList.readNumberedGraph(mediumFile);
		System.out.println("MEDIUM GRAPH");
		System.out.println(mediumGraph.toString());

	}

}
