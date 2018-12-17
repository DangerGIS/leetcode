package nowCoder.Class2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class addProblem_CommomWord {
	// ÇóÍ¬Ô´´Ê
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "abc", "aabbcc", "c", "ab", "baab" };
		Collection<List<String>> res = commonWord(str);
		for (List<String> s : res) {
			System.out.println(s);
		}
	}

	public static Collection<List<String>> commonWord(String[] str) {
		HashMap<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			if (str[i] != null) {
				char[] chs = str[i].toCharArray();
				int count = 0;
				for (int j = 0; j < chs.length; j++) {
					count |= 1 << (chs[j] - 'a');
				}
				if (!map.containsKey(count)) {
					map.put(count, new ArrayList<>());
				}
				map.get(count).add(str[i]);
			}
		}
		return map.values();
	}

}
