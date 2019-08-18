import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
	
	public static void main(String[] args) {
		TC t = new TC();
		t.setI(1);
		t.setJ(11);
		t.setL(21);
		
		TC t2 = new TC();
		t2.setI(1);
		t2.setJ(11);
		t2.setL(21);
		
		
		TC t3 = new TC();
		t3.setI(1);
		t3.setJ(11);
		t3.setL(20);
		
		TC t4 = new TC();
		t4.setI(1);
		t4.setJ(11);
		t4.setL(22);
		
		List<TC> l = new ArrayList<>();
		l.add(t);
		l.add(t2);
		l.add(t3);
		l.add(t4);
		
		Collections.sort(l, hpdProductStoreComparator);
		
		for(TC tt: l) {
			System.out.println(tt.getL());
		}
		
		l.size();
		
	}
	
	static Comparator<TC> hpdProductStoreComparator = new Comparator<TC>() {
        public int compare(TC h1, TC h2) {
            int compareCat = h1.getI().compareTo(h2.getI());
            int compareProd = h1.getJ().compareTo(h2.getJ());
            int compareStore = h1.getL() < h2.getL() ? -1 : (h1.getL() == h2.getL() ? 0 : 1);
            if (compareCat == 0) {
                return compareProd == 0 ? compareStore : compareProd;
            } else {
                return compareCat;
            }
        }
    };

}

class TC{
	Integer i;
	Integer j;
	int l;
	
	public Integer getI() {
		return i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	public Integer getJ() {
		return j;
	}
	public void setJ(Integer j) {
		this.j = j;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	
	
}
