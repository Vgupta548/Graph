package arrayDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Function to find missing number 
public class Missing_Number_In_Array {

	
	// Java program to find missing Number 
	// using xor 
	// 1) XOR all the array elements, let the result of XOR be X1.
	// 2) XOR all numbers from 1 to n, let XOR be X2.
	// 3) XOR of X1 and X2 gives the missing number.
    static int getMissingNo (int a[], int n) 
    { 
        int x1 = a[0];  
        int x2 = 1;  
          
        for (int i = 1; i <= n; i++) {
            if(i != n)
            x1 = x1 ^ a[i];  
            x2 = x2 ^ (i+1); 
            
        }
        System.out.println("x2 :"+x2);
        return (x1 ^ x2); 
 
      /*   //For xor of all the elements  
           //in array 
        for (int i = 1; i < n; i++) {
            
            System.out.print(x1+" ^ "+a[i]);
            x1 = x1 ^ a[i];        
            System.out.println("="+x1);
            
        }
        System.out.println("x1 :"+x1);
        System.out.println("==");
         //For xor of all the elements  
         //  from 1 to n+1          
        for (int i = 2; i <= n+1; i++) {
        	System.out.print(x2+" ^ "+i);
            x2 = x2 ^ i;          
            System.out.println("="+x2);
        }
       
        System.out.println("x2 :"+x2);
        return (x1 ^ x2);  */
    } 
    
 // (Use sum formula)
    static int getMissingNo1(int a[], int n) 
    { 
        int i, total; 
        total  = (n+1)*(n+2)/2;    
        for ( i = 0; i< n; i++) 
           total -= a[i]; 
        return total; 
    }
       
    /* program to test above function */
    public static void main(String args[]) throws IOException
    { 
        int a[] = {1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23}; 
        int miss = getMissingNo(a,4); 
        System.out.println(miss); 
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    int t = Integer.parseInt(br.readLine()); 
	    while(t!=0)
	    {
	        t--;
	        int nn=Integer.parseInt(br.readLine()); 
	        int n=nn-1;
	        int arr[]=new int[n];
	        
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 
	       
	       
	        int x1=arr[0];
	        int x2=1;
	     /* For xor of all the elements  
           in array */
	       for (int i = 1; i <= n; i++) {
             if(i != n)
                x1 = x1 ^ arr[i];  
                x2 = x2 ^ (i+1); 
            
        }
	        /*XOR of X1 and X2 gives the missing number */
	       System.out.println(x1^x2);
	    
	    }
	 }
}
