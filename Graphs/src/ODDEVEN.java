
public class ODDEVEN {
	
	public static void main(String[] args) {
		
		OddEvenPrinter p = new OddEvenPrinter(1, 10);
		Thread t1 = new Thread() {
						@Override
					    public void run() {
								
						}
			};
			
			Thread t2 = new Thread() {
				@Override
			    public void run() {
						
				}
	};
	}

}


class OddEvenPrinter{
	private volatile int i;
	private volatile int n;
	
	OddEvenPrinter(int i, int n){
		this.i = i;
		this.n = n;
	}
	
	
	synchronized void printEven(int n) throws InterruptedException {
		while(i <= n) {
			if(i==1) {
				wait();
			}
			System.out.println(i);
			i++;
			notify();
			wait();
		}
	}
	
	synchronized void printOdd(int n) throws InterruptedException {
		while(i <= n) {
			System.out.println(i);
			i++;
			notify();
			wait();
		}
	}
	
	
}
