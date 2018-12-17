import java.util.HashMap;
import java.util.Map;

public class longestStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = lengthOfLongestSubstring("abcbeds");
		System.out.println(res);
	}

	public static int lengthOfLongestSubstring(String str) {
		int n = str.length(), res = 0;
		Map<Character, Integer> map = new HashMap<>();
		// 滑动窗口[i,j]
		for (int i = 0, j = 0; j < n; j++) {
			if (map.containsKey(str.charAt(j))) {
				i = Math.max(map.get(str.charAt(j)), i);
			}
			// 最长子串起始位置
			System.out.println(i);
			res = Math.max(res, j - i + 1);

			map.put(str.charAt(j), j + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return res;

	}
}
