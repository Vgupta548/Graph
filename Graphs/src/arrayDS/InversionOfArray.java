package arrayDS;

import java.util.Arrays;

public class InversionOfArray {

	static int mergeSort(int[] arr,  int n) {
		int[] temp = new int[n];
		return _mergeSort(arr, temp, 0, n-1);
	}
	
	static int _mergeSort(int[] arr, int[] temp, int left, int right) {
		
		int  inv_count = 0;
		if(left < right) {
			int mid = (left + right)/2 ;
			
			 inv_count += _mergeSort(arr, temp, left, mid);
			 inv_count += _mergeSort(arr, temp, mid+1, right);
			
			inv_count += merge(arr, temp, left, mid+1, right);
			System.out.println("merge "+Arrays.toString(arr));
		}
		
		return  inv_count;
	}
	
	static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		System.out.println(temp.length + " "+left+ " "+mid+" "+right);
		System.out.println(Arrays.toString(arr));
		int i, j , k;
		i = left;
		j = mid;
		k = left;
		
		int inv_count = 0;
		
		while(i < mid && j<=right) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++]; 
			}else {
				temp[k++] = arr[j++];
				inv_count += mid-i;
				System.out.println("inv add :"+(mid-i));
				System.out.println("inv :"+inv_count);
			}
		}
		
		while(i < mid) {
			temp[k++] = arr[i++];
		}
		
		while(j<= right) {
			temp[k++] = arr[j++];
		}
		
		for(i = left ; i<=right; i++) {
			arr[i] = temp[i];
		}
		System.out.println(inv_count);
		
		return inv_count;
	}

 // Driver method to test the above function 
 public static void main(String[] args) 
 { 
     int arr[] = new int[] { 20, 10, 1}; 
     System.out.println("Number of inversions are " + mergeSort(arr, arr.length)); 
     
     int arr1[] = new int[] { 1, 20, 6, 4, 5 }; 
     System.out.println("Number of inversions are " + mergeSort(arr1, arr1.length)); 
 } 
}
