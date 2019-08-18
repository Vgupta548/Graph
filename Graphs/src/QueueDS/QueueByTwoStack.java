package QueueDS;

import java.util.Stack;

public class QueueByTwoStack {

	// Driver code  
	public static void main(String[] args)  
	{  
		QueueByTwoStack q = new QueueByTwoStack();  
	    q.enQueue(1);  
	    q.enQueue(2);  
	    q.enQueue(3);  
	  
	    System.out.println(q.deQueue());  
	    System.out.println(q.deQueue()); 
	    System.out.println(q.deQueue()); 
	    
	    q.enQueue1(1);  
	    q.enQueue1(2);  
	    q.enQueue1(3);  
	  
	    System.out.println(q.deQueue1());  
	    System.out.println(q.deQueue1()); 
	    System.out.println(q.deQueue1()); 
	}
	
	Stack<Integer> reverserStack = new Stack<>();
	Stack<Integer> helperStack = new Stack<>();

	private int deQueue() {
		if(reverserStack.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return reverserStack.pop();
	}

	private void enQueue(int i) {
		
		while(!reverserStack.isEmpty()) {
			helperStack.push(reverserStack.pop());
		}
		
		reverserStack.push(i);
		
		while(!helperStack.isEmpty()) {
			reverserStack.push(helperStack.pop());
		}
		
	} 
	
    
	Stack<Integer> originalStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();
	
	private void enQueue1(int i) {
		originalStack.push(i);
	}
	
	private int deQueue1() {
		if(originalStack.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		while(!originalStack.isEmpty()) {
			popStack.push(originalStack.pop());
		}
		
		int x =popStack.pop();
		
		while(!popStack.isEmpty()) {
			originalStack.push(popStack.pop());
		}
		
		return x;
	}
	
}
