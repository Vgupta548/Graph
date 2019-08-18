package recurrsion;

/**
 * It is a coding problem using recursion. 
 * I've done it with a global variable but need to know the solution not using a global variable.
 * @author vipingupta
 *
 */
public class NoOfDigitInInteger {

	
	public static void main(String[] args) {
		int i =10343;
		System.out.println(""+i+" : "+countDigits(i));
		
		i =1034;
		System.out.println(""+i+" : "+countDigits(i));

		i =103;
		System.out.println(""+i+" : "+countDigits(i));
		

		i =10;
		System.out.println(""+i+" : "+countDigits(i));

		i =1;
		System.out.println(""+i+" : "+countDigits(i));

		i =0;
		System.out.println(""+i+" : "+countDigits(i));

		i =0;
		System.out.println(""+i+" : "+countDigits(i));
		
		
		
	}
	
	public static int countDigits(int no) {
        if(no<10) return 1;
        return (1 + countDigits(no/10));

  }
}
