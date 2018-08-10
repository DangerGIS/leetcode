package leetcode.Q22;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", 0, 0, n);
		return res;
	}

	// left��ʾ�����Ÿ�����right��ʾ�����Ÿ���
	// res��ʾ���صĽ������str��ʾһ���������
	public static void helper(List<String> res, String str, int left, int right, int n) {
		if (str.length() == n * 2) {
			res.add(str);
			return;
		}
		if (left < n)
			helper(res, str + "(", left + 1, right, n);
		if (right < left)
			helper(res, str + ")", left, right + 1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = generateParenthesis(3);
		for (String str : list) {
			System.out.println(str);
		}
	}

}
