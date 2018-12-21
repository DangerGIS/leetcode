package nowCoder.Class4;

public class Problem04_MinPathSum {
	// 求最短路径和
	public static int minPathSum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		for (int i = 1; i < row; i++)
			dp[i][0] = dp[i - 1][0] + m[i][0];// 第一列
		for (int j = 1; j < col; j++)
			dp[0][j] = dp[0][j - 1] + m[0][j];// 第一行
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public static int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length);
		int less = Math.max(m.length, m[0].length);
		boolean rowmore = more == m.length;// 是不是 行比列多
		int[] dp = new int[less];
		for (int i = 1; i < less; i++) {
			dp[i] = dp[i - 1] + (rowmore ? m[0][i] : m[i][0]);
		}
		for (int i = 1; i < more; i++) {
			dp[0] = dp[0] + (rowmore ? m[i][0] : m[0][i]);
			for (int j = 1; j < less; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
		return dp[less - 1];

	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// int[][] m = generateRandomMatrix(3, 4);
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		printMatrix(m);
		System.out.println(minPathSum1(m));
		System.out.println(minPathSum2(m));

	}
}
