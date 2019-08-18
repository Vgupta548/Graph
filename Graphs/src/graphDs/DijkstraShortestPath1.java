package graphDs;

class DijkstraShortestPath1 
{ 
	// A utility function to find the vertex with minimum distance value, 
	// from the set of vertices not yet included in shortest path tree 
	static final int V=9; 
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index=-1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) 
			{ 
				min = dist[v]; 
				min_index = v; 
				//System.out.println("minDistance : index "+v+ " :min "+min);
			} 

		return min_index; 
	} 

	// A utility function to print the constructed distance array 
	void printSolution(int dist[], int n) 
	{ 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i+" tt "+dist[i]); 
	} 

	void printPathLenth(int dist[], int pathLenth[], int parent[], int src) 
	{ 
		for (int i = 0; i < V; i++) {
			System.out.print(i+" path lenth "+parent[i]); 
			System.out.print(" PATH : "); 
			printPath(parent, src, i);
			System.out.println(""); 
		}		
		
	} 
	
	void printPath(int parent[], int src, int index) 
	{ 
		
		if(src == index) {
			System.out.print(" > "+index); 
			return;
		}
		printPath(parent, src, parent[index]);
		System.out.print(" > "+index); 
		
		
	} 
	
	// Funtion that implements Dijkstra's single source shortest path 
	// algorithm for a graph represented using adjacency matrix 
	// representation 
	void dijkstra(int graph[][], int src) 
	{ 
		int dist[] = new int[V]; // The output array. dist[i] will hold 
								// the shortest distance from src to i 

		// sptSet[i] will true if vertex i is included in shortest 
		// path tree or shortest distance from src to i is finalized 
		Boolean sptSet[] = new Boolean[V]; 
		
		// pathLenth[i] will hold 
		// the shortest path lenth from src to i  
		int pathLenth[] = new int[V];
		
		// parent[i] will hold 
		// the parent vertex from i for shortest path Length
		int parent[] = new int[V];
		

		// Initialize all distances as INFINITE and stpSet[] as false 
		for (int i = 0; i < V; i++) 
		{ 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
			pathLenth[i] = 0;
			parent[i] = -1;
		} 

		// Distance of source vertex from itself is always 0 
		dist[src] = 0; 
		parent[src] = src;

		// Find shortest path for all vertices 
		for (int count = 0; count < V-1; count++) 
		{ 
			// Pick the minimum distance vertex from the set of vertices 
			// not yet processed. u is always equal to src in first 
			// iteration. 
			int u = minDistance(dist, sptSet); 
			// Mark the picked vertex as processed 
			sptSet[u] = true; 
			// Update dist value of the adjacent vertices of the 
			// picked vertex. 
			for (int v = 0; v < V; v++) 

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!sptSet[v] && graph[u][v]!=0 && 
						dist[u] != Integer.MAX_VALUE ) {
					
					if (dist[u]+graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v]; 
						parent[v] = u;
						pathLenth[v]= pathLenth[u]+1; 
					}else if(dist[u]+graph[u][v] == dist[v]) {
						
						if(pathLenth[v] > pathLenth[u]+1) {
							parent[v]= u;
							pathLenth[v]= pathLenth[u]+1; 
						}
						
					}
				}
		} 

		// print the constructed distance array 
		printPathLenth(dist, pathLenth, parent, src);
	} 

	// Driver method 
	public static void main (String[] args) 
	{ 
		/* Let us create the example graph discussed above */
	int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
								{4, 0, 8, 0, 0, 0, 0, 11, 0}, 
								{0, 8, 0, 7, 0, 4, 0, 0, 2}, 
								{0, 0, 7, 0, 9, 14, 0, 0, 0}, 
								{0, 0, 0, 9, 0, 10, 0, 0, 0}, 
								{0, 0, 4, 14, 10, 0, 2, 0, 0}, 
								{0, 0, 0, 0, 0, 2, 0, 1, 6}, 
								{8, 11, 0, 0, 0, 0, 1, 0, 7}, 
								{0, 0, 2, 0, 0, 0, 6, 7, 0} 
								}; 
		DijkstraShortestPath1 t = new DijkstraShortestPath1(); 
		t.dijkstra(graph, 0); 
	} 
} 


