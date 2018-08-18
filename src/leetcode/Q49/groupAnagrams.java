package leetcode.Q49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] cs = str.toCharArray();
			Arrays.sort(cs);
			String key = String.valueOf(cs);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);

		}
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> lists = groupAnagrams(strs);
		for (List list : lists) {
			System.out.println(list.toString());
		}

	}

}
