package linkedListSortingDS;

/*
 * It takes O(n^2) time in worst case and O(nLogn) in average and best cases. 
 */

public class QuickSort_using_Doubly_LinkedList {

	Node head;
	
	static class Node{ 
        private int data; 
        private Node next; 
        private Node prev; 
          
        Node(int d){ 
            data = d; 
            next = null; 
            prev = null; 
        } 
    } 
	/* Driver program to test above function */
    public static void main(String[] args){ 
            QuickSort_using_Doubly_LinkedList list = new QuickSort_using_Doubly_LinkedList(); 
              
              
            list.push(5); 
            list.push(20); 
            list.push(4); 
            list.push(3); 
            list.push(30); 
            
              
            System.out.println("Linked List before sorting "); 
            list.printList(list.head); 
            System.out.println("\nLinked List after sorting"); 
            list.quickSort(list.head); 
            list.printList(list.head); 
          
    } 
    
    public void quickSort(Node node) {
    	if(node != null) {
    		Node lastNode = findLastNode(node);
    		linkListQuickSortUtil(node, lastNode);
    	}
    	
    }
    
    public void linkListQuickSortUtil(Node first, Node last) {
    	if(first != last && last !=null && first != last.next) {
    		Node pNode  = partition(first, last);
    		
    		linkListQuickSortUtil(first, pNode.prev);
    		linkListQuickSortUtil(pNode.next, last);
    	}
    	
    }
    
    public Node partition(Node first, Node last) {
    	
    	Node prev = first.prev;
    	for(Node i= first; i!=last; i = i.next) {
    		if(i.data <= last.data) {
    			prev = (prev == null)? first : prev.next;
    			int temp = prev.data;
    			prev.data = i.data;
    			i.data = temp;
    			
    		}
    	}
    	prev = (prev == null)? first : prev.next;
    	int temp = prev.data;
		prev.data = last.data;
		last.data = temp;
		
		return prev;
    	
    }
    
    public Node findLastNode(Node node) {
    	if(node == null) return null;
    	while(node.next !=null) {
    		node = node.next;
    	}
    	
    	return node;
    }
    
 // A utility function to print contents of arr 
    public void printList(Node head) 
    { 
       while(head!=null){ 
           System.out.print(head.data+" "); 
           head = head.next; 
       }
       System.out.println();
   } 
    
    /* Function to insert a node at the beginging of the Doubly Linked List */
    void push(int new_Data) 
    { 
        Node new_Node = new Node(new_Data);     /* allocate node */
          
        // if head is null, head = new_Node 
        if(head==null){ 
            head = new_Node; 
            return; 
        } 
          
        /* link the old list off the new node */
        new_Node.next = head; 
          
        /* change prev of head node to new node */
        head.prev = new_Node; 
          
        /* since we are adding at the begining, prev is always NULL */
        new_Node.prev = null; 
          
        /* move the head to point to the new node */
        head = new_Node; 
    } 

}
