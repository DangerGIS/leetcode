package nowCoder.Class2;

public class Problem03_NumToStringWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12258;
		System.out.println(convertWays(num));
		System.out.println(dpways(num));
	}

	public static int convertWays(int num) {
		if (num < 1) {
			return 0;
		}
		return process(String.valueOf(num).toCharArray(), 0);
	}

	// 暴力递归
	public static int process(char[] str, int index) {
		// 后续无字符
		if (index == str.length) {
			return 1;
		}
		// 后续有字符
		// 以0开头 0...
		if (str[index] == '0') {
			return 0;
		}
		// 后续有字符，非0开头
		int res = process(str, index + 1);
		if (index == str.length - 1) {// 除了index外没有别的字符了
			return res;
		}
		// 除了index外,还有别的字符，index和index+1组成
		if (((str[index] - '0') * 10 + (str[index + 1] - '0')) < 27) {
			res += process(str, index + 2);
		}
		return res;

	}

	// 动态规划
	public static int dpways(int num) {
		if (num < 1) {
			return 0;
		}
		char[] str = String.valueOf(num).toCharArray();
		int[] dp = new int[str.length + 1];// 因为index可以 == str.length
		dp[str.length] = 1;
		dp[str.length - 1] = str[str.length - 1] == '0' ? 0 : 1;
		for (int i = str.length - 2; i >= 0; i--) {
			if (str[i] == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i + 1] + (((str[i] - '0') * 10 + (str[i + 1] - '0')) < 27 ? dp[i + 2] : 0);
			}
		}
		return dp[0];
	}

}
