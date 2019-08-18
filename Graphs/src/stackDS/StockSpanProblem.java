package stackDS;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

	// Driver method 
    public static void main(String[] args) 
    { 
        int price[] = { 10, 4, 5, 90, 120, 80 }; 
        int n = price.length; 
        int S[] = new int[n]; 
  
        // Fill the span values in array S[] 
        calculateSpan(price, n, S); 
  
        // print the calculated span values 
        printArray(S); 
        
        calculateSpanWithoutStack(price, n, S);
        
        printArray(S); 
    } 
    
 // A utility function to print elements of array 
    static void printArray(int arr[]) 
    { 
        System.out.print(Arrays.toString(arr)); 
    }
    
    // stock span values by stack
    static void calculateSpan(int price[], int n, int S[]) {
    	Stack<Integer> stack = new Stack<Integer>();
    	S[0]= 1;
    	stack.push(0);
    	
    	for(int i=1; i<n; i++) {
    		
    		while(!stack.isEmpty() && price[i] >= price[stack.peek()] ) {
    			stack.pop();
    		}
    		
    		S[i] = stack.isEmpty() ? i+1 : i-stack.peek();
    		
    		stack.push(i);
    	}
    }
    
 // stock span values by stack
    static void calculateSpanWithoutStack(int price[], int n, int S[]) {
    	S[0] = 1;
    	
    	for(int i=1; i<n; i++) {
    		int counter =1;
    		while((i-counter)>= 0 && price[i] >= price[i-counter]) {
    			counter += S[i-counter];
    		}
    		S[i] = counter; 
    	}
    	
    }
}
