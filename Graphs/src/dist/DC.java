package dist;

import java.util.ArrayList;
import java.util.List;

public class DC {
	
	public static void main(String[] args) {
		BC b = new BC();
		
		AC a = new AC();
		
		b =(BC) a;
		
		a.getAvc();
		b.getBbc();
		
		List<String> aa = new ArrayList<>();
		
	}
	
	

}
