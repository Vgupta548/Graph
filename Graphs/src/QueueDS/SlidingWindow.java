package QueueDS;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

	// Driver program to test above functions 
    public static void main(String[] args)  
    { 
        int arr[]={12, 1, 78, 90, 57, 89, 56}; 
        int k=3; 
        printMax(arr, arr.length,k); 
    }

	private static void printMax(int[] arr, int length, int k) {
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i=0 ;i<k; i++) {
			
			while(!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.println("size:" +deque.size());
		
		for(int i=k; i<length; i++) {
			System.out.println(arr[deque.peekFirst()]);
			
			while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
				deque.removeFirst();
			}
			System.out.println("size:" +deque.size());
			while(!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
			System.out.println("size:" +deque.size());
		}
		System.out.println(arr[deque.peekFirst()]);
	} 
	
}
