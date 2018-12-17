package nowCoder.Class2;

public class Problem04_ParenthesesDeep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "((()))(())))";
		System.out.println(maxLength(str));
	}

	// 求子串中合法括号的最长长度
	public static int maxLength(String str) {
		char[] chs = str.toCharArray();
		int[] dp = new int[chs.length];
		int pre = 0;
		int res = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chs[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
