package stackDS;

public class TwoStack {

	int size ;
	int top1 ;
	int top2 ;
	int[] arr;
	
	public TwoStack(int n) {
		size = n;
		arr = new int[size];
		top1 = -1;
		top2 = size;
		
	}
	
	public void push1(int x) {
		if(top1< top2-1) {
			top1++;
			arr[top1] = x;
		}else {
			System.out.println("Stack Overfloe");
			System.exit(1);
		}
	}
	
	public void push2(int x) {
		if(top2 > top1+1) {
			top2--;
			arr[top2] = x;
		}else {
			System.out.println("Stack Overfloe");
			System.exit(1);
		}
	}
	
	public int pop1() {
		if(top1 <= -1) {
			System.out.println("stack underflow");
			System.exit(1);
		}else {
			return  arr[top1--];
		}
		return Integer.MIN_VALUE;
	}
	
	public int pop2() {
		if(top2 >= size) {
			System.out.println("stack underflow");
			System.exit(1);
		}else {
			return  arr[top2++];
		}
		return Integer.MIN_VALUE;
	}
	
	public boolean isEmpty1() {
		return top1 == -1;
	}
	
	public boolean isEmpty2() {
		return top2 >=size;
	}
	
	/* Driver program to test twStacks class */
	public static void main(String[] args) 
	{ 
		TwoStack ts = new TwoStack(5);
	    ts.push1(5); 
	    ts.push2(10); 
	    ts.push2(15); 
	    ts.push1(11); 
	    ts.push2(7); 
	    System.out.println("Popped element from stack1 is "+ ts.pop1()); 
	    ts.push2(40); 
	    System.out.println( "Popped element from stack2 is " +ts.pop2()); 
	} 
	
}
