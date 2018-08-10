package leetcode.Q5;

public class longestPalindrome {
	private static int lo;
	private static int maxlen = 0;

	public static String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			extendPalindrome(s, i, i);// 奇数回文
			extendPalindrome(s, i, i + 1);// 偶数回文
		}
		return s.substring(lo, lo + maxlen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxlen < k - j - 1) {
			lo = j + 1;// while循环结束后，j--了，lo需要从j+1开始
			maxlen = k - j - 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("babaaaab"));
	}

}
