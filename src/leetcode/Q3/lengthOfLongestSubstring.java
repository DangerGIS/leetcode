package leetcode.Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int max = lengthOfLongestSubstring(s);
		System.out.println(max);
	}

	static public int lengthOfLongestSubstring(String s) {
		// 统计字符串s中各字符之前出现的位置
		Map<Character, Integer> charPosition = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			// 如果字符不是第一次出现，则记录当前位置的下一个作为最长子串的起点
			if (charPosition.containsKey(s.charAt(i)))
				j = Math.max(j, charPosition.get(s.charAt(i)) + 1);
			charPosition.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}

		return max;
	}

}
