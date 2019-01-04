package nowCoder.Class6;

public class Problem07_SubMatrixMaxSum {
	public static int maxSum(int[][] num) {
		if (num == null || num.length == 0 || num[0].length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		int[] s = null;
		for (int i = 0; i < num.length; i++) {
			s = new int[num[0].length];
			for (int j = i; j < num.length; j++) {
				cur = 0;
				for (int k = 0; k < s.length; k++) {
					s[k] += num[j][k];
					cur += s[k];
					max = Math.max(cur, max);
					cur = cur < 0 ? 0 : cur;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));

	}

}
