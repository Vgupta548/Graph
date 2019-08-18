package stackDS;

import java.util.Stack;

public class ReverseString {

	//driver function 
    public static void main(String args[]) 
    { 
        //create a new string 
        StringBuffer s= new StringBuffer("GeeksQuiz"); 
          
        //call reverse method 
        reverse(s); 
          
        //print the reversed string 
        System.out.println("Reversed string is " + s); 
    } 
    
  //function to reverse the string 
    public static void reverse(StringBuffer str) 
    { 
        // Create a stack of capacity  
        // equal to length of string 
        int n = str.length(); 
        Stack<Character> obj = new Stack<>();
          
        // Push all characters of string  
        // to stack 
        for(int i=0; i<str.length(); i++) {
        	obj.push(str.charAt(i));
        }
      
        // Pop all characters of string  
        // and put them back to str 
        for(int i=0; i<str.length(); i++) {
        	str.setCharAt(i,obj.pop());
        }
    } 
    
    
    /*
     * https://www.journaldev.com/538/string-vs-stringbuffer-vs-stringbuilder
     * 
     * String : immutable -> concatenation | subString > new string and discards old string for garbage collection
     * 						These are heavy operations and generate a lot of garbage in heap.
     * 
     * 
     * StringBuffer: mutable | append(), insert(), delete() and substring()
     * 					Synch | performance cost
     * 
     * 
     * StringBuilder 1.5: mutable | 
     * 						non-Synch | multithreaded
     * 
     * 
     */
    
}
