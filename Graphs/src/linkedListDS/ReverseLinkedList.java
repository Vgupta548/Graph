package linkedListDS;

public class ReverseLinkedList {

	static DoubleNode head;
	
	public static void main(String[] args) { 
		ReverseLinkedList list = new ReverseLinkedList(); 
        list.head = new DoubleNode(85); 
        list.head.next = new DoubleNode(15); 
        list.head.next.next = new DoubleNode(4); 
        list.head.next.next.next = new DoubleNode(20); 
          
        System.out.println("Given Linked list"); 
        list.printList(head); 
        head = list.reverse(head); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        list.printList(head); 
        
        head = list.reverseRec(head, null); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        list.printList(head); 
    } 
	
	// prints content of double linked list 
    void printList(DoubleNode node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
    
    /* Function to reverse the linked list */
    DoubleNode reverse(DoubleNode node) { 
    	DoubleNode prev = null;
    	DoubleNode curr = node;
    	DoubleNode next = null;
    	
    	while(curr !=null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	node =prev;
    	return node;
    	
    }
    
    DoubleNode reverseRec(DoubleNode curr, DoubleNode prev) { 
    	
    	if(curr == null) {
    		head = prev;
    		return head;
    	}
    	DoubleNode next = curr.next;
    	curr.next = prev;
    	
    	return reverseRec(next, curr);
    	
    	
    }
}
