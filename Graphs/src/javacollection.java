import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class javacollection {
	String name ;
	String age;
	
	public static void main(String[] args) {
		 ExecutorService productSpecificationExecutor = Executors.newFixedThreadPool(2);
		String s  = "sec as : asasd | ";
		System.out.println(s);
		String[] ss = s.split("\\|");
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		String[] aa = ss[0].split(":");
		System.out.println(aa[0]);
		System.out.println(aa[1]);
		
		
		List<String> alphabets = Arrays.asList("A", "B", "C", "D");
		String delimiter = ",";

		String result = String.join(delimiter, alphabets);
System.out.println(result);
		
		
		System.out.println("yoyo");
		Thread t = new Thread() {
			@Override
			public void run() {
				while(true) {
					// TODO Auto-generated method stub
					System.out.println("aa1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("bb1");
			}
		}
		};
		
		//t.run();
		
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					// TODO Auto-generated method stub
					System.out.println("aa");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("bb");
			}
				
			}
		};
		
		t1.start();
		
		
		
		
		
		ABC abc = new ABC();
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(9);
		x.add(3);
		x.add(6);
		x.add(19);
		System.out.println(abc.findmaxInRange(x, 1, 5));
		
		List<String> x1 = new ArrayList<String>();
		x1.add("1");
		x1.add("9");
		x1.add("3");
		x1.add("6");
		x1.add("19");
		System.out.println(abc.findmaxInRange(x1, 1, 5));
		
		List<String> x2 = new ArrayList<String>();
		x2.add("a");
		x2.add("g");
		x2.add("s");
		x2.add("c");
		x2.add("b");
		System.out.println(abc.findmaxInRange(x2, 1, 5));
		
		Integer[] z = new Integer[] {1,2,3,4,5};
		abc.swape(z, 0, 3);
		
		String[] z1 = new String[] {"aa","cc", "xs", "we", "sdd"};
		abc.swape(z1, 0, 3);
		
		Map<String, String> m = new LinkedHashMap<String, String>(){
			int MAX = 10;
			protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
				return size()> MAX; 
			}
		};
	
		
		
	}
	
	
}

class ABC {
	
	
	public <E extends Comparable<E>> E findmaxInRange(List<E> a, int start, int end) {
		E max = a.get(start);
		
		for(++start; start<end; ++start) {
			if(max.compareTo(a.get(start))<0) {
				max = a.get(start);
			}
		}
		return max;
	}
	
	public <E extends Comparable<Integer>> E findmaxInRange1(List<E> a, int start, int end) {
		E max = a.get(start);
		
		for(++start; start<end; ++start) {
			if(max.compareTo((Integer) a.get(start))<0) {
				max = a.get(start);
			}
		}
		return max;
	}
	
	public static <T> void swape(T[] a, int i, int j){
		
		T temp = a[i];
		a[i]= a[j] ;
		a[j] = temp;
	}
	

}
