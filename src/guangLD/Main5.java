package guangLD;

public class Main5 {
	public static void main(String[] args) {
		int[][] martix = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 15, 5 }, };
		System.out.println("�����µ��·��Ϊ��" + fun(martix));
	}

	public static int fun(int[][] arr) {
		int dp[][] = new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < arr.length; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
			System.out.println(arr[i][0]);
			// ��һ��ֻ����������
		}
		for (int j = 1; j < arr[0].length; j++) {
			dp[0][j] = dp[0][j - 1] + arr[0][j];
			System.out.println(arr[0][j]);
			// ��һ��ֻ����������
		}
		for (int i = 1; i < arr.length; i++)
			for (int j = 1; j < arr[0].length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
				// System.out.println(arr[i][j]);
			}

		return dp[arr.length - 1][arr[0].length - 1];

	}

}
