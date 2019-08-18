package graphDs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	
	public static void main(String[] args) {
		System.out.println("start");
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(0, 1);
		
		sort(graph);
		System.out.println(" ");
		reverseSort(graph);
	}
	
	static void reverseSort(Graph graph) {
		
		boolean[] visited = new boolean[graph.V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<graph.V; i++) {
			visited[i] = false;
		}
		
		for(int i=0; i<graph.V; i++) {
			if(!visited[i]) {
				reverseSortUtil(i, graph, visited, stack);
			}
		}
		
		for(Integer st : stack) {
			System.out.print(st+" ");
		}
		
		System.out.println("");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	
	static void reverseSortUtil(int i, Graph graph, boolean[] visited, Stack<Integer> stack) {
		
		visited[i] = true;
		
		LinkedList<Integer> edges = graph.adj[i];
		
		for(Integer edge : edges) {
			if(!visited[edge]) {
				reverseSortUtil(edge, graph, visited, stack);
			}
		}
		
		stack.push(i);
		
		
	}
	
	static void sort(Graph graph) {
		
		boolean[] visited = new boolean[graph.V];
		for(int i=0; i<graph.V; i++) {
			visited[i] = false;
		}
		
		for(int i=0; i<graph.V; i++) {
			if(!visited[i]) {
				sortUtil(i, graph, visited);
			}
		}
	}
	
	static void sortUtil(int i, Graph graph, boolean[] visited) {
		
		visited[i] = true;
		
		LinkedList<Integer> edges = graph.adj[i];
		
		for(Integer edge : edges) {
			if(!visited[edge]) {
				sortUtil(edge, graph, visited);
			}
		}
		
		System.out.println(i +" ");
		
		
	}
}


class Graph{
	
	int V;
	LinkedList<Integer> adj[];
	
	Graph(int V){
		this.V = V;
		adj = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	
	
}