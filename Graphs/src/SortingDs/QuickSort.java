package SortingDs;

public class QuickSort {

	public static void main(String args[]) 
    { 
		System.out.println("Learn Sahare Learan".indexOf('a'));
		System.out.println("Learn Sahare Learan".indexOf('a', 3));
		System.out.println("Learn Sahare Learan".indexOf('a', 4));
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        printArray(arr); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    }

	/* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 

	private void sort(int[] arr, int low, int high) {
		if(low<high) {
			
			int pi = partition(arr, low, high);
			System.out.println("pivot  :"+pi+" : "+arr[pi]); 
			 printArray(arr); 
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
		
	}
	
	private int partition(int[] arr, int low, int high) {
		
		int i = low -1 ;
		
		for(int j=low; j<high; j++ ) {
			
			if(arr[j] <= arr[high]) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
		
		
	}
}


/*
 * Worst Case: theta(n2)
 *  when the array is already sorted in increasing or decreasing order. Following is recurrence for worst case.

 T(n) = T(0) + T(n-1) + \theta(n)
which is equivalent to  
 T(n) = T(n-1) + \theta(n)
 The solution of above recurrence is \theta(n2).

Best Case:  \theta(nLogn
The best case occurs when the partition process always picks the middle element as pivot. Following is recurrence for best case.

 T(n) = 2T(n/2) + \theta(n)
 
 Average Case:O(nLogn)
T(n) = T(n/9) + T(9n/10) + \theta(n)

 * 
 * 
 * QuickSort is faster in practice, because its inner loop can be efficiently implemented on most architectures, 
 * and in most real-world data. QuickSort can be implemented in different ways by changing the choice of pivot,
 *  so that the worst case rarely occurs for a given type of data. However, 
 *  merge sort is generally considered better when data is huge and stored in external storage.
 * 
 * 
 * In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
a) arr[l..i] elements less than pivot.
b) arr[i+1..j-1] elements equal to pivot.
c) arr[j..r] elements greater than pivot.


Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage)
 whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive. 


In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists.
 */
