package stackDS;

import java.util.Stack;


public class InfixToPrefix {
	
	public static void main(String[] args) {
		
		String str = "3+2*4+4";
		System.out.println(convert(str));
		
		str = "3+2*(4+4)";
		System.out.println(convert(str));
		
		str = "3+2*((4+4)*2)";
		System.out.println(convert(str));
		
		str = "3+(2*(4+4)";
		System.out.println(convert(str));
		
		
		
		str = "(3+(2)*4+4)";
		System.out.println(convert(str));
	}

	static String convert(String str) {
		String out = "";
		Stack<Character> stack = new Stack<Character>();
		
		char[] arr = str.toCharArray();
		
		for(int i =0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				out +=c;
			}
			
			else if(c == '(') {
				System.out.println("push1 : "+c);
				stack.push(c);
			}
			
			else if(c == ')') {
				
				while(!stack.isEmpty() && stack.peek() != '(') {
					System.out.println("pop1 : "+stack.peek() );
					out += stack.pop();
				}
				
				if(!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				}else {
					System.out.println("pop2 : "+stack.peek() );
					stack.pop();
				}
				
			}
			
			else {
				while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					System.out.println("pop3 : "+stack.peek() );
					if(stack.peek() == '(') return "Invalid Expression";
					out +=stack.pop();
				}
				System.out.println("push2 : "+c);
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println("pop4 : "+stack.peek() );
			if(stack.peek() == '(') return "Invalid Expression";
			out +=stack.pop();
		}
		
		return out;
	}
	
	static int Prec(char c) {
		
		switch(c) {
			case '+' :	
			case '-' :
				return 1;
			case '/' :
			case '*' :
				return 2;
			case '^' :
				return 3;
			default : return -1;	
			
		
		}
	}
}
