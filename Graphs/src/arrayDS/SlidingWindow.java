package arrayDS;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
	
	public static void main(String[] args) {
		
		int arr[] = { 12, 1, 78, 90, 57, 89, 56,4,3,5,2,4,3,8 }; 
        int k = 4; 
        printMax(arr, arr.length, k); 
	}
	
	// A Dequeue (Double ended queue) based method for printing maximum element of 
    // all subarrays of size k 
    static void printMax(int arr[], int n, int k) 
    { 
       Deque<Integer> qi = new LinkedList<Integer>();
       
       int i= 0;
       for(; i<k; i++) {
    	   
    	   while(!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
    		   qi.removeLast();
    	   }
    	   qi.addLast(i);
       }
       
       System.out.println("ii :"+i);
       for(; i<n; i++) {
    	   System.out.println(arr[qi.peekFirst()] + " ");
    	   while(!qi.isEmpty() && i-k >= qi.peekFirst()) {
    		   qi.removeFirst();
    	   }
    	   
    	   while(!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
    		   qi.removeLast();
    	   }
    	   qi.addLast(i);
    	   
    	  
       }
       System.out.println(arr[qi.peekFirst()] + " ");
    } 
}
