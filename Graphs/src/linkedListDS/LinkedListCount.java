package linkedListDS;

public class LinkedListCount {

	static DoubleNode head;  // head of list 
	
	public static void main(String[] args) {
		LinkedListCount list = new LinkedListCount();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(125);
		
		System.out.println(list.getCount());
	}
	
    /* Inserts a new Node at front of the list. */
    public void add(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        DoubleNode new_node = new DoubleNode(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
	
	 static int getCount() {
		
		return  getCountRec(head);
		 
	}
	 
	 static int getCountRec(DoubleNode node) {
			
		if(node == null) return 0;
		
		return 1+getCountRec(node.next);
		 
		 
	}
}
