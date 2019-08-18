package arrayDS;

import java.util.Arrays;

public class Find_Four_Element_For_Sum {

	public static void main(String[] args) {
		Find_Four_Element_For_Sum findfour = new Find_Four_Element_For_Sum();
		int A[] = { 1, 4, 45, 6, 10, 12 };
		int n = A.length;
		int X = 21;
		findfour.find4Numbers(A, n, X);

	}

	/*
	 * A sorting based solution to print all combination of 4 elements in A[] with
	 * sum equal to X
	 */
	void find4Numbers(int Arr[], int n, int sum) {

		// Sort the array in increasing order, using library 
        // function for quick sort 
		Arrays.sort(Arr);

		int Left;
		int Right;
		int currSum;
		// Initialize two variables as indexes of the first and last
		// elements in the remaining elements
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				Left = j + 1;
				Right = n - 1;

				// To find the remaining two elements, move the index  
                // variables (l & r) toward each other. 
				while (Left < Right) {
					currSum = Arr[i] + Arr[j] + Arr[Left] + Arr[Right];
					if (currSum == sum) {
						System.out.println(Arr[i] + " " + Arr[j] + " " + Arr[Left] + " " + Arr[Right]);
						Left++;
						Right--;
					} else if (currSum < sum) {
						Left++;
					} else {
						Right--;
					}
				}
			}
		}
	}

}
