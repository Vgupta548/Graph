package QueueDS;

public class QueueByArray {
	int front, rear, size; 
    int  capacity; 
    int array[]; 
       
    public QueueByArray(int capacity) { 
         this.capacity = capacity; 
         front = this.size = 0;  
         rear = capacity - 1; 
         array = new int[this.capacity]; 
         System.out.println("rear :"+rear); 
         System.out.println("front :"+front); 
            
    } 
       
    // Queue is full when size becomes equal to  
    // the capacity  
    boolean isFull(QueueByArray queue) 
    {  return (queue.size == queue.capacity); 
    } 
       
    // Queue is empty when size is 0 
    boolean isEmpty(QueueByArray queue) 
    {  return (queue.size == 0); } 
       
    // Method to add an item to the queue.  
    // It changes rear and size 
    void enqueue( int item) 
    { 
      if(isFull(this)) {
    	  return;
      }
      this.rear = (rear + 1)%capacity ;
      array[rear] = item;
      this.size++;
      System.out.println(item +" enqueued to queue : rear : "+rear);
    } 
       
    // Method to remove an item from queue.   
    // It changes front and size 
    int dequeue() 
    { 
        if(isEmpty(this)) {
        	return Integer.MIN_VALUE;
        }
        int x= array[front];
        this.front = (front + 1)% capacity;
        this.size--;
        System.out.println(": front : "+front);
        return x;
    } 
       
    // Method to get front of queue 
    int front() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
           
        return this.array[this.front]; 
    } 
        
    // Method to get rear of queue 
    int rear() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
           
        return this.array[this.rear]; 
    } 


	public static void main(String[] args)  
    { 
        QueueByArray queue = new QueueByArray(1000); 
            
        queue.enqueue(10); 
        queue.enqueue(20); 
        queue.enqueue(30); 
        queue.enqueue(40); 
        
        System.out.println(queue.dequeue() +  
                     " dequeued from queue\n"); 
        
        System.out.println("Front item is " +  
                               queue.front()); 
           
        System.out.println("Rear item is " +  
                                queue.rear()); 
        System.out.println(queue.dequeue() +  
                " dequeued from queue\n"); 
        System.out.println(queue.dequeue() +  
                " dequeued from queue\n"); 
    } 
}
