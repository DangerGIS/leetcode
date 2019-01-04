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
		// // ��ʼ��help����
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

	// ��ǰ������iλ��
	// ����Ǳ̨�ʣ�help[0..i-2]�϶��Ѿ�������
	// pre��ʾi-1λ���Ƿ����
	// �������������λ�ö�������help[i..���]��Ҫ��յ��
	// process(help, i,
	// true)����ʾhelp[0..i-2]�϶��Ѿ������ˣ�i-1λ��Ҳ����������£�help[i..���]��Ҫ��յ��
	// process(help, i,
	// false)����ʾhelp[0..i-2]�϶��Ѿ������ˣ�����i-1λ��û��������£�help[i..���]��Ҫ��յ��
	public static int process(char[] help, int i, boolean pre) {
		if (i == help.length) {
			return 0;
		}
		if (i == help.length - 1) {
			return pre ? 0 : Integer.MAX_VALUE;
		}
		int ans = Integer.MAX_VALUE;
		int restLight = 0;
		if (pre) {// i-1��λ��������
			if (help[i] == '.') {// i��λ��������
				// ������iλ�÷ŵƣ���i+1���Ǽ���
				restLight = process(help, i + 1, true);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight);
				}
			} else {// i��λ���ǲ�����
				// Ҳ������iλ�÷ŵƣ���i+1���Ǽ��ɣ�pre��false
				restLight = process(help, i + 1, false);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight);
				}
				// ��iλ�õ�������i+1λ��Ҳ���ˣ���i+2���ǣ�pre��true
				restLight = process(help, i + 2, true);
				if (restLight != Integer.MAX_VALUE) {
					ans = Math.min(ans, restLight + 1);
				}
			}
		} else {// i-1��λ���ǲ�����
				// �����iλ�õ�������ôi+1λ��Ҳ�����ˣ���i+2��ʼ����
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
