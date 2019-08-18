package linkedListDS;

public class LinkedListImpl {

	 Node head = null;
	
	static class Node {

		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	/* Driver program to test above functions*/
	public static void main(String[] args) 
	{ 
	  /* Start with the empty list */
		LinkedListImpl link = new LinkedListImpl();
		
	  // Insert 6.  So linked list becomes 6->NULL 
		link.append(6); 
	  
	  // Insert 7 at the beginning. So linked list becomes 7->6->NULL 
		link.push(7); 
	  
	  // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL 
		link.push(1); 
	  
	  // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
		link.append(4); 
	  
	  // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
		link.insertAfter(link.head.next, 8); 
	  
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head); 
		
		link.delete(7);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
	  
		link.delete(1);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
		link.delete(4);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
		link.append(11); 
		
		link.append(12);
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		System.out.println("====");
		link.deleteAtPosition(2);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
		link.deleteAtPosition(3);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
		link.deleteAtPosition(0);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
link.deleteAtPosition(1);
		
		System.out.println(" Created Linked list is: "); 
		link.printList(link.head);
		
	}

	private  void printList(Node head) {
		Node tmp = head;
		while (tmp != null) 
		  { 
		     System.out.println(" "+tmp.data); 
		     tmp = tmp.next; 
		  } 
		
	}

	private  void insertAfter(Node next, int i) {
		if(next == null)
			return;
		else {
			Node node = new Node(i);
			node.next = next.next;
			next.next= node;
		}
		
	}

	private  void push(int i) {
		Node node = new Node(i);
		node.next= head;
		head = node;
	}

	private  void append( int i) {
		Node node = new Node(i);
		if(head == null)
			head = node;
		else {
			Node tmp = head;
			while(tmp.next !=null)
				tmp = tmp.next;
			tmp.next= node;
		}
		
	} 
	
	private  void delete( int i) {
		if(head == null)
			return;
		else {
			if(head.data == i) {
				head = head.next;
				return;
			}
			Node tmp = head;
			while(tmp.next !=null) {
				if(tmp.next.data == i) {
					tmp.next = tmp.next.next;
					return;
				}
				tmp = tmp.next;
			}
		}
		
	} 
	
	private  void deleteAtPosition(int position) {
		if(head == null)
			return;
		else {
			Node prev = null;
			Node tmp = head;
			if(position == 0) {
				head = tmp.next;
				return;
			}
			
			while(tmp != null && position-- >0) {
				prev = tmp;
				tmp = tmp.next;
			}
			if(tmp == null) return;
			prev.next = tmp.next;
			
			
		}
		
	}
}
