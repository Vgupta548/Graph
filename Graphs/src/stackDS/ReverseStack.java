package stackDS;

import java.util.Stack;

public class ReverseStack {

	static Stack<Character> st = new Stack<>(); 
	// Driver Code 
    public static void main(String[] args)  
    { 
          
        // push elements into 
        // the stack 
        st.push('1'); 
        st.push('2'); 
        st.push('3'); 
        st.push('4'); 
          
        System.out.println("Original Stack"); 
          
        System.out.println(st); 
          
        // function to reverse  
        // the stack 
        reverse(); 
          
        System.out.println("Reversed Stack"); 
          
        System.out.println(st); 
    }
    
	private static void reverse() {

		if(!st.isEmpty()) {
			char x = st.pop();
			reverse();
			
			inserAtBottom(x);
			
		}
	} 
	
	private static void inserAtBottom(char x) {
		if(st.isEmpty()) {
			st.push(x);
		}else {
			char y = st.pop();
			inserAtBottom(x);
			st.push(y);
		}
	}
}
