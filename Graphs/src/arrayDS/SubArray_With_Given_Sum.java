package arrayDS;

import java.util.HashMap;

/*
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 */
public class SubArray_With_Given_Sum {

	int subArraySum(int arr[], int n, int sum)  
    { 
        int curr_sum = arr[0], start = 0, i; 
  
        // Pick a starting point 
        for (i = 1; i <= n; i++)  
        { 
            // If curr_sum exceeds the sum, then remove the starting elements 
        	System.out.println("i :"+i);
            while (curr_sum > sum && start < i-1) 
            { 
            	System.out.println("remove: "+start);
                curr_sum = curr_sum - arr[start]; 
                start++; 
                System.out.println("current sum :"+curr_sum);
            } 
              
            // If curr_sum becomes equal to sum, then return true 
            if (curr_sum == sum)  
            { 
                int p = i-1; 
                System.out.println("Sum found between indexes " + start 
                        + " and " + p); 
                return 1; 
            } 
              
            // Add this element to curr_sum 
            if (i < n) 
            curr_sum = curr_sum + arr[i]; 
            System.out.println("current sum :"+curr_sum);
              
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    } 
	
	public static void subArraySumNegative(int[] arr, int n, int sum) { 
        //cur_sum to keep track of cummulative sum till that point 
        int cur_sum = 0; 
        int start = 0; 
        int end = -1; 
        HashMap<Integer, Integer> hashMap = new HashMap<>(); 
  
        for (int i = 0; i < n; i++) { 
            cur_sum = cur_sum + arr[i]; 
            //check whether cur_sum - sum = 0, if 0 it means 
            //the sub array is starting from index 0- so stop 
            if (cur_sum - sum == 0) { 
                start = 0; 
                end = i; 
                break; 
            } 
            //if hashMap already has the value, means we already  
            // have subarray with the sum - so stop 
            if (hashMap.containsKey(cur_sum - sum)) { 
                start = hashMap.get(cur_sum - sum) + 1; 
                end = i; 
                break; 
            } 
            //if value is not present then add to hashmap 
            hashMap.put(cur_sum, i); 
  
        } 
        // if end is -1 : means we have reached end without the sum 
        if (end == -1) { 
            System.out.println("No subarray with given sum exists"); 
        } else { 
            System.out.println("Sum found between indexes " 
                            + start + " to " + end); 
        } 
  
    } 
  
    public static void main(String[] args)  
    { 
    	SubArray_With_Given_Sum arraysum = new SubArray_With_Given_Sum(); 
        int arr[] = {15, -2, 4, 8, 9, 5, 10, 23}; 
       // int arr[] = {15, -2, 4, 8, 9, 5, 10, 23}; sum =21 fails when sum is 19 increase index rather than remove trail -2
        int n = arr.length; 
        int sum = 21; 
        arraysum.subArraySum(arr, n, sum); 
        
        System.out.println("==========");
        int[] arr1 = {10, 2, -2, -20, 10}; 
        int n1 = arr.length; 
        int sum1 = -10; 
        subArraySumNegative(arr1, n1, sum1); 
  
    } 
}
