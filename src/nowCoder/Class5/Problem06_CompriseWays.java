package nowCoder.Class5;

public class Problem06_CompriseWays {
	// 背包问题
	// arr[0...i]自由使用的情况下，容量不超过limit的方法数
	// public static int process(int[] arr, int i, int limit) {
	// if (limit == 0)
	// return 1;
	// int ways = process(arr, i, limit);// 不要i位置上的商品
	// ways += process(arr, i, limit - arr[i]);// 要i位置上的商品
	// return ways;
	// }

	//
	public static int ways(int[] arr, int w) {
		if (arr == null || arr.length == 0 || w < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][w + 1];
		// 初始化dp的第一行和第一列
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j <= w; j++) {
			dp[0][j] = j >= arr[0] ? 2 : 1;
		}
		// 动态规划表里的其他内容
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= w; j++) {
				// 不要i位置上的商品
				dp[i][j] = dp[i - 1][j];
				// 要i位置上的商品，并且没越界
				if (j - arr[i] >= 0)
					dp[i][j] += dp[i - 1][j - arr[i]];
			}
		}
		return dp[arr.length - 1][w];
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 9 };
		int w = 8;
		System.out.println(ways(arr, w));
	}
}
