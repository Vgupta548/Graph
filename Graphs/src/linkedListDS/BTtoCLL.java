package linkedListDS;


public class BTtoCLL {

	class Tree 
	{ 
	    DoubleNode root; 
	    public Tree() 
	    { 
	        root = null; 
	    } 
	  
 // Method converts a tree to a circular 
    // Link List and then returns the head 
    // of the Link List 
    public void toDubleLinkedList(DoubleNode root) 
    { 
        inOrder(root);
    } 
    
     DoubleNode prev = null;
    
    public void inOrder(DoubleNode node) {
    	if(node == null) return ;
    	
    	inOrder(node.prev);
    	
    	if(prev ==null) {
    		root = node;
    	}else {
    		node.prev = prev;
    		prev.next = node;
    	}
    	
    	prev = node;
    	
    	 inOrder(node.next);
    	 
    }
    
	}
    
	/*
	 * public static void main(String args[]) { // Build the tree Tree tree = new
	 * Tree(); tree.root = new DoubleNode(10); tree.root.left = new DoubleNode(12);
	 * tree.root.right = new DoubleNode(15); tree.root.left.left = new
	 * DoubleNode(25); tree.root.left.right = new DoubleNode(30);
	 * tree.root.right.left = new DoubleNode(36);
	 * 
	 * // head refers to the head of the Link List
	 * tree.toDubleLinkedList(tree.root); // DoubleNode head =
	 * tree.bTreeToCList(tree.root);
	 * 
	 * // Display the Circular LinkedList }
	 */ 
}
