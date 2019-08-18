package StringDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchDict_charArray {
	
	static final int MAX_CHAR =26;

	public static void main(String[] args) {
		
		
		Long l = 2L;
		
		List<Long> ll = new ArrayList<>();
		ll.add(22L);
		ll.add(3L);
		ll.add(4L);
		
		List<Long> ll1 = new ArrayList<>();
		ll1.add(2L);
		ll1.add(33L);
		ll1.add(4L);
		
		ll1.removeAll(ll);
		
		
		
		String Dict[] = {"go", "bat", "me", "eat", 
                "goal", "boy", "goo",  "goon", "run"} ; 
		Map<Long, Integer> idToHitsMap = new HashMap();
		String arr[] = {"1111", "2323"};
		long[] ids = Arrays.stream(arr).mapToLong(Long::valueOf).toArray();
        System.out.println("duplicate  ids: " + Arrays.toString(ids));
        Set<Long> idsSet = new HashSet(Arrays.asList(ids));
        for (long id : ids) {
            idToHitsMap.put(id, 12);
        }
	}
	
	public static void printAllWords(String Dict[], char key[]) {
		
		TreeNode head = new TreeNode();	
		
		for(int i=0; i< Dict.length; i++) {
			String currWord = Dict[i]; 
			TreeNode childNode = head;
			
			for(int j =0; j<currWord.length(); j++ ) {
				int index = currWord.charAt(j)-'a';
				//childNode.childs[index];
				
			}
		}
		
	}

	
	
	
	
	static class TreeNode{
		boolean isLeaf = false;
		TreeNode childs[] = new TreeNode[MAX_CHAR];
	}
}
