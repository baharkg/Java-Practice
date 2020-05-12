/******************************************************************************

                            Online Java Debugger.
                Code, Run and Debug Java program online.
Write your code in this editor and press "Debug" button to debug program.

*******************************************************************************/
import java.io.*; 
import java.util.*; 

public class Main
{
	public class Graph { 
	    private int V;   // No. of vertices 
	    private LinkedList<Integer> adj[]; // Adjacency List Represntation 
	  
	    // Constructor 
	    Graph(int v) { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for(int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    // Function to add an edge into the graph 
	    void addEdge(int v,int w) { 
	        adj[v].add(w); 
	        adj[w].add(v); 
	    } 
	  
    }
  
  
// This code is contributed by Aakash Hasija 


	public static void main(String[] args) {
		Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
		System.out.println("Hello World");
	}




}


