import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyPad {

	public static void main(String[] args) throws java.lang.Exception {
		// findSchedules(56, 8, '???8???');
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		list.add("jkl");
		list.add("mno");
		list.add("pqrs");
		list.add("tuv");
		list.add("wxyz");
		System.out.println(countMessages(list, "heu"));
		
	}
	
	

	public static int countMessages(List<String> keys, String message) {
		//dictionary of character -> keypad number
		Map<Character, String> dict = new HashMap<>();
		for (int i = 0; i < keys.size(); i++) {
			int y = 1;
			for (char ch : keys.get(i).toCharArray()) {
				String s = new String(new char[y++]).replaceAll("\0", (i+2)+"");
				dict.put(ch, s) ;
			}
		}
		
		StringBuilder str = new StringBuilder();
		int i = 0;
		for (char ch : message.toCharArray()) {
			str.append(dict.get(ch));
		}
		System.out.println(str);
		
		keys.add(0, "");
		 return printKeyWords(str.toString(), keys.stream().toArray(String[]::new)).size();
	}
	
	public static ArrayList<String> printKeyWords(String str, String[] codes) {

        // If str is empty
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");

            // Return an Arraylist containing
            // empty string
            return baseRes;
        }
        
        // First character of str
        char ch = str.charAt(0);

        // Rest of the characters of str
        String restStr = str.substring(1);

        ArrayList<String> prevRes = printKeyWords(restStr, codes);
        ArrayList<String> Res = new ArrayList<>();

        String code = codes[ch - '0'];

        for (String val : prevRes) {

            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }
        return Res;
    }

}