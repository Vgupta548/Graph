package dist;

public class GCD {

	public static void main(String[] args) {
		
		AC c = new AC();
		System.out.println("ccc :"+c.getAvc());
		
		
		// TODO Auto-generated method stub 
		System.out.println(gcd(1, 3));
		System.out.println("--");
		System.out.println(gcd(2, 6));
		System.out.println("--");
		System.out.println(gcd(7, 2));
		System.out.println("--");
		System.out.println(gcd(8, 12));
		System.out.println("--");
		System.out.println(gcd(5, 12));
		System.out.println("--");
	}

	private static int gcd(int a, int b) {
		System.out.println(a + " : "+b );
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
	
	private static void ss(AC c) {
		c = new AC();
		c.setAvc("ddfd");
	}
}
