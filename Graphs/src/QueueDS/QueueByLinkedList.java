package QueueDS;

public class QueueByLinkedList {
	
	QNode front, rear;
	
	class QNode 
	{ 
	    int key; 
	    QNode next; 
	      
	    // constructor to create a new linked list node 
	    public QNode(int key) { 
	        this.key = key; 
	        this.next = null; 
	    } 
	}
	
	public QueueByLinkedList() { 
        this.front = this.rear = null; 
    }

	public static void main(String[] args)  
    { 
		QueueByLinkedList q=new QueueByLinkedList(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
          
        System.out.println("Dequeued item is "+ q.dequeue().key); 
    } 
	
	QNode dequeue() 
    { 
		if(this.front == null) {
			return null;
		}
		QNode q= this.front;
		this.front = q.next;
		return q;
		
    }
	
	void enqueue(int key) 
    { 
		QNode q = new QNode(key);
		if(this.rear == null) {
			this.front=this.rear=q;
			return;
		}
		this.rear.next = q;
		this.rear = q;
    }
}
