package nowCoder.Class5;

public class Problem06_CompriseWays {
	// ��������
	// arr[0...i]����ʹ�õ�����£�����������limit�ķ�����
	// public static int process(int[] arr, int i, int limit) {
	// if (limit == 0)
	// return 1;
	// int ways = process(arr, i, limit);// ��Ҫiλ���ϵ���Ʒ
	// ways += process(arr, i, limit - arr[i]);// Ҫiλ���ϵ���Ʒ
	// return ways;
	// }

	//
	public static int ways(int[] arr, int w) {
		if (arr == null || arr.length == 0 || w < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][w + 1];
		// ��ʼ��dp�ĵ�һ�к͵�һ��
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j <= w; j++) {
			dp[0][j] = j >= arr[0] ? 2 : 1;
		}
		// ��̬�滮�������������
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= w; j++) {
				// ��Ҫiλ���ϵ���Ʒ
				dp[i][j] = dp[i - 1][j];
				// Ҫiλ���ϵ���Ʒ������ûԽ��
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
