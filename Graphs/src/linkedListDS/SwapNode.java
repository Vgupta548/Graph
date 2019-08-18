package linkedListDS;

public class SwapNode {

	static DoubleNode head;
	public static void main(String[] args) {
		SwapNode llist = new SwapNode(); 
		  
        /* The constructed linked list is: 
            1->2->3->4->5->6->7 */
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
  
        System.out.print("\n Linked list before calling swapNodes() "); 
        llist.printList(); 
        
        swapNodes(head, 1, 3);
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
  
        llist.swapNodes(2, 4); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        
        llist.swapNodes(1, 3); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        
        llist.swapNodes(2, 7); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        
        
  
        llist.swapNode(2, 4); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        
        llist.swapNode(1, 3); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        
        llist.swapNode(2, 7); 
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
	}
	
	public void push(int new_data) 
    { 
        /* 1. alloc the Node and put the data */
        DoubleNode new_Node = new DoubleNode(new_data); 
  
        /* 2. Make next of new Node as head */
        new_Node.next = head; 
  
        /* 3. Move the head to point to new Node */
        head = new_Node; 
    } 
  
    /* This function prints contents of linked list starting 
       from the given Node */
    public void printList() 
    { 
        DoubleNode tNode = head; 
        while (tNode != null) 
        { 
            System.out.print(tNode.data+" "); 
            tNode = tNode.next; 
        } 
        
    } 
    
    static DoubleNode swapNodes(DoubleNode node, int x, int y)  
    {  
        DoubleNode head_ref=node; 
        // Nothing to do if x and y are same  
        if (x == y)  
            return null;  
      
        DoubleNode a = null, b = null;  
      
        // search for x and y in the linked list  
        // and store therir pointer in a and b  
        while (head_ref.next!=null) {  
      
            if ((head_ref.next).data == x) {  
                a = head_ref;  
            }  
      
            else if ((head_ref.next).data == y) {  
                b = head_ref;  
            }  
      
            head_ref = ((head_ref).next);  
        }  
      
        // if we have found both a and b  
        // in the linked list swap current  
        // pointer and next pointer of these  
        if (a!=null&&  b!=null) {  
        DoubleNode temp = a.next;  
        a.next = b.next;  
        b.next = temp;      
        temp = a.next.next;  
        a.next.next = b.next.next;  
        b.next.next = temp;  
        }  
        return head; 
    }
	
	 void swapNodes(int i, int j) {
		
		 if(i==j) return;
		if(head == null || head.next == null) {
			return;
		}
		DoubleNode preN1 = null;
		DoubleNode N1= null;
		DoubleNode postN1 = null;
		DoubleNode preN2 = null;
		DoubleNode N2= null;
		DoubleNode postN2 = null;
		
		boolean isFirstFound = false;
		boolean isAllFound = false;
		
		System.out.println();
		
		
		DoubleNode tmp = head;
		if(tmp.data == i || tmp.data == j) {
			N1 = tmp;
			isFirstFound = true;
			j = tmp.data == i ? j : i;
			postN1 = tmp.next;
			System.out.println("first found:"+tmp.data);
		}else {
			preN1 = tmp;
		}
		preN2 = tmp;
		tmp = tmp.next;
		
		while(tmp != null) {
			if(isAllFound) {
				break;
			}
			if(!isFirstFound) {
				if(tmp.data == i || tmp.data == j) {
					N1 = tmp;
					j = tmp.data == i ? j : i;
					postN1 = tmp.next;
					isFirstFound = true;
					System.out.println("first found:"+tmp.data);
				}else {
					preN1 = tmp;
				}
				preN2 = tmp;
			}else {
				if(tmp.data == j) {
					N2 = tmp;
					postN2 = tmp.next;
					isAllFound = true;
					System.out.println("second found :"+tmp.data);
					
				}else {
					preN2 = tmp;
				}
			}
			
			tmp =tmp.next;
		}
		
		//System.out.println("preN1:"+preN1.data);
		System.out.println("N1:"+N1.data);
		System.out.println("postN1:"+postN1.data);
		System.out.println("preN2:"+preN2.data);
		System.out.println("N2:"+N2.data);
		//System.out.println("postN2:"+postN2.data);
		
		
		if(N1 !=null && N2 !=null) {
			if (preN1 != null) 
				preN1.next = N2; 
	        else //make y the new head 
	            head = N2; 
	  
	        // If y is not head of linked list 
	        if (preN2 != null) 
	        	preN2.next = N1; 
	        else // make x the new head 
	            head = N1; 
	  
	        // Swap next pointers 
	        DoubleNode temp = N1.next; 
	        N1.next = N2.next; 
	        N2.next = temp; 
		}
	}
	 
	 /* Function to swap Nodes x and y in linked list by 
     changing links */
  public void swapNode(int x, int y) 
  { 
      // Nothing to do if x and y are same 
      if (x == y) return; 

      // Search for x (keep track of prevX and CurrX) 
      DoubleNode prevX = null, currX = head; 
      while (currX != null && currX.data != x) 
      { 
          prevX = currX; 
          currX = currX.next; 
      } 

      // Search for y (keep track of prevY and currY) 
      DoubleNode prevY = null, currY = head; 
      while (currY != null && currY.data != y) 
      { 
          prevY = currY; 
          currY = currY.next; 
      } 

      // If either x or y is not present, nothing to do 
      if (currX == null || currY == null) 
          return; 

      // If x is not head of linked list 
      if (prevX != null) 
          prevX.next = currY; 
      else //make y the new head 
          head = currY; 

      // If y is not head of linked list 
      if (prevY != null) 
          prevY.next = currX; 
      else // make x the new head 
          head = currX; 

      // Swap next pointers 
      DoubleNode temp = currX.next; 
      currX.next = currY.next; 
      currY.next = temp; 
  } 
}
