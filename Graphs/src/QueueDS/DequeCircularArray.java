package QueueDS;

public class DequeCircularArray {

	// Driver program to test above function 
    public static void main(String[] args) 
    { 
          
    	DequeCircularArray dq = new DequeCircularArray(5); 
           
         System.out.println("Insert element at rear end  : 5 "); 
         dq.insertrear(5); 
           
         System.out.println("insert element at rear end : 10 "); 
         dq.insertrear(10); 
           
         System.out.println("get rear element : "+ dq.getRear()); 
           
         dq.deleterear(); 
         System.out.println("After delete rear element new rear become : " +  
                                dq.getRear()); 
           
         System.out.println("inserting element at front end"); 
         dq.insertfront(15); 
           
         System.out.println("get front element: " +dq.getFront()); 
           
         dq.deletefront(); 
           
         System.out.println("After delete front element new front become : " + dq.getFront()); 
          
    }
    
    static int MAX;
    int size;
    int arr[];
    int front;
    int rear;
    
    DequeCircularArray(int capacity) {
		this.MAX =capacity;
		this.size = 0;
		arr = new int[MAX];
		front = -1;
		rear = -1;
	}

	private void deletefront() {
		if(size == 0) return;
		front = (front +1)%MAX;
		size--;
	}

	private void insertfront(int i) {
		if(size == MAX) return ;
		if(size == 0) {
			front =rear = 0;
			arr[front] = i;
		}else {
			front = (front-1+MAX)%MAX;
			arr[front] = i;
		}
		size++;
	}

	private int getFront() {
		if(size == 0) return Integer.MIN_VALUE;
		return arr[front];
	}

	private int getRear() {
		if(size == MAX) return Integer.MIN_VALUE;
		return arr[rear];
	}

	private void deleterear() {
		if(size == 0) return;
		rear = (rear -1)%MAX;
		size--;
		if(size == 0) front =rear = -1;
		
	}

	private void insertrear(int i) {
		if(size == MAX) return ;
		if(size == 0) {
			front = 0 ;
			rear = 0;
		}else {
			 rear = (rear+1)%MAX;
		}
		arr[rear] = i;
		size++;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	private boolean idFull() {
		return size == MAX;
	}
    
    
}
