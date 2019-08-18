package arrayDS;

public class Trapping_Rain_Water {

	static int arr[] = new int[]{1, 3, 2, 4, 3, 1, 2, 2, 5, 4, 1, 3, 2, 1}; 
	//static int arr[] = new int[]{3 ,0,0,2,0,4}; 
    
    // Method for maximum amount of water 
	//the width of each bar is 1 
	//******************above blocks**************
    static int findWater(int n) 
    { 
    	for (int i = 0; i < n; i++) 
            System.out.print(i +" ");
    	
    	  System.out.println();
    	for (int i = 0; i < n; i++) 
            System.out.print(arr[i] +" ");
    	
    	 System.out.println();
        // left[i] contains height of tallest bar to the 
        // left of i'th bar including itself 
        int left[] = new int[n]; 
       
        // Right [i] contains height of tallest bar to 
        // the right of ith bar including itself 
        int right[] = new int[n]; 
       
        // Initialize result 
        int water = 0; 
       
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
           left[i] = Math.max(left[i-1], arr[i]); 
        
        for (int i = 0; i < n; i++) 
            System.out.print(left[i] +" ");
       
        System.out.println();
        // Fill right array 
        right[n-1] = arr[n-1]; 
        for (int i = n-2; i >= 0; i--) 
           right[i] = Math.max(right[i+1], arr[i]); 
        
        for (int i = 0; i < n; i++) 
            System.out.print(right[i] +" ");
       
        System.out.println();
        // Calculate the accumulated water element by element 
        // consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular 
        // bar will be equal to min(left[i], right[i]) - arr[i] . 
        for (int i = 0; i < n; i++) {
           water += Math.min(left[i],right[i]) - arr[i];
           System.out.print(Math.min(left[i],right[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print((Math.min(left[i],right[i]) - arr[i]) + " ");
         }
        System.out.println();
        return water; 
    } 
    
    static int findWater(int arr[], int n) 
    { 
        // initialize output 
        int result = 0; 
           
        // maximum element on left and right 
        int left_max = 0, right_max = 0; 
           
        // indices to traverse the array 
        int lo = 0, hi = n-1; 
           
        while(lo <= hi)  
        { 
            if(arr[lo] < arr[hi]) 
            { 
                if(arr[lo] > left_max) 
      
                // update max in left 
                left_max = arr[lo]; 
                else
      
                // water on curr element =  
                // max - curr 
                result += left_max - arr[lo]; 
                lo++; 
            } 
            else
            { 
                if(arr[hi] > right_max) 
                  
                // update right maximum 
                right_max = arr[hi]; 
                  
                else
                result += right_max - arr[hi]; 
                hi--; 
            } 
        } 
           
        return result; 
    }
    
    
 // Method for maximum amount of water 
  //******************between blocks**************
    static int findWater1(int n) 
    { 
    	for (int i = 0; i < n; i++) 
            System.out.print(arr[i] +" ");
    	
    	 System.out.println();
        // left[i] contains height of tallest bar to the 
        // left of i'th bar including itself 
        int left[] = new int[n]; 
       
        // Right [i] contains height of tallest bar to 
        // the right of ith bar including itself 
        int right[] = new int[n]; 
       
        // Initialize result 
        int water = 0; 
       
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
           left[i] = Math.max(left[i-1], arr[i]); 
        
        for (int i = 0; i < n; i++) 
            System.out.print(left[i] +" ");
       
        System.out.println();
        // Fill right array 
        right[n-1] = arr[n-1]; 
        for (int i = n-2; i >= 0; i--) 
           right[i] = Math.max(right[i+1], arr[i]); 
        
        for (int i = 0; i < n; i++) 
            System.out.print(right[i] +" ");
       
        System.out.println();
        // Calculate the accumulated water element by element 
        // consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular 
        // bar will be equal to min(left[i], right[i]) - arr[i] . 
        System.out.print( "  " );
        for (int i = 1; i < n; i++) {
        	water += Math.min(left[i-1],right[i]);
          // water += Math.min(left[i],right[i]) - arr[i];
           System.out.print(Math.min(left[i-1],right[i]) + " ");
        }
        
        System.out.println();
        return water; 
    } 
      
    // Driver method to test the above function 
    public static void main(String[] args)  
    { 
          
        System.out.println("Maximum water that can be accumulated is " +  
                                        findWater1(arr.length)); 
        System.out.println("Maximum water that can be accumulated is " +  
                findWater(arr.length)); 
        System.out.println("Maximum water that can be accumulated is " +  
                findWater(arr, arr.length)); 
    } 
}
