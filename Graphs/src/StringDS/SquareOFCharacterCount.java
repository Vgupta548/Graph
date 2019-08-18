package StringDS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SquareOFCharacterCount {

	static final int MAX_CHAR = 26;
	public static void main(String[] args) {
		 
		SquareOFCharacterCount S = new SquareOFCharacterCount();
		
		String str = "abbccc";
		int k =2;
				
		int count =minStringValue(str, k);
		System.out.println(count);
		
		str = "aaab";           // Input 2 
        k = 2; 
        System.out.println(minStringValue(str, k)); 
		
	}
	
 static class IntComparator implements Comparator<Integer> {
	 public int compare(Integer i, Integer j) {
		 if(j > i) return 1;
		 else if(j < i) return -1;
		 else return 0;
	 }

	
 }
	
	
	public static int minStringValue(String str, int k) {
		
		int count =0;
		int strlength = str.length();
		
		if(k>=strlength) return 0;
		
		Comparator<Integer> c = new IntComparator();
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(c);
		
		int[] freq = new int[MAX_CHAR];
		
		for(int i =0 ; i< strlength;  i++) {
			System.out.println(str.charAt(i));
			freq[(str.charAt(i)-'a')]++;
		}
		
		for(int i=0; i<MAX_CHAR ; i++) {
			if(freq[i] != 0) queue.add(freq[i]);
		}
		
		while(k>0) {
			
			Integer temp = queue.poll();
			System.out.println(temp);
			temp--;
			queue.add(temp);
			k--;
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			count += temp*temp;
		}
		
		
		return count;
	}
}
