package QueueDS;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBNo {

	// Driver program to test above function 
    public static void main(String[] args)  
    { 
        int n=5; 
        generatePrintBinary(n); 
    }

	private static void generatePrintBinary(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		//for(int i=1; i<= n; i++) {
		while(n-- > 0) {	
			//Deque first
			int x = q.poll();
			//append 0 and enqueue
			q.add(x*10);
			//append 1 and enqueue
			q.add(x*10 +1);
			
			System.out.println(x);
		}
		
	} 
}
