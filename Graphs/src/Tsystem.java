import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tsystem extends Thread{
	
	public static void main(String[] args) {
		
		System.out.println(1+2+3);
		Thread t=new Tsystem();
		Thread t2=new Tsystem();
		try {
			t.join();
			t2.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
