package StringDS;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitNum {

	public static void main(String[] args) {
		int N=12;
		System.out.println("The number is : ");
		digitNum(N);
		digitNum(22);
		digitNum(5);
	}
	
	public static void digitNum(int N) {

		String str = "";
		StringBuilder s = new StringBuilder();
		
		int lowestDigit = N%9;
		if(lowestDigit != 0) s.append(lowestDigit);
		
		int nextNines = N/9;
		while(nextNines>0) {
			s.append(9);
			nextNines--;
		}
		
		IntStream.range(0, N).mapToObj(i -> s).collect(Collectors.joining(""));
		String sRepeated = IntStream.range(0, N).mapToObj(i -> "0").collect(Collectors.joining(""));

		s.append(sRepeated);
		System.out.println(s.toString());
	}
}
