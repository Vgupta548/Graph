import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> callLogs= new ArrayList<>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(1);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(4);
		list3.add(2);
		
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(5);
		list4.add(2);
		
		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(6);
		list5.add(2);
		
		callLogs.add(list);
		callLogs.add(list1);
		callLogs.add(list2);
		callLogs.add(list3);
		callLogs.add(list4);
		callLogs.add(list5);
		List<Integer> cache = cacheContents(callLogs);
		System.out.println(cache.size());
	}

	public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
		// Write your code here

		List<Integer> res = new ArrayList<Integer>();
		int rows = callLogs.size();
		Map<Integer, Item> uniqueItems = new TreeMap<Integer, Test.Item>();
		
		int lastTime = 0;
		for (int i = 0; i < rows; i++) {
				int timeid = callLogs.get(i).get(0);
				int itemid = callLogs.get(i).get(1);
				if(!uniqueItems.containsKey(itemid)) {
					Item it = new Item(itemid);
					uniqueItems.put(itemid, it);
				}
				Item item = uniqueItems.get(itemid);
				int noAccss = timeid - item.lastaceesTime -1;
				item.setPriority(item.getPriority() - noAccss);
				item.setPriority(item.getPriority()+2);
				
				if(!item.inCache && item.priority > 5) {
					item.setInCache(true);
				}
				lastTime = timeid;
		}
		
		for(Map.Entry<Integer, Item> entry : uniqueItems.entrySet()) {
			int timeid = entry.getValue().getLastaceesTime();
			int itemid = entry.getKey();
			
			int noAccss = lastTime - timeid -1;
			//item.setPriority(item.getPriority() - noAccss);
		}
		
		
		for(Map.Entry<Integer, Item> entry : uniqueItems.entrySet()) {
			if(entry.getValue().inCache || entry.getValue().isInCache()) {
				res.add(entry.getKey());
			}
		}
	
		return res;

	}
	
	static class Item {
		int id;
		int lastaceesTime;
		int priority = 0;
		boolean inCache = false;
		
		Item(int id){
			this.id = id;
		}

		public int getLastaceesTime() {
			return lastaceesTime;
		}

		public void setLastaceesTime(int lastaceesTime) {
			this.lastaceesTime = lastaceesTime;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			if(priority < 0 ) {
				priority = 0;
			}
			this.priority = priority;
		}

		public boolean isInCache() {
			return inCache;
		}

		public void setInCache(boolean inCache) {
			this.inCache = inCache;
		}
		
		
		
		
	}
	

}
