package leetcode.Q17;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
	static List<String> res = new ArrayList<>();
	// static char[] str = new char[100];
	static String dict[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		char[] str = new char[digits.length()];
		if (digits.isEmpty())
			return res;
		letterCombinationsDFS(digits, str, 0);
		return res;
	}

	public static void letterCombinationsDFS(String digits, char[] str, int step) {
		if (step == digits.length()) {
			// str[step] = '\0';
			res.add(String.copyValueOf(str));
			return;
		}

		int index = digits.charAt(step) - '0';
		for (int i = 0; i < dict[index].length(); i++) {
			str[step] = dict[index].charAt(i);
			letterCombinationsDFS(digits, str, step + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("");
		for (String s : res) {
			System.out.println(s);
		}

	}

}
