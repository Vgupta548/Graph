package graphDs;

public class UnDirectedGraph {
	
	int V, E; 
	Edge[] edge; 
	  
	UnDirectedGraph(int nV, int nE) 
	{ 
	    V = nV; 
	    E = nE; 
	    edge = new Edge[E]; 
	    for (int i = 0; i < E; i++)  
	    { 
	        edge[i] = new Edge(); 
	    } 
	} 
	  
	// class to represent edge  
	class Edge 
	{ 
	    int src, dest; 
	} 
	  
	// class to represent Subset 
	class subset 
	{ 
	    int parent; 
	    int rank; 
	} 
	  
	// A utility function to find  
	// set of an element i (uses  
	// path compression technique) 
	int find(subset [] subsets , int i) 
	{ 
	if (subsets[i].parent != i) 
	    subsets[i].parent = find(subsets,  
	                             subsets[i].parent); 
	    return subsets[i].parent; 
	} 
	  
	// A function that does union 
	// of two sets of x and y 
	// (uses union by rank) 
	void Union(subset [] subsets,  
	           int x , int y ) 
	{ 
	    int xroot = find(subsets, x); 
	    int yroot = find(subsets, y);
	    	 System.out.println("parent         : "+xroot + "---"+yroot);
	         System.out.println("rank           : "+subsets[xroot].rank + "---"+subsets[yroot].rank);
	    
	    if (subsets[xroot].rank < subsets[yroot].rank) 
	        subsets[xroot].parent = yroot; 
	    else if (subsets[yroot].rank < subsets[xroot].rank) 
	        subsets[yroot].parent = xroot; 
	    else
	    { 
	        subsets[xroot].parent = yroot; 
	        subsets[yroot].rank++; 
	    } 
	        System.out.println("parent           : "+subsets[xroot].parent + "---"+subsets[yroot].parent);
	        System.out.println("rank           : "+subsets[xroot].rank + "---"+subsets[yroot].rank);
	} 
	          
	// The main function to check whether  
	// a given graph contains cycle or not 
	int isCycle(UnDirectedGraph graph) 
	{ 
	    int V = graph.V; 
	    int E = graph.E; 
	  
	    subset [] subsets = new subset[V]; 
	    for (int v = 0; v < V; v++) 
	    { 
	  
	        subsets[v] = new subset(); 
	        subsets[v].parent = v; 
	        subsets[v].rank = 0; 
	    } 
	  
	    for (int e = 0; e < E; e++) 
	    { 
	    	System.out.println("=========");
	    	System.out.println("For            : "+graph.edge[e].src + "---"+graph.edge[e].dest);
	        int x = find(subsets, graph.edge[e].src); 
	        int y = find(subsets, graph.edge[e].dest); 
	        System.out.println("current parent : "+x + "---"+y);
	        if(x == y) 
	            return 1; 
	        Union(subsets, x, y); 
	    } 
	return 0; 
	} 
	
	// Driver Code 
	public static void main(String [] args) 
	{ 
	/* Let us create the following graph 
	    0 
	    | \ 
	    | \ 
	    1-----2 */
	  
	int V = 3, E = 3; 
	UnDirectedGraph graph = new UnDirectedGraph(V, E); 
	  
	// add edge 0-1 
	graph.edge[0].src = 0; 
	graph.edge[0].dest = 1; 
	  
	// add edge 1-2 
	graph.edge[1].src = 1; 
	graph.edge[1].dest = 2; 
	  
	// add edge 0-2 
	graph.edge[2].src = 0; 
	graph.edge[2].dest = 2; 
	  
	if (graph.isCycle(graph) == 1) 
	    System.out.println("Graph contains cycle"); 
	else
	    System.out.println("Graph doesn't contain cycle"); 
	
	
	System.out.println("-------------------\n");
	
	/*
	         0           5
	     	/ \         /
	       /   \       / 
	      1     2     6
               / \   /
              /   \ /
             3	   4
             \     /   
	          \   /
	            7
	 */
	
      V = 8; E = 8; 
	 graph = new UnDirectedGraph(V, E); 
	  
	// add edge 0-1 
	graph.edge[0].src = 0; 
	graph.edge[0].dest = 1; 
	  
	// add edge 0-2 
	graph.edge[1].src = 0; 
	graph.edge[1].dest = 2; 
	  
	// add edge 2-3 
	graph.edge[2].src = 2; 
	graph.edge[2].dest = 3; 
	
	// add edge 2-4 
	graph.edge[3].src = 2; 
	graph.edge[3].dest = 4; 
		
	// add edge 5-6 
	graph.edge[4].src = 5; 
	graph.edge[4].dest = 6; 
		
	// add edge 6-4 
	graph.edge[5].src = 4; 
	graph.edge[5].dest = 4; 
		
	// add edge 7-4 
	graph.edge[6].src = 7; 
	graph.edge[6].dest = 4; 
	  
	// add edge 7-3 
	graph.edge[7].src = 7; 
	graph.edge[7].dest = 3;
				
	if (graph.isCycle(graph) == 1) 
	    System.out.println("Graph contains cycle"); 
	else
	    System.out.println("Graph doesn't contain cycle"); 
	} 
	

}


