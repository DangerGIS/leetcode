package nowCoder.Class6;

public class Problem05_Light {
	public static void main(String[] args) {
		String test = "...X.X.X..XX.XX.X.X.X.X.XX.XXX.X.XXX.XX";
		System.out.println(minLight1(test));
		System.out.println(minLight2(test));
	}

	public static int minLight1(String s) {
		// if (str == null || str.length() == 0) {
		// return 0;
		// }
		// int len = str.length();
		// // 初始化help数组
		// char[] help = new char[len + 2];
		// help[0] = '.';
		// help[len] = '.';
		// for (int i = 0; i < str.length(); i++) {
		// help[i + 1] = str.charAt(i);
		// }
		// return process(help, 1, true);
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		char[] help = new char[str.length + 2];
		help[0] = '.';
		help[str.length] = '.';
		for (int i = 0; i < str.length; i++) {
			help[i + 1] = str[i];
		}
		return process(help, 1, true);
	}

	// 当前来到了i位置
	// 函数潜台词：help[0..i-2]上都已经点亮了
	// pre表示i-1位置是否点亮
	// 返回如果把所有位置都点亮，help[i..最后]需要几盏灯
	// process(help, i,
	// true)：表示help[0..i-2]上都已经点亮了，i-1位置也点亮的情况下，help[i..最后]需要几盏灯
	// process(help, i,
	// false)：表示help[0..i-2]上都已经点亮了，但是i-1位置没亮的情况下，help[i..最后]需要几盏灯
	public static int process(char[] help, int i, boolean pre) {
		if (i == help.length) {
			return 0;
		}
		if (i == help.length - 1) {
			return pre ? 0 : Integer.MAX_VALUE;
		}
		int ans = Integer.MAX_VALUE;
		int restLight = 0;
		if (pre) {// i-1的位置是亮的
			if (help[i] == '.') {// i的位置是亮的
				// 无需在i位置放灯，从i+1考虑即可
				restLight = process(help, i + 1, true);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight);
				}
			} else {// i的位置是不亮的
				// 也无需在i位置放灯，从i+1考虑即可，pre变false
				restLight = process(help, i + 1, false);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight);
				}
				// 把i位置点亮，则i+1位置也亮了，从i+2考虑，pre是true
				restLight = process(help, i + 2, true);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight + 1);
				}
			}
		} else {// i-1的位置是不亮的
				// 必须把i位置点亮，那么i+1位置也就亮了，从i+2开始考虑
			restLight = process(help, i + 2, true);
			if (restLight != Integer.MAX_VALUE) {
				ans = Math.min(ans, restLight + 1);
			}
		}
		return ans;
	}

	public static int minLight2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		char[] help = new char[str.length + 2];
		help[0] = '.';
		help[str.length] = '.';
		for (int i = 0; i < str.length; i++) {
			help[i + 1] = str[i];
		}
		int[][] dp = new int[help.length + 1][2];
		dp[help.length][0] = 0;
		dp[help.length][1] = 0;
		dp[help.length - 1][0] = Integer.MAX_VALUE;
		dp[help.length - 1][1] = 0;
		for (int i = help.length - 2; i >= 1; i--) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
			int restLight = 0;
			if (help[i] == '.') {
				restLight = dp[i + 1][1];
				if (restLight != Integer.MAX_VALUE) {
					dp[i][1] = Math.min(dp[i][1], restLight);
				}
			} else {
				restLight = dp[i + 1][0];
				if (restLight != Integer.MAX_VALUE) {
					dp[i][1] = Math.min(dp[i][1], restLight);
				}
				restLight = dp[i + 2][1];
				if (restLight != Integer.MAX_VALUE) {
					dp[i][1] = Math.min(dp[i][1], restLight + 1);
				}
			}
			restLight = dp[i + 2][1];
			if (restLight != Integer.MAX_VALUE) {
				dp[i][0] = Math.min(dp[i][0], restLight + 1);
			}
		}
		return dp[1][1];

	}
}
