package stackDS;

import java.util.Stack;

public class SpecialStack 
	extends Stack<Integer> 
	{ 
	    Stack<Integer> min = new Stack<>(); 
	      
	    /* SpecialStack's member method to insert an element to it. This method 
	    makes sure that the min stack is also updated with appropriate minimum 
	    values */
	    void push(int x) {
	    	super.push(x);
	    	if(min.isEmpty()==true) {
	    		min.push(x);
	    	}else {
	    		if(x < min.peek())
	    			min.push(x);
	    		else min.push(min.peek());
	    	}
	    }
	    
	    public Integer pop() {
	    	min.pop();
	    	return super.pop();
	    }
	  
	    Integer getMin() {
	    	return min.peek();
	    }
	    /* Driver program to test SpecialStack methods */
	    public static void main(String[] args)  
	    { 
	        SpecialStack s = new SpecialStack(); 
	        s.push(10); 
	        s.push(20); 
	        s.push(30); 
	        System.out.println(s.getMin()); 
	        s.push(5); 
	        System.out.println(s.getMin()); 
	        s.pop(); 
	        System.out.println(s.getMin());
	        s.pop(); 
	        System.out.println(s.getMin());
	    } 
	} 